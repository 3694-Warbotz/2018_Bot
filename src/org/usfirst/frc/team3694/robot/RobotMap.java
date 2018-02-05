package org.usfirst.frc.team3694.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static ADIS16448_IMU imu  = new ADIS16448_IMU();
	
	public static Victor frontLeft = new Victor(0);
	public static Victor frontRight = new Victor(1);
	public static Victor backLeft = new Victor(2);
	public static Victor backRight = new Victor(3);
	
	public static Encoder frontLeftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder frontRightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	public static DigitalInput cubeLimitSwitch = new DigitalInput(0);
	public static DigitalInput cubeLimitSwitch2 = new DigitalInput(1);
	
}
