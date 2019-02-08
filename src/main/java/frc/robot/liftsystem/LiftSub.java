package frc.robot.liftsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.liftsystem.commands.TeleOpLiftDisable;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class LiftSub extends Subsystem {

    private DoubleSolenoid topliftsolenoid, bottomliftsolenoid, middleliftsolenoid;

    public LiftSub() {
        topliftsolenoid = new DoubleSolenoid(RobotMap.TOPLIFTSOLENOID_FORWARDCHANNEL, RobotMap.TOPLIFTSOLENOID_REVERSECHANNEL);
        bottomliftsolenoid = new DoubleSolenoid(RobotMap.BOTTOMLIFTSOLENOID_FORWARDCHANNEL, RobotMap.BOTTOMLIFTSOLENOID_REVERSECHANNEL);
        middleliftsolenoid = new DoubleSolenoid(RobotMap.MIDDLELIFTSOLENOID_FORWARDCHANNEL, RobotMap.MIDDLELIFTSOLENOID_REVERSECHANNEL);
    }

    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      setDefaultCommand(new TeleOpLiftDisable());
    }
    public void closePneumatics() {

      setPneumatics(Value.kReverse, Value.kReverse, Value.kReverse);
  
    }
  
  
  
    public void openPneumatics() {
  
      setPneumatics(Value.kForward, Value.kForward, Value.kForward);
  
    }
  
  
  
    public void disablePneumatics() {
  
      setPneumatics(Value.kOff, Value.kOff, Value.kOff);
  
    }
  
  
  
    public void setPneumatics(DoubleSolenoid.Value top, DoubleSolenoid.Value bottom, DoubleSolenoid.Value middle) {
  
      topliftsolenoid.set(top);
      middleliftsolenoid.set(middle);
      bottomliftsolenoid.set(bottom);
  
    }

}




