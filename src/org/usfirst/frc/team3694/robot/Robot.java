
package org.usfirst.frc.team3694.robot;


import org.usfirst.frc.team3694.robot.commands.ArcadeDrive;
import org.usfirst.frc.team3694.robot.commands.MecanumDrive;
import org.usfirst.frc.team3694.robot.commands.RightArcadeDrive;
import org.usfirst.frc.team3694.robot.commands.RightMecanumDrive;
import org.usfirst.frc.team3694.robot.commands.TankDrive;
import org.usfirst.frc.team3694.robot.commands.lineDrive;
import org.usfirst.frc.team3694.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3694.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	//Smart Dashboard
	private static final String crossLine = "Cross the Line";
	private static final String switchLeft = "far Left putting cube into switch";
	private static final String switchMiddle = "middle putting cube into switch";
	private static final String switchRight = "far Right putting cube into switch";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private SendableChooser<Command> driveChooser = new SendableChooser<>();
	private SendableChooser<String> joyRampChooser = new SendableChooser<>();
	
	public static String joyRampSelection = "";
	
	//Subsystems n' stuff
	public static OI Interface = new OI();
	public static DriveTrain driveTrain;
	public static Vision camera;
	
	//FMS
	String gameData;
	
	
	@Override
	public void robotInit() {
		//Smart Dashboard
		m_chooser.addDefault("Cross the Line", crossLine);
		m_chooser.addObject("far Left putting cube into switch", switchLeft);
		m_chooser.addObject("Middle putting cube into switch", switchMiddle);
		m_chooser.addObject("far Right putting cube into switch", switchRight);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		//Choose which joystick and drive mode you want. Lots of flexibility.
		driveChooser.addDefault("Left Stick Mecanum Drive", new MecanumDrive());
		driveChooser.addObject("Right Stick Mecanum Drive", new RightMecanumDrive());
		driveChooser.addObject("Left Stick Arcade Drive", new ArcadeDrive());
		driveChooser.addObject("Right Stick Arcade Drive", new RightArcadeDrive());
		driveChooser.addObject("Tank Drive", new TankDrive());
		SmartDashboard.putData("Drive Type", driveChooser);
		
		joyRampChooser.addDefault("Linear Ramping", "linear");
		joyRampChooser.addObject("Inverse Sigmoid Ramping (easier at higher speeds)", "inverseSigmoid");
		joyRampChooser.addObject("Sigmoid Ramping (harder at higher speeds)", "sigmoid");
		SmartDashboard.putData("Joystick Ramp Type", joyRampChooser);
		
		driveTrain = new DriveTrain();
		camera = new Vision();
		
		//FMS
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		joyRampSelection = joyRampChooser.getSelected();
		
	}

	
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		System.out.println("Auto selected: " + m_autoSelected);
	}
	
	//This function is called periodically during autonomous.
	@Override
	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();
		
		char ourSwitch = gameData.charAt(0);
		char scale = gameData.charAt(1);
		char theirSwitch = gameData.charAt(2);
		
		switch (m_autoSelected) {
			case crossLine:
				default:
					lineDrive.drive();	
					Timer.delay(3.00);
					break;
			case switchLeft:
				if(ourSwitch == 'L')
				{
					org.usfirst.frc.team3694.robot.commands.switchLeft.SwitchLeftLeft();
				} 
				else {
					org.usfirst.frc.team3694.robot.commands.switchLeft.SwitchLeftRight();
				}
				break;
			case switchMiddle:
				if(ourSwitch == 'L')
				{
					//Put left auto code here
				} 
				else {
					//Put right auto code here
				}
				break;
			case switchRight:
				if(ourSwitch == 'L')
				{
					//Put left auto code here
				} 
				else {
					//Put right auto code here
				}
				break;	
		}
	}
	
	public void teleopInit(){
		driveChooser.getSelected().start();
	}
	
	//This function is called periodically during operator control.
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	
    //This function is called periodically during test mode.
	@Override
	public void testPeriodic() {
	}
}
