// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public final static class Intakeconstants {
    // Intake Motor Ports
    public static final int kIntakeMotorPort = 0; //yet to be decieded!
    //Intake speed
    public static final double kIntakeSpeedin = 1; // the speed the intake goes in, 100% speed
    public static final double kIntakeSpeedout = -1; // the speed the intake goes out, 100% speed

  }
  public final class Elevatorconstants {
  // Elevator Motor Ports
  public static final int kElevatorMotorPort = 13;
  
  // Elevator speed (arcade drive)
  public static final double kElevatorSpeedup = 0.5; // 0.5 is the speed
  public static final double kElevatorSpeeddown = -0.5; // -0.5 is the speed

  // Elevator PID Constants 
  public static final double kElevatorSetpointreturn = 0; // the setpoint for the elevator to return to (0 meters)
  public static final double kElevatorSetpointgoto = 1.2; // the setpoint for the elevator to go to (1.2 meters)
  
}
  public final class DriveTrainconstants {
  // DriveTrain Motor Ports
  public static final int kLeftMotorPort1 = 18;
  public static final int kLeftMotorPort2 = 3;
  public static final int kRightMotorPort1 = 4;
  public static final int kRightMotorPort2 = 1;
}

}
