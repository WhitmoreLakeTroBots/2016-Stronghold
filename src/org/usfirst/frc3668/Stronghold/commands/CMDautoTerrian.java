package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CMDautoTerrian extends CommandGroup {

	public CMDautoTerrian() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		// addSequential(new
		// CMDdriveForward(Settings.Auto_InchesToDefenseTerrian,0,
		// Settings.Auto_TerrianFastSpeed));
		// addSequential(new CMDdriveDelay(Settings.Auto_delayTimeMillis));
		// addSequential(new
		// CMDdriveForward(Settings.Auto_InchesToCrossDefenseTerrian ,0,
		// Settings.Auto_TerrianFastSpeed));
		addSequential(
				new CMDdriveForward(Settings.Auto_InchesToDefenseTerrian + Settings.Auto_InchesToCrossDefenseTerrian
						+ Settings.Auto_InchesAfterDefenseTerrian, 0, Settings.Auto_TerrianFastSpeed));
	}
}
