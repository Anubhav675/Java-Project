# Task 1 (W): Performance measures in an example case

**Example case: a health centre with one doctor's reception.** The service point is the doctor's room. The customers are the patients. The queue is the waiting room.

Imagine one working day: the simulation runs for T = 480 minutes (8 hours).

## Directly observable variables

| Variable | Meaning in general | Meaning in the health centre |
|---|---|---|
| **A** (arrival count) | How many customers have arrived at the service point | Number of patients who came to the doctor's waiting room during the day, e.g. A = 50 |
| **C** (completed count) | How many customers have been fully served | Number of patients whose visit with the doctor has ended, e.g. C = 48 (two are still waiting at closing time) |
| **B** (busy time) | Total time the service point was actively serving | Total minutes the doctor was with a patient, e.g. B = 400 min. Time when the doctor waits with an empty room does not count |
| **T** (total time) | Length of the observation period | The length of the working day, T = 480 min |

## Derived variables

| Variable | Formula | Meaning in the health centre | Example |
|---|---|---|---|
| **U** (utilization) | U = B / T | The share of the day that the doctor was busy. U = 1 means 100 %, the doctor never rested | 400 / 480 = 0.83 (83 %) |
| **X** (throughput) | X = C / T | How many patients the doctor treats per unit of time | 48 / 480 = 0.1 patients/min = 6 patients/hour |
| **S** (service time) | S = B / C | Average length of one visit with the doctor (without waiting) | 400 / 48 = 8.3 min |

## Additional variables

| Variable | Meaning in the health centre | Example |
|---|---|---|
| **Rᵢ** (response time of customer i) | The time patient *i* spends in the health centre system from arriving at the waiting room until the visit ends (waiting + treatment) | Patient 7 arrives 9:00, leaves the doctor 9:40, so R₇ = 40 min |
| **W** (waiting time, cumulative) | The sum of all patients' response times: W = R₁ + R₂ + ... + R_C | W = 2400 patient-minutes |
| **R** (average response time) | R = W / C. How long a patient spends in the system on average (waiting + treatment) | 2400 / 48 = 50 min |
| **N** (average queue length) | N = W / T. The average number of patients present at the doctor's point (waiting and being treated) | 2400 / 480 = 5 patients |

## Interpretation

- A high **U** (close to 1) means the doctor is well used, but there is no spare capacity, and queues grow quickly.
- **X** can never be larger than the service point's capacity. If A is bigger than C over a long time, the queue grows without limit.
- **S** is a property of the service itself. **R** is what the customer feels. R is always at least S, and the difference R − S is the average time spent waiting in the queue (here 50 − 8.3 = 41.7 min).
- **N** counts the patient in the doctor's room too, which is why the definition says "including the served".