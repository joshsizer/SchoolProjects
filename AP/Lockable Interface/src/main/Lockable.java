package main;

/**
 * 
 * @author Joshua Sizer
 * An interface to lock an object
 */
public interface Lockable {
	
	/**
	 * Sets the class's key
	 * @param aKey an integer key
	 */
	public void setKey(int aKey);
	
	/**
	 * Locks the class if the correct key is entered
	 * @param key the class's integer key
	 */
	public void lock(int key);
	
	/**
	 * Unlocks the class if the correct key is entered
	 * @param key the class's integer key
	 */
	public void unlock(int key);
	
	/**
	 * @return true if this class is locked, false if it is not locked. 
	 */
	public boolean locked();
}
