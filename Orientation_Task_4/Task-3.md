# Task 3 (W): Two systems of service points

## System 1: Airport departure (four service points in series)

Passengers go through four service points one after the other: check-in, security control, passport control and the boarding gate.

```mermaid
flowchart LR
    in1[ ] --> q1[(Queue)]
    q1 -.- sp1((Check-in desk))
    sp1 --> q2[(Queue)]
    q2 -.- sp2((Security control))
    sp2 --> q3[(Queue)]
    q3 -.- sp3((Passport control))
    sp3 --> q4[(Queue)]
    q4 -.- sp4((Boarding gate))
    sp4 --> out1[ ]

    style in1 height:0px;
    style out1 height:0px;
```

## System 2: Health centre (four service points, with branching)

A patient registers at the reception and sees a nurse. After that, the nurse sends the patient either to the doctor or to the laboratory (for example for a blood test).

```mermaid
flowchart LR
    in2[ ] --> r1[(Queue)]
    r1 -.- reception((Reception))
    reception --> r2[(Queue)]
    r2 -.- nurse((Nurse))
    nurse --> r3[(Queue)]
    r3 -.- doctor((Doctor))
    nurse --> r4[(Queue)]
    r4 -.- lab((Laboratory))
    doctor --> out2[ ]
    lab --> out3[ ]

    style in2 height:0px;
    style out2 height:0px;
    style out3 height:0px;
```

## Explanation

- System 1 is a pure **serial** system: every customer visits all service points in the same order, so the slowest service point (the bottleneck) limits the whole system.
- System 2 has a **branch**: after the nurse, customers go to different service points, so each of the later service points sees only part of the customers.