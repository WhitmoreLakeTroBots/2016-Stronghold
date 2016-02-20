package org.usfirst.frc3668.Stronghold;

public class Settings {

	// ************
	// PWM Ports
	// ************
	public final static int PWMPorts_chassisShifterRight = 8;
	public final static int PWMPorts_chassisShifterLeft = 9;

	// **************
	// Relay Ports
	// *************

	public final static int Relay_RollerPort = 0;

	// ******************
	// DIO Ports Settings
	// ******************

	public final static int DIO_leftEncoderFirstPort = 0;
	public final static int DIO_LeftEncoderSecondPort = 1;
	public final static int DIO_RightEncoderFirstPort = 2;
	public final static int DIO_RightEncoderSecondPort = 3;
	public final static int DIO_TurtleTailEncoderFirstPort = 4;
	public final static int DIO_TurtleTailEncoderSecondPort = 5;
	public final static int DIO_rollerLimitSwitch = 6;
	public final static int DIO_TurtleTailLimitSwitchUP = 7;
	public final static int DIO_TurtleTailLimitSwitchDOWN = 8;

	// ********************
	// Analog Settings
	// ********************

	public final static int Analog_GryoPort = 0;
	public final static double GryoSensitivity = 0.007;
	public final static double Heading_Kp = 25;

	// ********************
	// Drive Train Settings
	// ********************

	public final static int CAN_rightMotor1ID = 1; 
	public final static int CAN_rightMotor2ID = 2;
	public final static int CAN_leftMotor1ID = 3;
	public final static int CAN_leftMotor2ID = 4;
	public final static int CAN_TurtleTailMotorID = 5; 
	public final static double ShifterAngleLeftLowSpeed = 117;
	public final static double ShifterAngleLeftHighSpeed = 35;
	public final static double ShifterAngleRightLowSpeed = 145;
	public final static double ShifterAngleRightHighSpeed = 80;
	// wheel Diameter * PI / 360 * wheel part of ratio / encoder part of ratio (encoder 39:42 wheels)
	public final static double EncoderDistancePerPulse = 7.5 * Math.PI / 360 * 42 / 39*6/5;
	public final static double MotorExpiration = 1000;

	// *****************
	// Joystick Settings
	// *****************
	public final static int Button_joyTurbo = 1;
	public final static int Button_joyInvertFront = 3;
	public final static int Button_rollerForward = 5;
	public final static int Button_rollerBackward = 3;
	public final static int Button_turtleTailUP = 4;
	public final static int Button_turtleTailDOWN = 6;
	public final static double Joystick_Deadband = .05;

	// *************
	// Autonomous settings
	// *************
	public final static int Auto_InchesFromOuterworks = 168;
	public final static double Auto_TurnHeading = 270;
	public final static int Auto_InchesToTower = 36;
	public final static int Auto_RunRollerMotorSeconds = 2;
	public final static double Auto_DriveSpeed = 1;
	public final static double Auto_TurnSpeed = 0.5;
	public final static double Auto_DriveSlowSpeed = .75;
	public final static double Auto_DriveDeadBand = 5;
	public final static double Auto_SlowDownDistance = 12;           
	public final static double Auto_turnDeadband = 1;                    
	public final static double Auto_turnSlowDownBand = 10;
	public final static double Auto_turnSlowSpeed = .1;
	public final static long Auto_delayTimeMillis = 375;

	// ***************
	// Turtle Tail Settings
	// ***************
//	public final static double TT_kP = 1.0;
//	public final static double TT_kI = 0.5;
//	public final static double TT_kD = 0.0;
//	public final static double TT_EncoderDistancePerPulse = 1 / 7;
//	public final static double TT_joyScale = 4;
//	public final static double TT_joyDeadBand = 0.05;
	public final static double TT_motorSpeed = -0.5;
	public final static double TT_downPosition = 865;
	public final static double TT_slowDownBand = 75;
	public final static double TT_slowSpeed = -0.35;
	public final static double TT_upPosition = 1;
	
	// ***************
	// Other Settings <3
	// ***************
	public static final double universalSpeedScaleFactor = 2;

	

}
