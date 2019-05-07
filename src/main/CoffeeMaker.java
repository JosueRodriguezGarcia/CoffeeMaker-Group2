
public class CoffeeMaker {

	private boolean isOn = true;
	StartButton button;
	LightIndicator light;
	Plate plate;
	Boiler boiler;
	

	CoffeeMaker() {
	}

	public boolean getStatus() {
		return isOn;
	}

	public void setStatus(boolean isOn) {
		this.isOn = isOn;
	}

}
