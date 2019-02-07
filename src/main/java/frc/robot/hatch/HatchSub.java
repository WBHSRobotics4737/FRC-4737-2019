package frc.robot.hatch;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class HatchSub extends Subsystem {

    private DoubleSolenoid topsolenoid, bottomsolenoid;

    public HatchSub() {
        topsolenoid = new DoubleSolenoid(RobotMap.TOPSOLENOID_FORWARDCHANNEL, RobotMap.TOPSOLENOID_REVERSECHANNEL);
        bottomsolenoid = new DoubleSolenoid(RobotMap.BOTTOMSOLENOID_FORWARDCHANNEL, RobotMap.BOTTOMSOLENOID_REVERSECHANNEL);
    }

    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      //setDefaultCommand(new DisableHatch());
    }
    public void closePneumatics() {

      setPneumatics(Value.kReverse, Value.kReverse);
  
    }
  
  
  
    public void openPneumatics() {
  
      setPneumatics(Value.kForward, Value.kForward);
  
    }
  
  
  
    public void disablePneumatics() {
  
      setPneumatics(Value.kOff, Value.kOff);
  
    }
  
  
  
    public void setPneumatics(DoubleSolenoid.Value top, DoubleSolenoid.Value bottom) {
  
      topsolenoid.set(top);
  
      bottomsolenoid.set(bottom);
  
    }

}



