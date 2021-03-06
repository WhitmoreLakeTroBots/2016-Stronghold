package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDjoyTurtleTail extends Command {

    public CMDjoyTurtleTail() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.TurtleTail);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double joyVector = Robot.oi.getJoyArticulator().getY();
    	if (Math.abs(joyVector) > Settings.Joystick_Deadband) {
    		Robot.TurtleTail.Move(joyVector);
    	}
//    	if(Robot.oi.joyArticulator.getY() > 0){
//    		Robot.TurtleTail.Raise(Robot.oi.joyArticulator);
//    	}
//    	if(Robot.oi.joyArticulator.getY() < 0){
//    		Robot.TurtleTail.Lower(Robot.oi.joyArticulator);
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.TurtleTail.Move(0);
    }
}
