package controlSurfacesModule;

import java.util.List;

import autopilotModule.Coordinates;
//using observer pattern
public class GPSDataSubject {
    // TODO: complete the implementation
    /*
    * The GPS Data Subject notifies the Actuators
    * (which move the control surfaces) with the current
    * latitude and longitude values,
    * and the desired path’s latitude and longitude values (see the
    * Observer Pattern).
    */
	private List<IControlActuator> actuators;
	
	public GPSDataSubject(List<IControlActuator> actuators) {
		this.actuators = actuators;
	}
	
	public void notify(Coordinates cur, Coordinates next) {
		for(IControlActuator a : actuators)
			a.update(cur.getLatitude(), cur.getLongitude(), next.getLatitude(), next.getLongitude());
	}
	
}
