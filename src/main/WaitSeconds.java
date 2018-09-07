package main;

public class WaitSeconds implements CommandInterface{
	
	private int seconds = 0;
	
	public WaitSeconds(int seconds){
		this.seconds = seconds * 1000;  // Berechnung von Sekunden zu Milisekunden

	}
    public void execute(){
       try{
    	 Thread.sleep(this.seconds);    	 
       }
       catch (Exception e){}
    }
    
}
