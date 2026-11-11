# Task 5 (W): Simulator classes, A-phase, B-events and C-events

A typical simulator consists of these classes:

| Class | Role |
|---|---|
| `Engine` | The simulation engine. It contains the main loop with the three phases |
| `Clock` | Holds the current simulation time |
| `EventList` | Holds the future events in time order |
| `Event` (with `EventType`) | One scheduled event: its type and its time |
| `ArrivalProcess` | Generates new arrival events for customers |
| `ServicePoint` | A queue and a service. Stores A, B, C, W and does the service |
| `Customer` | One customer, stores arrival time and calculates its response time |

## a) What does A-phase coding mean?

The A-phase is coded in the **`Engine`** main loop. The engine asks the `EventList` for the time of the earliest event and sets the `Clock` to that time. The simulation clock jumps from event to event, so nothing happens between events and no time is wasted.

```java
clock.setTime(eventList.getNextTime());
```

## b) What does coding B-events mean?

B-events are the events that are **bound to a time**: they happen because their time has come. In the code, the `Engine` takes every event from the `EventList` whose time equals the clock, and a method (for example `runEvent(Event e)`) handles it according to its `EventType`.

```java
protected void runEvent(Event e) {
    switch (e.getType()) {

        case ARRIVAL:
            Customer c = new Customer();                 // new customer arrives
            servicePoint.addToQueue(c);                  // A is increased, arrival time stored
            arrivalProcess.generateNextEvent();          // schedule the next arrival
            break;

        case DEPARTURE:
            Customer done = servicePoint.takeFromService();  // service ends
            // update C, B, W and the customer's response time
            // then move the customer to the next service point, or remove from the system
            break;
    }
}
```

So coding B-events means: for each event type, write what changes in the system when that event happens, and schedule the following events that it causes (for example an arrival schedules the next arrival).

## c) What does coding C-events mean?

C-events are **conditional events**: they are not scheduled in the event list. They happen when a **condition** is true at the current moment. In the code, they are in a method (for example `tryCEvents()`) that the `Engine` calls after the B-phase. The method goes through the service points and checks the condition.

The typical C-event is "begin service": the condition is that the service point is free and there is a customer in the queue.

```java
protected void tryCEvents() {
    boolean executed;
    do {
        executed = false;
        for (ServicePoint sp : servicePoints) {
            if (!sp.isReserved() && sp.hasQueue()) {
                sp.beginService();       // takes customer from the queue,
                // marks the service point as busy,
                // and schedules a DEPARTURE event (a new B-event)
                // at time = clock + service time
                executed = true;
            }
        }
    } while (executed);                  // repeat until no C-event can be executed
}
```

The phases work together: a B-event (arrival) puts a customer in the queue, a C-event (begin service) starts the service and schedules a new B-event (departure), and the departure B-event later frees the service point so that the next C-event can start the next service.