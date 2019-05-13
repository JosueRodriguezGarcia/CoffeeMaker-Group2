package main;

public interface ISensor {
	public ISensorStatus getStatus();
	public void setStatus(ISensorStatus status);
}
