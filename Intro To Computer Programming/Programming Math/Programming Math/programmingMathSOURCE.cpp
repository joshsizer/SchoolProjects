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

using namespace std;

int main() 
{
	int x, y, z;
	
    cout << "Enter a number: ";
	cin >> x;
	cout << "\n\nEnter a second number: ";
	cin >> y;

	z = x + y;
	cout << x << " + " << y << " = " << z << endl; 

	z = x - y;
	cout << x << " - " << y << " = " << z << endl;

	z = x * y;
	cout << x << " * " << y << " = " << z << endl;

	z = x / y;
	cout << x << " / " << y << " = " << z << endl;

	z = x % y;
	cout << x << " % " << y << " = " << z << endl;

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
