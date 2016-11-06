package main;

/**
 * Relay.java - a class to handle the data for a relay race.
 * 
 * The time records for each runner of the relay race are stored in an array.
 * The contents of this array are printed to the console window and (not yet
 * implemented) the total time is also printed.
 * 
 * @author dlevine
 * @version August 31, 2006
 *
 */

/*
 * Questions: 1) Do you see any reference to TimeA to Time.java? No, there is no
 * reference.
 * 
 * 2) If so, describe where it occurs 
 * 		NO reference.
 * 
 * 3) Do you see any reference to Time in TimeA.java? 
 * 		Yes, the class header of TimeA has the keywords "implements Time".
 * 
 * 4) What output is produced? 
 * 		First runner: some time 
 * 		Second runner: some time
 * 		Third runner: some time
 *
 * 5) Explain why this output is produced
 * 		This output is produced because its toString method returns "some time"
 *
 * 6) What is the output?
 * 		The output is 1:2:3
 * 
 * 7) Is this the correct answer?
 * 		This is the correct answer
 * 
 * 8) What happens if you change the times of the various legs of the relay?
 * 		The output does not change.
 * 
 * 9) Does the program behave correctly?
 * 		Yes, it behaves as expected
 * 
 * 10) Why or why not?
 * 		It behaves correctly because TimeA and TimeB implements
 * 		the Time interface, so you can instantiate them in an array of type
 * 		Time
 * 
 * 12) What goes wrong? Why? 
 * 		It gives a compiler error. This happens because TimeA and TimeB are on the same level
 * 		of inheritance. TimeB is not a subclass or an implementation of TimeA.
 * 		
 * 	   Try to create a Time object as one of the types. What happens?
 * 		A compiler error occurs. You cannot instantiate a Time class because it is not a class,
 * 		it is an interface. 
 *		
 * 13) What happens?
 * 		The program runs correctly
 * 
 * 14) To the best of your ability, explain why
 * 		TimeA and TimeB both implement the Time interface. All a Time
 * 		array is ensuring is that the objects within the array implement the
 * 		Time interface. 
 * 
 */

public class Relay {

	public static void main(String[] args) {
		Time[] raceLegs = new Time[3];
		raceLegs[0] = new TimeB(903);
		raceLegs[1] = new TimeB(103);
		raceLegs[2] = new TimeA("0:45:17");

		System.out.println("First runner:  " + raceLegs[0].toString());
		System.out.println("Second runner: " + raceLegs[1].toString());
		System.out.println("Third runner:  " + raceLegs[2].toString());
		
		Time sum = new TimeB(0);
		
		for (Time time : raceLegs) {
			sum = sum.add(time);
		}
		
		System.out.println("Total: " + sum);
	}
	
	public static int getTotalSeconds(int h, int m, int s) {
		return (h * 3600) + (m * 60) + s;
	}
	
}
