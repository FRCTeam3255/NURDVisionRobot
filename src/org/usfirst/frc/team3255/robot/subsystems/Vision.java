package org.usfirst.frc.team3255.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	
	// Creates a new NetworkTable variable named data
	NetworkTable visionData; 
	
	public Vision() {
		 visionData = NetworkTableInstance.getDefault().getTable("NURDVision");
	}
	
	public double getTargetDistance() {
		return visionData.getEntry("Distance").getDouble(-99.9);
	}
	
	public double getTargetOffset() {
		return visionData.getEntry("Offset").getDouble(-99.9);
	}
	
	public double getTargetAngle() {
		 return visionData.getEntry("Angle").getDouble(-99.9);
	}
	 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

