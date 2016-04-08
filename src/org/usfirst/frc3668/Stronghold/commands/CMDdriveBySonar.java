package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotCaluator;
import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDdriveBySonar extends Command {

	double _DistanceFromWall;
	double _CommandedHeading;
	double _Speed;
	double _initSonarVal;
	boolean _isFinished = false;
	boolean _useHighGear = false;
	long _initialMillis =0;
	long _currentMillis =0;
	boolean _inHighGear = false;
	
	public CMDdriveBySonar(double DistanceFromWall, int CommandedHeading, double Speed) {
		// Use reqdouble Distance, int CommandedHeading, double Speeduires()
		// here to declare subsystem dependencies
		requires(Robot.chassis);

		_DistanceFromWall = DistanceFromWall;
		_CommandedHeading = CommandedHeading;
		_Speed = Speed;
		_useHighGear = false;
	}

	public CMDdriveBySonar(double DistanceFromWall, int CommandedHeading, double Speed, boolean highGear) {
		// Use reqdouble Distance, int CommandedHeading, double Speeduires()
		// here to declare subsystem dependencies
		requires(Robot.chassis);

		_DistanceFromWall = DistanceFromWall;
		_CommandedHeading = CommandedHeading;
		_Speed = Speed;
		_useHighGear = highGear;
	}

	
	// Called just before this Command runs the first time
	protected void initialize() {
		_initSonarVal = Robot.chassis.getSonarValue();
		_initialMillis = System.currentTimeMillis();
	}

	public double DistanceDelta() {
		return Robot.chassis.getSonarValue() - _DistanceFromWall;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		_currentMillis = System.currentTimeMillis();
		
		// if we need to shift into high gear after a slight delay 
		if ((_useHighGear != _inHighGear) && (_currentMillis - _initialMillis) > Settings.Auto_HighGearDelay){
			Robot.chassis.Shift(true);
			_inHighGear = true;
		}
		
		double distanceDelta = DistanceDelta();
		if (distanceDelta <= Settings.Auto_DriveDeadBand) {
			_isFinished = true;
			Robot.chassis.drive(0, 0);
		} else {
			double headingX = RobotCaluator.Heading2Direction(_CommandedHeading, Robot.chassis.getCurrentHeading());
			
			//If we need to shift back to low then get back into low gear for up coming stop
			if (_inHighGear && (Math.abs(distanceDelta) < Settings.Auto_HigGearSlowDownDistance)) {
			  Robot.chassis.Shift(false);
			}
			
			if (Math.abs(distanceDelta) < Settings.Auto_SlowDownDistance) {
				Robot.chassis.drive((Math.signum(distanceDelta)
						* Math.max(_Speed * Settings.Auto_DriveSlowSpeedFactor, Settings.Auto_DriveSlowSpeedFloor)),
						headingX);
			} else {
				Robot.chassis.drive((Math.signum(distanceDelta) * _Speed), headingX);
			}
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
