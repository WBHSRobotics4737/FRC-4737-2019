package frc.robot.liftsystem.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



/**

 *

 */

public class TeleOpLift extends Command {




	public TeleOpLift() {

		requires(Robot.LIFT);

	}



	// Called just before this Command runs the first time

	protected void initialize() {

	}



	// Called repeatedly when this Command is scheduled to run

	protected void execute() {

		boolean extend = Robot.OI.operator.getButton("RB").get();

		boolean release = Robot.OI.operator.getButton("LB").get();



		if (extend) {

			Robot.LIFT.openPneumatics();

		} else if (release) {

			Robot.LIFT.closePneumatics();

		}

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