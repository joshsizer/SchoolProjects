package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the place where all the Data for this project will be held. This includes all EarthQuakes, as well 5 
 * lists of earth quakes sorted by their five attributes.
 * 
 * @author Josh Sizer
 *
 */
public class DataCenter {
	public static final int SORT_BY_DATE = 0;
	public static final int SORT_BY_LAT = 1;
	public static final int SORT_BY_LONG = 2;
	public static final int SORT_BY_DEPTH = 3;
	public static final int SORT_BY_MAG = 4;
	
	public static final int SEARCH_BY_DATE = 0;
	public static final int SEARCH_BY_LAT = 1;
	public static final int SEARCH_BY_LONG = 2;
	public static final int SEARCH_BY_DEPTH = 3;
	public static final int SEARCH_BY_MAG = 4;
	
	private EarthQuake[] allQuakes;
	
	public DataCenter(String path) throws IOException {
		allQuakes = Parser.getEarthQuakes(path).toArray(new EarthQuake[]{});
		sortByLat();
		print(allQuakes);
		int index = searchLat(44.7832);
		System.out.println(index);
		System.out.println(allQuakes[index]);
	}
	
	public void sortByDate() {
		Arrays.sort(allQuakes, EarthQuake.getComparator(SORT_BY_DATE));
	}

	public void sortByLat() {
		Arrays.sort(allQuakes, EarthQuake.getComparator(SORT_BY_LAT));
	}
	
	public void sortByLong() {
		Arrays.sort(allQuakes, EarthQuake.getComparator(SORT_BY_LONG));
	}
	
	public void sortByDepth() {
		Arrays.sort(allQuakes, EarthQuake.getComparator(SORT_BY_DEPTH));
	}
	
	public void sortByMag() {
		Arrays.sort(allQuakes, EarthQuake.getComparator(SORT_BY_MAG));
	}
	
	public int searchLat(double lat) {
		return BinarySearch.search(Arrays.asList(allQuakes), lat, EarthQuake.getSortator(SEARCH_BY_LAT));
	}
	
	public void print(EarthQuake[] arr) {
		for (EarthQuake cur : arr) {
			System.out.println(cur);
		}
	}
}
