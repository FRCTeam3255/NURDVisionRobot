package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ResetYaw extends InstantCommand {

    public ResetYaw() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.navigation);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.navigation.resetYaw();
    }

}
