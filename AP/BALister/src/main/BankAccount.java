// BankAccount.java
package main;

import java.util.Arrays;

/** 
 * 
 * Implements a bank account storing balance and 
 * 	customer's name
 * 
 * @author  Steinberg
 * @version July 23, 2007
 *
 */

public class BankAccount implements Comparable<BankAccount>
{
	private double balance;
	private String name;
	
	/**
	 * Constructs a BankAccount from a name and a balance
	 * @param n customer's name
	 * @param b starting balance
	 */
	public BankAccount(String n, double b)
	{
		balance = b;
		name = n;
	}
	   	
	/**
	 * Constructs a BankAccount from a name.
	 * Initial balance is 0.
	 * @param n customer's name
	 */
	public BankAccount(String n)
	{
		this(n, 0.0);
	}
	
	/**
	 * Returns the name of the owner of the account
	 * @return name of owner
	 */
 	public String getName()
 	{
		return name;	
 	}

	/**
	 * Returns the current balance in the account
	 * @return current balance
	 */
 	public double getBalance()
 	{
		return balance;	
 	}

	/**
	 * Deposits an amount into the account
	 * @param amount amount deposited
	 * @throws IllegalArgumentException if amount is negative
	 */
	public void deposit(double amount)
	{
		if (amount < 0.0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			balance += amount;
		}
	}
	
	/**
	 * Withdraws an amount from the account
	 * @param amount amount withdrawn
	 * @throws IllegalArgmentException if amount is greater than balance
	 */
	public void withdraw(double amount)
	{
		if (amount > balance || amount < 0.0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			balance -= amount;
		}
	}
	
	@Override
	public String toString() {
		return "Account holder: " + name + "\nBalance: " + balance;
	}

	@Override
	public boolean equals(Object rhs) {
		if (!(rhs instanceof BankAccount))
			return false;
		else {
			BankAccount other = (BankAccount) rhs;
			return getBalance() == other.getBalance() && getName().equals(other.getName());
		}
	}

	/**
	 * Returns -1 if this object comes before the object being compared,
	 * 1 if it comes after, and 0 if they are the same.
	 */
	@Override
	public int compareTo(BankAccount arg0) {
		//Exercise 2: compare by balance
		/*
		if (this.getBalance() == arg0.getBalance())
			return 0;
		else if (this.getBalance() < arg0.getBalance())
			return -1;
		else
			return 1;
		*/
		
		//Exercise 3: compare by name
		return this.getName().toLowerCase().compareTo(arg0.getName().toLowerCase());
	}

}
 