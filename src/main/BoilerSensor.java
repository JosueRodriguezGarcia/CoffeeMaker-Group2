package main;

public class BoilerSensor implements Sensor {
	BoilerSensorStatus status;

	public BoilerSensor() {
		this.status = BoilerSensorStatus.BOILER_EMPTY;
	}
	
	public BoilerSensorStatus getStatus() {
		return status;
	}
	
	public void setStatus(SensorStatus status) {
		this.status = (BoilerSensorStatus) status;
	}
}
