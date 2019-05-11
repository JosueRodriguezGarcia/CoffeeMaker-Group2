package main;

public class Plate {
	Heater heater;
	PlateSensor sensor;
	Pot pot;

	public Plate() {
		sensor = new PlateSensor();
		heater = new Heater();
		pot = new Pot();
	}
	
	void warmingPot() {
		if (sensor.getStatus() == 2) {
			heater.on();
		}
	}

	// ****
	void puttingPot() {
		sensor.setStatus(1);
	}

	void removingPot() {
		sensor.setStatus(0);
	}

	void stopWarmingPot() {
		heater.off();
	}
	
	
	//GettersyStter
	public Heater getHeater() {
		return heater;
	}

	public void setHeater(Heater heater) {
		this.heater = heater;
	}

	public PlateSensor getSensor() {
		return sensor;
	}

	public void setSensor(PlateSensor sensor) {
		this.sensor = sensor;
	}
	
}
