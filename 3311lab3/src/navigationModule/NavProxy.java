package navigationModule;

import java.util.ArrayList;
import java.util.List;

import GPSReceiverModule.GPSReceiver;
import autopilotModule.Coordinates;
import controlSurfacesModule.Aileron;
import controlSurfacesModule.Elevator;
import controlSurfacesModule.GPSDataSubject;
import controlSurfacesModule.IControlActuator;
import controlSurfacesModule.Rudder;
import coordinateComparisonModule.*;

// Using the proxy pattern
public class NavProxy {
	private Coordinates curCoord, nextCoord;
	private NavigationFacade nf;
	private GPSDataSubject GDS;
	private List<GPSReceiver> gpsReaders;
	private List<IControlActuator> actuators;
	public NavProxy(){


		
	}
	
	public void navigate() {
		if(gpsReaders == null) {
			gpsReaders = new ArrayList<>();
			gpsReaders.add(new GPSReceiver("HoneyWell"));
			gpsReaders.add(new GPSReceiver("HoneyWell"));
			gpsReaders.add(new GPSReceiver("Rockwell"));
		}
		
		if(actuators == null) {
			actuators = new ArrayList<>();
			actuators.add(new Aileron());
			actuators.add(new Elevator());
			actuators.add(new Rudder());
		}
		
		if(nf == null)
			nf = new NavigationFacade(gpsReaders, new TwoThreeVoting(), new FirstIsBest(), actuators);
		
		this.giveCoordToFacade();
		this.nextCoord = nf.navigate();
		

	}
	
	public void getCoordFromAutoPilot(Coordinates coord) {
		this.curCoord = coord;
	}
	
	public void giveCoordToFacade() {
		nf.getCoord(curCoord);
	}
	
	public GPSDataSubject giveGDStoFacade(){
		return this.GDS;
	}
	
	public Coordinates giveCoordToAutoPilot() {
		return this.nextCoord;
	}
	
}
