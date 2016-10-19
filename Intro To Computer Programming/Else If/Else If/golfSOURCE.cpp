/*
template.cpp
this is a file that students can use to set up the code
in a standard C++ program written in Visual Studio


Name: Josh Sizer
Date: 10/3/2014
Purpose of Program: To explore else if statements


*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	
	int hole;

	cout << "Please enter how many strokes you took: ";
	cin >> hole;

	if (hole == 1)
	{
		cout << "Hole in One!";
	}
	else if (hole == 2)
	{
		cout << "Double Eagle";
	}
	else if (hole == 3)
	{
		cout << "Eagle";
	}
	else if (hole == 4)
	{
		cout << "Birdie";
	}
	else if (hole == 5)
	{
		cout << "Par";
	}
	else if (hole == 6)
	{
		cout << "Bogey";
	}
	else if (hole == 7)
	{
		cout << "Double Bogey";
	}
	else if (hole == 8)
	{
		cout << "Tripple Bogey";
	}
	else 
	{
		cout << "Disaster!";
	}


	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
