package nl.workshop.event;

import java.util.Map;

public interface EventHandler {
	
	void register(int queueid);
	
	void handleQueuedEvent(Map<String, Object> payload, int eventId);
	
	void handleResponseEvent(Map<String, Object> response);
	
}