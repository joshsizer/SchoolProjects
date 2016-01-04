/*
SteinbergFunctionCalculatorSOURCE.cpp

THis is a program to show how to use
1) function prototypes
2) function calls
3) function implementations

fill in the code as necessary to make the program work.  Don't forget that you
need all 3 parts of the function to make it work. 
*/
#include <iostream>
#include <iomanip>

using namespace std;

//function prototypes go here Add the appropriate code.
double Add(double, double);
//prototype for subtraction
double Subtract(double, double);
//multiplication
double Multiply(double, double);
//division
double Divide(double, double);
//exponents
double RaiseToThePowerOf(double, double);

int main()
{
	double a, b, result;
	int choice;

	cout << "Steinberg's Function Calculator" << endl;
	cout << "*-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *" << endl;

	cout << "\n\nEnter two real numbers:\nfirst number: ";
	cin >> a;
	cout << "second number: ";
	cin >> b;

	cout << "*-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *-+/ *\n" << endl;

	cout << "Press 1 and Enter to Add the two numbers." << endl;
	cout << "Press 2 and Enter to Subtract the two numbers." << endl;
	cout << "Press 3 and Enter to Multiply the two numbers." << endl;
	cout << "Press 4 and Enter to Divide the two numbers." << endl;
	cout << "Press 5 and Enter to Raise the first number to the power of the second number." << endl;

	cin >> choice;
	
	if( choice == 1 )  //addition
	{
		result = Add( a, b );  //function call for the Add function
	}
	else if( choice == 2 ) //subtraction
	{
		result = Subtract(a, b);
	}
	else if( choice == 3 ) //Multiplication
	{
		result = Multiply(a, b);
	}
	else if( choice == 4 ) //Division
	{
		result = Divide(a, b); 
	}
	else if( choice == 5 ) //exponents
	{
		result = RaiseToThePowerOf(a, b);
	}
	else
	{
		cout << "this is an incorrect choice" << endl;
	}

	cout << "Answer: " << result << endl;


	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}


/**
* The Add function adds together two doubles and returns the result
**/
double Add( double one, double two )
{
	double answer = one + two;

	return answer;
}

/**
* The Subtract function subtracts the second value from the first and returns the result
**/
double Subtract( double one, double two )
{
	double answer = one - two;

	return answer;
}

/**
* The Multiply function Multiplies together two doubles and returns the result
**/
double Multiply( double one, double two )
{
	double answer = one * two;

	return answer;
}

/**
* The Divide function divides the first by the second and returns the result
**/
double Divide( double one, double two )
{
	double answer = one/two;

	return answer;
}

/**
* The  RaiseToThePowerOf function uses the first variable as the base
* and raises it to the power of the second variable.
	HINT: pow( double, int )
**/
double RaiseToThePowerOf( double one, double two )
{
	double answer;
	int exponent = two;

	answer = pow(one, exponent);

	return answer;
}