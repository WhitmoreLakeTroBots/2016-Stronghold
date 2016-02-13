// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3668.Stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.Settings;

/**
 *
 */
public class CMDturn extends Command {
	boolean _isFinished;
	double _DesiredHeading;
	double _gyroAngle;
//	int loop;
	public CMDturn(double DesiredHeading) {
		_DesiredHeading = DesiredHeading;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.chassis.resetEncoders();
		_isFinished = false;
		//System.out.println("CMDturn");
	}
	public double headingDelta(){
		double currentHeading = Robot.chassis.getCurrentHeading();
		double headingdelta =_DesiredHeading - currentHeading;
		if(headingdelta < -180){
			headingdelta =+360;
		}
		if(headingdelta > 180){
			headingdelta =-360;
		}
		return headingdelta;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double currentHeading = Robot.chassis.getCurrentHeading();
		double headingDelta = headingDelta();
		//double LeftOrRight = -Math.signum(headingDelta);
		if (headingDelta > Settings.turnDeadband && currentHeading < _DesiredHeading) {
				Robot.chassis.drive(0 ,Math.signum(headingDelta)/ Settings.Auto_TurnSpeed);
		} else {
			Robot.chassis.drive(0.0, 0.0);
			_isFinished = true;
		}

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
	}
}
