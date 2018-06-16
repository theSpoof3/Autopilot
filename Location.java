package autopilot;
public class Location {
	private double lat;
	private double lon;
	private double alt;
	private double airspeed;
	private double groundspeed;
	private double cog;
	private double heading;
	public Location(double lat, double lon, double alt, double groundspeed, double airspeed, double cog, double heading) {
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.airspeed = airspeed;
		this.groundspeed = groundspeed;
		this.cog = cog;
		this.heading = heading;
	}
	public Location(Waypoint wp) {
		this(wp.getLat(), wp.getLon(), wp.getAlt(), 15, 15, 0,0);
	}

	public double getAlt() {
		return alt;
	}
	public double getLat() {
		return lat;
	}
	public double getLon() {
		return lon;
	}
	public double getAirspeed() {
		return airspeed;
	}
	public void setLat(double lat) {
		this.lat = lat; 
	}
	public void setLon(double lon) {
		this.lon = lon; 
	}
	public void setAlt(double alt) {
		this.alt = alt; 
	}
	public void setAirspeed(double airspeed) {
		this.airspeed = airspeed; 
	}
	public double getHeading() {
		return heading;
	}
	public String toString() {
		String s = lat + ", " + lon + ", " + alt + ", " + airspeed + ", " + groundspeed + ", " + cog + ", " + heading;
    	return s;
	}
	public double getLatRadians() {
		return (Math.toRadians(lat));
	}
	public double getLonRadians() {
		return (Math.toRadians(lon));
	}

}