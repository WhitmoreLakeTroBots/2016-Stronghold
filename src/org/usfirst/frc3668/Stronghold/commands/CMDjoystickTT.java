package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDjoystickTT extends Command {

    public CMDjoystickTT() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.TurtleTail);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.TurtleTail.wagWithJoystick(Robot.oi.getJoyArticulator());
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
    }
}
