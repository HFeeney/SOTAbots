package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class pidTurretCommand extends Command {
	PIDController pidcontroller;
	double target;
  	double factor = 0.00001;
	public static double PTurret = 0.41;
	public static double ITurret = 0.00;
  	public static double DTurret = 0.0;
  
	public static double pidTurretStall = -0.07;

	public void PIDspin(double target) {

    requires(Robot.turretSub);
    
		pidcontroller = new PIDController(factor* PTurret, factor * ITurret, factor * DTurret, new PIDSource(){

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				return RobotMap.m_turret.getSensorCollection().getQuadraturePosition();
      }
      
		}, new PIDOutput(){

			@Override
			public void pidWrite(double output) {
        double power = -output;
        
        // double power = 0;
        
				if(power <= 0){
					power *= 0.9;
        }
        
				if(RobotMap.m_turret.getSensorCollection().getQuadraturePosition() > 0){
					power += pidTurretStall;
        }
        
        Robot.turretSub.spin(power);
        
			}
		});
		this.target = target;
		pidcontroller.setOutputRange(-1, 1);
		pidcontroller.setAbsoluteTolerance(3000);
	}

	protected void initialize() {
		pidcontroller.reset();
		pidcontroller.setSetpoint(target);
		pidcontroller.enable();
	}

	public void setSetpoint(double target){
		this.target = target;
	}
	
	protected void execute(){
		// if(Robot.m_oi.stick.getPOV() == 270){
		// 	pidcontroller.setSetpoint(target + 20000);
    // }
    

	}

	protected boolean isFinished() {
		if (pidcontroller.onTarget()) {
			Robot.gyroLast = Robot.gyro.getAngle();
			return true;
		}
		return false;
	}

	protected void end() {
		Robot.turretSub.spin(0);
		pidcontroller.disable();
	}

	protected void interrupted() {
		pidcontroller.disable();
		this.end();
	}
}