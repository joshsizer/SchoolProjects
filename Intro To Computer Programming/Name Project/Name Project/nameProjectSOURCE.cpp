/*
Name: Josh Sizer
Date: September 8th, 2014
Purpose of Program: Output my name
*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	int int1 = 0;

	while (int1 <= 10)
	{
		cout << int1 << endl;
		if (int1 == 5)
		{
			system("pause");
			system("color 2b");
			cout << "Josh Sizer" << endl;
		}

		int1++;
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
