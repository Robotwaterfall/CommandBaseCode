// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.commands.ArcadeDrivecmd;
import frc.robot.commands.ElevatorJoystickCmd;
import frc.robot.commands.ElevatorPIDcmd;


public class RobotContainer {
  private final DriveTrainSubsystem drivetrainSubsystem = new DriveTrainSubsystem(); //DriveTrain subsystem
  private final ElevatorSubsystem elevatorsubsystem = new ElevatorSubsystem(); // elevator subsystem
  private final Joystick joystick1 = new Joystick(0); // joystick port 0

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(
        new ArcadeDrivecmd(drivetrainSubsystem, () -> joystick1.getRawAxis(1), () -> joystick1.getRawAxis(0)) // y-axis is 1, x-axis is 0
    );
    configureBindings();
    configureButtonBindings();
}

  private void configureBindings() {}

  private void configureButtonBindings() {
    new JoystickButton(joystick1, 3).whileTrue(new ElevatorPIDcmd(elevatorsubsystem, 1.2)); // 1.2meters is the setpoint
    new JoystickButton(joystick1, 4).whileTrue(new ElevatorPIDcmd(elevatorsubsystem, 0)); //reset the elevator to setpoint 0
    new JoystickButton(joystick1, 1).whileTrue(new ElevatorJoystickCmd(elevatorsubsystem, 0.5)); //move the elevator up
    new JoystickButton(joystick1, 2).whileTrue(new ElevatorJoystickCmd(elevatorsubsystem, -0.5)); //move the elevator down
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
