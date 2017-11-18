package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.Robot;
import org.usfirst.frc.team3255.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MaintainDistance extends Command {
	
	double distance;
	String commandName;

    public MaintainDistance(String name, double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.distancePID);
    	
    	distance = inches;
    	commandName = name;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + distance + " inches");
    	Robot.distancePID.setSetpoint(distance);
    	Robot.distancePID.setRawTolerance(RobotPreferences.distanceTolerance());
    	
    	Robot.distancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.telemetry.setAutonomousStatus("Running " + commandName + ": " + distance + " inches");
    	Robot.drivetrain.arcadeDrive(Robot.distancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Robot.drivetrainDistancePID.onRawTarget();
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finished " + commandName + ": " + distance + " inches");
    	
    	Robot.distancePID.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
