package simu.framework;

import eduni.distributions.ContinuousGenerator;
import simu.model.EventType;

public class ArrivalProcess {
    private ContinuousGenerator generator;   // property: random number generator
    private EventType type;                  // property: type of events created

    public ArrivalProcess(ContinuousGenerator generator, EventType type) {
        this.generator = generator;
        this.type = type;
    }

    // Creates a new arrival event and adds it to the event list
    public Event generateNextEvent(EventList eventList) {
        double time = Clock.getInstance().getTime() + generator.sample();
        Event event = new Event(type, time);
        eventList.add(event);
        return event;
    }
}