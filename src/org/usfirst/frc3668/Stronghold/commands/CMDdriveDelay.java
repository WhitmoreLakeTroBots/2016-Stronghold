package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDdriveDelay extends Command {
	long _initialMillis;
	long _commandedWaitmSec;
	boolean _isFinished;
    public CMDdriveDelay(long mSec) {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.chassis);
         _commandedWaitmSec = mSec;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	_initialMillis = System.currentTimeMillis();
    	_isFinished = false;
    	System.out.println("starting Delay 1");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      long MillisDelta  = System.currentTimeMillis() - _initialMillis;
      if(MillisDelta > _commandedWaitmSec){
    	  _isFinished = true;
      	System.out.println("Delay is over");
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
