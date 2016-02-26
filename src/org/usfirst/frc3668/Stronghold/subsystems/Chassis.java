
package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.Settings;
import org.usfirst.frc3668.Stronghold.commands.*;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {

	/*
	 * private final Talon motorChassisRight1 =
	 * RobotMap.chassisMotorChassisRight1; private final Talon
	 * motorChassisRight2 = RobotMap.chassisMotorChassisRight2; private final
	 * Talon motorChassisLeft1 = RobotMap.chassisMotorChassisLeft1; private
	 * final Talon motorChassisLeft2 = RobotMap.chassisMotorChassisLeft2;
	 */
	private final Accelerometer Accel = RobotMap.Accel;
	private final RobotDrive robotDrive41 = RobotMap.chassisRobotDrive41;
	private final Encoder encoderChassisLeft = RobotMap.chassisEncoderChassisLeft;
	private final Encoder encoderChassisRight = RobotMap.chassisEncoderChassisRight;
	private final AnalogGyro gyro = RobotMap.chassisGyro;
	private final Servo ShifterRight = RobotMap.chassisShifterRight;
	private final Servo ShifterLeft = RobotMap.chassisShifterLeft;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public double getAccelX(){
		return Accel.getX();
	}
	
	public double getAccelY(){
		return Accel.getY();
	}
	
	public double getAccelZ(){
		return Accel.getZ();
	}
	
	public void initGyro() {
		gyro.initGyro();
		gyro.calibrate();
		gyro.reset();
		System.out.println("initGyro");
		// System.out.println(Settings.EncoderDistancePerPulse);
	}

	public void resetGyro() {
		gyro.reset();
	}

	public double getCurrentHeading() {
		// double Heading = (gyro.getAngle() % 360.0) * 360.0;
		double divResult = gyro.getAngle() / 360.0;
		double gyroMod = divResult % 1;
		double GMheading = gyroMod * 360.0;
		// System.out.println("Gyro Angle: " + gyro.getAngle() +"\t div Result:
		// "+ divResult+ "\t Gyro Mod: " + gyroMod + "\t finished heading: " +
		// GMheading );
		if (GMheading < 0) {
			GMheading = GMheading + 360;
		}

		return GMheading;
	}

	public double getGyroAngle() {
		return gyro.getAngle();
	}

	public void Shift(boolean Fast) {
		if (Fast) {
			ShifterLeft.setAngle(Settings.ShifterAngleLeftHighSpeed);
			ShifterRight.setAngle(Settings.ShifterAngleRightHighSpeed);
		} else {
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
		double invertedJoyX = joyDrive.getX();
		double invertedJoyY = -joyDrive.getY();
		//System.out.println("Inverted X axis: " + invertedJoyX + "\t Inverted Y axis: " + invertedJoyY + "\t Normal X axis: " + joyDrive.getX() + "\t Normal Y axis: " + joyDrive.getY());

		if (Robot.isDriveReversed) {
			robotDrive41.arcadeDrive(invertedJoyY,invertedJoyX );
		} else {
			robotDrive41.arcadeDrive(joyDrive);

		}
		// System.out.println("Current heading: "+getCurrentHeading());
	}

	public void drive(double Speed, double Direction) {
		robotDrive41.arcadeDrive(Speed, Direction);
		/*
		 * double ScaledDirection = Direction * Settings.Gyro_Kp; double
		 * LeftMotorSpeed = Speed + ScaledDirection/2; double RightMotorSpeed =
		 * -(Speed - ScaledDirection/2);
		 * RobotMap.chassisMotorChassisRight1.set(RightMotorSpeed);
		 * RobotMap.chassisMotorChassisRight2.set(RightMotorSpeed);
		 * RobotMap.chassisMotorChassisLeft1.set(LeftMotorSpeed);
		 * RobotMap.chassisMotorChassisLeft2.set(LeftMotorSpeed);
		 * //System.out.println("Encoder Right: " +
		 * encoderChassisRight.getDistance()); //System.out.println(
		 * "Encoder Left: " + encoderChassisLeft.getDistance());
		 */

	}

	/*
	 * public void drive(double Speed, double Direction){ double LeftMotorSpeed
	 * = Speed + Direction; double RightMotorSpeed = -(Speed - Direction);
	 * RobotMap.chassisMotorChassisRight1.set(RightMotorSpeed);
	 * RobotMap.chassisMotorChassisRight2.set(RightMotorSpeed);
	 * RobotMap.chassisMotorChassisLeft1.set(LeftMotorSpeed);
	 * RobotMap.chassisMotorChassisLeft2.set(LeftMotorSpeed);
	 * //System.out.println("Encoder Right: " +
	 * encoderChassisRight.getDistance()); //System.out.println("Encoder Left: "
	 * + encoderChassisLeft.getDistance());
	 * 
	 * }
	 */

	public void resetEncoders() {
		encoderChassisLeft.reset();
		encoderChassisRight.reset();

	}

	public double getEncoderValue() {
		return (encoderChassisLeft.getDistance() + encoderChassisRight.getDistance()) / 2;
	}
}
