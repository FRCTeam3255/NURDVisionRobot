package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.Robot;
import org.usfirst.frc.team3255.robot.RobotPreferences;
import org.usfirst.frc.team3255.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Telemetry() {
		SmartDashboard.putData("Move To Cube", new MoveToCube(RobotPreferences.cubeDistanceSetpoint()));
		SmartDashboard.putData("Go To Distance", new GotoDistance("GoToDistance", RobotPreferences.goToDistanceSetpoint(), 0.0));
		
		SmartDashboard.putData("Reset Yaw", new ResetYaw());
	}
	
	public void update() {
		// Puts values received from NURDVision on the SmartDashboard
		SmartDashboard.putNumber("Distance", Robot.vision.getTargetDistance());
		SmartDashboard.putNumber("Offset", Robot.vision.getTargetOffset());
		SmartDashboard.putNumber("Angle", Robot.vision.getTargetAngle());
		SmartDashboard.putNumber("Cube Distance", Robot.vision.getCubeDistance());
		SmartDashboard.putNumber("Cube Offset", Robot.vision.getCubeOffset());
		
		SmartDashboard.putNumber("Yaw", Robot.navigation.getYaw());
		SmartDashboard.putNumber("Roll", Robot.navigation.getRoll());
		SmartDashboard.putNumber("Pitch", Robot.navigation.getPitch());
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Autonomous Status", statusText);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

