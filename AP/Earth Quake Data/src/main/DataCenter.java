package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This is the place where all the Data for this project will be held. This includes all EarthQuakes, as well 5 
 * lists of earth quakes sorted by their five attributes.
 * 
 * @author Josh Sizer
 *
 */
public class DataCenter {
	public static final int SORT_BY_LAT = 0;
	public static final int SORT_BY_LONG = 1;
	public static final int SORT_BY_DEPTH = 2;
	public static final int SORT_BY_MAG = 3;
	
	private ArrayList<EarthQuake> byDate;
	private ArrayList<EarthQuake> byLat;
	private ArrayList<EarthQuake> byLong;
	private ArrayList<EarthQuake> byDepth;
	private ArrayList<EarthQuake> byMag;
	
	public DataCenter(String path) throws FileNotFoundException {
		byDate = (ArrayList<EarthQuake>) Parser.getEarthQuakes(path);
		System.out.println(byDate);
	}
	
	public ArrayList<EarthQuake> sort(ArrayList<EarthQuake> list, int sortBy) {
		ArrayList<EarthQuake> sorted = new ArrayList<EarthQuake>();
		
		double smallest;
		
		switch(sortBy) {
			case SORT_BY_LAT:
				smallest = list.get(0).getLat();
				for (int i = 1; i < list.size(); i++) {
					if (smallest)
				}
				break;
			case SORT_BY_LONG:
				break;
			case SORT_BY_DEPTH:
				break;
			case SORT_BY_MAG:
				break;
		}
		return sorted;
	}
	
	public ArrayList<EarthQuake> sortByLat() {
		return sort(byDate, SORT_BY_LAT);
	}
	
	public ArrayList<EarthQuake> sortByLong() {
		return sort(byDate, SORT_BY_LONG);
	}
	
	public ArrayList<EarthQuake> sortByDepth() {
		return sort(byDate, SORT_BY_DEPTH);
	}
	
	public ArrayList<EarthQuake> sortByMag() {
		return sort(byDate, SORT_BY_MAG);
	}
}
