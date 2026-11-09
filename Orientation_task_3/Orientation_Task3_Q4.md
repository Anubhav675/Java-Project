# Orientation Task 3-Q4:

The `eduni.distributions` package has two kinds of generators, both with a `sample()` method:

- `ContinuousGenerator`: returns decimal numbers (e.g. exponential, normal, uniform)
- `DiscreteGenerator`: returns integers (e.g. Bernoulli, Poisson, binomial)

Because both kinds share the same interface, one distribution can easily be swapped for another in the simulator.

| Distribution | Type | Real-life / simulator example |
|---|---|---|
| **Uniform** | Continuous | Service time known only to be "between 3 and 7 minutes"; rolling a die |
| **Normal** | Continuous | Service times clustered around a typical value; heights, measurement errors, exam scores |
| **Exponential** (`Negexp`) | Continuous | Time between customer arrivals; time until the next machine breakdown |
| **Poisson** | Discrete | Number of customers arriving per hour; phone calls per minute at a call center |
| **Binomial** | Discrete | How many of 20 customers buy an extra product; number of heads in 10 coin flips |
| **Bernoulli** | Discrete | A single yes/no event, e.g. whether a customer needs a second service |
| **Own (empirical) distribution** | Discrete | Any measured data, such as the age distribution of students (cumulative table, as in Tasks 1 and 2) |

## How they relate

- **Poisson and exponential** describe the same process: Poisson counts how many events happen in a fixed interval, and exponential gives the time between those events. For generating arrival times in the simulator, the exponential distribution is used.
- **Binomial** is a sum of several Bernoulli trials, and with many trials it starts to look like a normal distribution.
- **Predictable variability** (for example, pre-arranged work shifts) needs no random numbers. It can be coded directly as B-events or as conditions of C-events.