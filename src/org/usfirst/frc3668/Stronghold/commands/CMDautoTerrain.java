package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CMDautoTerrain extends CommandGroup {

	public CMDautoTerrain(int startingPosition, boolean Score) {

		addSequential(
				new CMDdrive(Settings.Auto_InchesToDefenseTerrian + Settings.Auto_InchesToCrossDefenseTerrian
						+ Settings.Auto_InchesAfterDefenseTerrian, 0, Settings.Auto_TerrianFastSpeed));
//		addSequential(new CMDdrive(Settings.Auto_InchesToStraighten, 0, Settings.Auto_DriveSpeed));
//		addSequential(new CMDdriveBySonar(Settings.Auto_InchesStop,0,Settings.Auto_DriveSpeed));
		addSequential(new CMDscoreInAuto(startingPosition, Score));
	}
}
