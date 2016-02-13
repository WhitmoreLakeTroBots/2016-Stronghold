
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
    private final Encoder encoderChassisLeft = RobotMap.chassisEncoderChassisLeft;
    private final Encoder encoderChassisRight = RobotMap.chassisEncoderChassisRight;
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
    }
    public void driveStraight(double Speed, double Direction){
    	double ScaledDirection = Direction * Settings.Gyro_Kp;
    	double LeftMotorSpeed = Speed + ScaledDirection/2;
    	double RightMotorSpeed = -(Speed - ScaledDirection/2);
    	RobotMap.chassisMotorChassisRight1.set(RightMotorSpeed);
    	RobotMap.chassisMotorChassisRight2.set(RightMotorSpeed);
    	RobotMap.chassisMotorChassisLeft1.set(LeftMotorSpeed);
    	RobotMap.chassisMotorChassisLeft2.set(LeftMotorSpeed);
    	//System.out.println("Encoder Right: " + encoderChassisRight.getDistance());
    	//System.out.println("Encoder Left: " + encoderChassisLeft.getDistance());
    
}
    
    public void driveTurn(double Speed, double Direction){
    	double LeftMotorSpeed = Speed + Direction;
    	double RightMotorSpeed = -(Speed - Direction);
    	RobotMap.chassisMotorChassisRight1.set(RightMotorSpeed);
    	RobotMap.chassisMotorChassisRight2.set(RightMotorSpeed);
    	RobotMap.chassisMotorChassisLeft1.set(LeftMotorSpeed);
    	RobotMap.chassisMotorChassisLeft2.set(LeftMotorSpeed);
    	//System.out.println("Encoder Right: " + encoderChassisRight.getDistance());
    	//System.out.println("Encoder Left: " + encoderChassisLeft.getDistance());
    
}
    
    public void resetEncoders(){
    	encoderChassisLeft.reset();
    	encoderChassisRight.reset();
    	
    }
    public double getEncoderValue(){
    	return (encoderChassisLeft.getDistance() + encoderChassisRight.getDistance()) / 2;
    }
}

