import eduni.distributions.Negexp;
import simu.framework.ArrivalProcess;
import simu.framework.Clock;
import simu.framework.Event;
import simu.framework.EventList;
import simu.model.Customer;
import simu.model.EventType;
import simu.model.ServicePoint;

public class Main_Test7 {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        EventList eventList = new EventList();
        ServicePoint servicePoint = new ServicePoint();
        ArrivalProcess arrivals = new ArrivalProcess(new Negexp(10), EventType.ARR1);

        // 1. Create 10 arrival events; the clock moves to each new event's time
        for (int i = 0; i < 10; i++) {
            Event e = arrivals.generateNextEvent(eventList);
            clock.setTime(e.getTime());
        }
        System.out.println("Time of the last event created: " + clock.getTime());

        // 2. Process all events one by one (the clock is not moved).
        //    Each event time is the arrival time of a new customer.
        while (!eventList.isEmpty()) {
            Event e = eventList.remove();
            Customer c = new Customer();
            c.setArrivalTime(e.getTime());
            servicePoint.addToQueue(c);
        }

        // 3. Move the clock forward by 5 time units
        clock.setTime(clock.getTime() + 5);

        // 4. Clear the service point one customer at a time
        while (servicePoint.hasCustomers()) {
            Customer c = servicePoint.removeFromQueue();
            c.report();
        }
    }
}