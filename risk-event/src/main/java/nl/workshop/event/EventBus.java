package nl.workshop.event;

import java.util.Map;

public interface EventBus {
	void register (int type, Registrar registrar);
	void send (int type, Sender sender, Map<String, Object> payload);
}
