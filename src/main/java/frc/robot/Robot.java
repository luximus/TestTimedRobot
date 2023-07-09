// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
    CANSparkMax leftFrontDriveMotorController = new CANSparkMax(RobotMap.LEFT_FRONT_DRIVE_MOTOR_CONTROLLER_CAN_ID, MotorType.kBrushless);
    CANSparkMax leftRearDriveMotorController = new CANSparkMax(RobotMap.LEFT_REAR_DRIVE_MOTOR_CONTROLLER_CAN_ID, MotorType.kBrushless);
    MotorControllerGroup leftDriveMotorController = new MotorControllerGroup(leftFrontDriveMotorController, leftRearDriveMotorController);
    CANSparkMax rightFrontDriveMotorController = new CANSparkMax(RobotMap.RIGHT_FRONT_DRIVE_MOTOR_CONTROLLER_CAN_ID, MotorType.kBrushless);
    CANSparkMax rightRearDriveMotorController = new CANSparkMax(RobotMap.RIGHT_REAR_DRIVE_MOTOR_CONTROLLER_CAN_ID, MotorType.kBrushless);
    MotorControllerGroup rightDriveMotorController = new MotorControllerGroup(rightFrontDriveMotorController, rightRearDriveMotorController);
    DifferentialDrive driveTrain = new DifferentialDrive(leftDriveMotorController, rightDriveMotorController);

    XboxController driverController = new XboxController(RobotMap.DRIVER_CONTROLLER_PORT);
    SlewRateLimiter driveAccelerationLimiter = new SlewRateLimiter(RobotMap.RAMP_RATE); 
    Talon leftIntakeMotorController = new Talon(RobotMap.LEFT_INTAKE_MOTOR_CONTROLLER_CHANNEL_ID);
    Talon rightIntakeMotorController = new Talon(RobotMap.RIGHT_INTAKE_MOTOR_CONTROLLER_CHANNEL_ID);
    MotorControllerGroup intakeMotorControllerGroup = new MotorControllerGroup(leftDriveMotorController, rightDriveMotorController);    
    Talon indexerMotorController = new Talon(RobotMap.INDEXER_MOTOR_CONTROLLER_CHANNEL_ID);
    Talon shooterFeedMotorController = new Talon(RobotMap.SHOOTER_FEED_MOTOR_CONTROLLER_CHANNEL_ID);
    Talon shooterMotorController = new Talon(RobotMap.SHOOTER_MOTOR_CONTROLLER_CHANNEL_ID);

    XboxController operatorController = new XboxController(RobotMap.OPERATOR_CONTROLLER_PORT);

    SlewRateLimiter intakeRateLimiter = new SlewRateLimiter(RobotMap.RAMP_RATE);
    SlewRateLimiter indexerRateLimiter = new SlewRateLimiter(RobotMap.RAMP_RATE);
    SlewRateLimiter shooterFeedRateLimiter = new SlewRateLimiter(RobotMap.RAMP_RATE);
    SlewRateLimiter shooterRateLimiter = new SlewRateLimiter(RobotMap.RAMP_RATE);

    Timer timer = new Timer();

    @Override
    public void robotInit() {
        intakeMotorControllerGroup.setInverted(RobotMap.INTAKE_IS_INVERTED);
        indexerMotorController.setInverted(RobotMap.INDEXER_IS_INVERTED);
        shooterFeedMotorController.setInverted(RobotMap.SHOOTER_FEED_IS_INVERTED);
        shooterMotorController.setInverted(RobotMap.SHOOTER_IS_INVERTED);
    }

    @Override
    public void robotPeriodic() {}

    @Override
    public void autonomousInit() {
        timer.reset();
        timer.start();
    }

    @Override
    public void autonomousPeriodic() {
        double leftMotorSpeed = 0.0;
        double rightMotorSpeed = 0.0;

        if (RobotMap.MOVE_FORWARD_1_START_TIME <= timer.get() && timer.get() < RobotMap.MOVE_FORWARD_1_END_TIME) {
            leftMotorSpeed = RobotMap.AUTONOMOUS_MOVE_SPEED * RobotMap.LEFT_MOTOR_MOVE_STRAIGHT_ADJUSTMENT;
            rightMotorSpeed = RobotMap.AUTONOMOUS_MOVE_SPEED * RobotMap.RIGHT_MOTOR_MOVE_STRAIGHT_ADJUSTMENT;
        }
        if (RobotMap.TURN_RIGHT_START_TIME <= timer.get() && timer.get() < RobotMap.TURN_RIGHT_END_TIME) {
            leftMotorSpeed = RobotMap.AUTONOMOUS_TURN_SPEED;
            rightMotorSpeed = -RobotMap.AUTONOMOUS_TURN_SPEED;
        }
        if (RobotMap.MOVE_FORWARD_2_START_TIME <= timer.get() && timer.get() < RobotMap.MOVE_FORWARD_2_END_TIME) {
            leftMotorSpeed = RobotMap.AUTONOMOUS_MOVE_SPEED * RobotMap.LEFT_MOTOR_MOVE_STRAIGHT_ADJUSTMENT;
            rightMotorSpeed = RobotMap.AUTONOMOUS_MOVE_SPEED * RobotMap.RIGHT_MOTOR_MOVE_STRAIGHT_ADJUSTMENT;
        }

        leftDriveMotorController.set(leftMotorSpeed);
        rightDriveMotorController.set(rightMotorSpeed);
    }

    @Override
    public void teleopInit() {
        leftFrontDriveMotorController.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        leftRearDriveMotorController.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        rightFrontDriveMotorController.setOpenLoopRampRate(RobotMap.RAMP_RATE);
        rightRearDriveMotorController.setOpenLoopRampRate(RobotMap.RAMP_RATE);
    }

    @Override
    public void teleopPeriodic() {
        // Drive
        final double speedMultiplier;
        if (driverController.getRawButtonPressed(RobotMap.DRIVER_SLOW_SPEED_BUTTON.value)) {
            speedMultiplier = RobotMap.SLOW_SPEED_MULTIPLIER;
        } else if (driverController.getRawButton(RobotMap.DRIVER_FAST_SPEED_BUTTON.value)) {
            speedMultiplier = RobotMap.FAST_SPEED_MULTIPLIER;
        } else {
            speedMultiplier = RobotMap.DEFAULT_SPEED_MULTIPLIER;
        }
        double leftInput = driveAccelerationLimiter.calculate(
            speedMultiplier*driverController.getRawAxis(RobotMap.DRIVER_LEFT_CONTROL_AXIS.value));
        double rightInput = driveAccelerationLimiter.calculate(
            speedMultiplier*driverController.getRawAxis(RobotMap.DRIVER_RIGHT_CONTROL_AXIS.value));
        driveTrain.tankDrive(leftInput, rightInput);

        // Intake and shooter
        final double intakeSpeed;
        final double indexerSpeed;
        final double shooterFeedSpeed;
        final double shooterSpeed;
        if (operatorController.getRawButton(RobotMap.OPERATOR_ALL_REVERSE_BUTTON.value)) {
            intakeSpeed = -RobotMap.INTAKE_REVERSE_SPEED;
            indexerSpeed = -RobotMap.INDEXER_REVERSE_SPEED;
            shooterFeedSpeed = -RobotMap.SHOOTER_FEED_REVERSE_SPEED;
            shooterSpeed = -RobotMap.SHOOTER_REVERSE_SPEED;
        } else {
            if (operatorController.getRawButton(RobotMap.OPERATOR_INTAKE_AND_INDEXER_CONTROL_BUTTON.value)) {
                intakeSpeed = RobotMap.INTAKE_SPEED;
                indexerSpeed = RobotMap.INDEXER_SPEED;
            } else {
                intakeSpeed = 0.0d;
                indexerSpeed = 0.0d;
            }

            if (operatorController.getRawButton(RobotMap.OPERATOR_SHOOTER_CONTROL_BUTTON.value)) {
                shooterFeedSpeed = RobotMap.SHOOTER_FEED_SPEED;
                shooterSpeed = RobotMap.SHOOTER_SPEED;
            } else {
                shooterFeedSpeed = 0.0d;
                shooterSpeed = 0.0d;
            }
        }

        intakeMotorControllerGroup.set(intakeRateLimiter.calculate(intakeSpeed));
        indexerMotorController.set(indexerRateLimiter.calculate(indexerSpeed));
        shooterFeedMotorController.set(shooterFeedRateLimiter.calculate(shooterFeedSpeed));
        shooterMotorController.set(shooterRateLimiter.calculate(shooterSpeed));
    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {}

    @Override
    public void simulationInit() {}

    @Override
    public void simulationPeriodic() {}
}
