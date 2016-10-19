/*
	Random Number Generator Code
	Monday, October 4th, 2010
	Written by: Bobby Steinberg
	Description:
		This program demonstrates the rand() and srand() functions.
		Also, the time() function is noted here.  The goal of this 
		code is to explain how to control the rand() function to 
		generate random numbers from a given range and starting point.
*/
#include <cstdlib> 
#include <iostream>
#include <Windows.h>
#include <ctime>

using namespace std;

int main() 
{ 	
	
	srand( unsigned( time( 0 ) ) ); 
	int range = 101;   			
	int startingPoint = 0;	
	int grade = ( rand() % range ) + startingPoint;
	

	if (grade <= 64)
	{
		cout << grade << "% is an F";
	}
	else if (grade <= 69)
	{
		cout << grade << "% is an D";
	}
	else if (grade <= 79)
	{
		cout << grade << "% is an C";
	}
	else if (grade <= 89)
	{
		cout << grade << "% is an B";
	}
	else if (grade >= 90)
	{
		cout << grade << "% is an A";
	}

	cout << endl;
	system("pause");	
    return EXIT_SUCCESS; 
}