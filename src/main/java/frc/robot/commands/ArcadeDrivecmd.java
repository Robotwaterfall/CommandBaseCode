// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ArcadeDrivecmd extends Command {
  private final DriveTrainSubsystem drivetrianSubsystem;
  private final Supplier<Double> speedFunction, turnFunction;

  public ArcadeDrivecmd (DriveTrainSubsystem drivetrianSubsystem, //
        Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.drivetrianSubsystem = drivetrianSubsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    addRequirements(drivetrianSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("ArcadeDrivecmd initialized");
  }

  @Override
  public void execute() {
    double realtimeSpeed = speedFunction.get();
    double realtimeTurn = turnFunction.get();

    double leftSpeed = realtimeSpeed + realtimeTurn;
    double rightSpeed = realtimeSpeed - realtimeTurn;

    drivetrianSubsystem.setLeftMotors(leftSpeed, rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("ArcadeDrivecmd ended");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
