package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Robot;
import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CMDautoPortcullis extends CommandGroup {

	public CMDautoPortcullis(int startingPosition, boolean Score) {

		CommandGroup StartTT = new CommandGroup();
		StartTT.addSequential(new CMDCalibrateTurtleTail());
		StartTT.addSequential(new CMDturtleTailDOWN());

		CommandGroup StartUP = new CommandGroup();
		StartUP.addParallel(StartTT);
		StartUP.addParallel(new CMDdrive(Settings.Auto_InchesToPortcullis, 0, Settings.Auto_TerrianFastSpeed));

		addSequential(StartUP);
		// System.out.println("Sartup commands finished");
		// addSequential(new CMDdriveDelay(Settings.Auto_delayTimeMillis));
		// addSequential(new
		// CMDdriveForward(Settings.Auto_InchesToPortcullis,0,Settings.Auto_DriveSpeed));
		// //driving up to the Portcullis
		addSequential(new CMDdrive(Settings.Auto_InchesUnderPortcullis, 0, Settings.Auto_TerrianFastSpeed)); // driving
																												// under
																												// Portcullis
		addSequential(new CMDdrive(Settings.Auto_InchesUnderPortcullis, 0, Settings.Auto_TerrianFastSpeed));
		addSequential(new CMDturn(Settings.Auto_PortcullisTurnHeadingEnd));
		addSequential(new CMDsetGyroOffset(Settings.GyroInverseOffset));

		addSequential(new CMDscoreInAuto(startingPosition, Score));
	}
}
