package CoffeeMaker;

public class BoilerSensor implements ISensor {
	BoilerSensorStatus status;

	public BoilerSensor() {
		this.status = BoilerSensorStatus.BOILER_NOT_EMPTY;
	}
	
	public BoilerSensorStatus getStatus() {
		return status;
	}
	
	public void setStatus(ISensorStatus status) {
		this.status = (BoilerSensorStatus) status;
	}
}
