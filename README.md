# FleetBot Example

An example FleetBot.

<span style="color:red">**WARNING: This code has not been tested.**</span>

## Specification

This robot uses four REV Spark Max motor controllers: two for left-side control and two for right-side control. An Xbox controller tank drive is implemented with motor control mapped to the left and right analog triggers, a slow speed button mapped to the left bumper, and a fast speed button mapped to the right bumper. An open-loop ramp is used to ramp drive input values, and a slew rate limiter is used to ramp other values. All channel/port assignments, button mappings, speed multipliers, and ramping values can be modified in RobotMap.java.

The robot has a simple two-motor intake, single-motor indexer, single-motor shooter feed, and single-motor shooter, all powered by PWM-based Talon motors.

The robot also implements a simple autonomous routine.
