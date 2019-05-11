package main;

public class StartButton {
	private boolean isPushed;

	public StartButton() {
		isPushed = false;
	}

	public boolean getStatus() {
		return isPushed;
	}

	public void setStatus(boolean isPushed) {
		this.isPushed = isPushed;
	}

}
