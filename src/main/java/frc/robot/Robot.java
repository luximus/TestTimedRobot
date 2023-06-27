// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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

   Talon leftDriveMotorController = new Talon(RobotMap.LEFT_DRIVE_MOTOR_CONTROLLER_CHANNEL_ID);
   Talon rightDriveMotorController = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_CONTROLLER_CHANNEL_ID);
   DifferentialDrive driveTrain = new DifferentialDrive(leftDriveMotorController, rightDriveMotorController);
   
   XboxController driverController = new XboxController(RobotMap.DRIVER_CONTROLLER_PORT);

   SlewRateLimiter driveAccelerationLimiter = new SlewRateLimiter(RobotMap.RAMP_RATE);

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double speedMultiplier;
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
