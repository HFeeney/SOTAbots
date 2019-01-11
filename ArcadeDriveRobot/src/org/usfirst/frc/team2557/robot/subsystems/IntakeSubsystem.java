package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	
	public void takeIn() {
		double axisIn = Robot.m_oi.controller.getRawAxis(3);
				
		RobotMap.intake1.set(axisIn);
		RobotMap.intake2.set(-axisIn);
	}
	public void takeOut() {
		double axisOut = Robot.m_oi.controller.getRawAxis(2);
		
		RobotMap.intake1.set(-axisOut);
		RobotMap.intake2.set(axisOut);
	}
	



    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

