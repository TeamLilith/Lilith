
package main;

import lejos.hardware.port.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Main {
	public static void main(String[] args) {
		// creating new behaviors
		//Behavior b1 = new DriveForward();
//		Behavior b2 = new HitWall(SensorPort.S2);
		Behavior b3 = new FollowBlackLine(SensorPort.S3);
		// b5, b3 -- Follow has a higher priority than searching for the line
		//Behavior b4 = new BatteryLow(6.5f);
		// priority: low --> high
		Behavior[] bArray = { b3 };
		Arbitrator arby = new Arbitrator(bArray);
		arby.go();
	}
}