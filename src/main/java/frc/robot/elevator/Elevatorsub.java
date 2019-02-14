/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.elevator;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.elevator.commands.DisableElevator;
/**
 * Add your docs here.
 */
public class ElevatorSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static WPI_TalonSRX elevatorMotorR;
  public static WPI_TalonSRX elevatorMotorL;

  public ElevatorSub() {
    elevatorMotorR = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_R);
    elevatorMotorL = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_L);
    elevatorMotorL.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DisableElevator());
  }

  public void setSpeed(double speed) {
    // This code only works with an elevator encoder
    // if (speed < 0) {
    //   double maxSpeed = -(1.0/6.0)*getHeight()-0.2;
    //   if (speed < maxSpeed) {
    //     speed = maxSpeed;
    //   }
    // } else if (speed > 0) {
    //   double maxSpeed = (1.0/6.0)*getHeight()+0.2;
    //   if (speed > maxSpeed) {
    //     speed = maxSpeed;
    //   }
    // }     
    elevatorMotorL.set(speed);
    elevatorMotorR.set(speed);
  }

  public void setHeight(double height) {
    // To do when the elevator encoder is added
  }

  /**
   * 
   * @return The elevator height in inches
   */
  public double getHeight() {
    return 0; // To do when the elevator encoder is added
  }
  
}
