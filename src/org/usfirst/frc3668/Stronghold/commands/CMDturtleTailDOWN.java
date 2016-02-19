package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDturtleTailDOWN extends Command {
    public CMDturtleTailDOWN() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.TurtleTail);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.TurtleTail.Lower();
    	//RobotMap.turtleTailMotor.set(-1);
    	System.out.println("RD Turtle Tail Encoder = " + Robot.TurtleTail.getTurtleTailEconder());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.TurtleTail.isDown();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.turtleTailMotor.set(0);
    }
}
