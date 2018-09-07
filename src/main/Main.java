package main;


import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {

		// LCD.drawString("1", 1, 1);
		 CompositeCommand p = new CompositeCommand();
	     MoveForwardCommand mfc = new MoveForwardCommand(5);
		 MoveBackwardCommand mbc = new MoveBackwardCommand(5);
		 MoveLeftCommand mlc = new MoveLeftCommand(5);
		 MoveRightCommand mrc = new MoveRightCommand(5);
		 p.list.add(mfc);
		 p.list.add(mbc);
		 p.list.add(mlc);
		 p.list.add(mrc);
		 p.execute();
		// WaitSeconds ws = new WaitSeconds(5);
		// LCD.drawString("Objekte zur Liste hinzufügen", 2, 2);
		// p.list.add(mfc); // Geradeaus fahren
		// p.list.add(ws); // Warten
		// p.list.add(mbc); // Rückwärts fahren
		// LCD.drawString("Vor Execute", 3, 3 );
		// p.execute();

/*		Motor.A.setSpeed(720);// 2 RPM
		Motor.B.setSpeed(720);
		Motor.A.backward();
		Motor.B.backward();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		LCD.drawString("StartDelay", 1, 1);
		Delay.msDelay(5000);
		LCD.drawString("EndDelay", 1, 1);

		Motor.A.setSpeed(720);// 2 RPM
		Motor.B.setSpeed(720);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
*/
	}
}
