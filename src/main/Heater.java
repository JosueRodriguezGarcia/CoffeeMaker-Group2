
public class Heater {
	boolean isOn;
	Sensor sensor;

	public Heater() {

	}

	public boolean getStatus() {
		return isOn;
	}

	public void setStatus(boolean isOn) {
		this.isOn = isOn;
	}

}
