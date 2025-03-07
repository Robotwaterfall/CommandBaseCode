// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
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
  XboxController controller = new XboxController(0); // controller port 0

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(
        new ArcadeDrivecmd(drivetrainSubsystem, () -> controller.getRawAxis(1), () -> controller.getRawAxis(0)) // y-axis is 1, x-axis is 0
    );
    configureBindings();
    configureButtonBindings();
}

  private void configureBindings() {}

  private void configureButtonBindings() {
    new JoystickButton(controller, 3).whileTrue(new ElevatorPIDcmd(elevatorsubsystem, 1.2)); // 1.2meters is the setpoint
    new JoystickButton(controller, 4).whileTrue(new ElevatorPIDcmd(elevatorsubsystem, 0)); //reset the elevator to setpoint 0
    new JoystickButton(controller, 1).whileTrue(new ElevatorJoystickCmd(elevatorsubsystem, 0.5)); //move the elevator up
    new JoystickButton(controller, 2).whileTrue(new ElevatorJoystickCmd(elevatorsubsystem, -0.5)); //move the elevator down
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
