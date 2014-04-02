package nl.workshop.event;

import java.util.Map;

public interface EventBus {
	void register(EventQueueIds queueId, EventHandler registrar);

	void send(EventQueueIds queueId, EventHandler sender, Map<String, Object> payload, String conext);

	void handleResponseEvent(int eventId, Map<String, Object> response, String conext);
}
