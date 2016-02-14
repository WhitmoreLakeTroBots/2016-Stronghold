package org.usfirst.frc3668.Stronghold;

public class RobotCaluator {
	public static double scaledSpeed(double speed, double scalingFactor){
		return (Math.abs(Math.pow(speed, scalingFactor)) * Math.signum(speed));
	}
	
	public static double HeadingDelta( double commandedHeading,double currentHeading){
		double headingdelta =commandedHeading - currentHeading;
		if(headingdelta < -180){
			headingdelta =+360;
		}
		if(headingdelta > 180){
			headingdelta =-360;
		}
		if (Math.abs(Math.round(headingdelta)) == 360) {headingdelta = 0.0;}
		return headingdelta;
	}
	// takes heading in degrees and converts it to a driveable number
	public static double Heading2Direction(double commandedHeading, double currentHeading){
		double headingDelta = HeadingDelta(commandedHeading, currentHeading);
		double Heading2Direction = Math.round(headingDelta/360*1000);
		double DirectionInProgress = Heading2Direction/1000*Settings.Heading_Kp;
		System.out.println("HeadingDelta: " + headingDelta + "\tHeading too Direction: " + Heading2Direction+"\t Direction in progress: " + DirectionInProgress );
		return DirectionInProgress;
	}
}
