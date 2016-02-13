package org.usfirst.frc3668.Stronghold;

public class Settings {
	public final static double turnDeadband = 3; // 3 degrees

	
	//************
	//PWM Ports
	//************
	public final static int PWMPorts_chassisShifterRight = 8;
	public final static int	PWMPorts_chassisShifterLeft = 9;
	
	
	//**************
	//Relay Ports
	//*************
	
	public final static int Relay_RollerPort = 0;
	
	
	//******************
	//DIO Ports Settings 
	//******************
	
	public final static int DIO_leftEncoderFirstPort = 0;
	public final static int DIO_LeftEncoderSecondPort = 1;
	public final static int DIO_RightEncoderFirstPort = 2;
	public final static int DIO_RightEncoderSecondPort = 3;
	public final static int DIO_TurtleTailEncoderFirstPort = 4;
	public final static int DIO_TurtleTailEncoderSecondPort = 5;
	public final static int DIO_rollerLimitSwitch = 6;
	public final static int DIO_TurtleTailLimitSwitchUP = 7;
	public final static int DIO_TurtleTailLimitSwitchDOWN = 8;
	
	
	//********************
	//Analog Settings
	//********************
	 
	public final static int Analog_GryoPort = 0;
	public final static double GryoSensitivity = 0.007;
	public final static double Gyro_Kp = 0.03;
	
	//********************
	//Drive Train Settings
	//********************
	
	public final static int CAN_rightMotor1ID = 1; // THIS SHOULD BE 0!!
	public final static int CAN_rightMotor2ID = 2;
	public final static int CAN_leftMotor1ID = 3;
	public final static int CAN_leftMotor2ID = 4;
	public final static int CAN_TurtleTailMotorID = 5; // THIS SHOULD BE 4!!
	public final static double ShifterAngleLeftLowSpeed = 117;
	public final static double ShifterAngleLeftHighSpeed = 35;
	public final static double ShifterAngleRightLowSpeed = 145;
	public final static double ShifterAngleRightHighSpeed = 80;
	public final static double EncoderDistancePerPulse = 8*Math.PI/1440;
	public final static double MotorExpiration = 1000;
	
	
	//*****************
	//Joystick Settings
	//*****************
	public final static int Button_joyTurbo = 1;
	public final static int Button_rollerForward = 5;
	public final static int Button_rollerBackward = 3;
	public final static double Joystick_Deadband = .05;


	
	//*************
	//Autonomous settings
	//*************
	public final static int Auto_InchesFromOuterworks = 50;
	public final static double Auto_TurnDegrees = 90;
	public final static int Auto_InchesToTower = 36;
	public final static int Auto_RunRollerMotorSeconds = 5;
	public final static double Auto_DriveSpeed = 0.5;
	public final static double Auto_TurnSpeed = 0;
	public final static double Auto_DriveSlowSpeed = .25;
	public final static double Auto_DriveDeadBand = 5;
	public final static double Auto_SlowDownDistance = 30; //since Matt said so... this is measured in inches

	//***************
	// Turtle Tail Settings
	//***************
	public final static double TT_kP = 1.0;
	public final static double TT_kI = 0.5;
	public final static double TT_kD = 0.0;
	public final static double TT_EncoderDistancePerPulse = 1/7;
	public final static double TT_joyScale = 4;
	public final static double TT_joyDeadBand = 0.05;
	
}

