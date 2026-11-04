public class Event implements Comparable<Event> {

    private double eventTime;
    private EventType eventType;

    public Event(EventType eventType, double eventTime) {
        this.eventTime = eventTime;
        this.eventType = eventType;
    }

    public double getEventTime() {
        return eventTime;
    }
    public EventType getEventType() {
        return eventType;
    }

    public int compareTo(Event otherEvent) {
        return Double.compare(this.eventTime, otherEvent.eventTime);
    }

    public String toString() {
        return eventType + " at time " + eventTime;
    }
}