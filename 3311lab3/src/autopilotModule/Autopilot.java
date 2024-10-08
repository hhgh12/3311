package autopilotModule;

import navigationModule.NavProxy;

public class Autopilot {
	
	private NavProxy np;
	private Coordinates cd, cd2;
	public Autopilot(NavProxy proxy, int nextWaypointLatitude, int nextWaypointLongitude) {
		np = proxy;
		cd = new Coordinates(nextWaypointLatitude, nextWaypointLongitude);
	}

	/**
	 * The point of this method is to send a message to the proxy.
	 * @return the same coordinates that the facade is returning to the autopilot (via the proxy)
	 */
	public Coordinates navigate() {
		this.giveCoordToProxy();
		np.navigate();
		cd2 = np.giveCoordToAutoPilot();
		return cd2;
	}
	public void giveCoordToProxy() {
		np.getCoordFromAutoPilot(cd);
	}

}

