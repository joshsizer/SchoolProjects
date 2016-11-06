package main;

/**
 * TimeA - a class to store records of race times that run in units measured in
 * hours/minutes/seconds.
 * 
 * @author dlevine
 * @version August 31, 2006
 *
 */
public class TimeA implements Time {

	private int hours;
	private int minutes;
	private int seconds;

	/**
	 * Simple constructor assumes data is in proper format
	 * 
	 * @param h
	 *            number of hours
	 * @param m
	 *            number of minutes
	 * @param s
	 *            number of seconds
	 */
	public TimeA(int h, int m, int s) {
		hours = h;
		minutes = m;
		seconds = s;
	}

	/**
	 * Constructor that assumes a total number of seconds
	 * 
	 * @param total
	 *            the total number of seconds taken
	 */
	public TimeA(int total) {
		hours = total / 3600;
		minutes = (total / 60) % 60;
		seconds = total % 60;
	}

	/**
	 * Constructor that assumes a properly formatted time String
	 * 
	 * @param time
	 *            the time as a string
	 */
	public TimeA(String time) {
		String[] data = time.split(":");
		hours = Integer.parseInt(data[0]);
		minutes = Integer.parseInt(data[1]);
		seconds = Integer.parseInt(data[2]);
	}

	/**
	 * Adds the given time to the current time, producing the sum
	 * 
	 * @param other
	 *            the given time to add
	 * @return the sum of this time and the other time
	 */
	public Time add(Time other) {
		int totalSeconds = Relay.getTotalSeconds(hours, minutes, seconds)
				+ Relay.getTotalSeconds(other.getHours(), other.getMinutes(), other.getSeconds());
		Time newTime = new TimeA(totalSeconds / 3600,(totalSeconds / 60) % 60, totalSeconds % 60);
		return newTime;
	}
	
	/**
	 * Returns the seconds part of this time
	 */
	public int getSeconds() {
		return seconds;
	}
	
	/**
	 * Returns the minutes part of this time
	 */
	public int getMinutes() {
		return minutes;
	}
	
	/**
	 * Returns the hours part of this time.
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Return a String representation of this time
	 * 
	 * @return this time represented as a String in hh:mm:ss format
	 */
	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}
}
