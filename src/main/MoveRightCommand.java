package main;

import lejos.hardware.motor.Motor;

public class MoveRightCommand implements CommandInterface{
private int seconds = 0;
	
	public MoveRightCommand(int seconds){
		this.seconds = seconds * 1000; // Berechnung der Sekunden zu Milisekunden

	}

	public void execute(){
		
		{
		    Motor.B.setSpeed(720);// 2 RPM
	    	Motor.B.forward();
		}
		try
		{
	    	Thread.sleep(this.seconds);
		} 
		catch(InterruptedException e)
		{
			
		}
	}

}
