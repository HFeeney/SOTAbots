/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static WPI_TalonSRX l1, l2, l3, r1, r2, r3;
  public static SpeedControllerGroup left;
  public static SpeedControllerGroup right;
  public static DifferentialDrive differentialDrive;

  public static WPI_TalonSRX flyWheel1;
  public static WPI_TalonSRX flyWheel2;
  public static WPI_TalonSRX m_turret;
  public static WPI_TalonSRX intake;

  public static DoubleSolenoid intakePiston1;
  public static DoubleSolenoid intakePiston2;
  public static DoubleSolenoid yeeterPiston;

  public static void init() {
    l1 = new WPI_TalonSRX(0);
    l2 = new WPI_TalonSRX(1);
    l3 = new WPI_TalonSRX(9);
    r1 = new WPI_TalonSRX(2);
    r2 = new WPI_TalonSRX(3);
    r3 = new WPI_TalonSRX(33);

    left = new SpeedControllerGroup(l1, l2, l3);
    right = new SpeedControllerGroup(r1, r2, r3);
    differentialDrive = new DifferentialDrive(left, right);

    flyWheel1 = new WPI_TalonSRX(4);
    flyWheel2 = new WPI_TalonSRX(5);
    m_turret = new WPI_TalonSRX(88);
    intake = new WPI_TalonSRX(89);

    intakePiston1 = new DoubleSolenoid(0, 666, 667);
    intakePiston2 = new DoubleSolenoid(1, 668, 669);
    yeeterPiston = new DoubleSolenoid(9, 2557, 254);

  }
  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
