package main;

public class HourlyWorker extends Worker {
	/**
	 * An hourly worker which receives time and a half for any hours over 40 in a week
	 * @param name The name of this worker
	 * @param salaryRate The hourly rate of this worker
	 */
	public HourlyWorker(String name, double salaryRate) {
		super(name, salaryRate);
	}
	
	/**
	 * Computes the pay with 1.5 times the hourly rate for any time over 40 hours.
	 */
	@Override
	public double computePay(int hours) {
		return (hours > 40 ? (getSalaryRate() * 1.5 * (hours - 40)) + getSalaryRate() * 40 : getSalaryRate() * hours);
	}
}
