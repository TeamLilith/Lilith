package main;

import lejos.hardware.motor.Motor;

public class MoveBackwardCommand implements CommandInterface {
	
	private int seconds = 0;
	
	public MoveBackwardCommand(int seconds){
		this.seconds = seconds * 1000;  // Berechnung von Sekunden zu Milisekunden

	}

	public void execute(){					
		{
		    Motor.A.setSpeed(720);// 2 RPM
	    	Motor.B.setSpeed(720);
	    	Motor.A.backward();
	    	Motor.B.backward();	    	
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

