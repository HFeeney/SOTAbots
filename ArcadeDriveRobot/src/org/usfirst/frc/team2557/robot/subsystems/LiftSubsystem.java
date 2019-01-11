package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.LiftCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void lift() {
		double axis = Robot.m_oi.controller.getRawAxis(5);
		
		RobotMap.lift1.set(axis * .5);
		RobotMap.lift2.set(axis * .5);
		
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new LiftCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

