package nl.workshop.event;

import java.util.HashMap;
import java.util.Map;

public class RiskEventBus implements EventBus {

	private int eventId = 0;
	private Map<EventQueueIds, EventHandler> queues = new HashMap<EventQueueIds, EventHandler>();

	private Map<Integer, EventHandler> events = new HashMap<Integer, EventHandler>();

	@Override
	public void register(EventQueueIds queueId, EventHandler registrar) {
		queues.put(queueId, registrar);
	}

	@Override
	public void send(EventQueueIds queueId, EventHandler sender,
			Map<String, Object> payload) {
		events.put(eventId++, sender);
		queues.get(queueId).handleQueuedEvent(payload, queueId);
	}

	@Override
	public void handleResponseEvent(int eventId, Map<String, Object> response) {
		events.get(eventId).handleResponseEvent(response);
		events.remove(eventId);
	}

}
