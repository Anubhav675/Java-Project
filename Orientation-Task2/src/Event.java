public class Event implements Comparable<Event> {

    private double eventTime;

    public Event(double eventTime) {
        this.eventTime = eventTime;
    }

    public double getEventTime() {
        return eventTime;
    }

    public int compareTo(Event otherEvent) {
        return Double.compare(this.eventTime, otherEvent.eventTime);
    }

    public String toString() {
        return "Event at time " + eventTime;
    }
}