// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Elevatorconstants;

public class ElevatorSubsystem extends SubsystemBase {

  private SparkMax PIDmotor = new SparkMax(Elevatorconstants.kElevatorMotorPort, MotorType.kBrushless);
  private final double kEncoderTick2Meter = 1.0/4096.0 * 0.1 * Math.PI;

  public double getEncoderMeters() {
    return getEncoderPosition() * kEncoderTick2Meter;
  }
  private final double getEncoderPosition() {
    return PIDmotor.getEncoder().getPosition();
  }

  /** Creates a new ElevatorPIDSubsystem. */
  public ElevatorSubsystem() {

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm Encoder", getEncoderPosition());
  }

  public void setSpeed(double speed) {
    PIDmotor.set(speed);
  }
}
