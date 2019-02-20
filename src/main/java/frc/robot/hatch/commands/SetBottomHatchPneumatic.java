/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hatch.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class SetBottomHatchPneumatic extends InstantCommand {

  private boolean extended;

  /**
   * Add your docs here.
   */
  public SetBottomHatchPneumatic(boolean extended) {
    super();
    requires(Robot.HATCH);

    this.extended = extended;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    /*
    if (extended) {
      Robot.HATCH.extendBottom();
    } else {
      Robot.HATCH.retractBottom();
    }
    */
  }

}
