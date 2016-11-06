package main;

import java.util.Scanner;

/**
 * 
 * @author Josh Sizer
 *
 */
public class Main {
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		Coin coin = new Coin();
		
		System.out.println("The coin is: " + coin.toString());
		System.out.println("\nLocking coin.");
		
		coin.setKey(1234);
		coin.lock(1234);
		
		System.out.println("The coin is: " + coin.toString());
		System.out.println("\nTrying to flip coin...");
		
		//just makes sure that the ClassLockedException is never thrown
		if (!coin.locked()) {
			try {
				coin.flip();
				System.out.println("The coin is: " + coin.toString());
			} catch (ClassLockedException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("The coin is: " + coin.toString());
		
		System.out.println("\nUnlocking coin");
		System.out.println("Trying to flip coin...");

		coin.unlock(1234);

		if (!coin.locked()) {
			try {
				coin.flip();
				System.out.println("The coin is: " + coin.toString());
			} catch (ClassLockedException e) {
				e.printStackTrace();
			}
		} else
			System.out.println("The coin is: " + coin.toString());
		
		System.out.println("\nProof that you cannot unlock a class with the improper key");
		coin.lock(2344);
		System.out.println("The coin is: " + coin.toString());
		
		System.out.println("\nProof that you cannot access methods in the object when the"
				+ " object is locked: (exception)");
		
		coin.lock(1234);
		try {
			coin.flip();
		} catch (ClassLockedException e) {
			e.printStackTrace();
		}	
	}
}