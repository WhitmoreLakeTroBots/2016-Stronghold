
package org.usfirst.frc3668.Stronghold;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
	public static Accelerometer Accel; 
	public static Relay scalerTrigger;
    public static CANTalon chassisMotorChassisRight1;
    public static CANTalon chassisMotorChassisRight2;
    public static CANTalon chassisMotorChassisLeft1;
    public static CANTalon chassisMotorChassisLeft2;
    public static CANTalon turtleTailMotor;
    public static Talon ScalingMotor;
    public static RobotDrive chassisRobotDrive41;
    public static Encoder chassisEncoderChassisLeft;
    public static Encoder chassisEncoderChassisRight;
    public static Encoder turtleTailEncoder;
    public static AnalogGyro chassisGyro;
    public static CANTalon boulderRollerRollerMotor;
    public static DigitalInput boulderRollerRollerMotorSwitch;
    public static DigitalInput turtleTailLimitSwitchUP;
    public static DigitalInput turtleTailLimitSwitchDOWN;
    public static Servo chassisShifterRight;
    public static Servo chassisShifterLeft;
    public static Servo scalerServo;
    public static SmartDashboard SmartDashboard;
    public static AnalogPotentiometer Sonar;


    public static void init() {
        chassisMotorChassisRight1 = new CANTalon(Settings.CAN_rightMotor1ID);
        LiveWindow.addActuator("Chassis", "MotorChassisRight1", chassisMotorChassisRight1);
        
        chassisMotorChassisRight2 = new CANTalon(Settings.CAN_rightMotor2ID);
        LiveWindow.addActuator("Chassis", "MotorChassisRight2", chassisMotorChassisRight2);
        
        chassisMotorChassisLeft1 = new CANTalon(Settings.CAN_leftMotor1ID);
        LiveWindow.addActuator("Chassis", "MotorChassisLeft1", chassisMotorChassisLeft1);
        
        chassisMotorChassisLeft2 = new CANTalon(Settings.CAN_leftMotor2ID);
        LiveWindow.addActuator("Chassis", "MotorChassisLeft2", chassisMotorChassisLeft2);
        
        turtleTailMotor = new CANTalon(Settings.CAN_TurtleTailMotorID);
        LiveWindow.addActuator("Turtle Tail", "Turtle Tail Motor", turtleTailMotor);
        
        ScalingMotor = new Talon(Settings.PWMPorts_ScalingMotor);
        LiveWindow.addActuator("Scaler", "Scaling Motor", ScalingMotor);
        
        chassisRobotDrive41 = new RobotDrive(chassisMotorChassisLeft1, chassisMotorChassisLeft2,
              chassisMotorChassisRight1, chassisMotorChassisRight2);
        
        chassisRobotDrive41.setSafetyEnabled(true);
        chassisRobotDrive41.setExpiration(0.1);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);
        
        chassisEncoderChassisLeft = new Encoder(Settings.DIO_leftEncoderFirstPort, Settings.DIO_LeftEncoderSecondPort, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "EncoderChassisLeft", chassisEncoderChassisLeft);
        chassisEncoderChassisLeft.setDistancePerPulse(Settings.EncoderDistancePerPulse);
        chassisEncoderChassisLeft.setPIDSourceType(PIDSourceType.kRate);
       
        chassisEncoderChassisRight = new Encoder(Settings.DIO_RightEncoderFirstPort, Settings.DIO_RightEncoderSecondPort, true, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "EncoderChassisRight", chassisEncoderChassisRight);
        chassisEncoderChassisRight.setDistancePerPulse(Settings.EncoderDistancePerPulse);
        chassisEncoderChassisRight.setPIDSourceType(PIDSourceType.kRate);
        
        turtleTailEncoder = new Encoder(Settings.DIO_TurtleTailEncoderFirstPort, Settings.DIO_TurtleTailEncoderSecondPort, true, EncodingType.k4X);
        LiveWindow.addSensor("Turtle Tail", "Turtle Tail Encoder", turtleTailEncoder);
    //    turtleTailEncoder.setDistancePerPulse(Settings.TT_EncoderDistancePerPulse);
        turtleTailEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        chassisGyro = new AnalogGyro(Settings.Analog_GryoPort);
        LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(Settings.GryoSensitivity);
        
        boulderRollerRollerMotor = new CANTalon(Settings.CAN_BoulderRollerMotorID);
        LiveWindow.addActuator("BoulderRoller", "RollerMotor", boulderRollerRollerMotor);
        
        boulderRollerRollerMotorSwitch = new DigitalInput(Settings.DIO_rollerLimitSwitch);
        LiveWindow.addSensor("BoulderRoller", "RollerMotorSwitch", boulderRollerRollerMotorSwitch);
        
        turtleTailLimitSwitchUP = new DigitalInput(Settings.DIO_TurtleTailLimitSwitchUP);
        LiveWindow.addSensor("Turtle Tail", "Turtle Tail Limit Switch UP", turtleTailLimitSwitchUP);
        
        turtleTailLimitSwitchDOWN = new DigitalInput(Settings.DIO_TurtleTailLimitSwitchDOWN);
        LiveWindow.addSensor("Turtle Tail", "Turtle Tail Limit Switch DOWN", turtleTailLimitSwitchDOWN);
        
        chassisShifterRight = new Servo(Settings.PWMPorts_chassisShifterRight);
        chassisShifterLeft = new Servo(Settings.PWMPorts_chassisShifterLeft);
        
        scalerServo = new Servo(Settings.PWMPorts_scalingServo);
        
        Accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
        
        Sonar = new AnalogPotentiometer(Settings.Analog_SonarPort, Settings.Sonar_Scale);
        
        scalerTrigger = new Relay(Settings.RelayPort_ScalerRelease);
    }
}
