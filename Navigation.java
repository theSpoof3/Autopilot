package autopilot;

import java.util.ArrayList;

public class Navigation {
public static final double CLOSEENOUGH = .005;
	public static void main(String[] args) {
		Waypoint wp1 = new Waypoint(1, 47.450434, -122.308799, 100);//sea-tac
		Waypoint wp3 = new Waypoint(3, 37.712187, -122.212142, 350);//oakland airport
		Leg l1 = new Leg(3, wp1, wp3, 25);
		Leg l3 = new Leg(3, wp3, wp1, 15);
		System.out.println(l3.getAirspeed());
		System.out.println(l3.getLength());
		System.out.println(wp3.distanceTo(wp1));
		System.out.println(wp3.getAlt());
		System.out.println(wp3.getLat());
		System.out.println(l3.getStart());
		
	}
	public static void fakeMoving(Leg test) {
		Location loc1 = new Location(test.getStart());
		for (int i = 0; i < test.getLength()%.001; i++) {
			loc1.setLat();
		}
	}
		
}

