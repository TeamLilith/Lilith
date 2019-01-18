

import lejos.hardware.motor.Motor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.Port;

public class Motors {
  public NXTRegulatedMotor FMotorA = Motor.A;	
  public NXTRegulatedMotor FMotorB = Motor.B;
	
  public void driveForward() {
	FMotorA.forward();
	FMotorB.forward();
  }
  
  public void driveBackward() {
	FMotorA.backward();
	FMotorB.backward();
  }
  public void driveLeft() {
	FMotorA.forward();
	FMotorB.stop();
  }
  public void driveRight() {
    FMotorA.stop();
    FMotorB.forward();
  }
  public void stop() {
	FMotorA.stop();
	FMotorB.stop();
  }
  
}
