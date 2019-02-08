package main;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Behavior;

	public class touchWall implements Behavior {
		private boolean suppressed = false;
		// private EV3TouchSensor touchSensor;
		// private SensorMode touchSensorMode;
		// private float[] sampleTouch;
		private EV3TouchSensor touchSensor;
		float[] FSampleTouch;
		private SensorMode FTouchSensorMode; 
		public touchWall(Port port) {
			// touchSensor = new EV3TouchSensor(port);
			touchSensor = new EV3TouchSensor(port);
		}

		public boolean takeControl() {
			// sampleTouch = new float[touchSensorMode.sampleSize()];
			// touchSensorMode = touchSensor.getTouchMode();
			FSampleTouch = new float[FTouchSensorMode.sampleSize()];
			FTouchSensorMode = touchSensor.getTouchMode();
				if (FSampleTouch[0] == 1) {
					return true;
				}
				return false;
			
		}

		public void suppress() {
			suppressed = true;
		}

		public void action() {
			suppressed = false;
			Motor.C.rotate(180, true);
			Motor.D.rotate(-360, true);

			while (Motor.D.isMoving() && !suppressed)
				Thread.yield();

			Motor.C.stop();
			Motor.D.stop();
		}
}
