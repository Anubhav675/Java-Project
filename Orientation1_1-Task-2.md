# Orientation-1.1 Task 2

**System observed:** a supermarket with shelves, a fresh food counter, several checkouts and self-service machines.

## Variability

- **Predictable:** many customers come after work (16:00-18:00) and on Fridays, and very few late in the evening. Shifts of cashiers are also planned.
- **Unpredictable:** customers arrive at random times, some have a full cart and some only a few items, and sometimes a price check, a payment error or a broken scanner slows things down.

## Interconnectedness

The parts of the supermarket depend on each other:

- If one checkout is slow, its queue grows and customers move to other checkouts, making those queues longer too.
- If the shelves are empty, the staff leave the checkout to refill them, so the queues grow.
- If the fresh food counter is slow, customers spend more time in the shop and arrive at the checkouts later and all at once.

A change in one part always affects the other parts.

## Complexity

- **Combinatorial complexity:** there are many checkouts and self-service machines, and each customer can choose any of them. More checkouts mean many more possible choices and combinations.
- **Dynamic complexity:** effects over time are hard to predict. For example, adding a new checkout may not shorten the queues if there are not enough cashiers to staff it. A small delay at one checkout at 16:30 can also cause a long queue at 17:30.

## Conclusion

Because the supermarket has variability, interconnected parts and complexity at the same time, it is hard to predict its performance with simple calculations. This is why simulation is a suitable method.