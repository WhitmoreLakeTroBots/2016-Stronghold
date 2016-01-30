package org.usfirst.frc3668.Stronghold;

public class Settings {
	public final static double turnDeadband = 3; // 3 degrees
	
	//*************
	//Autonomous settings
	//*************
	public final static int Auto_InchesFromOuterworks = 60;
	public final static double Auto_TurnDegrees = 90;
	public final static int Auto_InchesToTower = 36;
	
	
	//************
	//PWM Ports
	//************
	public final static int PWMPorts_chassisShifterRight = 8;
	public final static int	PWMPorts_chassisShifterLeft = 9;	
	
	
	//**************
	//Misc Settings
	//**************
	public final static double ShifterAngleLeftLowSpeed = 117;
	public final static double ShifterAngleLeftHighSpeed = 35;
	public final static double ShifterAngleRightLowSpeed = 145;
	public final static double ShifterAngleRightHighSpeed = 80;
	
	
	//*****************
	//Joystick Settings
	//*****************
	public final static int Button_joyTurbo = 1;
	public final static int Button_rollerForward = 5;
	public final static int Button_rollerBackward = 3;
	
	
}

