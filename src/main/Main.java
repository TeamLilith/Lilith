
package main;

import lejos.hardware.port.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	public static void main(String[] args) {
		// creating new behaviors
		Behavior b1 = new DriveForward();
		Behavior b2 = new HitWall(SensorPort.S3);
		Behavior b3 = new Home(SensorPort.S2);
		Behavior b4 = new touchWall(SensorPort.S4);
		Behavior b5 = new EnemyContact(SensorPort.S1);
		
		// Behavior b6 = new BatteryLow(6.5f);
		// priority: low --> high
		// Battery -> Home -> Wall -> Forward
		Behavior[] bArray = { b1, b5, b2, b3, b4 };
		Arbitrator arby = new Arbitrator(bArray);
		arby.go();
	}
}
