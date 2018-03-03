package org.usfirst.frc.team3255.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Navigation extends Subsystem {
	public static AHRS ahrs = null;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Navigation() {
		try {
			ahrs = new AHRS(SPI.Port.kMXP);
		}catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(), true);
		}
	}

	public double getYaw() {
		return ahrs.getYaw();
	}
	
	public double getRoll() {
		return ahrs.getRoll();
	}
	
	public double getPitch() {
		return ahrs.getPitch();
	}
	
	public void resetYaw() {
		ahrs.reset();
		
		try {
			Thread.sleep(250);
		}catch (InterruptedException e) {
		}
		
		ahrs.zeroYaw();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

