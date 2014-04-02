package nl.workshop.event;

import java.util.HashMap;
import java.util.Map;

public class RiskEventBus implements EventBus {

	private int eventId = 0;
	private Map<EventQueueIds, EventHandler> queues = new HashMap<EventQueueIds, EventHandler>();

	private Map<Integer, EventHandler> events = new HashMap<Integer, EventHandler>();
	private Map<Integer, String> contextst = new HashMap<Integer, String>();

	@Override
	public void register(EventQueueIds queueId, EventHandler registrar) {
		queues.put(queueId, registrar);
	}

	@Override
	public void send(EventQueueIds queueId, EventHandler sender,
			Map<String, Object> payload, String context) {
		events.put(eventId++, sender);
		contextst.put(eventId, context);
		queues.get(queueId).handleQueuedEvent(payload, queueId, context);
	}

	@Override
	public void handleResponseEvent(int eventId, Map<String, Object> response, String context) {
		events.get(eventId).handleResponseEvent(response, context);
		events.remove(eventId);
		contextst.remove(eventId);
	}

}
