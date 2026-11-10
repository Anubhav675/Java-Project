package simu.framework;

import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> list = new PriorityQueue<>();

    public void add(Event event) {
        list.add(event);
    }

    public Event remove() {
        return list.remove();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Event e : list) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }
}