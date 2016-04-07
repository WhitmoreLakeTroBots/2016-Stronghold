
package org.usfirst.frc3668.Stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.Settings;
import org.usfirst.frc3668.Stronghold.RobotCaluator;

/**
 *
 */
public class CMDdrive extends Command {
	boolean _isFinished;
	double _Distance;
	double _gyroAngle;
	double _CommandedHeading;
	int loopLastCall;
	double _fastSpeed;
	// int _CommandedHeading;

	public CMDdrive(double Distance, int CommandedHeading, double Speed) {
		_Distance = Distance;
		_CommandedHeading = CommandedHeading;
		_fastSpeed = Speed;
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chassis.resetEncoders();
		_isFinished = false;
		System.out.println("CMDdriveForward");
		// _CommandedHeading = Robot.chassis.getCurrentHeading();

	}

	public double DistanceDelta() {
		return _Distance - Robot.chassis.getEncoderValue();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
//		double X = Robot.chassis.getAccelX();
//		// double Y = Robot.chassis.getAccelY();
//		if (Math.abs(X) > 0.1) {
//			System.out.println(X);
//		}
		double distanceDelta = DistanceDelta();

		double headingX = RobotCaluator.Heading2Direction(_CommandedHeading, Robot.chassis.getCurrentHeading());
		// System.out.println("JoyX = "+ joyX);
		if ((Math.abs(distanceDelta) > 0) && (Math.abs(distanceDelta) > Settings.Auto_DriveDeadBand)) {
			if (Math.abs(distanceDelta) < Settings.Auto_SlowDownDistance) {
				Robot.chassis.drive((Math.signum(distanceDelta)
						* Math.max(_fastSpeed * Settings.Auto_DriveSlowSpeedFactor, Settings.Auto_DriveSlowSpeedFloor)),
						headingX);
			} else {
				Robot.chassis.drive((Math.signum(distanceDelta) * _fastSpeed), headingX);
				// System.out.println("this is normal speed: " + distanceDelta);
			}
		} else {
			Robot.chassis.drive(0, 0);
			_isFinished = true;
			// System.out.println("********************");
		}

		System.out.println(Robot.chassis.getEncoderValue());

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
