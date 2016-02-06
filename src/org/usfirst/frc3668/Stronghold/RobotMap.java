
package org.usfirst.frc3668.Stronghold;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static CANTalon chassisMotorChassisRight1;
    public static CANTalon chassisMotorChassisRight2;
    public static CANTalon chassisMotorChassisLeft1;
    public static CANTalon chassisMotorChassisLeft2;
    public static RobotDrive chassisRobotDrive41;
    public static Encoder chassisEncoderChassisLeft1;
    public static AnalogGyro chassisGyro;
    public static Relay boulderRollerRollerMotor;
    public static DigitalInput boulderRollerRollerMotorSwitch;
    public static Servo chassisShifterRight;
    public static Servo chassisShifterLeft;
    public static SmartDashboard SmartDashboard;


    public static void init() {
        chassisMotorChassisRight1 = new CANTalon(Settings.CAN_rightMotor1ID);
        LiveWindow.addActuator("Chassis", "MotorChassisRight1", chassisMotorChassisRight1);
        
        chassisMotorChassisRight2 = new CANTalon(Settings.CAN_rightMotor2ID);
        LiveWindow.addActuator("Chassis", "MotorChassisRight2", chassisMotorChassisRight2);
        
        chassisMotorChassisLeft1 = new CANTalon(Settings.CAN_leftMotor1ID);
        LiveWindow.addActuator("Chassis", "MotorChassisLeft1", chassisMotorChassisLeft1);
        
        chassisMotorChassisLeft2 = new CANTalon(Settings.CAN_leftMotor2ID);
        LiveWindow.addActuator("Chassis", "MotorChassisLeft2", chassisMotorChassisLeft2);
        
        chassisRobotDrive41 = new RobotDrive(chassisMotorChassisLeft1, chassisMotorChassisLeft2,
              chassisMotorChassisRight1, chassisMotorChassisRight2);
        
        chassisRobotDrive41.setSafetyEnabled(false);
        chassisRobotDrive41.setExpiration(0.3);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);
        chassisMotorChassisRight1.setSafetyEnabled(false);
        chassisMotorChassisRight2.setSafetyEnabled(false);
        chassisMotorChassisLeft1.setSafetyEnabled(false);
        chassisMotorChassisLeft2.setSafetyEnabled(false);
        
        

        chassisEncoderChassisLeft1 = new Encoder(Settings.DIO_leftEncoderFirstPort, Settings.DIO_LeftEncoderSecondPort, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "EncoderChassisLeft1", chassisEncoderChassisLeft1);
        chassisEncoderChassisLeft1.setDistancePerPulse(Settings.EncoderDistancePerPulse);
        chassisEncoderChassisLeft1.setPIDSourceType(PIDSourceType.kRate);
        chassisGyro = new AnalogGyro(Settings.Analog_GryoPort);
        LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(Settings.GryoSensitivity);
        boulderRollerRollerMotor = new Relay(Settings.Relay_RollerPort);
        LiveWindow.addActuator("BoulderRoller", "RollerMotor", boulderRollerRollerMotor);
        
        boulderRollerRollerMotorSwitch = new DigitalInput(Settings.DIO_rollerLimitSwitch);
        LiveWindow.addSensor("BoulderRoller", "RollerMotorSwitch", boulderRollerRollerMotorSwitch);
        
        chassisShifterRight = new Servo(Settings.PWMPorts_chassisShifterRight);
        chassisShifterLeft = new Servo(Settings.PWMPorts_chassisShifterLeft);
   
    }
}
