# Orientation Task 3 Q1 

Use a **cumulative table** (the idea from the "Your own distribution" example).

## 1. Build the table

Count how many students there are of each age and convert to percentages. Then add up the shares to get a cumulative bound for each age. Example:

| Age | Share | Cumulative bound | Random numbers (1..100) |
|---|---|---|---|
| 20 | 10 % | 10 | 1..10 |
| 21 | 20 % | 30 | 11..30 |
| 22 | 30 % | 60 | 31..60 |
| 23 | 20 % | 80 | 61..80 |
| 25 | 15 % | 95 | 81..95 |
| 30 | 5 % | 100 | 96..100 |

## 2. Algorithm

```
table[][] = rows of {cumulative bound, age}      // last bound = 100
count[]   = counter per age, all 0

repeat 1000 times:
    x = random integer 1..100                    // uniform
    j = 0
    while x > table[j][0]: j = j + 1             // first row with bound >= x
    count[table[j][1]]++                         // that row's age was drawn

print age, count, count / 1000 * 100 %
```

## 3. Explanation:

- x is uniform, so every value from 1 to 100 has probability 1/100.
- An age that owns k of those numbers is drawn with probability k/100, which equals its share in the group (for example, age 22 owns 30 numbers, so 30 %).
- Each draw is independent of the others.
- With 1000 draws the observed percentages are close to the group's percentages, but not exactly equal, because of random variation.