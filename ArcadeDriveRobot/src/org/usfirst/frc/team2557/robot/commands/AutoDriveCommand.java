package org.usfirst.frc.team2557.robot.commands;

import org.usfirst.frc.team2557.robot.Robot;
import org.usfirst.frc.team2557.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveCommand extends Command {

    public AutoDriveCommand() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.bL.getSensorCollection().setQuadraturePosition(0, 10);
    	RobotMap.bR.getSensorCollection().setQuadraturePosition(0, 10);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	Robot.drivetrain.Drive(-.5, 0);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (RobotMap.bL.getSensorCollection().getQuadraturePosition() >= 2500 && RobotMap.bR.getSensorCollection().getQuadraturePosition() <= -2500) {
    		return true;
    	} else {
            return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
