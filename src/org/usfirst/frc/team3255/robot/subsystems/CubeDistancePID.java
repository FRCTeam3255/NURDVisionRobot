package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.Robot;

/**
 *
 */
public class CubeDistancePID extends DistancePID {
	
    // Initialize your subsystem here
    public CubeDistancePID() {
    	super();
    }
    
    protected double returnPIDInput() {
        return Robot.vision.getCubeDistance();
    }
}
