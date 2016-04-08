
package org.usfirst.frc3668.Stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.Settings;
import org.usfirst.frc3668.Stronghold.RobotCaluator;


public class CMDdrive extends Command {

	boolean _isFinished;
	double _Distance;
	double _gyroAngle;
	double _CommandedHeading;
	double _fastSpeed;
	boolean _useHighGear = false;
	long _initialMillis = 0;
	long _currentMillis = 0;
	boolean _inHighGear = false;

	public CMDdrive(double Distance, int CommandedHeading, double Speed) {
		_Distance = Distance;
		_CommandedHeading = CommandedHeading;
		_fastSpeed = Speed;
		requires(Robot.chassis);
	}

	public CMDdrive(double Distance, int CommandedHeading, double Speed, boolean HighGear) {
		_Distance = Distance;
		_CommandedHeading = CommandedHeading;
		_fastSpeed = Speed;
		_useHighGear = HighGear;
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chassis.resetEncoders();
		_isFinished = false;
		_initialMillis = System.currentTimeMillis();
	}

	public double DistanceDelta() {
		return _Distance - Robot.chassis.getEncoderValue();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double distanceDelta = DistanceDelta();
		_currentMillis = System.currentTimeMillis();
		double headingX = RobotCaluator.Heading2Direction(_CommandedHeading, Robot.chassis.getCurrentHeading());

		// if we need to shift into high gear after a slight delay
		if ((_useHighGear != _inHighGear) && (_currentMillis - _initialMillis) > Settings.Auto_HighGearDelay) {
			Robot.chassis.Shift(true);
			_inHighGear = true;
		}

		if ((Math.abs(distanceDelta) > 0) && (Math.abs(distanceDelta) >= Settings.Auto_DriveDeadBand)) {
			if (_inHighGear && (Math.abs(distanceDelta) < Settings.Auto_HigGearSlowDownDistance)) {
				Robot.chassis.Shift(false);
				_inHighGear = false;
			} if (Math.abs(distanceDelta) < Settings.Auto_SlowDownDistance) {
				Robot.chassis.drive((Math.signum(distanceDelta)
						* Math.max(_fastSpeed * Settings.Auto_DriveSlowSpeedFactor, Settings.Auto_DriveSlowSpeedFloor)),
						headingX);
			} else {
				Robot.chassis.drive((Math.signum(distanceDelta) * _fastSpeed), headingX);
			}
		} else {
			Robot.chassis.drive(0, 0);
			_isFinished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return _isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.chassis.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.chassis.drive(0, 0);
	}
}