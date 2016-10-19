/*
Name: Josh Sizer
Date: 10/20/14
Purpose of Program: To Explore nested for loops
*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	int x;
	int y;

    for (y = 1; y <=10; y++)
	{
		for (x = 1; x <=10; x++)
		{
			cout << setw(3)<< x*y << " ";
		}
		cout << endl;
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
