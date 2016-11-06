package main;

/**
 * TimeB, an alternate implementation of Time.
 * @author 18jsizer
 *
 */
public class TimeB implements Time {
	private int totalSeconds;
	
	/**
	 * Contructs a time object
	 * @param seconds The total number of seconds
	 */
	public TimeB(int seconds) {
		totalSeconds = seconds;
	}
	
	/**
	 * Adds this objects time to another objects time,
	 * returning a TimeB object to hold the time. 
	 */
	@Override
	public Time add(Time other) {
		int total = this.totalSeconds 
				+ Relay.getTotalSeconds(
						other.getHours(), other.getMinutes(), other.getSeconds());
		Time newTime = new TimeB(total);
		return newTime;
	}

	/**
	 * Returns the seconds part of the time.
	 */
	@Override
	public int getSeconds() {
		return totalSeconds % 60;
	}

	/**
	 * Returns the minutes part of the time
	 */
	@Override
	public int getMinutes() {
		return (totalSeconds / 60) % 60;
	}

	/**
	 * Returns the hours part of the time
	 */
	@Override
	public int getHours() {
		return totalSeconds / 3600;
	}

	/**
	 * Return a String representation of this time
	 * 
	 * @return this time represented as a String in hh:mm:ss format
	 */
	@Override
	public String toString() {
		return totalSeconds / 3600 + ":" + (totalSeconds / 60) % 60 + ":"
				+ totalSeconds % 60;
	}
}
