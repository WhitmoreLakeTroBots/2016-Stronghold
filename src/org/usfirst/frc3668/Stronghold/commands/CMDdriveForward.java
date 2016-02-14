
package org.usfirst.frc3668.Stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.Settings;
import org.usfirst.frc3668.Stronghold.RobotCaluator;

/**
 *
 */
public class CMDdriveForward extends Command {
	boolean _isFinished;
	int _Distance;
	double _gyroAngle;
	double _initialHeading;
	int loopLastCall;

	public CMDdriveForward(int Distance) {
		_Distance = Distance;
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chassis.resetEncoders();
		_isFinished = false;
		System.out.println("CMDdriveForward");
		_initialHeading = Robot.chassis.getCurrentHeading();

	}

	public double DistanceDelta() {
		return _Distance - Robot.chassis.getEncoderValue();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double distanceDelta = DistanceDelta();

		double joyX = RobotCaluator.Heading2Direction(_initialHeading, Robot.chassis.getCurrentHeading());
		//System.out.println("JoyX = "+ joyX);
		if ((distanceDelta > 0) && (Math.abs(distanceDelta) > Settings.Auto_DriveDeadBand)) {
			if (Math.abs(distanceDelta) < Settings.Auto_SlowDownDistance) {
				Robot.chassis.drive((Math.signum(distanceDelta) * Settings.Auto_DriveSlowSpeed), joyX);
			} else {
				Robot.chassis.drive((Math.signum(distanceDelta) * Settings.Auto_DriveSpeed), joyX);
				// System.out.println("this is normal speed: " + distanceDelta);
			}
		} else {
			Robot.chassis.drive(0, 0);
			_isFinished = true;
			// System.out.println("********************");
		}

		// System.out.println(Robot.chassis.getEncoderValue());

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return _isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.chassis.drive(0, 0);
	}
}
