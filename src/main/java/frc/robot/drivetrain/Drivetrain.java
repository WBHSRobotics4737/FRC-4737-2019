/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drivetrain;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.libs.JerkLimitedTalonSRXController;
import frc.robot.RobotMap;

import frc.robot.drivetrain.commands.TeleOpDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX frontLeftM;
  private WPI_TalonSRX frontRightM;
  private WPI_TalonSRX rearLeftS;
  private WPI_TalonSRX rearRightS;

  private DifferentialDrive drive;

  private JerkLimitedTalonSRXController lSmoothDrive;
  private JerkLimitedTalonSRXController rSmoothDrive;
  private DifferentialDrive smoothDrive;

  public Drivetrain() {
    frontLeftM = new WPI_TalonSRX(RobotMap.FRONTLEFTM);
    rearLeftS = new WPI_TalonSRX(RobotMap.REARLEFTS);
    frontRightM = new WPI_TalonSRX(RobotMap.FRONTRIGHTM);
    rearRightS = new WPI_TalonSRX(RobotMap.REARRIGHTS);
    
	  //slave follows master configuration
	  rearRightS.follow(frontRightM);
	  rearLeftS.follow(frontLeftM);
    
    // drive = new DifferentialDrive(frontLeftM, frontRightM);
    
    smoothDrive = new DifferentialDrive(
				lSmoothDrive = new JerkLimitedTalonSRXController(frontLeftM, RobotMap.DRIVE_MAX_VEL, RobotMap.DRIVE_MAX_ACCEL, RobotMap.DRIVE_MAX_JERK),
				rSmoothDrive = new JerkLimitedTalonSRXController(frontRightM, RobotMap.DRIVE_MAX_VEL, RobotMap.DRIVE_MAX_ACCEL, RobotMap.DRIVE_MAX_JERK));
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TeleOpDrive());
  }

  public void arcadeDrive(double throttle, double steer) {
    // drive.arcadeDrive(throttle, steer);
    smoothDrive.arcadeDrive(throttle, steer);
  }   

  public void setAccelerationLimit(double accelLimit) {
    lSmoothDrive.setMaxAccel(accelLimit);
    rSmoothDrive.setMaxAccel(accelLimit);
  }

  public void setBrakeMode() {
		frontLeftM.setNeutralMode(NeutralMode.Brake);
		rearLeftS.setNeutralMode(NeutralMode.Brake);
		frontRightM.setNeutralMode(NeutralMode.Brake);
		rearRightS.setNeutralMode(NeutralMode.Brake);
  }

}
