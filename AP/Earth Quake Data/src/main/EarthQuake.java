package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
					return Double.compare(first.getLat(), second.getLat()); }};
					
		case DataCenter.SORT_BY_LONG:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					return Double.compare(first.getLong(), second.getLong()); }};
					
		case DataCenter.SORT_BY_DEPTH:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					return Double.compare(first.getDepth(), second.getDepth()); }};
					
		case DataCenter.SORT_BY_MAG:
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					return Double.compare(first.getMag(), second.getMag()); }};
					
		default: 
			return new Comparator<EarthQuake>() {
				@Override
				public int compare(EarthQuake first, EarthQuake second) {
					return first.getDate().compareTo(second.getDate()); }};  
		}
	}
	
	public static Sortator<EarthQuake> getSortator(int searchBy) {
		switch (searchBy) {
		/*
		case DataCenter.SEARCH_BY_DATE:
			return new Sortator<EarthQuake>() {
				@Override
				public double get(List<EarthQuake> list, int index) {
					return list.get(index).getDate(); }};
			*/
		case DataCenter.SORT_BY_LAT:
			return new Sortator<EarthQuake>() {
				@Override
				public double get(List<EarthQuake> list, int index) {
					return list.get(index).getLat(); }};
					
		case DataCenter.SORT_BY_LONG:
			return new Sortator<EarthQuake>() {
				@Override
				public double get(List<EarthQuake> list, int index) {
					return list.get(index).getLong(); }};
					
		case DataCenter.SORT_BY_DEPTH:
			return new Sortator<EarthQuake>() {
				@Override
				public double get(List<EarthQuake> list, int index) {
					return list.get(index).getDepth(); }};
				
		default:
			return new Sortator<EarthQuake>() {
				@Override
				public double get(List<EarthQuake> list, int index) {
					return list.get(index).getMag(); }};
			
		}
	}
}
