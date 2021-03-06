package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Scaler extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void driveScaler (double speed){
    	if(Math.signum(speed) < 0){
    	RobotMap.ScalingMotor.set(speed);
    	}
    	else{
    		RobotMap.ScalingMotor.set(0);
    	}
    }
    
    public void engageServo(){
    	RobotMap.scalerServo.setAngle(Settings.SL_ServoEngaged);
    }
    
    public void disengageServo(){
    	RobotMap.scalerServo.setAngle(Settings.SL_ServoDisenaged);
    	//RobotMap.scalerServo.set(1); //HS-422
    }
    
    public void releaseWithMotor(){
    	//System.out.println("Running Motor");
    	RobotMap.scalerTrigger.set(Relay.Value.kForward);
    }
    
    public void killMotor(){
    	RobotMap.scalerTrigger.set(Relay.Value.kOff);
    	System.out.println("WE KILLED IT!");
    }
}

