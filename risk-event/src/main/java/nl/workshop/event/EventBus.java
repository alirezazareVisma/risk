package nl.workshop.event;

import java.util.Map;

public interface EventBus {
	void register(int queueId, EventHandler registrar);

	void send(int queueId, EventHandler sender, Map<String, Object> payload);

	void handleResponseEvent(int eventId, Map<String, Object> response);
}
