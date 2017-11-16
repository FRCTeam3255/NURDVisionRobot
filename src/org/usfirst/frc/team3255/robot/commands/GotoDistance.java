package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.Robot;
import org.usfirst.frc.team3255.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GotoDistance extends Command {
	
	double targetDistance;
	String commandName;
	double targetOffset;

    public GotoDistance(String name, double inches, double offset) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.drivetrainDistancePID);
    	
    	targetDistance = inches;
    	commandName = name;
    	targetOffset= offset;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.telemetry.setAutonomousStatus("Starting " + commandName + ": " + targetDistance + " inches");
    	Robot.drivetrainDistancePID.setSetpoint(targetDistance);
    	Robot.drivetrainDistancePID.setRawTolerance(RobotPreferences.distanceTolerance());
    	Robot.drivetrainOffsetPID.setSetpoint(targetOffset);
    	Robot.drivetrainOffsetPID.setRawTolerance(RobotPreferences.offsetTolerance());
    	
    	Robot.drivetrainDistancePID.enable();
    	Robot.drivetrainOffsetPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.telemetry.setAutonomousStatus("Running " + commandName + ": " + targetDistance + " inches");
    	Robot.drivetrain.arcadeDrive(Robot.drivetrainDistancePID.getOutput(), Robot.drivetrainOffsetPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.drivetrainDistancePID.onRawTarget() && Robot.drivetrainOffsetPID.onRawTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.telemetry.setAutonomousStatus("Finished " + commandName + ": " + targetDistance + " inches");
    	
    	Robot.drivetrainDistancePID.disable();
    	Robot.drivetrainOffsetPID.disable();
    	
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
