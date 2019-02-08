package main;

import lejos.hardware.motor.Motor;
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
		
		return true;
	}

	public void suppress() {
		suppressed = true;
	}
 
	public void action() {
		suppressed = false;
		int x = 0;
		while(x != 1) {
			
			colorSensorProvider = colorSensor.getRedMode();
			colorSensorProvider.fetchSample(sampleColor, 0);
			//System.out.println("sampleColor = " + sampleColor[0]);

			if (sampleColor[0] < 0.15) {
				System.out.println("Links = " + sampleColor[0]);

				Motor.B.setSpeed(15);
				Motor.B.forward();
				
				Motor.C.setSpeed(25);
				Motor.C.backward();
			
			}
			else if (sampleColor[0] > 0.12 && sampleColor[0] <= 0.27 ) {
				System.out.println("Geradeaus = " + sampleColor[0]);

				Motor.B.setSpeed(150);
				Motor.B.forward();
				
				Motor.C.setSpeed(150);
				Motor.C.forward();
			} 
			else if (sampleColor[0] > 0.27) {
				System.out.println("Rechts = " + sampleColor[0]);
				Motor.B.setSpeed(15);
				Motor.B.backward();
				
				Motor.C.setSpeed(25);
				Motor.C.forward();
			}
			
		}
		
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