package autopilot;

import java.util.ArrayList;

public class Navigation {
public static final double CLOSEENOUGH = .05;
	public static void main(String[] args) throws InterruptedException {
		//Setup goes here. User edits to make waypoints and legs
		Waypoint wp1 = new Waypoint(1, 47.450434, -122.308799, 100);//sea-tac
		Waypoint wp3 = new Waypoint(3, 37.712187, -122.212142, 350);//oakland airport
		Waypoint wp2 = new Waypoint(1, 47.250434, -122.308799, 550);//sea-tac lon, just south lat
		Leg l1 = new Leg(3, wp1, wp3, 25);
		Leg l3 = new Leg(3, wp3, wp1, 15);
		Leg test = new Leg(4, wp2, wp1, 15);
		Leg[] legs = new Leg[2];
		legs[0] = test;
		legs[1] = l1;
		//END USER EDIT
		Location loc1 = new Location(47.350434, -122.308799, 550, 15, 15, 266, 266);
		for (int i = 0; i < legs.length; i++) {
			loc1 = flyLeg(legs[i], loc1);
		}
		System.out.println(wp3.courseTo(wp2));
		System.out.println(test.getLength());
		//System.out.println(test.getStart());
		
	}
	/*Stand in for the real update method, which would query a GPS for the new location
	 * 
	 */
	public static Location update(Location loc1) {
		loc1.setLat(loc1.getLat()+0.00016667);
		return loc1;
	}
	/* Actually does flying, queries update method
	 * 
	 */
	public static Location flyLeg(Leg l, Location loc1) throws InterruptedException {
		double distance = l.getEnd().distanceTo(loc1);
		int count = 0;
		boolean test = true;
		while (test == true) {
			System.out.println("Control side given commands: Speed: " + l.getAirspeed() + " Heading: " + l.getEnd().courseTo(loc1) + " Climb Rate: " + l.getClimbRate(loc1));

			System.out.println("Distance to go: " + l.getEnd().distanceTo(loc1));
			System.out.println(l.getID());
			loc1 = update(loc1);
			count++;
			test = false;
			if (l.getEnd().distanceTo(loc1) > CLOSEENOUGH) {
				System.out.println(true);
				test = true;
			}
			System.out.println(count);
			Thread.sleep(100);
		}
		return loc1;
	}
		
}