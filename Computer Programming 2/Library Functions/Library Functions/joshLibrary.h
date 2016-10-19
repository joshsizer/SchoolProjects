/*
Author: Josh Sizer
Date: 3/16/15

*/ 

#include <string>

using namespace std;

//swap function intputs two pointer to variables and then swaps their values
void swap (int*, int*);
void swap (double*, double*);
void swap (char *a, char *b);
void swap (string *a, string *b);


//selection sort and bubble sort inputs the array to be sorted and the size of the array
//returns nothing because it uses pointers
void selectionSort( int*, int );
void selectionSort( char*, int);
void selectionSort( double*, int );
void selectionSort( string*, int);


void bubbleSort( int*, int );
void bubbleSort( char*, int);
void bubbleSort( double*, int );
void bubbleSort( string*, int );


// linearSearch returns the position of the target in the list (int)
// the second parameter in linearSearch is the target
// the third parameter should be the size of the array
int linearSearch( int[], int, int);
int linearSearch( char[], char, int);
int linearSearch( double[], double, int );
int linearSearch( string[], string, int);

////////////////////////////////////////////////////////////////////////////////////////////////////////
void swap (int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void swap (double *a, double *b)
{
	double temp = *a;
	*a = *b;
	*b = temp;
}
void swap (char *a, char *b)
{
	char temp = *a;
	*a = *b;
	*b = temp;
}
void swap (string *a, string *b)
{
	string temp = *a;
	*a = *b;
	*b = temp;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void selectionSort( int *arr, int SIZE )
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
void selectionSort( char *arr, int SIZE )
{
	char *min = arr;
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
void selectionSort( double *arr, int SIZE )
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
void selectionSort( string *arr, int SIZE )
{
	string *min = arr;
	for (int i = 0; i < SIZE - 1; i++)
	{
		min = arr + i;
		for (int j = i + 1; j < SIZE; j++)
		{
			if ((*(arr + j)).compare((*min).c_str()) < 0)
			{
				min = arr + j;
			}
		}

		if ((*(arr + i)).compare((*min).c_str()) != 0)
		{
			swap (min, (arr + i));
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void bubbleSort( int *arr, int SIZE)
{
	for (int i = 0; i < SIZE - 1; i++)
	{
		for (int i = 0; i < SIZE - 1; i++)
		{
			if (*(arr + i) > *(arr + (i + 1)))
			{
				swap ((arr + i), (arr + (i + 1))); 
			}
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void bubbleSort( char *arr, int SIZE)
{
	for (int i = 0; i < SIZE - 1; i++)
	{
		for (int i = 0; i < SIZE - 1; i++)
		{
			if (*(arr + i) > *(arr + (i + 1)))
			{
				swap ((arr + i), (arr + (i + 1))); 
			}
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void bubbleSort( double *arr, int SIZE)
{
	for (int i = 0; i < SIZE - 1; i++)
	{
		for (int i = 0; i < SIZE - 1; i++)
		{
			if (*(arr + i) > *(arr + (i + 1)))
			{
				swap ((arr + i), (arr + (i + 1))); 
			}
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
void bubbleSort( string *arr, int SIZE)
{
	for (int i = 0; i < SIZE - 1; i++)
	{
		for (int i = 0; i < SIZE - 1; i++)
		{
			if (*(arr + i) > *(arr + (i + 1)))
			{
				swap ((arr + i), (arr + (i + 1))); 
			}
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
int linearSearch( int *arr, int target, int SIZE)
{
	int position = 0;
	for (int i = 0; i < SIZE; i++)
	{
		if (*(arr + i) == target)
		{
			position = i;
		}
	}
	return position;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
int linearSearch( char *arr, char target, int SIZE)
{
	int position = 0;
	for (int i = 0; i < SIZE; i++)
	{
		if (*(arr + i) == target)
		{
			position = i;
		}
	}
	return position;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
int linearSearch( double *arr, double target, int SIZE)
{
	int position = 0;
	for (int i = 0; i < SIZE; i++)
	{
		if (*(arr + i) == target)
		{
			position = i;
		}
	}
	return position;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
int linearSearch( string *arr, string target, int SIZE)
{
	int position = 0;
	for (int i = 0; i < SIZE; i++)
	{
		if ((*(arr + i)).compare(target.c_str()) == 0)
		{
			position = i;
		}
	}
	return position;
}