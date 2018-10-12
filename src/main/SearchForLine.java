package main;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.subsumption.Behavior;

public class SearchForLine implements Behavior {
	private boolean suppressed = false;
	private EV3ColorSensor colorSensor;
	
	public SearchForLine(Port port) {
		colorSensor = new EV3ColorSensor(port);
	}

	public boolean takeControl() {
		// TODO take control if the sensor returns not black 
		return colorSensor.getRGBMode() != null;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		// TODO need to rotate right and left to search for a new sample which returns black
		Motor.A.rotate(-180, true);
		Motor.C.rotate(-360, true);

		while (Motor.C.isMoving() && !suppressed)
			Thread.yield();

		Motor.A.stop();
		Motor.C.stop();
	}
}
