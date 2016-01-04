/*
elevatorElseSOURCE.cpp

This is an elevator simulation. We ask the user to type in the desired
floor number and then compute the actual floor number.  When the input
is above 13, then we need to decrement the input to obtain the actual
floor.  For example, if the user provides an input of 20, the program 
will determine that the actual floor as 19.
*/
#include <iostream>

using namespace std;

int main()
{
	//variable declaration
	int floor;
	int actualFloor;

	//prompt the user to enter a floor
	cout << "Floor: ";
	cin >> floor;

	//determine if the actual floor is greater or less then 13
	if( floor > 13 )
	{
		actualFloor = floor - 1;
	}
	else
	{
		actualFloor = floor;
	}

	//display the results of the program calculation for the user
	cout << "The elevator will travel to the actual floor " 
			<< actualFloor << endl;


	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}

/*
Answer the questions.

1.  In some Asian countries, the number 14 is considered unlucky.  Some
	building owners play it safe and skip BOTH the thirteenth and fourteenth
	floor.  Write the code how you might modify the program to handle 
	such a building.

	if( floor > 14 )
	{
		actualFloor = floor - 2;
	}
	else
	{
		actualFloor = floor;
	}

//////////////////////////////////////////////////////////////////////////////
2.	Consider the following if statement to compute a discounted price:

		if( originalPrice > 100 )
		{
			discountedPrice = originalPrice - 20;
		}
		else
		{
			discountedPrice = originalPrice - 10;
		}

	What is the discounted price if the original price is 95?  100?  105?
	95 = 85
	100 = 90
	105 = 85

	//////////////////////////////////////////////////////////////////////////////
3.	Compare this if statement with the one in question 2:

		if( originalPrice < 100 )
		{
			discountedPrice = originalPrice - 10;
		}
		else
		{
			discountedPrice = originalPrice - 20;
		}

	Do the two statements always compute the same value?  If not, when do the values differ?
	They do not always compute the same values.
	The time when it does not compute the same value
	is when originalPrice = 100. In the first case, 
	100 is not greater than 100, so it will only get
	a discount price of $90. In the second case, 100
	is not less than 100, so it will have a discounted 
	price of $80.

//////////////////////////////////////////////////////////////////////////////
4.	Consider the following statements to compute a discounted price:

		discountedPrice = originalPrice;
		if(originalPrice > 100 )
		{
			discountedPrice = originalPrice - 10;
		}

	What is the discounted price if the original price is 95? 100? 105?
	95 = 95
	100 = 100
	105 = 95
*/