package main;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class HitWall implements Behavior {
	private boolean suppressed = false;
	// private EV3TouchSensor touchSensor;
	// private SensorMode touchSensorMode;
	// private float[] sampleTouch;
	private EV3UltrasonicSensor sonarSensor;
	private SampleProvider sonarSensorProvider;
	private float[] sampleSonar = { 50 };

	public HitWall(Port port) {
		// touchSensor = new EV3TouchSensor(port);
		sonarSensor = new EV3UltrasonicSensor(port);
	}

	public boolean takeControl() {
		// sampleTouch = new float[touchSensorMode.sampleSize()];
		// touchSensorMode = touchSensor.getTouchMode();
		sonarSensorProvider = sonarSensor.getDistanceMode();
		sonarSensorProvider.fetchSample(sampleSonar, 0);
		System.out.println("Distance: " + sampleSonar[0]);
		return /* sampleTouch[0] == 0 || */ sampleSonar[0] < 0.2;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		// Rotate to avoid the wall
		Motor.C.rotate(-180, true);
		Motor.D.rotate(180, true);

		while (Motor.D.isMoving() && !suppressed)
			Thread.yield();

		Motor.C.stop();
		Motor.D.stop();
	}
}