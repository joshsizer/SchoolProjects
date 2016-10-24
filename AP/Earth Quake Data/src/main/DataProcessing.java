package main;

import java.util.Arrays;
import java.util.Comparator;

public class DataProcessing {
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

	public static final int LINEAR_SEARCH = 0;
	public static final int BINARY_SEARCH = 1;

	public static final int LOW_TO_HIGH = 0;
	public static final int HIGH_TO_LOW = 1;

	/*
	 * ------------------------------------------------------ All sorting
	 * function -------------------------------------------------------
	 */

	public static void sortByDate() {
		sortByDate(LOW_TO_HIGH);
	}

	public static void sortByLat() {
		sortByLat(LOW_TO_HIGH);
	}

	public static void sortByLong() {
		sortByLong(LOW_TO_HIGH);
	}

	public static void sortByDepth() {
		sortByDepth(LOW_TO_HIGH);
	}

	public static void sortByMag() {
		sortByMag(LOW_TO_HIGH);
	}

	public static void sortByDate(int order) {
		Arrays.sort(DataCenter.allQuakes, getComparator(DataProcessing.SORT_BY_DATE, order));
	}

	public static void sortByLat(int order) {
		Arrays.sort(DataCenter.allQuakes, getComparator(DataProcessing.SORT_BY_LAT, order));
	}

	public static void sortByLong(int order) {
		Arrays.sort(DataCenter.allQuakes, getComparator(DataProcessing.SORT_BY_LONG, order));
	}

	public static void sortByDepth(int order) {
		Arrays.sort(DataCenter.allQuakes, getComparator(DataProcessing.SORT_BY_DEPTH, order));
	}

	public static void sortByMag(int order) {
		Arrays.sort(DataCenter.allQuakes, getComparator(DataProcessing.SORT_BY_MAG, order));
	}

	/*
	 * ------------------------------------------------------ All searching
	 * function -------------------------------------------------------
	 */

	public static int searchDate(String date, int typeOfSearch, int order) {
		if (typeOfSearch == LINEAR_SEARCH)
			return LinearSearch.search(Arrays.asList(DataCenter.allQuakes), date,
					getSearcher(DataProcessing.SEARCH_BY_DATE));
		else
			return BinarySearch.search(Arrays.asList(DataCenter.allQuakes), date,
					getSearcher(DataProcessing.SEARCH_BY_DATE), order);
	}

	public static int searchLat(double lat, int typeOfSearch, int order) {
		if (typeOfSearch == LINEAR_SEARCH)
			return LinearSearch.search(Arrays.asList(DataCenter.allQuakes), lat,
					getSearcher(DataProcessing.SEARCH_BY_LAT));
		else
			return BinarySearch.search(Arrays.asList(DataCenter.allQuakes), lat,
					getSearcher(DataProcessing.SEARCH_BY_LAT), order);
	}

	public static int searchLong(double longi, int typeOfSearch, int order) {
		if (typeOfSearch == LINEAR_SEARCH)
			return LinearSearch.search(Arrays.asList(DataCenter.allQuakes), longi,
					getSearcher(DataProcessing.SEARCH_BY_LONG));
		else
			return BinarySearch.search(Arrays.asList(DataCenter.allQuakes), longi,
					getSearcher(DataProcessing.SEARCH_BY_LONG), order);
	}

	public static int searchDepth(double depth, int typeOfSearch, int order) {
		if (typeOfSearch == LINEAR_SEARCH)
			return LinearSearch.search(Arrays.asList(DataCenter.allQuakes), depth,
					getSearcher(DataProcessing.SEARCH_BY_DEPTH));
		else
			return BinarySearch.search(Arrays.asList(DataCenter.allQuakes), depth,
					getSearcher(DataProcessing.SEARCH_BY_DEPTH), order);
	}

	public static int searchMag(double mag, int typeOfSearch, int order) {
		if (typeOfSearch == LINEAR_SEARCH)
			return LinearSearch.search(Arrays.asList(DataCenter.allQuakes), mag,
					getSearcher(DataProcessing.SEARCH_BY_MAG));
		else
			return BinarySearch.search(Arrays.asList(DataCenter.allQuakes), mag,
					getSearcher(DataProcessing.SEARCH_BY_MAG), order);
	}

	/**
	 * Returns a comparator that will sort an EarthQuake by a specific piece of
	 * instance data
	 * 
	 * @param sortBy
	 *            The instance data to sort by
	 * @param order
	 *            weather you want to sort from low to high or high to low
	 * @return The corresponding comparator
	 */
	public static Comparator<EarthQuake> getComparator(int sortBy, int order) {
		switch (sortBy) {
		case DataProcessing.SORT_BY_DATE:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					if (order == LOW_TO_HIGH)
						return first.getDate().compareTo(second.getDate());
					else
						return second.getDate().compareTo(first.getDate());
				}
			};
		case DataProcessing.SORT_BY_LAT:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					if (order == LOW_TO_HIGH)
						return Double.compare(first.getLat(), second.getLat());
					else
						return Double.compare(second.getLat(), first.getLat());
				}
			};

		case DataProcessing.SORT_BY_LONG:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					if (order == LOW_TO_HIGH)
						return Double.compare(first.getLong(), second.getLong());
					return Double.compare(second.getLong(), first.getLong());
				}
			};

		case DataProcessing.SORT_BY_DEPTH:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					if (order == LOW_TO_HIGH)
						return Double.compare(first.getDepth(), second.getDepth());
					else
						return Double.compare(second.getDepth(), first.getDepth());
				}
			};

		default:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					if (order == LOW_TO_HIGH)
						return Double.compare(first.getMag(), second.getMag());
					else
						return Double.compare(second.getMag(), first.getMag());
				}
			};
		}
	}

	/**
	 * Returns a "Searcher" that can compare a specific member of an earthquake
	 * to a specified value.
	 * 
	 * @param searchBy
	 *            What member data you wish to sort by
	 * @return The corresponding searcher interface
	 */
	public static Searcher getSearcher(int searchBy) {
		switch (searchBy) {
		case DataProcessing.SEARCH_BY_DATE:
			return new Searcher() {
				@Override
				public int compare(EarthQuake earthQuake, Object target) {
					return earthQuake.getDate().compareTo((String) target);
				}
			};
		case DataProcessing.SORT_BY_LAT:
			return new Searcher() {

				@Override
				public int compare(EarthQuake earthQuake, Object target) {
					return Double.compare(earthQuake.getLat(), (double) target);
				}
			};

		case DataProcessing.SORT_BY_LONG:
			return new Searcher() {

				@Override
				public int compare(EarthQuake earthQuake, Object target) {
					return Double.compare(earthQuake.getLong(), (double) target);
				}
			};
		case DataProcessing.SORT_BY_DEPTH:
			return new Searcher() {

				@Override
				public int compare(EarthQuake earthQuake, Object target) {
					return Double.compare(earthQuake.getDepth(), (double) target);
				}
			};

		default:
			return new Searcher() {
				@Override
				public int compare(EarthQuake earthQuake, Object target) {
					return Double.compare(earthQuake.getMag(), (double) target);
				}

			};
		}
	}
}
