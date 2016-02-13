package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TurtleTail extends Subsystem {

	public TurtleTail() {
		RobotMap.turtleTailEncoder.reset();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void RaiseLower(boolean Raise) {
		if (Raise && RobotMap.turtleTailLimitSwitchUP.get()) {
			RobotMap.turtleTailMotor.set(Settings.TT_motorSpeed);
		} else if (!Raise && RobotMap.turtleTailLimitSwitchDOWN.get()) {
			RobotMap.turtleTailMotor.set(-Settings.TT_motorSpeed);
		} else {
			RobotMap.turtleTailMotor.set(0);
		}
	}

}
