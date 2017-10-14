package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.RobotPreferences;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {


	private CANTalon leftTalon = null;
	private CANTalon rightTalon = null;
	private Encoder leftEncoder = null;
	private Encoder rightEncoder = null;
	
	private RobotDrive robotDrive = null;
	
	public Drivetrain() {
		//CANTalons
		leftTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_TALON);
		
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_ENCODER_CH_A, RobotMap.DRIVETRAIN_LEFT_ENCODER_CH_B);
		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_RIGHT_ENCODER_CH_A, RobotMap.DRIVETRAIN_RIGHT_ENCODER_CH_A);
		
		leftTalon.enableBrakeMode(true);
		rightTalon.enableBrakeMode(true);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);
		
		robotDrive = new RobotDrive(leftTalon, rightTalon);
		
		robotDrive.setSafetyEnabled(false);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){
		robotDrive.arcadeDrive(-moveSpeed, rotateSpeed);
	}

	public double getLeftEncoderDistance() {
		return leftEncoder.get()/RobotPreferences.;
	}
	
	 public void initDefaultCommand() {
	        // Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    	setDefaultCommand(new DriveArcade());    
	}
}

