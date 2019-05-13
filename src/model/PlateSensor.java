package model;

public class PlateSensor implements ISensor {
	PlateSensorStatus status;
	
	public PlateSensor() {
		this.status = PlateSensorStatus.WARMER_EMPTY;
	}
	
	public PlateSensorStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(ISensorStatus status) {
		this.status = (PlateSensorStatus) status;
	}
}
