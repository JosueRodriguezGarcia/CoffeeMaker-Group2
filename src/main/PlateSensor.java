package main;

public class PlateSensor implements Sensor {
	PlateSensorStatus status;
	
	public PlateSensor() {
		this.status = PlateSensorStatus.WARMER_EMPTY;
	}
	
	public PlateSensorStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(SensorStatus status) {
		this.status = (PlateSensorStatus) status;
	}
}
