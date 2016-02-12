package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class TurtleTail extends PIDSubsystem {

	// Initialize your subsystem here
	public TurtleTail() {
		super("TurtleTail", Settings.TT_kP, Settings.TT_kI, Settings.TT_kD);
		// Use these to get going:
		// setSetpoint() - Sets where the PID controller should move the system
		RobotMap.turtleTailEncoder.reset();
		enable(); // - Enables the PID controller.
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected void canMove(double setPoint, double encoderVal) {
		boolean OkToGoUp = RobotMap.turtleTailLimitSwitchUP.get();
		boolean OkToGoDown = RobotMap.turtleTailLimitSwitchDOWN.get();
		boolean Going_Up = (setPoint > encoderVal);

		if ((Going_Up && OkToGoUp) || (!Going_Up && OkToGoDown)) {
			setSetpoint(setPoint);
		} else {
			setSetpoint(encoderVal);
		}

	}

	public void wagWithJoystick(Joystick joyArticulator) {
		double joyArtY = joyArticulator.getY();
		if (Math.abs(joyArtY) > Settings.Joystick_Deadband) {
			double encoderVal = RobotMap.turtleTailEncoder.getDistance();
			System.out.println(encoderVal + " Encoder Value <3");
			double newSetPoint = encoderVal + (-joyArtY * Settings.TT_joyScale);
			System.out.println(newSetPoint + " Set Point Value <3");
			canMove(newSetPoint, encoderVal);
		}
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return RobotMap.turtleTailEncoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		RobotMap.turtleTailMotor.set(output);
	}
}