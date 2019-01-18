import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;

public class TouchSensor {
	private EV3TouchSensor FTouchSensor;
	private SensorMode FTouchSensorMode;
	private float[] FSampleTouch;

	public TouchSensor(Port port) {
		EV3TouchSensor FTouchSensor = new EV3TouchSensor(port);
	}

	private boolean IsPressed() {
		FSampleTouch = new float[FTouchSensorMode.sampleSize()];
		FTouchSensorMode = FTouchSensor.getTouchMode();
		if (FSampleTouch[0] == 1) {
			return true;
		}
		return false;
	}
}
