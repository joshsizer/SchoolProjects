/* 
Name: Josh Sizer
Date: 11/18/14
Purpose for program: To explore linear search
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	srand(unsigned(time(0)));

	const int ARRAYSIZE = 100;
	int target;
	int numArr[ARRAYSIZE];
	bool counter = false;
	int occurance = 0;

	//fills array numArr with values from 0 to 100
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		numArr[i] = rand() % 101;
	}

	//promts user for target number
	cout << "What number would you like to find (between 0 and 100)? ";
	cin >> target;
	cout << endl;

	//searches through the array numArr for target number
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		if (numArr[i] == target)
		{
			cout << "Your target number " << target << " was found at position " << i << endl;
			counter = true;
			occurance++;
		}
	}

	//if the number is never found, output "number was never found", else output the number of times it was found
	if (!counter)
	{
		cout << "Your target number " << target << " was never found." << endl;
	}
	else
	{
		cout << "Your number was found " << occurance << " time(s)" << endl;
	}

	//outputs the values of array numArr
	cout << "\nHere's some proof: \n" << endl;
	cout << "Position\tValue" << endl;

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << i << "\t\t" << numArr[i] << endl;
	}

	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}