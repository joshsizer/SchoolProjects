package main;

public class CheckingAccount extends BankAccount {
	public static final double TRANSACTION_FEE = .4;
	private int feeCount;
	private int transactionCount;
	
	public CheckingAccount(String name, double balance) {
		super(name, balance);
		feeCount = 0;
		transactionCount = 0;
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		feeCount++;
		transactionCount++;
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		feeCount++;
		transactionCount++;
	}
	
	@Override
	public String toString() {
		return "Account Type: CheckingAccount\n" + super.toString() + "\nUnpaid fees: " + (double)feeCount * CheckingAccount.TRANSACTION_FEE
				+ "\nTransaction Count: " + this.transactionCount;
	}
	
	public void deductFees() {
		double total = (double)feeCount * CheckingAccount.TRANSACTION_FEE;
		if (total > super.getBalance())
			withdraw(super.getBalance());
		else
			withdraw(total);
		feeCount = 0;
	}
	
	public int getTransactionCount() {
		return transactionCount;
	}
	
	public int getFeeCount() {
		return feeCount;
	}
	
	@Override
	public boolean equals(Object rhs) {
		if (!super.equals(rhs)) 
			return false;
		CheckingAccount ac = (CheckingAccount)rhs;
		return (this.getTransactionCount() == ac.getTransactionCount()) &&
				(this.getFeeCount() == ac.getFeeCount());
	}
}
