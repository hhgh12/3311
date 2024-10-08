package coordinateComparisonModule;

import autopilotModule.*;

public class TwoThreeVoting implements ICompareCoordsStrategy {

    @Override
    public Coordinates compareCoords(Coordinates gps1, Coordinates gps2, Coordinates gps3) {
        // TODO: complete the implementation. Refer to SampleOutput.txt to see expected output strings
        // NOTE: if there is no agreement between at least 2/3 receivers, then return null
    	System.out.println(" ********* INVOKING VOTING COMPARISON **********");
        if(gps1.equals(gps2) || gps1.equals(gps3)) {
        	System.out.println("------- AGREEMENT WITH GPS1 AND GPS" + (gps1.equals(gps2)?"2":"3"));
        	return gps1;
        }
        else if(gps2.equals(gps3)) {
        	System.out.println("------- AGREEMENT WITH GPS2 AND GPS3");
        	return gps2;
        }
        return null;
    }
    
}
