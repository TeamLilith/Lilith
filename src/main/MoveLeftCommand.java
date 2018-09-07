package main;

import lejos.hardware.motor.Motor;

public class MoveLeftCommand implements CommandInterface{
private int seconds = 0;
	
	public MoveLeftCommand(int seconds){
		this.seconds = seconds * 1000; // Berechnung der Sekunden zu Milisekunden

	}

	public void execute(){
		
		{
		    Motor.A.setSpeed(720);// 2 RPM
	    	Motor.A.forward();
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
