package frc.robot.hatch;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.hatch.commands.DisableHatch;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class HatchSub extends Subsystem {

  private DoubleSolenoid topsolenoid, bottomsolenoid;
  private DoubleSolenoid extendersolenoid;

  public HatchSub() {
    topsolenoid = new DoubleSolenoid(RobotMap.TOPSOLENOID_FORWARDCHANNEL, RobotMap.TOPSOLENOID_REVERSECHANNEL);
    bottomsolenoid = new DoubleSolenoid(RobotMap.BOTTOMSOLENOID_FORWARDCHANNEL, RobotMap.BOTTOMSOLENOID_REVERSECHANNEL);
    extendersolenoid = new DoubleSolenoid(RobotMap.SINGLESOLENOID_FORWARDCHANNEL, RobotMap.SINGLESOLENOID_REVERSECHANNEL);
  }

  public void extendTop() {
    topsolenoid.set(Value.kForward);
  }

  public void retractTop() {
    topsolenoid.set(Value.kReverse);
  }

  public void extendBottom() {
    bottomsolenoid.set(Value.kForward);
  }

  public void retractBottom() {
    bottomsolenoid.set(Value.kReverse);
  }

  public void extendExtender() {
    extendersolenoid.set(Value.kForward);
  }

  public void retractExtender() {
    extendersolenoid.set(Value.kReverse);
  }

  public void disablePneumatics() {
    setPneumatics(Value.kOff, Value.kOff);
  }

  public void setPneumatics(DoubleSolenoid.Value top, DoubleSolenoid.Value bottom) {
    topsolenoid.set(top);
    bottomsolenoid.set(bottom);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DisableHatch());
  }

}
