package model;

public class BoilerSensor implements ISensor {
	BoilerSensorStatus status;

	// Constructor
	public BoilerSensor() {
		this.status = BoilerSensorStatus.BOILER_NOT_EMPTY;
	}
	
	// Getter & Setter
	public BoilerSensorStatus getStatus() {
		return status;
	}
	
	public void setStatus(Enum<?> status) {
		this.status = (BoilerSensorStatus) status;
	}
}
