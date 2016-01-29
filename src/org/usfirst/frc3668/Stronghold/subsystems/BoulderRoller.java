// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3668.Stronghold.subsystems;

import org.usfirst.frc3668.Stronghold.RobotMap;
import org.usfirst.frc3668.Stronghold.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BoulderRoller extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Relay rollerMotor = RobotMap.boulderRollerRollerMotor;
    private final DigitalInput rollerMotorSwitch = RobotMap.boulderRollerRollerMotorSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean getRollerSwitchState(){
    	return rollerMotorSwitch.get();
    }
    
    public void rollerRun(Relay.Value runState){
    	Relay.Value runStateTrue;
    	// These If statements invert the value we pass to the relay... Why? so the buttons line up with the direction we want! 
    	/*if(runState == Relay.Value.kForward){
    		runStateTrue = Relay.Value.kReverse;
    	}
    	else if(runState == Relay.Value.kReverse){
    		runStateTrue = Relay.Value.kForward;
    	}
    	else{
    		runStateTrue = runState;
    	}*/
    	rollerMotor.set(runState/*True*/);
    }
}

