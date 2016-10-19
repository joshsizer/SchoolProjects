/**
 * 145 = 1! + 4! + 5!. This program calculates the sum
 * of all these numbers between 0 and a specified number.
 * 
 * 1 and 2 does not qualify because they are not sums. 
 * @author 18jsizer
 *
 */
public class FactorialCalculator {
	public static int calculate(int maxNumber) {
		int total = 0;
		for (int i = 3; i < maxNumber; i++) {
			if (qualifies(Integer.toString(i)))
				total += i;
		}
		return total;
	}
	
	public static boolean qualifies(String input) {
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			int blah = Integer.parseInt(input.substring(i, i + 1));
			sum += factorial(blah);
		}
		return sum == Integer.parseInt(input);
	}
		
	public static int factorial(int input) {
		int product = 1;
		for (int i = input; i > 0; i--) {
			product *= i;
		}
		
		return product;
	}
	
	public static void main(String[] args) {
		System.out.println(calculate((int) 1e6));
	}
}
