package main;

/**
 * Defines the interface Time
 * 
 * @author andrianoff
 * @version January 15, 2008
 *
 */
public interface Time {
	/**
	 * Adds the given time to the current time, producing the sum
	 * 
	 * @param other
	 *            the given time to add
	 * @return the sum of this time and the other time
	 */
	public abstract Time add(Time other);

	/**
	 * Return a String representation of this time
	 * 
	 * @return this time represented as a String in hh:mm:ss format
	 */
	public abstract String toString();
	
	/**
	 * Returns the seconds part of this time
	 * @return
	 */
	public abstract int getSeconds();
	
	/**
	 * Returns the seconds part of this time
	 * @return
	 */
	public abstract int getMinutes();
	
	/**
	 * Returns the minutes part of this time.
	 * @return
	 */
	public abstract int getHours();
}
