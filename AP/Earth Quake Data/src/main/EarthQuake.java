package main;

import java.util.ArrayList;

public class EarthQuake {
	private String date;
	private double lat, longi, depth, mag;
	
	public EarthQuake(String[] args) {
		this(args[0], 
				Double.parseDouble(args[1]), 
				Double.parseDouble(args[2]), 
				Double.parseDouble(args[3]), 
				Double.parseDouble(args[4]));
	}
	
	public EarthQuake(String date, double lat, double longi, double depth, double mag) {
		this.date = date;
		this.lat = lat;
		this.longi = longi;
		this.depth = depth;
		this.mag = mag;
	}
	
	public String getDate() {
		return date;
	}

	public double getLat() {
		return lat;
	}

	public double getLong() {
		return longi;
	}

	public double getDepth() {
		return depth;
	}

	public double getMag() {
		return mag;
	}

	@Override
	public String toString() {
		return date + "," + lat + "," + longi + "," + depth + "," + mag;
	}
}
