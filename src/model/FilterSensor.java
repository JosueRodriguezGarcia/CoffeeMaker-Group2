package model;

public class FilterSensor implements ISensor {
	FilterSensorStatus status;
	
	public FilterSensor () {
		this.status = FilterSensorStatus.FILTER_EMPTY;
	}
	
	public FilterSensorStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(ISensorStatus status) {
		this.status = (FilterSensorStatus) status; 
	}
}
