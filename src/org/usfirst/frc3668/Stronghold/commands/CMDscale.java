package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CMDscale extends Command {

    public CMDscale() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.Scaler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.joySafetyArt.get()){
    	Robot.Scaler.driveScaler(Settings.SL_MotorSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Scaler.driveScaler(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.Scaler.driveScaler(0);
    }
}
