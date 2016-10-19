/*
template.cpp
this is a file that students can use to set up the code
in a standard C++ program written in Visual Studio


Name:
Date:
Purpose of Program:


*/
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main() 
{
	
	int x = 3;
	int p;
	int i;

	cout << "x = 2x" << endl;

	for (i = 0; i < 10; i++)
	{
		cout << x << ", ";
		x = x*2;
	}

	cout << "\n\nx = x - 5" << endl;
	x = 50;

	for (i = 0; i < 10; i++)
	{
		cout << x << ", ";
		x = x - 5;
	}

	cout << "\n\nx = 5x + 1" << endl;
	x =  2;

	for (i = 0; i < 10; i++)
	{
		cout << x << ", ";
		x = (5 * x) + 1;
	}
	
	cout << "\n\nx = 2x + 3" << endl;
	x = 3;

	for (i = 0; i < 10; i++)
	{
		cout << x << ", ";
		x = (2 * x) + 3;
	}

	cout << "\n\nx = 2x - 5" << endl;
	x = 6;

	for (i = 0; i < 10; i++)
	{
		cout << x << ", ";
		x = (2 * x) - 5;
	}

	cout << "\n\nFibbinacci Sequence" << endl;
	
	int c = 1;
	int n = 0;
	p = 0;

	for (i = 0; i < 10; i++)
	{
		cout << c << ", ";

		n = c + p;
		p = c;
		c = n;
	}

	
	





	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
