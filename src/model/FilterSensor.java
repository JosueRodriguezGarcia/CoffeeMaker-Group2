package model;

public class FilterSensor implements ISensor {
	FilterSensorStatus status;
	
	// Constructor
	public FilterSensor () {
		this.status = FilterSensorStatus.FILTER_NOT_EMPTY;
	}
	
	// Getter & Setter
	public FilterSensorStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(Enum<?> status) {
		this.status = (FilterSensorStatus) status; 
	}
}
