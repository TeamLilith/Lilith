
package main;

// Port 1 = Licht
// Port 2 = Druck
// Port 3 = Ultra
// Port 4 = Gyro
import lejos.hardware.port.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	public static void main(String[] args) {
		// creating new behaviors
		Behavior b1 = new DriveForward();
		Behavior b2 = new HitWall(SensorPort.S3);
		Behavior b3 = new Home(SensorPort.S2);
		// Behavior b4 = new BatteryLow(6.5f);
		// priority: low --> high
		// Battery -> Home -> Wall -> Forward
		Behavior[] bArray = {b1, b3 , b2};
		Arbitrator arby = new Arbitrator(bArray);
		arby.go();
	}
}
