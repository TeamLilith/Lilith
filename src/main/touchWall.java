package main;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class touchWall implements Behavior {
	private boolean suppressed = false;
	private EV3TouchSensor touchSensor;
	private SampleProvider touchSensorProvider;
	private float[] sampleTouch = { 0 };

	public touchWall(Port port) {
		touchSensor = new EV3TouchSensor(port);
	}

	public boolean takeControl() {
		touchSensorProvider = touchSensor.getTouchMode();
		touchSensorProvider.fetchSample(sampleTouch, 0);
		// System.out.println("IsPushed: " + sampleTouch[0]);
		return sampleTouch[0] == 1;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		// Rückwärts rausfahren
		Motor.C.rotate(-90, true);
		Motor.D.rotate(-90, true);

		while (Motor.D.isMoving() && !suppressed)
			Thread.yield();

		Motor.C.stop();
		Motor.D.stop();
	}
}
