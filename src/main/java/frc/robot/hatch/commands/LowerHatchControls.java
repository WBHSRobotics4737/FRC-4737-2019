package frc.robot.hatch.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



/**

 *

 */

public class LowerHatchControls extends Command {



	public LowerHatchControls() {

		requires(Robot.HATCH);

	}



	// Called just before this Command runs the first time

	protected void initialize() {

	}



	// Called repeatedly when this Command is scheduled to run

	protected void execute() {

		boolean extend = Robot.OI.operator.getButton("A").get();

		boolean retract = Robot.OI.operator.getButton("B").get();



		if (extend) {

			Robot.HATCH.openPneumatics();

		} else if (retract) {

			Robot.HATCH.closePneumatics();

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