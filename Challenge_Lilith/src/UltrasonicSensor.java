import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class UltrasonicSensor {	
	public EV3UltrasonicSensor FUltrasonicSensor;	
	private SampleProvider FUltrasonicSensorProvider;
	private float[] FSampleUltrasonic;
	public UltrasonicSensor(Port port) {
		EV3UltrasonicSensor FUltrasonicSensor = new EV3UltrasonicSensor(port); 	
	}

	private boolean hasObjectInDistance(float distance) {   // ToDO: Werte testen!
	  if (FSampleUltrasonic[0] < distance) {
		  return true;
	  }
		return false;	
	}
	

}
