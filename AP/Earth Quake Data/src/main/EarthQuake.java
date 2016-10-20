package main;

import java.util.ArrayList;
import java.util.Comparator;

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

	public static Comparator<EarthQuake> getComparator(int sortBy) {
		switch(sortBy) {
			case DataCenter.SORT_BY_LAT:
				return new Comparator<EarthQuake>() {
					@Override
					public int compare(EarthQuake first, EarthQuake second) {
						if (first.getLat() > second.getLat()) 
							return 1;
						else
							return -1;
					}
				};
			case DataCenter.SORT_BY_LONG:
				return new Comparator<EarthQuake>() {
					@Override
					public int compare(EarthQuake first, EarthQuake second) {
						if (first.getLong() > second.getLong()) 
							return 1;
						else
							return -1;
					}
				};
			case DataCenter.SORT_BY_DEPTH:
				return new Comparator<EarthQuake>() {
					@Override
					public int compare(EarthQuake first, EarthQuake second) {
						if (first.getDepth() > second.getDepth()) 
							return 1;
						else
							return -1;
					}
				};
			case DataCenter.SORT_BY_MAG:
				return new Comparator<EarthQuake>() {
					@Override
					public int compare(EarthQuake first, EarthQuake second) {
						if (first.getMag() > second.getMag()) 
							return 1;
						else
							return -1;
					}
				};
			default: 
				return new Comparator<EarthQuake>() {
					@Override
					public int compare(EarthQuake first, EarthQuake second) {
						return first.getDate().compareTo(second.getDate());
					}
				};  
		}
	
	}
}
