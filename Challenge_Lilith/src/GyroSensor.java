import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;

public class GyroSensor {
  private EV3GyroSensor FGyroSensor;
  private float[] FSample;
  private float FCurrentAngle = 0;
  
	
  private GyroSensor(Port port) {
	  EV3GyroSensor FGyroSensor = new EV3GyroSensor(port);   
  }
}
