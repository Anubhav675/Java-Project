# Task 2 (W): Categories in which performance measures are maintained

In general terms, the measures are kept in **three categories**, according to what they describe and when they are updated.

## 1. Customer (per-customer data)

Each customer object stores its own data:

- **arrival time** at the service point (set when the customer arrives)
- **response time Rᵢ** (computed when the service ends: *clock − arrival time*)

## 2. Service point (per-service-point data)

Each service point has its own counters, updated at the right events:

| Measure | When it is updated |
|---|---|
| **A** | Increased when a customer arrives at the service point (the customer enters the queue) |
| **B** | Increased by the length of the service when a service is completed (or at the start, using the planned service time) |
| **C** | Increased by one when a service ends |
| **W** | Increased by the customer's response time Rᵢ when the service ends |

## 3. Simulation (global data)

- **T**: the simulation clock at the end of the simulation (set once, at the end).

## Computed (derived) measures

**U, X, S, R and N** are *not* updated during the simulation. They are **computed at the end** (or whenever a report is printed) from the stored values:

```
U = B / T      X = C / T      S = B / C
R = W / C      N = W / T
```

So: counters **A, B, C, W** are *maintained* at the service point during the run, **Rᵢ** is *computed* for each customer from its stored arrival time, **T** is *read* from the clock, and the rest are *derived* when the results are printed.