package nl.workshop.event;

import java.util.Map;

public interface EventHandler {
	
	void register(EventQueueIds queueid);
	
	void handleQueuedEvent(Map<String, Object> payload, EventQueueIds eventId);
	
	void handleResponseEvent(Map<String, Object> response);
	
}