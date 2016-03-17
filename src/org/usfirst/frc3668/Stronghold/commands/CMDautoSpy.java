package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CMDautoSpy extends CommandGroup {
    
    public  CMDautoSpy() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new CMDdriveForward(Settings.Auto_SpyDistance2Turn,0,Settings.Auto_DriveSpeed));
    	addSequential(new CMDturn(Settings.Auto_SpyTurnHeading));
    	addSequential(new CMDdriveForward(Settings.Auto_SpyDistance2goal,Settings.Auto_SpyTurnHeading,Settings.Auto_DriveSpeed));
    	addSequential(new CMDautoRoller(Settings.Auto_RunRollerMotorSeconds));
    	
    	addSequential(new CMDdriveForward(-Settings.Auto_SpyDistance2goal,Settings.Auto_SpyTurnHeading,Settings.Auto_DriveSpeed));
    	addSequential(new CMDturn(0));
    	addSequential(new CMDdriveForward(-Settings.Auto_SpyDistance2Turn,0,Settings.Auto_DriveSpeed));
   }
}