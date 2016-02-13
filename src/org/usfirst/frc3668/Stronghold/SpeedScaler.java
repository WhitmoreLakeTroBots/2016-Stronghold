package org.usfirst.frc3668.Stronghold;

public class SpeedScaler {
	public static double scaledSpeed(double speed, double scalingFactor){
		return (Math.abs(Math.pow(speed, scalingFactor)) * Math.signum(speed));
	}
	
}
