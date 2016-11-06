package main;

/**
 * An exception thrown to stop calls to locked objects
 * @author 18jsizer
 *
 */
@SuppressWarnings("serial")
public class ClassLockedException extends Exception {
	public ClassLockedException() {
		super("Class is locked");
	}
}
