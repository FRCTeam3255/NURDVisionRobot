package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.Robot;
import org.usfirst.frc.team3255.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveToCube extends Command {
	double distance;
	
    public MoveToCube(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cubeDistancePID);
//    	requires(Robot.cubeOffsetPID);
    	
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cubeDistancePID.setRawTolerance(RobotPreferences.cubeDistanceTolerance());
    	Robot.cubeDistancePID.setSetpoint(distance);
//    	Robot.cubeOffsetPID.setRawTolerance(RobotPreferences.cubeOffsetTolerance());
//    	Robot.cubeOffsetPID.setSetpoint(0.0);
    	
    	Robot.cubeDistancePID.enable();
//    	Robot.cubeOffsetPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.drivetrain.arcadeDrive(Robot.cubeDistancePID.getOutput(), Robot.cubeOffsetPID.getOutput());
    	Robot.drivetrain.arcadeDrive(Robot.cubeDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//      return Robot.cubeDistancePID.onRawTarget() && Robot.cubeOffsetPID.onRawTarget();
        return Robot.cubeDistancePID.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cubeDistancePID.disable();
//    	Robot.cubeOffsetPID.disable();
    	Robot.drivetrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
