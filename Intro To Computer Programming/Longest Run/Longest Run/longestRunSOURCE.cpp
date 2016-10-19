#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	srand(unsigned(time(0)));
	const int ARRAYSIZE = 25;
	int arr[ARRAYSIZE];
	int counter[6];
	int value;
	int largest;
	int counter1 = 0;
	int position = -99;

	//fills array with random numbers
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		arr[i] = rand() % 5 + 1;
	}

	//outputs array
	cout << "Original: ";

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << setw(2) << arr[i];
	}

	//sorts array from smallest to largest
	for (int pass = 0; pass < ARRAYSIZE - 1; pass++)
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

	
	//outputs sorted array
	cout << endl <<  "Sorted:   ";
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << setw(2) << arr[i];
	}

	//initiates counter array
	for (int i = 0; i < 6; i++)
	{
		counter[i] = 0;
	}

	//counts all the runs
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		counter[arr[i]]++;
	}

	//finds largest run
	largest = counter[1];
	for (int i = 2; i < 6; i++)
	{
		if (counter[i] > largest)
		{
			largest = counter[i];
			value = i;
		}
	}

	//finds starting position of largest run
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		if (arr[i] == value && position == -99)
		{
			position = i;
		}
	}

	cout << endl << "The largest run was starts at position " << position << " and is a run of " << value << "'s.";

	cout <<endl;
	system("Pause");
	return EXIT_SUCCESS;
}