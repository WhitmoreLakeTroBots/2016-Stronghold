package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.subsystems.BoulderRoller;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;
import java.util.Timer;

/**
 *
 */
public class CMDautoRoller extends Command {
	long _TargetNanoSeconds;
	long _startTime;
	boolean _isFinished;
	
    public CMDautoRoller(int SecondsToRun) {
    	_TargetNanoSeconds = (long)SecondsToRun * 1000000000;
    
        // Use requires() here to declare subsystem dependencies
         requires(Robot.boulderRoller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	_startTime = System.nanoTime();
    	System.out.println("CMDautoRoller");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (System.nanoTime() - _startTime < _TargetNanoSeconds){
    	Robot.boulderRoller.rollerRun(Relay.Value.kForward);
    	_isFinished = false;
    		
    	}
    	else {
    		Robot.boulderRoller.rollerRun(Relay.Value.kOff);
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
