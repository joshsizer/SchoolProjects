#include <iostream>
#include <ctime>

using namespace std;

const int ARRAYSIZE = 10;

void swap (int*, int*);
void swap (double*, double*);
void sortS2L (int*, int);
void sortL2S (int*, int);
void sortS2L (double*, int);
void sortL2S (double*, int);

int main()
{
	srand(unsigned(time(0)));

	int arr1[ARRAYSIZE];
	double arr2[ARRAYSIZE] = {7, 6.6, 88.43, 34.44, 101, 103, 24, 55, 54, 10.012};

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		arr1[i] = (rand() % 100) + 1;
	}

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << arr2[i] << endl;
	}

	cout << "\n\n==========================================\n\n";

	sortL2S (arr2, ARRAYSIZE);

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << arr2[i] << endl;
	}

	cout << endl;
	system("pause");
	return 0;
}

void swap (int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void swap (double* a, double* b)
{
	double temp = *a;
	*a = *b;
	*b = temp;
}

void sortS2L (int *arr, int SIZE)
{
	int *min = arr;
	for (int i = 0; i < SIZE - 1; i++)
	{
		min = arr+i;
		for (int j = i + 1; j < SIZE; j++)
		{
			if (*(arr + j) < *min)
			{
				min = (arr + j);
			}
		}

		if (*(arr + i) != *min)
		{
			swap (min, (arr+i));
		}
	}
}

void sortL2S (int *arr, int SIZE)
{
	int *min = arr;
	for (int i = 0; i < SIZE - 1; i++)
	{
		min = arr+i;
		for (int j = i + 1; j < SIZE; j++)
		{
			if (*(arr + j) > *min)
			{
				min = (arr + j);
			}
		}

		if (*(arr + i) != *min)
		{
			swap (min, (arr+i));
		}
	}
}

void sortS2L (double *arr, int SIZE)
{
	double *min = arr;
	for (int i = 0; i < SIZE - 1; i++)
	{
		min = arr+i;
		for (int j = i + 1; j < SIZE; j++)
		{
			if (*(arr + j) < *min)
			{
				min = (arr + j);
			}
		}

		if (*(arr + i) != *min)
		{
			swap (min, (arr+i));
		}
	}
}

void sortL2S (double *arr, int SIZE)
{
	double *min = arr;
	for (int i = 0; i < SIZE - 1; i++)
	{
		min = arr+i;
		for (int j = i + 1; j < SIZE; j++)
		{
			if (*(arr + j) > *min)
			{
				min = (arr + j);
			}
		}

		if (*(arr + i) != *min)
		{
			swap (min, (arr+i));
		}
	}
}