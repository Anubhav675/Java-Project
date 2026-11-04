public class Main {
    public static void main(String[] args) {
        EventList myEventList = new EventList();


        myEventList.addEvent(new Event(10));
        myEventList.addEvent(new Event(5));
        myEventList.addEvent(new Event(18));
        myEventList.addEvent(new Event(6));
        myEventList.addEvent(new Event(12));


        Event firstEvent = myEventList.removeFirstEvent();
        System.out.println("Removed: " + firstEvent);


        System.out.println("Event list:");
        myEventList.printEvents();
    }
}