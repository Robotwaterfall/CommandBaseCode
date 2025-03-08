// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants.Elevatorconstants;
import frc.robot.Constants.Intakeconstants;
import frc.robot.commands.ArcadeDrivecmd;
import frc.robot.commands.ElevatorJoystickCmd;
import frc.robot.commands.ElevatorPIDcmd;
import frc.robot.commands.Intakecmd;


public class RobotContainer {
  private final DriveTrainSubsystem drivetrainSubsystem = new DriveTrainSubsystem(); //DriveTrain subsystem
  private final IntakeSubsystem intakesubsystem = new IntakeSubsystem(); //Intake subsystem
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
    new JoystickButton(controller, 3).whileTrue(new ElevatorPIDcmd(elevatorsubsystem, Elevatorconstants.kElevatorSetpointgoto)); // go to the setpoint
    new JoystickButton(controller, 4).whileTrue(new ElevatorPIDcmd(elevatorsubsystem, Elevatorconstants.kElevatorSetpointreturn)); //reset the elevator setpoint to its original state/point
    new JoystickButton(controller, 1).whileTrue(new ElevatorJoystickCmd(elevatorsubsystem, Elevatorconstants.kElevatorSpeedup)); //move the elevator up
    new JoystickButton(controller, 2).whileTrue(new ElevatorJoystickCmd(elevatorsubsystem, Elevatorconstants.kElevatorSpeeddown)); //move the elevator down
    new JoystickButton(controller, 5).whileTrue(new Intakecmd(intakesubsystem, Intakeconstants.kIntakeSpeedin)); 
    new JoystickButton(controller, 6).whileTrue(new Intakecmd(intakesubsystem, Intakeconstants.kIntakeSpeedout));
  }

  public Command getAutonomousCommand() {
    new SequentialCommandGroup(
      new ElevatorPIDcmd(elevatorsubsystem, Elevatorconstants.kElevatorSetpointgoto), //

      new ParallelCommandGroup(
        new Intakecmd(intakesubsystem, Intakeconstants.kIntakeSpeedin) //
      )//
    );
    return null;
  }
}
