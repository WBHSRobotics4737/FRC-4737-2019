package frc.robot.hatch.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



/**

 *

 */

public class OpenHatch extends Command {



	public OpenHatch() {

		requires(Robot.HATCH);

	}



	// Called just before this Command runs the first time

	protected void initialize() {

	}



	// Called repeatedly when this Command is scheduled to run

	protected void execute() {

		boolean grab = Robot.OI.driver.getButton("X").get();

		boolean release = Robot.OI.driver.getButton("Y").get();



		if (grab) {

			Robot.HATCH.closePneumatics();

		} else if (release) {

			Robot.HATCH.openPneumatics();

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