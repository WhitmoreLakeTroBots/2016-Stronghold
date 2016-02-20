package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TurtleTail extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public double getTurtleTailEconder() {
		return RobotMap.turtleTailEncoder.getDistance();
	}

	public void encoderReset() {
		RobotMap.turtleTailEncoder.reset();
	}

	public boolean isDown() {
		return !RobotMap.turtleTailLimitSwitchDOWN.get() || (getTurtleTailEconder() >= Settings.TT_downPosition);
	}
public boolean CalibrateIsUp() {
	return !RobotMap.turtleTailLimitSwitchUP.get();
}
	public boolean isUP() {
		return !RobotMap.turtleTailLimitSwitchUP.get() || (getTurtleTailEconder() <= Settings.TT_upPosition);
	}

	public void Move(double vector) {
		double direction = Math.signum(vector);
		
		if ((direction == 1) && !isUP()) {
			RobotMap.turtleTailMotor.set(vector);
			
		} else if (direction == -1 && !isDown()) {
			RobotMap.turtleTailMotor.set(vector);
			
		} else {
			RobotMap.turtleTailMotor.set(0);
		}
	}

//	public void autoLower() {
//		double encoderVal = RobotMap.turtleTailEncoder.getDistance();
//		if (RobotMap.turtleTailLimitSwitchDOWN.get() && (encoderVal < Settings.TT_downPosition)) {
//			if (encoderVal < (Settings.TT_downPosition - Settings.TT_slowDownBand)) {
//				RobotMap.turtleTailMotor.set(Settings.TT_motorSpeed);
//			} else {
//				RobotMap.turtleTailMotor.set(Settings.TT_slowSpeed);
//			}
//
//		} else {
//			RobotMap.turtleTailMotor.set(0);
//		}
//	}
//
//	public void Lower(Joystick joyLower) {
//		double encoderVal = RobotMap.turtleTailEncoder.getDistance();
//		if (RobotMap.turtleTailLimitSwitchDOWN.get() && (encoderVal < Settings.TT_downPosition)) {
//			RobotMap.turtleTailMotor.set(joyLower.getY());
//
//		} else {
//			RobotMap.turtleTailMotor.set(0);
//		}
//	}
//
//	public void Raise(Joystick joyRaise) {
//		double encoderVal = RobotMap.turtleTailEncoder.getDistance();
//		if (RobotMap.turtleTailLimitSwitchUP.get() && (encoderVal > Settings.TT_upPosition)) {
//			RobotMap.turtleTailMotor.set(joyRaise.getY());
//
//		} else {
//			RobotMap.turtleTailMotor.set(0);
//		}
//
//	}
//
//	public void autoRaise() {
//		double encoderVal = RobotMap.turtleTailEncoder.getDistance();
//		if (RobotMap.turtleTailLimitSwitchUP.get() && (encoderVal > Settings.TT_upPosition)) {
//			if (encoderVal > (Settings.TT_slowDownBand + Settings.TT_upPosition)) {
//				RobotMap.turtleTailMotor.set(-Settings.TT_motorSpeed);
//			} else {
//				RobotMap.turtleTailMotor.set(-Settings.TT_slowSpeed);
//			}
//
//		} else {
//			RobotMap.turtleTailMotor.set(0);
//		}
//
//	}

	public void RaiseNoEcncoder() {
		if (!RobotMap.turtleTailLimitSwitchUP.get()) {
			RobotMap.turtleTailMotor.set(Settings.TT_slowSpeed);

		} else {
			RobotMap.turtleTailMotor.set(0);
		}

	}
}
