package org.usfirst.frc.team3255.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends Subsystem {
	
	// Creates a new NetworkTable variable named data
	NetworkTable data; 
	
	public Vision() {
		 data = NetworkTable.getTable("NURDVision");
	}
	
	public double getTargetDistance() {
		return data.getNumber("Distance", -99.9);
	}
	
	public double getTargetOffset() {
		return data.getNumber("Offset", -99.9);
	}
	
	public double getTargetAngle() {
		 return data.getNumber ("Angle",-99.9);
	}
	 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

