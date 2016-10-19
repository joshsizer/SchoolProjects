#include <iostream>
#include <iomanip>

using namespace std;

/*
	This program computes the volume (in liters) of six soda
	cans and the total volume of a six-pack and a two-liter bottle of
	soda.
*/
int main()
{
	const double CAN_VOLUME = 0.423; 	//Liters in a 12-ounce can
	const double BOTTLE_VOLUME = 2;		//Two-Liter Bottle
	
	int cansPerPack = 6;
	int twentyFourPack = 24;
	double unitPrice = 2.99;
	int quantity = 7;
	double totalPurchasePrice; 

	double totalVolume = cansPerPack * CAN_VOLUME;
	
	cout << "A six-pack of 12-ounce soda cans contains "
		<< totalVolume << " liters. " << endl;
		
	totalVolume += BOTTLE_VOLUME;
	
	cout << "A six-pack and a two-liter bottle contain "
		<< totalVolume << " liters." << endl;

	totalPurchasePrice = unitPrice * quantity;

	cout << "Total purchase price for " << quantity << " soda bottles is $" << totalPurchasePrice << endl;

	cansPerPack = 12;
	totalVolume = CAN_VOLUME * cansPerPack;
	cout << "A twelve-pack of 12-ounce soda cans contains " << totalVolume << " liters. " << endl;



	int mystery = 7;
			mystery = -5 * mystery + 1;
			mystery = mystery - 5;

	cout << mystery << endl;

	//the value of mystery is -39

	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}


/*
	Answer the following questions / Complete the exercises.  
	You will be editing and fixing the code above for questions.
	--------------------------------------------------------------------------
	
	1.  create a variable suitable for holding 24
		cans of soda.  Be sure to use the best data type. 
		
	2.  Add a line of code that calculates the 
			totalVolume of a six-pack plus the totalVolume 
			of a two-liter bottle
		
	3.	Declare AND initialize the two variables: unitPrice, quantity

		unitPrice should contain the unit price of a single bottle,
		quantity should contain the number of bottles purchased.
		Initialize the variables to values that you think are appropriate.
		
	4.	Now that you have values in the unitPrice and quantity,
		write a line of code to calculate the total purchase price. 
		Display on the screen (cout) the total purchase price.
		
		
	
	5.	Sometimes in the market, you can buy soda in 12-pack size.  
		Below the code you have already written, add code to this program 
		to display the correct total volume using programming math.
		Don't forget to modify the output of the program (cout statements) 
		so the the data ( volume ) is correctly labeled on the screen.
		
		
		
		
	6.	What is the the value stored in "mystery" after the following 
		code is executed? ( you will need to add this code to the program 
		and use cout the answer as demonstrated above).
	
	
			int mystery = 7;
			mystery = -5 * mystery + 1;
			mystery = mystery - 5;
*/