package navigationModule;

import autopilotModule.*;
import controlSurfacesModule.*;
import coordinateComparisonModule.*;
import GPSReceiverModule.*;

import java.util.ArrayList;
import java.util.List;

public class NavigationFacade {
    // TODO: complete the implementation
    /*
    * The Navigation Façade does the following sequence of steps (see Façade pattern)
    * a. Send a request to GPSReceiver object #1 to get the first reading
    * b. Send a request to GPSReceiver object #2 to get the second reading
    * c. Send a request to GPSReceiver object #3 to get the third reading
    * !! Don’t forget, two of the GPSReceivers are Honeywell brand,
    * and the other one is Rockwell brand.
    * d. Apply the comparison strategy/strategies to get the resulting coordinates
    * (see the Strategy pattern)
    * e. Send the coordinates to the GPS Date Subject
    * f. Update the Autopilot with the new coordinates
    */

    // Using the facade pattern
	private Coordinates curCoord, result;
	private GPSDataSubject GDS;
	private List<GPSReceiver> gpsReaders;
	private List<IControlActuator> actuators;
	private ICompareCoordsStrategy comparisonStrategyOne, comparisonStrategyTwo;
    public NavigationFacade(List<GPSReceiver> gpsReaders, ICompareCoordsStrategy comparisonStrategyOne,
	 		ICompareCoordsStrategy comparisonStrategyTwo,List<IControlActuator> actuators) {
    	this.gpsReaders = gpsReaders;
    	this.actuators = actuators;
    	this.comparisonStrategyOne = comparisonStrategyOne;
    	this.comparisonStrategyTwo = comparisonStrategyTwo;
    	this.GDS = new GPSDataSubject(actuators);
    	
	 }

    public Coordinates navigate() {
    	Coordinates h1, r1, r2;
     	
     	h1 = gpsReaders.get(0).get();
        r1 = gpsReaders.get(1).get();
     	r2 = gpsReaders.get(2).get();
     	
     	List<Coordinates> cList = new ArrayList<>();
     	
     	cList.add(h1);
     	cList.add(r1);
     	cList.add(r2);
     	
    	result = compareGPSData(cList);
    	 
    	GDS.notify(result, curCoord);
    	return result;
    }
    
    public Coordinates compareGPSData(List<Coordinates> data) {
        // TODO: complete the implementation. this method is part of step d
    	
    	Coordinates result = comparisonStrategyOne.compareCoords(data.get(0), data.get(1), data.get(2));
    	if(result == null) {
    		System.out.println(" ********* NO AGREEMENT **********");
    		result = comparisonStrategyTwo.compareCoords(data.get(0), data.get(1), data.get(2));
    	}
        return result;
    }
    
    public void getCoord(Coordinates c) {
    	this.curCoord = c;
    }
    

}
