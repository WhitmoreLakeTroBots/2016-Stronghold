package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CMDautoRockwall extends CommandGroup {

	public CMDautoRockwall(int startingPosition, boolean Score) {

		addSequential(new CMDdrive(Settings.Auto_Inches2OverRockWall, 0, Settings.Auto_TerrianNormalSpeed));
		
//		addSequential(
//				new CMDdrive(Settings.Auto_InchesToDefenseTerrian + Settings.Auto_InchesToCrossDefenseTerrian, 0,
//						Settings.Auto_TerrianFastSpeed));
		
		addSequential(new CMDdrive(Settings.Auto_Inches2BackRockwall, 0, Settings.Auto_TerrianFastSpeed));
		addSequential(new CMDdriveBySonar(Settings.Auto_InchesStop, 0, Settings.Auto_TerrianFastSpeed));
		
//		addSequential(new CMDdrive(Settings.Auto_Inches2BackRockwall, 0, Settings.Auto_TerrianFastSpeed));
//		addSequential(new CMDdrive(Settings.Auto_Inches2GoForward, 0, Settings.Auto_TerrianFastSpeed));

//		addSequential(new CMDdrive(Settings.Auto_Inches2BackRockwall, 0, Settings.Auto_TerrianFastSpeed));
//		addSequential(new CMDdrive(Settings.Auto_Inches2GoForward, 0, Settings.Auto_TerrianFastSpeed));

//		addSequential(new CMDdrive(Settings.Auto_InchesToStraighten, 0, Settings.Auto_DriveSpeed));
		addSequential(new CMDscoreInAuto(startingPosition, Score));
	}
}