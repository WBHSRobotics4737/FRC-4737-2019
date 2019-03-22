/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.elevator.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.*;
import frc.robot.elevator.ElevatorSub;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class GetElevatorHeight extends InstantCommand {


  public int CurrentHeight;
  public WPI_TalonSRX elevatorMotorL;

  /**
   * Add your docs here.
   */
  public GetElevatorHeight() {
    super();
    // Use requires() here to declare subsystem dependencies
     requires(Robot.ELEVATOR);
     
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    // We can't get figure out how to get the current encoder value for the motor
    CurrentHeight = elevatorMotorL.getSelectedSensorPosition();
    System.out.print(CurrentHeight);
  }

}
