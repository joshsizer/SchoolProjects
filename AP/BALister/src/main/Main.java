package main;

import java.util.ArrayList;


/*
 * 	1. Why is it useful to implement the comparable interface as high in the inheritance
 *		hierarchy as possible?
 *		This allows all subclasses to automatically be able to compare from each other without
 *		having to each implement their own compareTo method. The only time a subclass would have
 *		to override the superclass's compareTo method is if was deemed necessary to compare 
 *		the subclasses in a different way than the superclass.
 *
 *	2. What happens in the savings account class when you also implement comparable
 *		at that level?
 *		It can only implement Comparable of type BankAccount. This means that if you are comparing
 *		a different value in the compareTo method in the subclass than in the superclass,
 *		you have to define a way to compare the generic type of BankAccount to the SavingsAccount.
 *		Since a BankAccount has 0.0 interest, I chose to return 0 when comparing a bank account
 *		to a savings account if and only if the SavingAccounts interest is also 0.0. 
 */
public class Main {
	public static void main(String[] args){
		ArrayList<BankAccount> al = new ArrayList<BankAccount>();
		BankAccount[] a =
				{new BankAccount("Joe Shmoe"), new BankAccount("Fred", 2012.33),
						new BankAccount("Aaron", 219.30), new BankAccount("Paul", 1103.32),
						new BankAccount("Sal", 20231.20), new BankAccount("Max", 453),
						new BankAccount("Josh", 33435.76), new BankAccount("Alycia", 20),
						new BankAccount("Kenny", 5610.43), new BankAccount("Noah", 1)
				};
		
		ArrayList<SavingsAccount> sa = new ArrayList<SavingsAccount>();
		SavingsAccount[] b = {
				new SavingsAccount("Joe Shmoe", 0.0, 0.03), new SavingsAccount("Fred", 2012.33, 0.02),
				new SavingsAccount("Aaron", 219.30, 0.1), new SavingsAccount("Paul", 1103.32, 0.05),
				new SavingsAccount("Sal", 20231.20, 0.03),
		};
		
		// Adds each element into its correct place.
		// This is done by accounting for the edge cases of the array (ie the ends of the array)
		// separately from the general case (ie when an element has something on the left and right
		// of it).
		for (BankAccount cur : a) {
			// the next for loop will not work if there are 0 elements in the array.
			if (al.size() == 0) {
				al.add(cur);
				continue;
			}
			/* Goes through the array, comparing the current BankAccount
			 * to each bank account already in the array. 
			 * 
			 * If it is comparing to the first element in the array, and the current bank account is smaller than it,
			 * that means it must be the smallest element in the list.
			 * 
			 * If it is comparing to the last element in the array, and it is greater than the last element,
			 * then it means that it is the largest in the list.
			 * 
			 * Otherwise, to be placed in the list, the element we are comparing our current bank account
			 * to must be less than the current bank account, the the element after the element we are comparing
			 * (i + 1) must be greater than the current bank account, in order to be placed at the location after
			 * the currently compared element (i + 1).
			 */
			for (int i = 0; i < al.size(); i++) {
				if (i == 0 && cur.compareTo(al.get(i)) < 0)
					al.add(i, cur);
				else if (i == al.size() - 1 && cur.compareTo(al.get(i)) > 0) 
					al.add(cur);
				//else if (cur.compareTo(al.get(i)) == 0)
					//al.add(i + 1, cur);
				else if (cur.compareTo(al.get(i)) > 0
						&& cur.compareTo(al.get(i+1)) < 0) {
					al.add(i + 1, cur);
					break;
				}
			}
		}
		System.out.println(al);
		
		for (SavingsAccount cur : b) {
			// the next for loop will not work if there are 0 elements in the array.
			if (sa.size() == 0) {
				sa.add(cur);
				continue;
			}
			/* Goes through the array, comparing the current BankAccount
			 * to each bank account already in the array. 
			 * 
			 * If it is comparing to the first element in the array, and the current bank account is smaller than it,
			 * that means it must be the smallest element in the list.
			 * 
			 * If it is comparing to the last element in the array, and it is greater than the last element,
			 * then it means that it is the largest in the list.
			 * 
			 * Otherwise, to be placed in the list, the element we are comparing our current bank account
			 * to must be less than the current bank account, the the element after the element we are comparing
			 * (i + 1) must be greater than the current bank account, in order to be placed at the location after
			 * the currently compared element (i + 1).
			 */
			for (int i = 0; i < sa.size(); i++) {
				if (i == 0 && cur.compareTo(sa.get(i)) < 0)
					sa.add(i, cur);
				else if (i == sa.size() - 1 && cur.compareTo(sa.get(i)) > 0) 
					sa.add(cur);
				//else if (cur.compareTo(al.get(i)) == 0)
					//al.add(i + 1, cur);
				else if (cur.compareTo(sa.get(i)) > 0
						&& cur.compareTo(sa.get(i+1)) < 0) {
					sa.add(i + 1, cur);
					break;
				}
			}
		}
		System.out.println();
		System.out.println(sa);
	}
}
