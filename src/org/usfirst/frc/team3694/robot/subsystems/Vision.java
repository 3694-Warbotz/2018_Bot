package org.usfirst.frc.team3694.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	
	private UsbCamera camera;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Vision(){
		camera = CameraServer.getInstance().startAutomaticCapture();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

