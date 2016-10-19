/*
Name: Josh Sizer
Date: 1/26/15
*/

#include <iostream>
#include <iomanip>

using namespace std;

double mean(int[]);
int median(int[]);
int mode(int[]);

const int ARRAYSIZE = 50;

int main()
{
	srand(unsigned(time(0)));
	int arr[ARRAYSIZE];
	int average;
	int middle;
	int most;

	//BUBBLESORT
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		arr[i] = rand() % 50 + 1;
	}

	for (int i = 0; i < ARRAYSIZE - 1; i++)
	{
		for (int i = 0; i < ARRAYSIZE - 1; i++)
		{
			if (arr[i] > arr[i+1])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
	}

	//PRINT ARRAY
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << setw(2) << i << ": " << setw(2) << arr[i] << endl;
	}

	average = mean(arr);
	cout << endl << "Average; " << average << endl;
	
	middle = median(arr);
	cout << endl << "Median: " << middle << endl;

	most = mode(arr);
	cout << endl << "Mode: " << most << endl;

	cout << endl;
	system("pause");
	return 0;
}

//takes in the array to find the mean, as well as the arraysize
double mean (int arr[])
{
	double mean;
	int sum = 0;

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		sum += arr[i];
	}

	mean = sum / ARRAYSIZE;

	return mean;
}

int median(int arr[])
{
	int medianPosition = ARRAYSIZE - 1;
	medianPosition /= 2;
	return arr[medianPosition];
}

int mode(int arr[])
{
	int mode;
	int counter[51];
	//counts all the numbers in the array
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		counter[arr[i]]++;
	}

	int largest = counter[1];
	int largestPosition = 1;
	for (int i = 2; i < 51; i++)
	{
		if (counter[i] > largest)
		{
			largest = counter[i];
			largestPosition = i;
		}
	}

	mode = largestPosition;
	return mode;
}

