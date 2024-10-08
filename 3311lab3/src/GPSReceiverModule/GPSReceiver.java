package GPSReceiverModule;

import java.util.Random;

import autopilotModule.Coordinates;

// TODO: decide whether this is a class or interface,
// then complete your implementation

 public class GPSReceiver {
	 private Random random;
	 private String name;
	 
	 public GPSReceiver(String name) {
		 this.random = new Random();
		 this.name = name;
	 }
	 
	 public Coordinates get() {
		 int i = random.nextInt(2),j = random.nextInt(2);
		 System.out.println(name + " GPS Reader is Used");
		 System.out.println("GPS DATA LAT DATA IS " + i + " GPS DATA LON IS  " + j);
		 return new Coordinates(i, j);

	 }
 }
