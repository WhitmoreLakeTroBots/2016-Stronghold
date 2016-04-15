package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDrealeaseScalerMotor extends Command {

	long InitMillis = 0;
	long _Millis2Run;
	boolean _isFinished = false;

	public CMDrealeaseScalerMotor(long Millis2Run) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.Scaler);
		_Millis2Run = Millis2Run;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		InitMillis = System.currentTimeMillis();
		_isFinished = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		long MillisDelta = System.currentTimeMillis() - InitMillis;
		System.out.println("CMDrealseScalerMotor has been called," + MillisDelta + "\t" + _Millis2Run);
		if (MillisDelta < _Millis2Run /* && Robot.oi.joySafety.get() */) {
			Robot.Scaler.releaseWithMotor();
			System.out.println("Running Motor");
		}

		else {
			_isFinished = true;
			// Robot.Scaler.killMotor();
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//Robot.Scaler.killMotor();
		return _isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.Scaler.killMotor();
		System.out.println("ended");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.Scaler.killMotor();
		System.out.println("interrupted");
	}
}
