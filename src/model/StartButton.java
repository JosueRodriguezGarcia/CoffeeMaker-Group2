package model;

public class StartButton {
	StartButtonStatus status;
	
	public StartButton() {
		status = StartButtonStatus.OFF;
	}
	
	StartButtonStatus getStatus() {
		return status;
	}
	
	void setStatus(StartButtonStatus status) {
		this.status = status;
	}
	
}
