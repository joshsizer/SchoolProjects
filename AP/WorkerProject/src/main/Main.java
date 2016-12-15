package main;

//27 lines of code, not including this class
public class Main {
	public static void main(String[] args) {
		Worker[] arr = {new SalariedWorker("Bob", 37.41), new HourlyWorker("Joe", 37.41)};

		for (Worker cur : arr)
			System.out.println(cur);
		
		/*
		 * Polymorphism is shown here because the objects in the worker array use
		 * the most specialized version of computePay() that they have. So, with more than 
		 * 40 hours, we see that the two objects in this array will calculate different 
		 * amounts since one is a SalariedWorker and will use it's computePay() method,
		 * while the other is an HourlyWorker and will it's computePay() method. These 
		 * two methods, as shown below, produce different results with the same input,
		 * showing that polymorphism is occuring.
		 */
		System.out.println("\nEach of the Workers have a salary of $37.41.");
		System.out.println("For 47 hours of work, Bob gets $" + arr[0].computePay(47));
		System.out.println("37.41 * 47 is " + 37.41 * 47 + ", showing that Bob is a salaried worker since "
				+ "he gets a flat rate of 1496.40 per week (Even when working more than 40 hours).");
		System.out.println();
		System.out.println("For 47 hours of work, Joe gets $" + arr[1].computePay(47));
		System.out.println("37.41 * 47 is " + 37.41 * 47 + ", showing that Joe is a hourly worker since "
				+ "he gets $1889.21 for 47 hours in a week because of time and a half.");
	}
}
