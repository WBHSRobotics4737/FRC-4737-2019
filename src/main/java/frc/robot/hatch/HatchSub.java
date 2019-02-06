package frc.robot.hatch;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;



public class HatchSub extends Subsystem {

    private Solenoid topsolenoid, bottomsolenoid;

    public HatchSub() {
        topsolenoid = new Solenoid(RobotMap.TOPSOLENOID);
        bottomsolenoid = new Solenoid(RobotMap.BOTTOMSOLENOID);
    }

    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      setDefaultCommand(new DisableHatch());
    }

}



