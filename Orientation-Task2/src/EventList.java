import java.util.PriorityQueue;

public class EventList {

    private PriorityQueue<Event> eventQueue = new PriorityQueue<>();

    public void addEvent(Event newEvent) {
        eventQueue.add(newEvent);
    }

    public Event removeFirstEvent() {
        return eventQueue.remove();
    }

    public void printEvents() {
        PriorityQueue<Event> tempQueue = new PriorityQueue<>(eventQueue);
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.remove());
        }
    }
}