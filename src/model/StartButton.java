package model;

public class StartButton {
	StartButtonStatus status;
	
	// Constructor
	public StartButton() {
		status = StartButtonStatus.OFF;
	}
	
	// Getter & Setter
	StartButtonStatus getStatus() {
		return status;
	}
	
	void setStatus(StartButtonStatus status) {
		this.status = status;
	}
	
}
