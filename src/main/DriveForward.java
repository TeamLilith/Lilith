package main;

import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class DriveForward implements Behavior {
	private boolean suppressed = false;

	public boolean takeControl() {
		return true;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		Motor.A.forward();
		Motor.C.forward();
		while (!suppressed)
			Thread.yield();
		Motor.A.stop(); // clean up
		Motor.C.stop();
	}
}