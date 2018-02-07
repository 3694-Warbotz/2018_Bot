package org.usfirst.frc.team3694.robot.subsystems;

import org.usfirst.frc.team3694.robot.RobotMap;
import org.usfirst.frc.team3694.robot.commands.MecanumDrive;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {
	
	//IMU
	public static ADIS16448_IMU imu  = RobotMap.imu;
	
	//Chassis Motor and Variables
	public static Victor frontLeft = RobotMap.frontLeft;
	public static Victor frontRight = RobotMap.frontRight;
	public static Victor backLeft = RobotMap.backLeft;
	public static Victor backRight = RobotMap.backRight;
	public static SpeedControllerGroup leftChassis = RobotMap.leftChassis;
	public static SpeedControllerGroup rightChassis = RobotMap.rightChassis;
	public static DifferentialDrive differentialDrive = RobotMap.differentialDrive;
	
	//Encoders For Chassis Wheels
	public static Encoder frontLeftEnc = RobotMap.frontLeftEnc;
	public static Encoder frontRightEnc = RobotMap.frontRightEnc;
	
    // Initialize your subsystem here
    public DriveTrain() {
    	super("Drive Train", 0.0, 0.0, 0.0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        enable();
    }
    
    public void arcadeDrive(double xSpeed, double zRot){
    	differentialDrive.arcadeDrive(xSpeed, zRot);
    }
    
    public void curvatureDrive(double xSpeed, double zRot, boolean isQuickTurn){
    	differentialDrive.curvatureDrive(xSpeed, zRot, isQuickTurn);
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public static void setSpeeds(double fL, double bL, double fR, double bR){
		frontLeft.set(fL);
		backLeft.set(bL);
		frontRight.set(fR);
		backRight.set(bR);
	}
    
    public void customMecanumDrive(double ySpeed, double xSpeed, Joystick driveStick){
    	//Get axis values from joystick to avoid calling methods to many times.
    			
    			//If trigger button is pressed down, strafe, else function normally.
    			while(driveStick.getTrigger() == true){

    				//Strafe left if joystick is left, else strafe right. Side that you want to go towards spins inwards while other spins outwards.
    				if(xSpeed < 0){
    					setSpeeds(xSpeed, -xSpeed, -xSpeed, xSpeed);
    				}else if(xSpeed > 0){
    					setSpeeds(-xSpeed, xSpeed, xSpeed, -xSpeed);
    				}
    				
    			}
    			while (driveStick.getTrigger() == false){
    				//Basically arcadeDrive
    				if(xSpeed == 0){
    					setSpeeds(ySpeed, ySpeed, ySpeed, ySpeed);
    				}else{
    					setSpeeds(xSpeed, xSpeed, -xSpeed, -xSpeed);
    				}
    			}
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MecanumDrive());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
