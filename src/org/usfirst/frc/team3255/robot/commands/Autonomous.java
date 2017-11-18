package org.usfirst.frc.team3255.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	//Change between GotoDistance and MaintainDistance (Maintain never finishes)
    	addSequential(new GotoDistance("GotoDistance", 10.0, 0.0));
    }
}
