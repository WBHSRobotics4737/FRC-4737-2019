package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


/**

 *

 */

public class TeleOpRaceDrive extends Command {



	public TeleOpRaceDrive() {

		requires(Robot.DRIVETRAIN);

	}



	// Called just before this Command runs the first time

	protected void initialize() {

		Robot.DRIVETRAIN.setBrakeMode();

		//Robot.DRIVETRAIN.disableVoltageCompensation();

	}



	// Called repeatedly when this Command is scheduled to run

	protected void execute() {

		boolean slow = Robot.OI.driver.getButton("LB").get();
		boolean slowAccel = Robot.OI.driver.getButton("RB").get();
		if (slowAccel) {
			Robot.DRIVETRAIN.setAccelerationLimit(RobotMap.DRIVE_MAX_ACCEL_SLOW);
		} else {
			Robot.DRIVETRAIN.setAccelerationLimit(RobotMap.DRIVE_MAX_ACCEL);
		}

		double throttle = (Robot.OI.driver.getAxis("RT").get() - Robot.OI.driver.getAxis("LT").get())

				* (slow ? RobotMap.DRIVE_SLOW_SCALE : 1);

		double steer = Robot.OI.driver.getThumbstick("LS").X.get() * (slow ? RobotMap.DRIVE_SLOW_SCALE : 1);

		

		Robot.DRIVETRAIN.arcadeDrive(throttle, steer);

	}



	// Make this return true when this Command no longer needs to run execute()

	protected boolean isFinished() {

		return false;

	}



	// Called once after isFinished returns true

	protected void end() {

	}



	// Called when another command which requires one or more of the same

	// subsystems is scheduled to run

	protected void interrupted() {

    }
}



