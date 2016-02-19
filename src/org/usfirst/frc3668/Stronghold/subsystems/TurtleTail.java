package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TurtleTail extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public double getTurtleTailEconder(){
		return RobotMap.turtleTailEncoder.getDistance();
	}
	
	public void encoderReset(){
		RobotMap.turtleTailEncoder.reset();
	}
	
	public boolean isDown(){
		return !RobotMap.turtleTailLimitSwitchDOWN.get();
	}
	
	public boolean isUP(){
		return !RobotMap.turtleTailLimitSwitchUP.get();
	}

	public void Lower() {
		double encoderVal = RobotMap.turtleTailEncoder.getDistance();
		if (RobotMap.turtleTailLimitSwitchDOWN.get() && (encoderVal < Settings.TT_downPosition)) {
			if(encoderVal < (Settings.TT_downPosition - Settings.TT_slowDownBand)){
				RobotMap.turtleTailMotor.set(Settings.TT_motorSpeed);
			} else {
				RobotMap.turtleTailMotor.set(Settings.TT_slowSpeed);
			}
			
		} else {
			RobotMap.turtleTailMotor.set(0);
		}
	}
		
		public void Raise() {
			double encoderVal = RobotMap.turtleTailEncoder.getDistance();
			if (RobotMap.turtleTailLimitSwitchUP.get() && (encoderVal > Settings.TT_upPosition )) {
				if(encoderVal > (Settings.TT_slowDownBand + Settings.TT_upPosition)){
					RobotMap.turtleTailMotor.set(-Settings.TT_motorSpeed);
				} else {
					RobotMap.turtleTailMotor.set(-Settings.TT_slowSpeed);
				}
				
			} else {
				RobotMap.turtleTailMotor.set(0);
			}
	}
	

}
