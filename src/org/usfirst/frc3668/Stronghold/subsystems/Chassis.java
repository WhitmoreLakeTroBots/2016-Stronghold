// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;
import org.usfirst.frc3668.Stronghold.commands.*;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Chassis extends Subsystem {

 /* private final Talon motorChassisRight1 = RobotMap.chassisMotorChassisRight1;
    private final Talon motorChassisRight2 = RobotMap.chassisMotorChassisRight2;
    private final Talon motorChassisLeft1 = RobotMap.chassisMotorChassisLeft1;
    private final Talon motorChassisLeft2 = RobotMap.chassisMotorChassisLeft2; */
    private final RobotDrive robotDrive41 = RobotMap.chassisRobotDrive41;
    private final Encoder encoderChassisLeft1 = RobotMap.chassisEncoderChassisLeft1;
    private final AnalogGyro gyro = RobotMap.chassisGyro;
    private final Servo ShifterRight = RobotMap.chassisShifterRight;
    private final Servo ShifterLeft = RobotMap.chassisShifterLeft;
    



    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initGyro(){
    	gyro.initGyro();
    	gyro.calibrate();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
    public double getGyroAngle(){
		return gyro.getAngle();
    }
   
		   public void Shift(boolean Fast){
    	if (Fast){
    		ShifterLeft.setAngle(Settings.ShifterAngleLeftHighSpeed); 
    		ShifterRight.setAngle(Settings.ShifterAngleRightHighSpeed);
    	}
    	else{
    		ShifterLeft.setAngle(Settings.ShifterAngleLeftLowSpeed);
    		ShifterRight.setAngle(Settings.ShifterAngleRightLowSpeed);
    	}
    }
    
    public void initDefaultCommand() {

       // setDefaultCommand(new CMDjoystickDrive());


        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void drive(Joystick joyDrive) {
    	robotDrive41.arcadeDrive(joyDrive);
    	System.out.println("Joystick X value: " + joyDrive.getX());
    	System.out.println("Joystick Y value: " + joyDrive.getY());
    	System.out.println("Right Motor Teleop: " + RobotMap.chassisMotorChassisRight1.get());
    	System.out.println("Left Motor Teleop: " + RobotMap.chassisMotorChassisLeft1.get());  

    }
    public void drive(double Speed, double Direction){
    	//System.out.println("Speed = " + Speed);
    	//System.out.println("Direction = " + Direction);
    	robotDrive41.arcadeDrive(Speed, Direction);
    	//RobotMap.chassisMotorChassisRight1.set(Speed);
    	//RobotMap.chassisMotorChassisLeft1.set(Speed);
    	//SmartDashboard.putNumber("Motor Right: ", RobotMap.chassisMotorChassisRight1.get());
    	//SmartDashboard.putNumber("Motor Left: ", RobotMap.chassisMotorChassisLeft1.get());
    	//System.out.println("Right Motor: " + RobotMap.chassisMotorChassisRight1.get());
    	//System.out.println("Left Motor: " + RobotMap.chassisMotorChassisLeft1.get());
    
}
    public void resetEncoder(){
    	encoderChassisLeft1.reset();
    }
    public double getEncoderValue(){
    	return encoderChassisLeft1.getDistance();
    }
}

