package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDgyroOffset extends Command {
	
	private double _Offset;
	
    public CMDgyroOffset(double Offset) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	_Offset = Offset;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.setGyroOffset(_Offset);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
