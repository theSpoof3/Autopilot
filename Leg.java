package autopilot;
// May want to remove this. May not be useful.
public class Leg {
	private double airspeed;
	private int id;
	private String name;
	private double length;
	private Waypoint start;
	private Waypoint end;
	private boolean active;
	public Leg(int id, Waypoint start, Waypoint end, double airspeed) {
		this.airspeed = airspeed;
		this.id = id;
		this.start = start;
		this.end = end;
		name = start.getName() + " " + end.getName();
		length = start.distanceTo(end);
		active = false;
	}
	public double getAirspeed() {
		return airspeed;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean b) {
		active = b;
	}
	public int getID() {
		return id;
	}
	public double getLength() {
		return length;
	}
	public String getName() {
		return name;
	}
	public double getClimbRate() {
		double time = 1.0/(airspeed/length);
		double altDifference = start.getAlt()-end.getAlt();
		return altDifference/time;
	}
	public Waypoint getStart() {
		return start;
	}
}
