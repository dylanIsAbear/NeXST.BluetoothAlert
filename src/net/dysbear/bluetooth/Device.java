package net.dysbear.bluetooth;

public class Device {
	
	private String deviceName;
	private boolean conn;
	private int time;
	
	public Device() {
		
	}
	
	public boolean isConnect() {
		return conn;
	}
	
	public String getName() {
		return deviceName;
	}
	
	public int getTime() {
		return time;
	}
	
}
