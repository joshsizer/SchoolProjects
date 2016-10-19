/*

Name: Josh Sizer
Date: 11/10/14
Purpose of Program: To Explore Boolean Statements
*/
#include <iostream>
#include <iomanip>
#include <ctime>

using namespace std;

int main() 
{
	int randNumAr [50];

	srand(unsigned(time(0)));

    for (int i = 0; i < 50; i++)
	{
		randNumAr[i] = rand() % 150 + 1;
	}

	for (int i = 0; i < 50; i++)
	{
		if (randNumAr[i] >= 37 && randNumAr[i] <= 77)
		{
			cout << "\t" << randNumAr[i] << endl;
		}
		else
		{
			cout << randNumAr[i] << endl;
		}
	}


	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
