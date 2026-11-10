import eduni.distributions.Negexp;
import simu.framework.ArrivalProcess;
import simu.framework.Clock;
import simu.framework.Event;
import simu.framework.EventList;
import simu.model.EventType;

public class ArrivalProcessTest {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        EventList eventList = new EventList();
        ArrivalProcess arrivals = new ArrivalProcess(new Negexp(10), EventType.ARR1);

        for (int i = 1; i <= 10; i++) {
            Event e = arrivals.generateNextEvent(eventList);
            clock.setTime(e.getTime());          // move the clock to the new event's time
        }

        System.out.println("Event list (" + eventList.size() + " events):");
        System.out.print(eventList);
    }
}