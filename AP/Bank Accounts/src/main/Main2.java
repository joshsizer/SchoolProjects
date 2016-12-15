package main;

public class Main2 {

	public static void main(String[] args) {
		CheckingAccount ch1 = new CheckingAccount("Joshua Sizer", 100);
		CheckingAccount ch2 = new CheckingAccount("Joshua Sizer", 100);
		CheckingAccount ch3 = new CheckingAccount("Joshua Sizer", 100);
		
		ch3.deposit(1000);
		ch3.withdraw(1000);
		
		System.out.println("=================Checking Accounts Equality Check===============");
		System.out.println(ch1);
		System.out.println();
		System.out.println(ch2);
		System.out.println();
		System.out.println(ch3);
		System.out.println();

		System.out.println("ch1.equals(ch2) is " + ch1.equals(ch2));
		System.out.println("ch3.equals(ch1) is " + ch3.equals(ch1));

		
		System.out.println("=================Savings Accounts Equality Check===============");
		SavingsAccount sa1 = new SavingsAccount("Joshua Sizer", 100, 0.5);
		SavingsAccount sa2 = new SavingsAccount("Joshua Sizer", 100, 0.5);
		SavingsAccount sa3 = new SavingsAccount("Joshua Sizer", 100, 0.3);
		
		System.out.println(sa1);
		System.out.println();
		System.out.println(sa2);
		System.out.println();
		System.out.println(sa3);
		System.out.println();

		System.out.println("sa1.equals(sa2) is " + sa1.equals(sa2));
		System.out.println("sa3.equals(sa1) is " + sa3.equals(sa1));
	}

}
