/*
Name: Josh Sizer
Date: 1/5/15
*/

#include <iostream>
#include <iomanip>
#include <ctime>

using namespace std;

int findDouble (int [], int);
int findTriple (int [], int);

int main()
{
	const int ARRAYSIZE = 150;
	srand(unsigned(time(0)));
	int arr[ARRAYSIZE];

	//fills array with random numbers between 1 and 15 and prints to screen
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		arr[i] = rand() % 15 + 1;
		cout << setw(3) << i << ": " << setw (2) << arr[i] << endl;
	}

	//outputs doubles and triples and stores the number of doubles or triples found
	int doubles = findDouble(arr, ARRAYSIZE);
	int triples = findTriple(arr, ARRAYSIZE);

	cout << endl << "========================================================" << endl << endl;

	//outputs the number of doubles and triples found
	cout << setw(2) << doubles << " doubles were found. " << endl;
	cout << setw(2) << triples << " triples were found. " << endl;

	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}

//outputs doubles found
//returns the number of doubles found
int findDouble (int arr[], int arrSize)
{
	int counter = 0;

	//goes through array and checks if the number at position i + 1 is equal to i
	for (int i = 0; i < arrSize - 1; i++)
	{
		if (arr[i] == arr[i+1])
		{
			cout << "A double was found at position " << i << endl;
			counter++;
		}
	}
	return counter;
}

//outputs triples found
//returns the number of triples found
int findTriple (int arr[], int arrSize)
{
	int counter = 0;

	//goes through array and checks if the number at position i + 1 is equal to i
	for (int i = 0; i < arrSize - 2; i++)
	{
		if (arr[i] == arr[i+1] && arr[i] == arr[i+2] )
		{
			cout << "A triple was found at position " << i << endl;
			counter++;
		}
	}
	return counter;
}