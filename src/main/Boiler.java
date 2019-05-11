package main;

public class Boiler {
	private double pressure;
	private Heater heater;
	private PlateSensor plateSensor;
	private BoilerSensor boilerSensor;
	private PressureValve valve;
	
	public Boiler () {
		pressure = 0.0;
		this.heater = new Heater();
		this.boilerSensor = new BoilerSensor();
		this.plateSensor = new PlateSensor();
		this.valve = valve;
	}
	
	public void waterHeating(){
		if (boilerSensor.getStatus() == 1) {
			valve.close();
			heater.on();			
		}
	}
	
	public void stoppingHeatingWater() {
		valve.isOpen();
		heater.off();
	}	
}
