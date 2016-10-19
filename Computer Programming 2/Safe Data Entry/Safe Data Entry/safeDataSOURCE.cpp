/*
SafeDataEntrySOURCE.cpp

Name: Bobby Steinberg
Date: 9/16/2014
Purpose of Program:
This program shows how to defend your program from user error.  By using
strings as buffers, it is possible to test the input before allowing
it to be utilized by the program.
*/
#include <iostream>
#include <iomanip>
#include <string>
#include <cctype>

using namespace std;

int getInt(void );			//returns viable int
double getDouble( void  );	//returns viable double


int main() 
{
	int intTest = -9999;
	double doubleTest = -999.999;
	string strInt;
	string strDoub;
	bool isInteger;

	cout << "  Welcome to Safe Data Entry!\n===============================" << endl;

	intTest = getInt();		
	cout << "You have successfully entered an integer, " << intTest << endl;
	cout << intTest << " + 5 = " << intTest + 5 << endl;  //proves an int

	doubleTest = getDouble();
	cout << "You have successfully entered an double " << doubleTest << endl;
	cout << doubleTest << " + 10.123 = " << doubleTest + 10.123 << endl;  
    
	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}

/*
int getInt(void) gets data from the user, stores it in a string
tests the string to ensure the value entered is an int(positive or negative),
then converts the string to an int to be returned to the main().
*/
int getInt(void)
{
	string userInput;	
	bool isInt = false;
	int finalInteger;
	int falsee;
	int truee;
	while (!isInt) // asks user to unput number until the number entered is an integer
	{
		falsee = 0;
		truee = 0;
		userInput = "";
		cout << "\nEnter an integer: ";
		getline(cin, userInput);

		//goes through each character, determining if it is a number or a minus sign
		for (int i = 0; i < userInput.size(); i++)
		{
			if (userInput[i] == '-' && i == 0)
			{
				truee++;
			}
			else if (isdigit(userInput[i]))
			{
				truee++;
			}
			else
			{
				falsee++;
			}
		}

		//if even one character was not a minus sign or a number, ask the user for another input
		if (falsee > 0)
		{
			isInt = false;
		}
		else
		{
			isInt = true;
		}
	}

	//once user enters a correct number, return the string converted to an integer
	finalInteger = atoi(userInput.c_str());
	return finalInteger;
}

/*
double getDouble(void) gets data from the user, stores it in a string
tests the string to ensure that the value entered is a double ( maybe even
checking for only 0 or 1 decimals and positive or negative),then converts the 
string to an double to be returned to the main().
*/
double getDouble( void )
{
	string userInput;	
	bool isInt = false;
	double finalDouble;
	int falsee;
	int truee;
	int decimal;

	while (!isInt)
	{
		falsee = 0;
		truee = 0;
		decimal = 0;
		userInput = "";
		cout << "\nEnter a double: ";
		getline(cin, userInput);
		
		//goes through each character, determining if it is a number, minus sign, or decimal point
		for (int i = 0; i < userInput.size(); i++)
		{
			if (userInput[i] == '-' && i == 0)
			{
				truee++;
			}
			else if (userInput[i] == '.' && decimal == 0)
			{
				truee++;
				decimal++;
			}
			else if (isdigit(userInput[i]))
			{
				truee++;
			}
			else
			{
				falsee++;
			}
		}

		//if even one character was not a minus sign or a number, ask the user for another input
		if (falsee > 0)
		{
			isInt = false;
		}
		else
		{
			isInt = true;
		}
	}

	//once user enters a correct number, return the string converted to an integer
	finalDouble = atof(userInput.c_str());
	return finalDouble;
}

