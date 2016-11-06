package main;

//********************************************************************
//Coin.java       Author: Lewis/Loftus/Cocking
//
//Represents a coin with two sides that can be flipped.
//********************************************************************

/**
 * 
 * @author Lewis/Loftus/Cocking, edited by Josh Sizer
 *
 */
public class Coin implements Lockable {
	private final int HEADS = 0;

	private int face;
	private int key;
	private boolean keySet;
	private boolean locked;

	// -----------------------------------------------------------------
	// Sets up the coin by flipping it initially.
	// -----------------------------------------------------------------
	public Coin() {
		key = 0;
		keySet = false;
		locked = false;
		try {
			flip();
		} catch (ClassLockedException e) {
			// this should never occur, because the
			// class is unlocked when constructed
		}
	}

	// -----------------------------------------------------------------
	// Flips the coin by randomly choosing a face value.
	// -----------------------------------------------------------------
	public void flip() throws ClassLockedException {
		if (locked)
			throw new ClassLockedException();
		face = (int) (Math.random() * 2);
	}

	// -----------------------------------------------------------------
	// Returns true if the current face of the coin is heads.
	// -----------------------------------------------------------------
	public boolean isHeads() {
		return (face == HEADS);
	}

	// -----------------------------------------------------------------
	// Returns the current face of the coin as a string
	// -----------------------------------------------------------------
	public String toString() {
		if (locked)
			return "locked";
		String faceName;
		if (face == HEADS)
			faceName = "Heads";
		else
			faceName = "Tails";

		return faceName;
	}

	/**
	 * Sets the class's key. Can only be called once. Any subsequent calls
	 * will not modify this class's key.
	 * @param aKey an integer key
	 */
	@Override
	public void setKey(int aKey) {
		if (!keySet)
			key = aKey;
		keySet = true;
	}

	/**
	 * Locks the class if the correct key is entered
	 * @param key the class's integer key
	 */
	@Override
	public void lock(int key) {
		if (key == this.key)
			locked = true;
	}

	/**
	 * Unlocks the class if the correct key is entered
	 * @param key the class's integer key
	 */
	@Override
	public void unlock(int key) {
		if (key == this.key)
			locked = false;
	}

	/**
	 * @return true if this class is locked, false if it is not locked. 
	 */
	@Override
	public boolean locked() {
		return locked;
	}
}
