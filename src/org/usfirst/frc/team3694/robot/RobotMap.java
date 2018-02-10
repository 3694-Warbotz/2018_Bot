package org.usfirst.frc.team3694.robot;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//IMU
	public static ADIS16448_IMU imu  = new ADIS16448_IMU();
	
	//Chassis Motor and Variables
	public static Victor frontLeft = new Victor(0);
	public static Victor frontRight = new Victor(1);
	public static Victor rearLeft = new Victor(2);
	public static Victor rearRight = new Victor(3);
	public static SpeedControllerGroup leftChassis = new SpeedControllerGroup(frontLeft, rearLeft);
	public static SpeedControllerGroup rightChassis = new SpeedControllerGroup(frontRight, rearRight);
	public static DifferentialDrive differentialDrive = new DifferentialDrive(leftChassis, rightChassis);
	public static MecanumDrive mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
	
	//Encoders For Chassis Wheels
	public static Encoder frontLeftEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder frontRightEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	public static Encoder backLeftEnc = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
	public static Encoder backRightEnc = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
	
	//Manipulator Roller Limit Switch
	public static DigitalInput cubeLimitSwitch = new DigitalInput(0);
	public static DigitalInput cubeLimitSwitch2 = new DigitalInput(1);
	
	//Initializes any predefined parameters for sensors
	public static void init(){
		
	}
	
}
