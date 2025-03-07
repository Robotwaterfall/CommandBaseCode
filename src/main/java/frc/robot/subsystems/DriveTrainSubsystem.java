// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainconstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrainSubsystem extends SubsystemBase {
  private TalonSRX LeftMasterMotor1 = new TalonSRX(DriveTrainconstants.kLeftMotorPort1);
  private TalonSRX LeftMasterMotor2 = new TalonSRX(DriveTrainconstants.kLeftMotorPort2);
  private TalonSRX RightMasterMotor1 = new TalonSRX(DriveTrainconstants.kRightMotorPort1);
  private TalonSRX RightMasterMotor2 = new TalonSRX(DriveTrainconstants.kRightMotorPort2);

  /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run 
  }

  public void setLeftMotors(double Leftspeed, double Rightspeed){ {
    LeftMasterMotor1.set(ControlMode.PercentOutput, Leftspeed);
    LeftMasterMotor2.set(ControlMode.PercentOutput, Leftspeed);
    RightMasterMotor1.set(ControlMode.PercentOutput, Rightspeed);
    RightMasterMotor2.set(ControlMode.PercentOutput, Rightspeed);
  }
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
