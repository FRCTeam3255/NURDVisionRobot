package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {


	private Talon leftTalon = null;
	private Talon rightTalon = null;
	
	private DifferentialDrive robotDrive = null;
	
	public Drivetrain() {
		//CANTalons
		leftTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_TALON);
		rightTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_TALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);
		
		robotDrive = new DifferentialDrive(leftTalon, rightTalon);
		
		robotDrive.setSafetyEnabled(false);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){
		robotDrive.arcadeDrive(moveSpeed, -rotateSpeed);
	}

	 public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand()); 
	}
}

