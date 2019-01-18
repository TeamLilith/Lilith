import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.Port;

public class ColorSensor {
	private EV3ColorSensor FColorSensor;
	private float FHomeColor;
	private float[] FSampleColor = {0};
	private SampleProvider FColorSensorProvider;
	
	public ColorSensor(Port port) {
		EV3ColorSensor FColorSensor = new EV3ColorSensor(port); 	
	}
	
	public float getHomeColor() {
		return FHomeColor;
	}

	public void setHomeColor(float fHomeColor) {
		FColorSensorProvider.fetchSample(FSampleColor, 0);
		FHomeColor = FSampleColor[0];
	}
	
	public boolean IsHome() {	  
	  FColorSensorProvider.fetchSample(FSampleColor, 0);
	  if (FHomeColor == FSampleColor[0]) {   // Wertebereiche testen!
		  return true;
	  }
	  return false;
	}
	
}
