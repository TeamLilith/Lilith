package main;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class FollowBlackLine implements Behavior {
	private boolean suppressed = false;
	private EV3ColorSensor colorSensor;
	private SampleProvider colorSensorProvider;
	private float[] sampleColor = {0};

	public FollowBlackLine(Port port) {
		colorSensor = new EV3ColorSensor(port);
	}

	public boolean takeControl() {
		// TODO take control if the sensor returns black
		colorSensorProvider = colorSensor.getRedMode();
		colorSensorProvider.fetchSample(sampleColor, 0);
		System.out.println("sampleColor = " + sampleColor[0]);
		return sampleColor[0] < 0.5;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		// TODO slow down speed
		/*if (sampleColor[0] == 0) {

		} else if (sampleColor[0] == 0.5) {

		} else if (sampleColor[0] == 1) {

		}
		Motor.A.forward();
		Motor.C.forward();
		while (!suppressed)
			Thread.yield();
		Motor.A.stop(); // clean up
		Motor.C.stop();*/
	}
}