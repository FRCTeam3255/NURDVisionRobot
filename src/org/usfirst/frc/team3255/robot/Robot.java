
package org.usfirst.frc.team3255.robot;


import org.usfirst.frc.team3255.robot.commands.Autonomous;
import org.usfirst.frc.team3255.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3255.robot.subsystems.CubeDistancePID;
import org.usfirst.frc.team3255.robot.subsystems.CubeOffsetPID;
import org.usfirst.frc.team3255.robot.subsystems.DistancePID;
import org.usfirst.frc.team3255.robot.subsystems.OffsetPID;
import org.usfirst.frc.team3255.robot.subsystems.Telemetry;
import org.usfirst.frc.team3255.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Drivetrain drivetrain = null;
	public static Vision vision = null;
	public static DistancePID distancePID = null;
	public static OffsetPID offsetPID = null;
	public static CubeDistancePID cubeDistancePID = null;
	public static CubeOffsetPID cubeOffsetPID = null;
	public static Telemetry telemetry = null;
	public static OI oi;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		vision = new Vision();
		drivetrain = new Drivetrain();
		distancePID = new DistancePID();
		offsetPID = new OffsetPID();
		cubeDistancePID = new CubeDistancePID();
		cubeOffsetPID = new CubeOffsetPID();
		telemetry = new Telemetry();
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		autonomousCommand = new Autonomous();

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
