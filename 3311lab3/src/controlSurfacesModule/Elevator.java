package controlSurfacesModule;

public class Elevator implements IControlActuator{
	@Override
	public void update(int curLat, int curLon, int nextLat, int nextLon) {
		System.out.println("Elevator Actuator Notified with values  " + curLat + " " + curLon + " " + nextLat + " " + nextLon);	
	}
}
