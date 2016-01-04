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
	int grade;

	cout << "Please enter your grade: ";
	cin >> grade;

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
