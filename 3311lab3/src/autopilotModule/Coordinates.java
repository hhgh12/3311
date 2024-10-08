package autopilotModule;

public class Coordinates {
	private int latitude;
	private int longitude;
	
	public Coordinates(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public boolean equals(Coordinates c) {
		return (this.latitude == c.latitude && this.longitude == c.longitude);
	}
}


