package main;

/**
 * The base class of a worker.
 * @author Josh Sizer
 *
 */
public class Worker {
	private String name;
	private double salaryRate;
	
	/**
	 * Creates a worker with the specified name and salary rate (hourly rate)
	 * @param name
	 * @param salaryRate
	 */
	public Worker(String name, double salaryRate) {
		this.name = name;
		this.salaryRate = salaryRate;
	}
	
	/**
	 * Return this worker's name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns this workers salary rate (hourly rate)
	 * @return
	 */
	public double getSalaryRate() {
		return salaryRate;
	}
	
	/**
	 * Computes this workers pay. Because this is a generic worker, it
	 * multiplies the number of hours by the salary worker, for any amount of hours.
	 * @param hours
	 * @return
	 */
	public double computePay(int hours) {
		return (double)hours * salaryRate;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "; Salary Rate: " + salaryRate;
	}
}
