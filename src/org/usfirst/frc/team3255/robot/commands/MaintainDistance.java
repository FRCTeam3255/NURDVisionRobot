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
    	requires(Robot.drivetrainDistancePID);
    	
    	distance = inches;
    	commandName = name;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + distance / 12 + " feet");
    	Robot.drivetrainDistancePID.setSetpoint(distance);
    	Robot.drivetrainDistancePID.setRawTolerance(RobotPreferences.distanceTolerance());
    	
    	Robot.drivetrainDistancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(Robot.drivetrainDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drivetrainDistancePID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finished " + commandName + ": " + distance / 12 + " feet");
    	
    	Robot.drivetrainDistancePID.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
