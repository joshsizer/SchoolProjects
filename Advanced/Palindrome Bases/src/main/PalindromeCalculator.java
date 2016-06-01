package main;

import java.util.ArrayList;

/**
 * The decimal 585 in base 10 as well in base 2, 
 * 1001001001001 is palindromic in both bases. This 
 * calculates the sum of all these numbers between 
 * 0 and a specified number
 * @author 18jsizer
 *
 */
public class PalindromeCalculator {
	/**
	 * Will calculate from 0 to one less than the max number
	 * @param maxNumber
	 */
	public static int calculate(int maxNumber) {
		//ArrayList<Integer> allDemPalindromes = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < maxNumber; i++) {
			String dec = Integer.toString(i);
			String bin = Integer.toBinaryString(i);
			
			if (isPalindrome(dec) && isPalindrome(bin))
				sum += i;
		}
		return sum;
	}
	
	public static boolean isPalindrome(String input) {
		if (input.length() == 1) 
			return true;
		
		int middle = input.length() / 2;
		
		String firstHalf = input.substring(0, middle);
		
		if (input.length() % 2 != 0)
			middle++;
		
		String secondHalf = input.substring(middle);
						
		String reverse = "";
		for (int i = secondHalf.length() - 1; i >= 0; i--) {
			reverse += secondHalf.charAt(i);
		}
		return firstHalf.equalsIgnoreCase(reverse);
	}
	
	public static void main(String[] args) {
		System.out.println(calculate((int) 1e6));
	}
}
