package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {


	private WPI_TalonSRX leftTalon = null;
	private WPI_TalonSRX rightTalon = null;
	
	private DifferentialDrive robotDrive = null;
	
	public Drivetrain() {
		//CANTalons
		leftTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_TALON);
		rightTalon = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_TALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);
		
		leftTalon.setNeutralMode(NeutralMode.Brake);
		rightTalon.setNeutralMode(NeutralMode.Brake);
		
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

