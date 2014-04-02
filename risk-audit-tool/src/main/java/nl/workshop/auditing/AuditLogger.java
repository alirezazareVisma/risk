package nl.workshop.auditing;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class AuditLogger implements AuditTool {
	static Logger LOG = Logger.getLogger(AuditLogger.class.getName());

	@Override
	public void logg(String logs) {
		LOG.info(logs.toString());
		
	}

}
