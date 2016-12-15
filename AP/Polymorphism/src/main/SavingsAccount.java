package main;
/**
 * 
 * Simulates a savings account on which interest can
 * 			be earned.
 * @author Steinberg
 * @version July 23, 2007
 * 
 */

public class SavingsAccount extends BankAccount
{
	private double interestRate;

	/**
	 * Constructs a savings account from 
	 * 	a customer name, an initial balance, and an
	 * 	interest rate.
	 * @param name customer's name
	 * @param balance initial balance
	 * @param rate interest rate	
	 */
	public SavingsAccount(String name, double balance, double rate)
	{
		super(name, balance);
		interestRate = rate;
	}
	
	/**
	 * Adds interest to the balance using the interest rate.
	 */
	public void addInterest()
	{
		double current;
		current = this.getBalance();
		this.deposit(interestRate*current);
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	@Override
	public String toString() {
		String superRet = super.toString();
		return "Account Type: SavingsAccount\n" + superRet + "\nInterest rate: " + interestRate;
	}
	
	@Override
	public boolean equals(Object rhs) {
		if (!(super.equals(rhs)))
			return false;
		SavingsAccount as = (SavingsAccount)rhs;
		return this.getInterestRate() == as.getInterestRate();
	}

}
