/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int FRONTLEFTM = 10;
  public static int FRONTRIGHTM = 11;
  public static int REARLEFTS = 12;
  public static int REARRIGHTS = 13;
  
  public static int INTAKE_MOTOR = 14;

  public static int ELEVATOR_MOTOR_R = 15;
  public static int ELEVATOR_MOTOR_L = 16;

  // Pneumatics
  // Hatch Pneumatics
  public static int TOPSOLENOID_FORWARDCHANNEL = 0;
  public static int TOPSOLENOID_REVERSECHANNEL = 1;
  public static int BOTTOMSOLENOID_FORWARDCHANNEL = 2;
  public static int BOTTOMSOLENOID_REVERSECHANNEL = 3;
  public static int SINGLESOLENOID_FORWARDCHANNEL = 10;
  public static int SINGLESOLENOID_REVERSECHANNEL = 11;

  // Lift subsystem
  public static int TOPLIFTSOLENOID_FORWARDCHANNEL = 4;
  public static int TOPLIFTSOLENOID_REVERSECHANNEL = 5;
  public static int MIDDLELIFTSOLENOID_FORWARDCHANNEL = 6;
  public static int MIDDLELIFTSOLENOID_REVERSECHANNEL = 7;
  public static int BOTTOMLIFTSOLENOID_FORWARDCHANNEL = 8;
  public static int BOTTOMLIFTSOLENOID_REVERSECHANNEL = 9;

  //Fun Constants
  public static final double DRIVE_SLOW_SCALE = 0.5;

}