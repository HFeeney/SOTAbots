package org.usfirst.frc.team2557.robot.subsystems;

import org.usfirst.frc.team2557.robot.RobotMap;
import org.usfirst.frc.team2557.robot.commands.pidLiftCommand;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class pidLiftSub extends PIDSubsystem {
	static double Kp = 1;
	static double Ki = 0;
	static double Kd = 0;
	static double Kf = 1;
	
	    // Initialize your subsystem here
    public pidLiftSub() {
    	super("Lift", Kp, Ki, Kd, Kf);
        setSetpoint(3000);
        // Sets where the PID controller should move the system   to
        enable();
        // Enables the PID controller.
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new pidLiftCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
