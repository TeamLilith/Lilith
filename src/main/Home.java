package main;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

public class Home implements Behavior {
	private boolean suppressed = false;
	private EV3ColorSensor colorSensor;
	private SampleProvider colorSensorProvider;
	private float[] sampleColor = { 0 };
	private float homeColor = 0;
	private boolean firstTime = true;

	public Home(Port port) {
		colorSensor = new EV3ColorSensor(port);
	}

	public boolean takeControl() {
		// TODO take control if the sensor returns not black
		// setHomeColor(0);

		// kleiner als 0.03 ist schwarz
		// zwischen 0.08 und 0.11 ist grün
		// alles 0.5 größer weiß

		colorSensorProvider = colorSensor.getRedMode();
		colorSensorProvider.fetchSample(sampleColor, 0);
		// System.out.println(sampleColor[0]);

		if (homeColor == 0)
			homeColor = sampleColor[0];

		if (homeColor > 0.03) {
			return ((sampleColor[0] > 0.03) && (sampleColor[0] <= 0.15));
		}
		return (sampleColor[0] <= 0.03);

	}

	public void suppress() {
		suppressed = true;
	}

	public void action() {
		suppressed = false;
		// TODO need to rotate right and left to search for a new sample which returns
		// black
		if (firstTime) {
			// Aus Base rausfahren
			Motor.C.rotate(240, true);
			Motor.D.rotate(240, true);

			while (Motor.D.isMoving() && !suppressed)
				Thread.yield();

			Motor.C.stop();
			Motor.D.stop();

			firstTime = false;
		} else {

			// Rückwärts rausfahren
			Motor.C.rotate(-360, true);
			Motor.D.rotate(-360, true);

			while (Motor.D.isMoving() && !suppressed)
				Thread.yield();

			Motor.C.rotate(180, true);
			Motor.D.rotate(-180, true);

			while (Motor.D.isMoving() && !suppressed)
				Thread.yield();

			Motor.C.stop();
			Motor.D.stop();

			// while (Motor.D.isMoving() && !suppressed)
			// Thread.yield();
			//
			// Motor.C.stop();
			// Motor.D.stop();

		}

	}
}
