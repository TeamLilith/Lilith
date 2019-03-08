package main;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class EnemyContact implements Behavior {
	private boolean suppressed = false;
	private EV3UltrasonicSensor sonarSensor;
	private SampleProvider sonarSensorProvider;
	private float[] sampleSonar = { 50 };

	public EnemyContact(Port port) {
		sonarSensor = new EV3UltrasonicSensor(port);
	}

	public boolean takeControl() {
		sonarSensorProvider = sonarSensor.getDistanceMode();
		sonarSensorProvider.fetchSample(sampleSonar, 0);
		// System.out.println("Distance: " + sampleSonar[0]);
		return sampleSonar[0] < 0.05;
	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		// Rotate to avoid the wall
		Motor.C.rotate(-120, true);
		Motor.D.rotate(-120, true);

		while (Motor.D.isMoving() && !suppressed)
			Thread.yield();

		Motor.C.stop();
		Motor.D.stop();
	}
}

// package main;
//
// import lejos.hardware.motor.Motor;
// import lejos.robotics.subsumption.Behavior;
//
// public class EnemyContact implements Behavior {
// private boolean suppressed = false;
//
// public EnemyContact() {
// }
//
// public boolean takeControl() {
// System.out.println(Motor.C.getRotationSpeed());
// // return true if motor is block by an obstacle
// return Motor.C.getRotationSpeed() < 90;
// }
//
// public void suppress() {
// suppressed = true;
// }
//
// public void action() {
// suppressed = false;
// // Rückwärts rausfahren
// Motor.C.rotate(-90, true);
// Motor.D.rotate(-90, true);
//
// while (Motor.D.isMoving() && !suppressed)
// Thread.yield();
//
// Motor.C.stop();
// Motor.D.stop();
// }
// }