#include <iostream>

using namespace std;

int main()
{
	double Rate1 = 0.10;
	double Rate2 = 0.25;
	double RateSingleLimit = 32000;
	double RateMarriedLimit = 64000;
	double tax1 = 0;
	double tax2 = 0;
	int maritalStatus = 0;
	double income;
	double totalTax;
	
	cout << "Please enter your income: ";
	cin >> income;
	
	cout << "Please enter 1 for single, and 2 for married: ";
	cin >> maritalStatus;
	
	if( maritalStatus == 1 )
	{
		if( income < RateSingleLimit)
		{
			tax1 = Rate1 * income;
		}
		else
		{
			tax1 = Rate1 * RateSingleLimit;
			tax2 = Rate2 * (income - RateSingleLimit);
		}
	}
	else
	{
		if(income <= RateMarriedLimit)
		{
			tax1 = Rate1 * income;
		}
		else
		{
			tax1 = Rate1 * RateMarriedLimit;
			tax2 = Rate2 * (income - RateMarriedLimit);
		}
	}
	
	totalTax = tax1 + tax2;		//calculate the total tax
	
	cout << "The tax is $" << totalTax << endl;
	
	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}


/*
Questions:
1.  What is the amount of tax that a single taxpayer pays on an income 
of $32,000?

A single taxpayer pays a total tax of $3,200 on a income of $32,000.

2.  Would that amount change if the first nested if statement changed from 

	if( income <= RateSingleLimit )
	to
	if(income < RateSingleLimit)

	The value would not change. I tested 32,000 in both situations 
	because 32,000 that is the RateSingleLimit, and should be the only 
	value affected by this change in condition. However, when you run
	32,000 in both situations, you still get $3,200 as your tax amount. 
	
3.  Suppose Jack and Jill each make $40,000 per year.  Would they save taxes
	if they married?
	
	Single:
	Jack tax = 5,200
	Jill tax = 5,200
	Total = 10,400

	Maried
	Jack and Jill tax = 10,400

	They would not save money in taxes. The tax amount would be the same. 

4.  How would you modify the tax.cpp program in order to check that they user entered a
	correct value for the marital status ( either a 1 or 2) ?

	You could put:

	if (income < 3)
	{
		if ( income > 0)
		{
		//This is where the 
		//if (maritalStatus = 1) and else  goes
		}
	}
	
	This code would go directly after:

	"cout << "Please enter 1 for single, and 2 for married: ";
	cin >> maritalStatus;"

5.  Some people object to higher tax rates for higher incomes, claiming that you might end up with 
	less money after taxes when you get a raise for working hard.
	What is the flaw in this argument?

	Ed is single and gets 20,000 
	Tax = 2,000
	Net =  18,000

	Ed gets a raise of 25,000! (Total of 45,000)
	Tax = 6,450
	Net = 38,550

	After getting a raise, Ed's taxes on his raise does not get him to a lower 
	net salary than the taxes on his normal salary. Therefore, the argument is flawed!


*/