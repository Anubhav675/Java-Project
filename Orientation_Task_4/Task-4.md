# Task 4 (W): Main loop of the simulator (three-phase simulation)

The three-phase simulation first initializes the model (the initial state and the initial B-events), and then repeats three phases until the simulation is complete:

- **A-phase:** inspect the event list, find the time of the next event and advance the simulation clock to that time.
- **B-phase:** execute all B-events (bound/booked events) that are due at the current clock time, for example "customer arrives" or "service ends".
- **C-phase:** attempt all C-events (conditional events) and execute those whose conditions are true, for example "start a service if a customer is waiting and the service point is idle". Because executing one C-event may make another C-event possible, the C-events are attempted again until none of them can be executed.

After the C-phase, the simulation either stops (if it is complete, for example the run-length has been reached or a set number of arrivals has been handled) or returns to the A-phase.

## Pseudocode

```
initialize the simulation:
    set the initial state of the model
    clock = 0
    create the event list
    schedule the initial B-events (e.g. the first arrival)

repeat:

    // A-phase
    nextTime = time of the earliest event in the event list
    clock = nextTime

    // B-phase
    while (event list is not empty AND time of the earliest event == clock):
        event = remove the earliest event from the event list
        execute the B-event (event)

    // C-phase
    repeat:
        executed = false
        for each C-event:
            if its condition is true:
                execute the C-event
                executed = true
    until (executed == false)

until (simulation is complete)

print the results
```

## Java version

```java
public void run() {
    initialize();                       // initial state, clock = 0, schedule initial B-events

    do {
        // A-phase
        clock.setTime(currentTime());   // time of the earliest event in the event list

        // B-phase
        runBEvents();                   // executes all B-events due at the clock time

        // C-phase
        tryCEvents();                   // attempts C-events until none can be executed

    } while (!simulationComplete());    // e.g. clock >= simulationEndTime

    results();                          // print the observed and derived quantities
}

private void runBEvents() {
    while (eventList.getNextTime() == clock.getTime()) {
        runEvent(eventList.remove());   // executes one B-event
    }
}

private void tryCEvents() {
    boolean executed;
    do {
        executed = false;
        for (ServicePoint sp : servicePoints) {
            if (!sp.isReserved() && sp.hasQueue()) {
                sp.beginService();      // executes the C-event "begin service"
                executed = true;
            }
        }
    } while (executed);                 // repeat until no C-event can be executed
}
```