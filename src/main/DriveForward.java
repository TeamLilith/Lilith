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

		Motor.C.setSpeed(540); // 210
		Motor.C.forward();
		Motor.D.setSpeed(540); // 210
		Motor.D.forward();

		while (Motor.D.isMoving() && !suppressed) {
			Thread.yield();
		}

		Motor.C.stop();
		Motor.D.stop();
	}
}