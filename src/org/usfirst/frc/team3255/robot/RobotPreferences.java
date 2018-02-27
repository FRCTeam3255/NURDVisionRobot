package org.usfirst.frc.team3255.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	// ====== Drive Distance PID Values ====== //
	public static double driveDistanceP() {
		return Preferences.getInstance().getDouble("DriveDistanceP", 0.0);
	}

	public static double driveDistanceI() {
		return Preferences.getInstance().getDouble("DriveDistanceI", 0.0);
	}

	public static double driveDistanceD() {
		return Preferences.getInstance().getDouble("DriveDistanceD", 0.0);
	}
	
	public static double distanceTolerance() {
		return Preferences.getInstance().getInt("DistanceTolerance", 5);
	}
	
	
	// ====== Drive Offset PID Values ====== //
	public static double driveOffsetP() {
		return Preferences.getInstance().getDouble("DriveOffsetP", 0.0);
	}

	public static double driveOffsetI() {
		return Preferences.getInstance().getDouble("DriveOffsetI", 0.0); 
	}

	public static double driveOffsetD() {
		return Preferences.getInstance().getDouble("DriveOffsetD", 0.0);
	}
	
	public static double offsetTolerance() {
		return Preferences.getInstance().getDouble("OffsetTolerance", 0.1);
	}
	
	public static double maxMoveSpeed() {
		return Preferences.getInstance().getDouble("MaxMoveSpeed", 0.5);
	}

	public static double minMoveSpeed() {
		return Preferences.getInstance().getDouble("MinMoveSpeed", 0.1);
	}

	public static int targetCount() {
		return Preferences.getInstance().getInt("TargetCount", 0);
	}

	// ====== Cube Distance & Offset ====== //
	public static double cubeDistanceTolerance() {
		return Preferences.getInstance().getDouble("CubeDistanceTolerance", 0.0);
	}

	public static double cubeOffsetTolerance() {
		return Preferences.getInstance().getDouble("CubeOffsetTolerance", 0.0);
	}

	public static double cubeDistanceSetpoint() {
		return Preferences.getInstance().getDouble("CubeDistanceSetpoint", 15.0);
	}
}
