package org.usfirst.frc3668.Stronghold.commands;

import org.usfirst.frc3668.Stronghold.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CMDautoPortcullis extends CommandGroup {
    
    public  CMDautoPortcullis() {
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
    	addSequential(new CMDCalibrateTurtleTail());
    	addSequential(new CMDturtleTailDOWN());
    	addSequential(new CMDdriveDelay(Settings.Auto_delayTimeMillis));
    	addSequential(new CMDdriveForward(Settings.Auto_InchesToPortcullis,0,Settings.Auto_DriveSpeed)); //driving up to the Portcullis
    	addSequential(new CMDdriveForward(Settings.Auto_InchesUnderPortcullis,0,Settings.Auto_DriveSpeed)); //driving under Portcullis
    	addSequential(new CMDdriveForward(Settings.Auto_InchesAfterPortcullis,0,Settings.Auto_DriveSpeed));
    }
}
