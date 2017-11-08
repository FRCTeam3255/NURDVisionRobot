package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void update() {
		SmartDashboard.putNumber("Distance", Robot.vision.getTargetDistance());
		SmartDashboard.putNumber("Offset", Robot.vision.getTargetOffset());
		SmartDashboard.putNumber("Angle", Robot.vision.getTargetAngle());
	}
	
	public void setAutonomousStatus(String statusText) {
		SmartDashboard.putString("Autonomous Status", statusText);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

