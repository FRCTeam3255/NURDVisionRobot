package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.Robot;

/**
 *
 */
public class CubeOffsetPID extends OffsetPID {
	
	// Initialize your subsystem here
    public CubeOffsetPID() {
    	super();
    }
    
    protected double returnPIDInput() {
        return Robot.vision.getCubeOffset();
    }
}
