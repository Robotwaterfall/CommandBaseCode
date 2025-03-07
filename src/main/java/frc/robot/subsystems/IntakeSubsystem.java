// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Intakeconstants;

public class IntakeSubsystem extends SubsystemBase {

  private SparkMax intakeMotor = new SparkMax(Intakeconstants.kIntakeMotorPort, SparkMax.MotorType.kBrushless);

  public void setSpeed(double speed) {
    intakeMotor.set(speed);
  }

  public void setSpeed(){
    intakeMotor.set(0);
  }
  
  public IntakeSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
