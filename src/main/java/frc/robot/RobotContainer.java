// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.commands.ArcadeDrivecmd;


public class RobotContainer {
  private final DriveTrainSubsystem drivetrainSubsystem = new DriveTrainSubsystem(); //DriveTrain subsystem
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
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
