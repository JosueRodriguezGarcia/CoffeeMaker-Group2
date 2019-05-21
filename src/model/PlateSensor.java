package model;

public class PlateSensor implements ISensor {
	PlateSensorStatus status;
	
	// Constructor
	public PlateSensor() {
		this.status = PlateSensorStatus.POT_EMPTY;
	}
	
	// Getter & Setter
	public PlateSensorStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(Enum<?> status) {
		this.status = (PlateSensorStatus) status;
	}
}
