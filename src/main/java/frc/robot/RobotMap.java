package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public final class RobotMap {
    // Motor controller channel IDs
    public static final int LEFT_DRIVE_MOTOR_CONTROLLER_CHANNEL_ID = 0;
    public static final int RIGHT_DRIVE_MOTOR_CONTROLLER_CHANNEL_ID = 1;
    public static final int LEFT_INTAKE_MOTOR_CONTROLLER_CHANNEL_ID = 2;
    public static final int RIGHT_INTAKE_MOTOR_CONTROLLER_CHANNEL_ID = 3;
    public static final int INDEXER_MOTOR_CONTROLLER_CHANNEL_ID = 4;
    public static final int SHOOTER_FEED_MOTOR_CONTROLLER_CHANNEL_ID = 5;
    public static final int SHOOTER_MOTOR_CONTROLLER_CHANNEL_ID = 6;

    // Input controller port numbers
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;

    // Buttons and axes for driver control
    public static final XboxController.Axis DRIVER_LEFT_CONTROL_AXIS = XboxController.Axis.kLeftTrigger;
    public static final XboxController.Axis DRIVER_RIGHT_CONTROL_AXIS = XboxController.Axis.kRightTrigger;
    public static final XboxController.Button DRIVER_SLOW_SPEED_BUTTON = XboxController.Button.kLeftBumper;
    public static final XboxController.Button DRIVER_FAST_SPEED_BUTTON = XboxController.Button.kRightBumper;

    // Buttons and axes for operator control
    public static final XboxController.Button OPERATOR_INTAKE_AND_INDEXER_CONTROL_BUTTON = XboxController.Button.kLeftBumper;
    public static final XboxController.Button OPERATOR_SHOOTER_CONTROL_BUTTON = XboxController.Button.kRightBumper;
    public static final XboxController.Button OPERATOR_ALL_REVERSE_BUTTON = XboxController.Button.kB;

    // Speed button multipliers
    public static final double SLOW_SPEED_MULTIPLIER = 0.2;
    public static final double FAST_SPEED_MULTIPLIER = 0.8;
    public static final double DEFAULT_SPEED_MULTIPLIER = 0.5;

    // Ramping
    public static final double RAMP_RATE = 0.1;

    // Static motor speed multipliers
    public static final double INTAKE_SPEED = 0.8;
    public static final double INTAKE_REVERSE_SPEED = 0.2;
    public static final boolean INTAKE_IS_INVERTED = false;
    public static final double INDEXER_SPEED = 0.5;
    public static final double INDEXER_REVERSE_SPEED = 0.2;
    public static final boolean INDEXER_IS_INVERTED = false;
    public static final double SHOOTER_FEED_SPEED = 0.8;
    public static final double SHOOTER_FEED_REVERSE_SPEED = 0.2;
    public static final boolean SHOOTER_FEED_IS_INVERTED = false;
    public static final double SHOOTER_SPEED = 0.8;
    public static final double SHOOTER_REVERSE_SPEED = 0.2;
    public static final boolean SHOOTER_IS_INVERTED = false;

}
