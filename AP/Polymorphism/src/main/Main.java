package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();
		
		System.out.println("==============Before adding $100=====================");
		for (int i = 0; i < 10; i++) {
			BankAccount cur;
			int random = (int)(Math.random() * 2);
			int name = 0;
			
			if (random == 1)
				cur = new CheckingAccount("A", 0.0);
			else
				cur = new SavingsAccount("A", 0, (Math.random()/10) + 0.01);
			
			System.out.println(cur);
			System.out.println();
			list.add(cur);
		}
		
		//Proof of polymophism
		// because we are iterating through the BankAccount array, but successfully accessing
		// the subclass's methods.
		// In addition, we do not even have to type cast the cur in order to deposit,
		// because polymorphism is making sure that no matter if the class is a BankAccount, SavingsAccount
		// or CheckingAccount, the most specific deposit()	method is being called.
		System.out.println("================After adding $100 and deducting fees if CheckingAccount"
				+ " and adding interest if it is a  SavingsAccount");
		double total = 0;
		for (BankAccount cur : list) {
			cur.deposit(100);
			
			
			if (cur instanceof CheckingAccount)
				((CheckingAccount) cur).deductFees();
			else if (cur instanceof SavingsAccount)
				((SavingsAccount) cur).addInterest();
			
			total += cur.getBalance();
			System.out.println(cur);
			System.out.println();
		}
		System.out.println();
		System.out.println("Total: " + total);
		
	}
}
