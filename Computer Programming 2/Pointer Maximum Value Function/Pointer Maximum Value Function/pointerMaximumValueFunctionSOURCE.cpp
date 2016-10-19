#include <iostream>
#include <iomanip>

using namespace std;

double *maximum(double *, int);

const int ARRAYSIZE = 10;

int main()
{
	double arr[ARRAYSIZE] = {0, 10, 123, 24, 8, 33, 1, 753, 99, 63}; //declares array with doubles

	double *max = maximum(arr, ARRAYSIZE); //calls maximum function

	cout << *max; //outputs the value the pointer is pointing to

	cout << endl;
	system("pause");
	return 0;
}

double *maximum(double *a, int size)
{
	if (size == 0)
	{
		return NULL;
	}

	double *max1 = a; //pointer to location of maximum value

	for (int i = 1; i < size; i++)
	{
		a += 1;				//a = second index in array
		if (*a > *max1)
		{
			max1 = a;		// if the second index is bigger than the previous largest number, then set the bigger number to max1
		}
	}

	return max1;
}