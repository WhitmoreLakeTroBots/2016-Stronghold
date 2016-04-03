package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CMDautoTerrain extends CommandGroup {

	public CMDautoTerrain(int startingPosition) {

		addSequential(
				new CMDdriveForward(Settings.Auto_InchesToDefenseTerrian + Settings.Auto_InchesToCrossDefenseTerrian
						+ Settings.Auto_InchesAfterDefenseTerrian, 0, Settings.Auto_TerrianFastSpeed));
		addSequential(new CMDdriveForward(Settings.Auto_InchesToStraighten, 0, Settings.Auto_DriveSpeed));

		if (startingPosition == 2) {
			addSequential(new CMDdriveBySonar(Settings.Auto_InchesToWall, 0, Settings.Auto_DriveSpeed));
			addSequential(new CMDturn(Settings.Auto_Position2TurnHeading));
			addSequential(new CMDdriveForward(Settings.Auto_Position2and5InchesToScore,
					Settings.Auto_Position2TurnHeading, Settings.Auto_DriveSpeed));
			addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
		}

		if (startingPosition == 5) {
			addSequential(new CMDdriveBySonar(Settings.Auto_InchesToWall, 0, Settings.Auto_DriveSpeed));
			addSequential(new CMDturn(Settings.Auto_Position5TurnHeading));
			addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
		}
	}
}
