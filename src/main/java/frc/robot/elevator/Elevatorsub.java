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


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import com.ctre.phoenix.motorcontrol.can.*;
/**
 * Add your docs here.
 */
public class ElevatorSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // public static WPI_TalonSRX elevatorMotorR;
  public WPI_TalonSRX elevatorMotorL;
  public int level = 0;

  public ElevatorSub() {
    // elevatorMotorR = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_R);
    elevatorMotorL = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_L);
    elevatorMotorL.setInverted(true);

    elevatorMotorL.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    // If the encoder reports negative values, change this to true
   elevatorMotorL.setSensorPhase(false);

   elevatorMotorL.configAllowableClosedloopError(0, 4096 / 3);



		/* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */

		//elevatorMotorL.config_kF(Constants.kPIDLoopIdx, Constants.kGains.kF, Constants.kTimeoutMs);

		elevatorMotorL.config_kP(0, 1.0 / (4096 * 4));

		elevatorMotorL.config_kI(0, 0.0);

		elevatorMotorL.config_kD(0, 0.0);

    int absolutePosition = elevatorMotorL.getSensorCollection().getPulseWidthPosition();



		/* Mask out overflows, keep bottom 12 bits */

		// absolutePosition &= 0xFFF;

		// if (Constants.kSensorPhase) { absolutePosition *= -1; }

		// if (Constants.kMotorInvert) { absolutePosition *= -1; }

		

		// /* Set the quadrature (relative) sensor to match absolute */

		// elevatorMotorL.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
                                    
    


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
    // elevatorMotorR.set(speed);
  }

  public void setHeight(double height) {
    // To do when the elevator encoder is added
    elevatorMotorL.set(ControlMode.Position, height);
  }

  public void changeLevel(int levelChange) {
    level = level + levelChange;
    if (level > 2) {
      level = 2;
    } else if (level < 0) {
      level = 0;
    }
    setHeight(RobotMap.ELEVATOR_HEIGHTS[level]);
  } 

  /**
   * 
   * @return The elevator height in inches
   */
  public double getHeight() {
    return 0; // To do when the elevator encoder is added
  }
  
}
