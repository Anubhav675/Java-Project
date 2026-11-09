public class Main {
    public static void main(String[] args) {
        EventList myEventList = new EventList();


        myEventList.addEvent(new Event(EventType.ARRIVAL, 10));
        myEventList.addEvent(new Event(EventType.ARRIVAL,5));
        myEventList.addEvent(new Event(EventType.EXIT, 6));
        myEventList.addEvent(new Event(EventType.EXIT,18));
        myEventList.addEvent(new Event(EventType.ARRIVAL,12));


        Event firstEvent = myEventList.removeFirstEvent();
        System.out.println("Removed: " + firstEvent);


        System.out.println("Event list:");
        myEventList.printEvents();
    }
}