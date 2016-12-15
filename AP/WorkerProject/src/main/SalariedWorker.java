package main;

public class SalariedWorker extends Worker {
	/**
	 * A salaried worker that receives 40 hours of pay, regardless of the number hours worked
	 * @param name The workers name
	 * @param salaryRate The "Hourly rate" that the worker receives
	 */
	public SalariedWorker(String name, double salaryRate) {
		super(name, salaryRate);
	}
	
	/**
	 * Always returns 40 * this salaries hourly rate.
	 */
	@Override
	public double computePay(int hours) {
		return 40 * super.getSalaryRate();
	}
}
