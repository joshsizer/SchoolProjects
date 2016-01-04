/*
Name: Josh Sizer	
Date: 11/17/14
Purpose of Program: To explore logical OR
*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	int month;
	cout << "Enter month number: ";
	cin >> month;

	if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
	{
		cout << "31 days " << endl;
	}

	else if (month == 4 || month == 6 || month == 9 || month == 11)
	{
		cout << "30 days " << endl;
	}
	else 
	{
		cout << "28 or 29 days" << endl;
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
