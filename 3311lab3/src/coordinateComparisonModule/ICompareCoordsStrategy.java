package coordinateComparisonModule;

import autopilotModule.*;
//using strategy pattern
public interface ICompareCoordsStrategy {
    public Coordinates compareCoords(Coordinates gps1, Coordinates gps2, Coordinates gps3);
}
