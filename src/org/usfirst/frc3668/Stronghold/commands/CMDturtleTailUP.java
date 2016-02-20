package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDturtleTailUP extends Command {

	public CMDturtleTailUP() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.TurtleTail);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Robot.TurtleTail.autoRaise();
		if (Robot.TurtleTail.getTurtleTailEconder() > (Settings.TT_slowDownBand + Settings.TT_upPosition)) {
			Robot.TurtleTail.Move(Settings.TT_motorSpeed);
		} else {
			Robot.TurtleTail.Move(Settings.TT_slowSpeed);
		}

		System.out.println("Upper Switch: " + Robot.TurtleTail.isUP() + "\t Turtle Tail encoder: "
				+ Robot.TurtleTail.getTurtleTailEconder());
		// System.out.println("RU Turtle Tail Encoder = " +
		// Robot.TurtleTail.getTurtleTailEconder());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.TurtleTail.isUP();
	}

	// Called once after isFinished returns true
	protected void end() {
    	Robot.TurtleTail.Move(0);
}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
    	Robot.TurtleTail.Move(0);
	}
}
