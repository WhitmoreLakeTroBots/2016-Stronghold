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

//	public final static int Relay_RollerPort = 0;

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
	public final static int DIO_TurtleTailLimitSwitchUP = 8;
	public final static int DIO_TurtleTailLimitSwitchDOWN = 7;

	// ********************
	// Analog Settings
	// ********************
	
	public final static int Analog_SonarPort = 1;
	
	public final static int Analog_GryoPort = 0;
	public final static double GryoSensitivity = 0.007;
	public final static double Heading_Kp = 25;
	public final static double GyroInverseOffset = 180;

	// ********************
	// Drive Train Settings
	// ********************

	public final static int CAN_rightMotor1ID = 1; 
	public final static int CAN_rightMotor2ID = 2;
	public final static int CAN_leftMotor1ID = 3;
	public final static int CAN_leftMotor2ID = 4;
	public final static int CAN_TurtleTailMotorID = 5; 
	public final static int CAN_BoulderRollerMotorID = 6;
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
	public final static int Button_joyTurbo = 8;
	public final static int Button_turtleTrigger = 1;
	public final static int Button_joyInvertFront = 3;
	public final static int Button_rollerForward = 5;
	public final static int Button_rollerBackward = 3;
	public final static int Button_turtleTailUP = 4;
	public final static int Button_turtleTailDOWN = 6;
	public final static double Joystick_Deadband = .05;

	// *************
	// Autonomous settings
	// *************
	public final static long AUto_Millis2DoNothing = 16000;
	public final static double Auto_SpyDistance2Turn = 87;
	public final static double Auto_SpyDistance2goal = 65;
	public final static int Auto_SpyTurnHeading = 219;
	public final static double Auto_InchesFromOuterworksLowBar = 168.75;
	public final static double Auto_InchesToDefenseTerrian = 70;
	public final static double Auto_InchesToCrossDefenseTerrian = 84;
	public final static double Auto_InchesAfterDefenseTerrian = 66;
	public final static double Auto_InchesToPortcullis = -36;
	public final static double Auto_InchesUnderPortcullis = -24;
	public final static double Auto_InchesAfterPortcullis = -144;
	public final static double Auto_PortcullisTurnHeadingEnd = 180;
	public final static int Auto_TurnHeadingLowBar = 50;
	public final static int Auto_InchesToTowerLowBar = 137;
	public final static int Auto_RunRollerMotorSeconds = 2;
	public final static double Auto_DriveSpeed = 0.85;
	public final static double Auto_TerrianNormalSpeed = Auto_DriveSpeed;
	public final static double Auto_TerrianFastSpeed = 1;
	public final static double Auto_TurnSpeed = 0.6;
	public final static double Auto_DriveSlowSpeedFloor = .4;
	public final static double Auto_DriveSlowSpeedFactor = 0.6;
	public final static double Auto_DriveDeadBand = 5;
	public final static double Auto_SlowDownDistance = 12;           
	public final static double Auto_turnDeadband = 1;                    
	public final static double Auto_turnSlowDownBand = 10;
	public final static double Auto_turnSlowSpeed = .4;
	public final static long Auto_delayTimeMillis = 375;
	public final static double Auto_InchesToStraighten = 30;
	public final static double Auto_InchesToWall = 72;
	public final static int Auto_Position2TurnHeading = 45;
	public final static double Auto_Position2and4InchesToScore = 42;

	// ***************
	// Turtle Tail Settings
	// ***************
//	public final static double TT_kP = 1.0;
//	public final static double TT_kI = 0.5;
//	public final static double TT_kD = 0.0;
//	public final static double TT_EncoderDistancePerPulse = 1 / 7;
//	public final static double TT_joyScale = 4;
//	public final static double TT_joyDeadBand = 0.05;
	public final static double TT_motorSpeed = 0.5;
	public final static double TT_downPosition = 865;
	public final static double TT_slowDownBand = 75;
	public final static double TT_slowSpeed = 0.35;
	public final static double TT_upPosition = 1;
	public final static double TT_scaleFactor = 0.5;
	
	
	//****************
	// Boulder Roller
	//****************
	public final static double BR_reverseSpeed = 0.45;
	public final static double BR_forwardSpeed = -1;
	public final static long BR_ejectMilliseconds = 2000;

	
	// ***************
	// Other Settings <3
	// ***************
	public static final double universalSpeedScaleFactor = 2;

	//***************
	// Sonar Settings
	//***************
	
	public final static double Sonar_Scale = 2500/5; // Scale is max range over volts
	
	
	
	
	
	
public enum autoCommand {
	LowBar
	,Terrain
	,Portcullis
	,Rockwall
	,Spy
	,DoNothingness
}
}
