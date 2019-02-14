
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.libs.F310Gamepad;
import frc.libs.XboxController;
import frc.robot.drivetrain.commands.*;
import frc.robot.elevator.commands.*;
import frc.robot.intake.commands.*;
import frc.robot.liftsystem.commands.TeleOpLift;
import frc.robot.hatch.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public XboxController driver;
  public F310Gamepad operator;

  public OI() {
    driver = new XboxController(0);

    operator.A.whileHeld(new SetBottomHatchPneumatic(true));
    operator.X.whileHeld(new SetBottomHatchPneumatic(false));
    operator.B.whileHeld(new SetTopHatchPneumatic(true));
    operator.Y.whileHeld(new SetTopHatchPneumatic(false));
    operator.DPAD.LEFT.whenPressed(new SetExtenderHatchPneumatic(false));
    operator.DPAD.RIGHT.whenPressed(new SetExtenderHatchPneumatic(true));
    // operator.getButton("RB").whileHeld(new TeleOpLift());
    // operator.getButton("LB").whileHeld(new TeleOpLift());

    // elevator code
    new Trigger() {
      public boolean get() {
        if (Robot.getInstance() == null)
          return false;
        return (operator.RS.Y.get() != 0);
      }
    }.whileActive(new TeleOpControlElevator());

    // elevator code
    new Trigger() {
      public boolean get() {
        if (Robot.getInstance() == null)
          return false;
        return (operator.RT.get() != 0 || operator.LT.get() != 0);
      }
    }.whileActive(new TeleOpControlIntake());

    // Driver code
    new Trigger() {
      public boolean get() {
        if (Robot.getInstance() == null)
          return false;
        return (Robot.OI.driver.LT.get() != 0 || Robot.OI.driver.RT.get() != 0 || Robot.OI.driver.LS.X.get() != 0);
      }
    }.whileActive(new TeleOpRaceDrive());

  }

}
