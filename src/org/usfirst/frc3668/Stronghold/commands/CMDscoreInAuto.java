package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CMDscoreInAuto extends CommandGroup {
    
    public  CMDscoreInAuto(int startingPosition, boolean Score) {
		if (Score) {
			switch (startingPosition) {
			case 2:
				addSequential(new CMDdriveBySonar(Settings.Auto_InchesToWallPos2, 0, Settings.Auto_DriveSpeed));
				addSequential(new CMDturn(Settings.Auto_Position2TurnHeading));
				addSequential(new CMDdrive(Settings.Auto_Position2and5InchesToScore,
						Settings.Auto_Position2TurnHeading, Settings.Auto_DriveSpeed));
				addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
				break;

			case 3:
				addSequential(new CMDturn(Settings.Auto_Position3and4TurnHeading));
				addSequential(new CMDdrive((5 - startingPosition) * Settings.DefensePaltformLength,
						Settings.Auto_Position3and4TurnHeading, Settings.Auto_TerrianWithShiftFastSpeed, true));
				addSequential(new CMDturn(0));
				addSequential(new CMDdriveBySonar(Settings.Auto_InchesToWallPos5, 0, Settings.Auto_DriveSpeed));
				addSequential(new CMDturn(Settings.Auto_RightGoalTurnHeading));
				addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
				break;

			case 4:
				addSequential(new CMDturn(Settings.Auto_Position3and4TurnHeading));
				addSequential(new CMDdrive((5 - startingPosition) * Settings.DefensePaltformLength,
						Settings.Auto_Position3and4TurnHeading, Settings.Auto_TerrianWithShiftFastSpeed, true));
				addSequential(new CMDturn(0));
				addSequential(new CMDdriveBySonar(Settings.Auto_InchesToWallPos5, 0, Settings.Auto_DriveSpeed));
				addSequential(new CMDturn(Settings.Auto_RightGoalTurnHeading));
				addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
				break;

			case 5:
				addSequential(new CMDdriveBySonar(Settings.Auto_InchesToWallPos5, 0, Settings.Auto_DriveSpeed));
				addSequential(new CMDturn(Settings.Auto_RightGoalTurnHeading));
				addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
				break;
			}
		}
    }
}