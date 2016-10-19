/*
Name: Josh Sizer
Date: 1/7/15
*/

#include <iostream>
#include <string>

using namespace std;

string intName(int);
string digitName(int);
string teenName(int number);
string tensName(int number);

int main()
{
	int input;
	
	cout << "Please enter a positive integer: ";
	cin >> input;
	
	cout << intName( input ) << endl;
	
	system("pause");
	return EXIT_SUCCESS;
}

string intName( int number )
{
	int part = number;	//The part that still needs to be converted
	string name;		//The return value
	
	if( part >= 100 )
	{
		name = digitName(part/100) + " hundred";
		part = part % 100;
	}
	
	if( part >= 20 )
	{
		
		name = name + " " + tensName(part/10);
		part = part % 10;
	}
	else if( part >= 10 )
	{
		name = name + " " + teenName( part );
		part = 0;
	}
	
	if( part > 0 )
	{
		name = name + " " + digitName( part );
	}
	
	return name;
}


/*
Turns a digit into its English name
@param	an integer btw 1 and 9
@return the name of digit( "one" ... "nine" )
*/
string digitName(int digit)
{
	string ones;
	switch (digit)
	{
		case 1:
			ones = "one";
			break;
		case 2:
			ones = "two";
			break;
		case 3:
			ones = "three";
			break;
		case 4:
			ones = "four";
			break;
		case 5:
			ones = "five";
			break;
		case 6:
			ones = "six";
			break;
		case 7:
			ones = "seven";
			break;
		case 8:
			ones = "eight";
			break;
		case 9:
			ones = "nine";
			break;
	}
	return ones;
}

/*
Turns a number btw 10 and 19 into its English name.
@param number an integer btw 10 and 19
@return the name of the given number( "ten" ... "nineteen")
*/
string teenName( int number )
{
	string teens;
	switch (number)
	{
		case 19:
			teens = "nineteen";
			break;
		case 18:
			teens = "eighteen";
			break;
		case 17:
			teens = "seventeen";
			break;
		case 16:
			teens = "sixteen";
			break;
		case 15:
			teens = "fifteen";
			break;
		case 14:
			teens = "fourteen";
			break;
		case 13:
			teens = "thirteen";
			break;
		case 12:
			teens = "twelve";
			break;
		case 11:
			teens = "eleven";
			break;
		case 10:
			teens = "ten";
			break;
	}
	
	return teens;
}

/*
Gives the name of the tens part of a number btw 20 and 99
@param number an integer btw 20 and 99
@return the name of the tens part of the number( "twenty" ... "ninety")
*/
string tensName( int number )
{
	string tens;
	switch (number)
	{
		case 2:
			tens = "twenty";
			break;
		case 3:
			tens = "thirty";
			break;
		case 4:
			tens = "forty";
			break;
		case 5:
			tens = "fifty";
			break;
		case 6:
			tens = "sixty";
			break;
		case 7:
			tens = "seventy";
			break;
		case 8:
			tens = "eighty";
			break;
		case 9:
			tens = "ninety";
			break;
	}
	return tens;
}