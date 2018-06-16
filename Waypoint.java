package autopilot;
// user must always define an ID, lat, lon, and alt. name is optional. ID reflects order flown
public class Waypoint {
	public static final int EARTHRADIUSNM = 3440;
	private int id;
	private String name;
	private double lat;
	private double lon;
	private double alt;
	public Waypoint(int id, String name, double lat, double lon, double alt) {
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
	}
	public Waypoint(int id, double lat, double lon, double alt) {
		this(id, null, lat, lon, alt);
		name = "waypoint " + id;
	}

    public double distanceTo(Location loc1) {
		// Return distance in radians
    	double a = Math.pow(Math.sin((loc1.getLatRadians()-this.getLatRadians())/2), 2)
                + Math.cos(this.getLatRadians()) * Math.cos(loc1.getLatRadians()) * Math.pow(Math.sin((loc1.getLonRadians()-this.getLonRadians())/2), 2);
    	double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance = 60 * angle2;
    	return distance;
	}
    public double courseTo(Location loc1) {
    	double y = Math.sin(loc1.getLonRadians()-this.getLonRadians()) * Math.cos(loc1.getLatRadians());
    	double x = Math.cos(this.getLatRadians())*Math.sin(loc1.getLatRadians()) -
    	        Math.sin(this.getLatRadians())*Math.cos(loc1.getLatRadians())*Math.cos(loc1.getLonRadians()-this.getLonRadians());
    	double result = Math.toDegrees(Math.atan2(y, x));
    	double course = (result+360)%360;
    	return course;
    }
    public String toString() {
    	String s = id + " " + name + " " + + lat + ", " + lon + ", " + alt;
    	return s;
    }
    public boolean equals(Waypoint wp) {
    	return (this.lat == wp.lat && this.lon == wp.lon && this.alt == wp.alt);
    }
    public boolean equalsIgnoreAlt(Waypoint wp) {
    	return (this.lat == wp.lat && this.lon == wp.lon);
    }
    public boolean equalsLocation(Location loc1) {
    	return (this.lat == loc1.getLat() && this.lon == loc1.getLon() && this.alt == loc1.getAlt());
    }

    public int getID() {
	return id;
    }
    public double distanceTo(Waypoint wp1) {
		// Return distance in radians
    	double a = Math.pow(Math.sin((wp1.getLatRadians()-this.getLatRadians())/2), 2)
                + Math.cos(this.getLatRadians()) * Math.cos(wp1.getLatRadians()) * Math.pow(Math.sin((wp1.getLonRadians()-this.getLonRadians())/2), 2);
    	double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance = 60 * angle2;
    	return distance;
	}
    public double flatEartherDistance(Waypoint other) {
    	double x = (other.getLon()-this.getLon()) * Math.cos((this.getLat()+other.getLat())/2);
    	double y = (other.getLat()-this.getLat());
    	double distance = Math.sqrt(x*x + y*y) * EARTHRADIUSNM;
    	return distance;
    }
    public double courseTo(Waypoint wp2) {
    	double y = Math.sin(wp2.getLonRadians()-this.getLonRadians()) * Math.cos(wp2.getLatRadians());
    	double x = Math.cos(this.getLatRadians())*Math.sin(wp2.getLatRadians()) -
    	        Math.sin(this.getLatRadians())*Math.cos(wp2.getLatRadians())*Math.cos(wp2.getLonRadians()-this.getLonRadians());
    	double result = Math.toDegrees(Math.atan2(y, x));
    	double course = (result+360)%360;
    	return course;
    }
    public double getLat() {
		return lat;
	}
	public double getLon() {
		return lon;
	}
	public double getLatRadians() {
		return (Math.toRadians(lat));
	}
	public double getLonRadians() {
		return (Math.toRadians(lon));
	}
	public double getAlt() {
		return alt;
	}
	public String getName() {
		return name;
	}


}