package main;

public class Main {

	public static void main(String[] args) {
		BankAccount b = new BankAccount("JP Morgan", 100);
		SavingsAccount s = new SavingsAccount("Robert", 200, 0.05);
		CheckingAccount c = new CheckingAccount("Josh", 1000);
		
		try {
			b.withdraw(-200);
		} catch (Exception e) {
			System.out.println("Cannot withdraw more than is in your account");
		}
		
		System.out.println("\n" + b + "\n");
		System.out.println(s + "\n");
		System.out.println(c + "\n===========Now for transactions======================");
		
		c.deposit(100);
		c.withdraw(53.85);
		System.out.println(c);
		
		c.deductFees();
		System.out.println(c);

		System.out.println();
		if (b instanceof SavingsAccount)
			System.out.println("A BankAccount object is an instance of SavingsAccount");
		if (s instanceof BankAccount)
			System.out.println("A SavingsAccount object is an instance of BankAccount");
		if (c instanceof BankAccount)
			System.out.println("A CheckingAccount object is an instance of BankAccount");
		//this will not even compile
		//if (c instanceof SavingsAccount)
			//System.out.println("A CheckingAccount object is an instance of SavingsAccount");

		
	}

}
