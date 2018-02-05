package org.usfirst.frc.team3694.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick leftDriveStick = new Joystick(0);
  	public static Joystick rightDriveStick = new Joystick(1);
  	public static Joystick manipulatorStick = new Joystick(2);
  	
  	public static JoystickButton leftDriveStickTrigger = new JoystickButton(leftDriveStick, 1);
  	public static JoystickButton rightDriveStickTrigger = new JoystickButton(rightDriveStick, 1);
}
