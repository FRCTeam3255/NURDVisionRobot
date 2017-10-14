package org.usfirst.frc.team3255.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends Subsystem {
	 
	NetworkTable table;
	 public Vision() {
		 table = NetworkTable.getTable("NURDVision");
	 }
	 public double getTargetDistance() {
		return table.getNumber("Distance", -99.9);
	 }
	 public double getTargetOffset() {
	    return table.getNumber("Offset", -99.9);
	 }
	 public double getTargetAngle() {
		 return table.getNumber ("Angle",-99.9);
	 }
	 
	 
	 
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

