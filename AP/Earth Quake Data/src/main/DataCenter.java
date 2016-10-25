package main;

import java.io.IOException;

/**
 * This is the place where all the Data for this project will be held. This includes all EarthQuakes, as well 5 
 * lists of earth quakes sorted by their five attributes.
 * 
 * @author Josh Sizer
 *
 */
public class DataCenter {
	public static EarthQuake[] allQuakes;
	
	public DataCenter(String path) throws IOException {
		allQuakes = Parser.getEarthQuakes(path).toArray(new EarthQuake[]{});
		
		DataProcessing.sortByMag();
		DataProcessing.sortByLat();
		DataProcessing.sortByDate();
		//print(allQuakes);
				
		System.out.println("EarthQuake found: " + allQuakes[DataProcessing.searchDate("20001014", DataProcessing.BINARY_SEARCH, DataProcessing.LOW_TO_HIGH)]);
		System.out.println("Number of comparisons with BinarySearch: " + BinarySearch.lastNumComparisons);
		DataProcessing.searchDate("20001014", DataProcessing.LINEAR_SEARCH, DataProcessing.HIGH_TO_LOW);
		System.out.println("Number of comparisons with LinearSearch: " + LinearSearch.lastNumComparisons);
		
	}
	
	public void print(EarthQuake[] arr) {
		StringBuilder toPrint = new StringBuilder();
		for (EarthQuake cur : arr) {
			toPrint.append(cur.toString() + "\n");
		}
		System.out.println(toPrint.toString());
	}
}
