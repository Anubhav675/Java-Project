## Task 4

From the end of Clock 15, where X3 is in the router, X2 is with operator 1 and Y1 is with operator 2.

**Call Centre Simulation: Clock 16 (Events B4, B3)**

The A-phase advances the clock to 16. In the B-phase, B4 is executed: operator 1 completes X2, which leaves the model, and the work complete count for X becomes 2. B3 is also executed: the router completes X3 and moves it to the operator 1 queue.

In the C-phase, C2 is executed: operator 1 takes X3 and B4 is scheduled at time 20 (16 + 4). No other C-events can be executed.

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | X3           | Idle   | Empty        | Y1     |
| C     | Empty        | Idle   | Empty        | X3     | Empty        | Y1     |

Event List:

| Event | Time |
|-------|------|
| B5    | 18   |
| B1    | 20   |
| B2    | 20   |
| B4    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 2 |
| Y                | 0 |

**Call Centre Simulation: Clock 18 (Event B5)**

The A-phase advances the clock to 18. In the B-phase, B5 is executed: operator 2 completes Y1, which leaves the model, and the work complete count for Y becomes 1.

In the C-phase, no C-event can be executed, because all queues are empty.

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | Empty        | X3     | Empty        | Idle   |
| C     | Empty        | Idle   | Empty        | X3     | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B1    | 20   |
| B2    | 20   |
| B4    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 2 |
| Y                | 1 |

Customer Y1 has exited the system at time 18.