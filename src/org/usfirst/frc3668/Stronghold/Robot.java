package org.usfirst.frc3668.Stronghold;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3668.Stronghold.commands.*;
import org.usfirst.frc3668.Stronghold.subsystems.*;

public class Robot extends IterativeRobot {

	Command autonomousCommand;
	Command chassisTeleopCommand;
	//Command turtleTailTeleop;
	
	public static SendableChooser autoChooser;
	public static SendableChooser autoPositionChooser;
	public static SendableChooser autoScoreChooser;
	public static Scaler Scaler;
	public static OI oi;
	public static Chassis chassis;
	public static BoulderRoller boulderRoller;
	public static TurtleTail TurtleTail;
	public static boolean isDriveReversed;

	CameraServer server;

	public void robotInit() {
		RobotMap.init();
		chassis = new Chassis();
		Robot.chassis.initGyro();
		boulderRoller = new BoulderRoller();
		TurtleTail = new TurtleTail();
		Scaler = new Scaler();
		autoPositionChooser = new SendableChooser();
		autoPositionChooser.addObject("Position 2", 2);
		autoPositionChooser.addObject("Position 3", 3);
		autoPositionChooser.addObject("Position 4", 4);
		autoPositionChooser.addObject("Position 5", 5);
		autoPositionChooser.addObject("Don't try to score", null);
		SmartDashboard.putData("Autonomous Position Chooser", autoPositionChooser);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Low Bar Autonomous", Settings.autoCommand.LowBar);
		autoChooser.addObject("Portcullis Autonomous", Settings.autoCommand.Portcullis);
		autoChooser.addObject("All-Terrain Autonomous", Settings.autoCommand.Terrain);
		autoChooser.addObject("Rockwall Autonomous", Settings.autoCommand.Rockwall);
		autoChooser.addObject("Spy Position Autonomous", Settings.autoCommand.Spy);
		autoChooser.addObject("Do nothing with a side of nothingness", Settings.autoCommand.DoNothingness);
		//autoChooser.addObject("Read ultrasonic", new CMDdriveTillObject());
		SmartDashboard.putData("Autonomous Mode Chooser",autoChooser);
		
		autoScoreChooser = new SendableChooser();
		autoScoreChooser.addDefault("Score", true);
		autoScoreChooser.addObject("Don't Score", false);
		SmartDashboard.putData("Score?", autoScoreChooser);
		
		 server = CameraServer.getInstance();
	     server.setQuality(50);
	     //the camera name (ex "cam0") can be found through the roborio web interface
	     server.startAutomaticCapture("cam0");
		
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();
		// instantiate the command used for the autonomous period
		chassisTeleopCommand = new CMDjoystickDrive();
		//turtleTailTeleop = new CMDjoyTurtleTail();

	}

	public void disabledInit() {
		if (chassisTeleopCommand != null)
			chassisTeleopCommand.cancel();
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	
		Robot.chassis.Shift(false);
		Robot.TurtleTail.encoderReset();
		Robot.Scaler.engageServo();
		
		Settings.autoCommand selectedAutoCommand = (Settings.autoCommand) autoChooser.getSelected();
		int selectedPosition = (int) autoPositionChooser.getSelected();
		boolean Score = (boolean) autoScoreChooser.getSelected();
		switch (selectedAutoCommand) {
			case LowBar:
				autonomousCommand = new CMDautoLowBar();
				break;
			case Terrain:
				autonomousCommand = new CMDautoTerrain(selectedPosition, Score);
				break;
			case Portcullis:
				autonomousCommand = new CMDautoPortcullis(selectedPosition, Score);
				break;
			case Rockwall:
				autonomousCommand = new CMDautoRockwall(selectedPosition, Score);
				break;		
			case Spy:
				autonomousCommand = new CMDautoSpy();
				break;
			case DoNothingness:
				autonomousCommand = new CMDdriveDelay(Settings.AUto_Millis2DoNothing);
				break;
				
				
		}
		
		System.out.println("AutoCommand: " + selectedAutoCommand);
		
		if (chassisTeleopCommand != null)
			chassisTeleopCommand.cancel();
		Robot.chassis.resetGyro();
		if (autonomousCommand != null)
			autonomousCommand.start();

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		Robot.Scaler.engageServo();
		Robot.chassis.Shift(false);
		
		if (chassisTeleopCommand != null)
			chassisTeleopCommand.start();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		if (chassisTeleopCommand != null)
			chassisTeleopCommand.cancel();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
