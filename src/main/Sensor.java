package main;

public abstract class Sensor {
	protected int status;
	
	protected int getStatus () {
		return status;
	}
	
	protected void setStatus (int status) {
		this.status = status;
	}
}
