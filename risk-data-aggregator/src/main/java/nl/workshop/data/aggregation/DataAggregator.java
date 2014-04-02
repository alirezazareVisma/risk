package nl.workshop.data.aggregation;

import nl.workshop.event.EventBus;
import nl.workshop.event.EventHandler;
import nl.workshop.event.EventQueueIds;

import java.util.HashMap;
import java.util.Map;

public class DataAggregator implements EventHandler {

    public static final String RDS = "RDS";
    public static final String TDS = "TDS";
    EventBus eventBus;

    Map<String, Object> eventRdsData;
    Map<String, Object> eventTdsData;
    private String context;


    public DataAggregator() {
        register(EventQueueIds.DATAAGGREGATOR);
    }

    @Override
    public void register(EventQueueIds queueid) {
        eventBus.register(queueid, this);
    }

    @Override
    public void handleQueuedEvent(Map<String, Object> payload, EventQueueIds eventId, String context) {
        this.context = context;

        eventBus.send(EventQueueIds.RDSIMPORTER, this, null, RDS);
        eventBus.send(EventQueueIds.TDSIMPORTER, this, null, TDS);
    }

    @Override
    public void handleResponseEvent(Map<String, Object> response, String context) {
        if (context.equals(RDS)) {
            eventRdsData = response;
        }

        if (context.equals(TDS)) {
            eventTdsData = response;
        }

        if (eventRdsData != null && eventTdsData != null) {

            Map<String, Object> mergedResult = new HashMap<String, Object>();
            eventBus.handleResponseEvent(5, mergedResult, this.context);

        }
    }
}
