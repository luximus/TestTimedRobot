package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public final class RobotMap {
    // Motor controller channel IDs
    public static final int LEFT_DRIVE_MOTOR_CONTROLLER_CHANNEL_ID = 0;
    public static final int RIGHT_DRIVE_MOTOR_CONTROLLER_CHANNEL_ID = 1;

    // Input controller port numbers
    public static final int DRIVER_CONTROLLER_PORT = 0;

    // Buttons and axes for driver control
    public static final XboxController.Axis DRIVER_LEFT_CONTROL_AXIS = XboxController.Axis.kLeftTrigger;
    public static final XboxController.Axis DRIVER_RIGHT_CONTROL_AXIS = XboxController.Axis.kRightTrigger;
    public static final XboxController.Button DRIVER_SLOW_SPEED_BUTTON = XboxController.Button.kLeftBumper;
    public static final XboxController.Button DRIVER_FAST_SPEED_BUTTON = XboxController.Button.kRightBumper;

    // Speed button multipliers
    public static final double SLOW_SPEED_MULTIPLIER = 0.2;
    public static final double FAST_SPEED_MULTIPLIER = 0.8;
    public static final double DEFAULT_SPEED_MULTIPLIER = 0.5;

    // Ramping
    public static final double RAMP_RATE = 0.1;
}
