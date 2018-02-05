package org.usfirst.frc.team3694.robot.commands;

import org.usfirst.frc.team3694.robot.OI;
import org.usfirst.frc.team3694.robot.subsystems.Manipulator;

public class manDrive {
	public static void Manipulator () {
		Manipulator.climb.set(OI.leftStick.getY());
		Manipulator.topLeft.set(OI.rightStick.getY());
		Manipulator.topRight.set(OI.rightStick.getY());
		while (OI.rightStick.getY() >= .75) {
			Manipulator.topLeft.set(.75);
			Manipulator.topRight.set(.75);
		}
		while (OI.rightStick.getY() <= -.75) {
			Manipulator.topLeft.set(-.75);
			Manipulator.topRight.set(-.75);
		}
	}
}
