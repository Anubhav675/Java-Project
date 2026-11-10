package simu.framework;

import simu.model.EventType;

public class Event implements Comparable<Event> {
    private EventType type;
    private double time;

    public Event(EventType type, double time) {
        this.type = type;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event " + type + " at time " + time;
    }
}