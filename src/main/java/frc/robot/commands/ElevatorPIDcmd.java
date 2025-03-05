// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;


public class ElevatorPIDcmd extends Command {

  private final ElevatorSubsystem elevatorSubsystem;
  private final PIDController pidcontroller;

  public ElevatorPIDcmd(ElevatorSubsystem elevatorSubsystem, double setpoint) {
    this.elevatorSubsystem = elevatorSubsystem;
    this.pidcontroller = new PIDController(3, 0, 0.8);
    pidcontroller.setSetpoint(setpoint);
    addRequirements(elevatorSubsystem);
  
  }

  @Override
  public void initialize() {
    pidcontroller.reset();
  }


  @Override
  public void execute() {
    System.out.println("ElevatorPIDcmd executed");
    double speed = pidcontroller.calculate(elevatorSubsystem.getEncoderMeters());
    elevatorSubsystem.setSpeed(speed);
  }


  @Override
  public void end(boolean interrupted) {
    System.out.println("ElevatorPIDcmd ended");
    elevatorSubsystem.setSpeed(0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
