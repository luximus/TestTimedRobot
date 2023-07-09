# FleetBot Example

An example FleetBot.

<span style="color:red">**WARNING: This code has not been tested.**</span>

## Specification

This robot uses two PWM Talon brushed motor controllers: one for left-side control and one for right-side control. An Xbox controller tank drive is implemented with motor control mapped to the left and right analog triggers, a slow speed button mapped to the left bumper, and a fast speed button mapped to the right bumper. A slew rate limiter is used to ramp input values. All channel/port assignments, button mappings, speed multipliers, and ramping values can be modified in RobotMap.java.

The robot has a simple two-motor intake, single-motor indexer, single-motor shooter feed, and single-motor shooter.

The robot also implements a simple autonomous routine.
