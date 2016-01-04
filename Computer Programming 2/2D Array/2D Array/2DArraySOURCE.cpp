#include <iostream>
#include <random>
#include <ctime>
#include <iomanip>

using namespace std;

const int ROW = 10;
const int COLUMN = 4;

void fillArray (char*);
void printArray (char* arr, int , int );

int main()
{
	char arr[ROW][COLUMN];
	char arrrg[5][5];

	fillArray (*arr);
	printArray (*arr, ROW, COLUMN);
	
	int letter = 0;
	int counter = 5;
	int x = 0;
	int y = 0;
	int interval = 1;

	/*
	while (letter < 25)
	{
		for (int i = 0; i < counter; i++)
		{
			arrrg[x][y] = 64 + letter;

			if (interval == 1)
			{
				x++;
			}
			else if (interval == 2)
			{
				y++;
			}
			else if (interval == 3)
			{
				x--;
			}
			else if (interval == 4)
			{
				y--;
			}
			letter++;
		}
		counter--;
	}
	*/

	while (letter < 24)
	{
		for (int a = 0; a < 4; a++)
		{
			for (int b = 0; b < 4; b++)
			{
				if (64 + letter != 74)			//sets x, y = to the next letter if the letter is not J
				{
					arrrg[x][y] = 64 + letter;
				}
				else 
				{
					arrrg[x][y] = 65 + letter;
				}

				if (a == 0)
				{
					x++;
				}
				else if (a == 1)
				{
					y++;
				}
				else if (a == 2)
				{
					x--;
				}
				else if (a == 3)
				{
					y--;
				}

				letter++;
			}
		}
		for (int a = 0; a < 2; a++)
		{
			for (int b = 0; b < 2; b++)
			{
				if (64 + letter != 74)			//sets x, y = to the next letter if the letter is not J
				{
					arrrg[x][y] = 64 + letter;
				}
				else 
				{
					arrrg[x][y] = 65 + letter;
				}

				if (a == 0)
				{
					x++;
				}
				else if (a == 1)
				{
					y++;
				}
				else if (a == 2)
				{
					x--;
				}
				else if (a == 3)
				{
					y--;
				}

				letter++;
			}
		}
	}

	arrrg[2][2] = 90;

	printArray(arrrg, 5, 5);

	cout << endl;
	system("pause");
	return 0;
}


void fillArray (char* arr)
{
	srand(unsigned(time(0)));
	int random;

	for (int y = 0; y < COLUMN; y++)		//fills array with random numbers
	{
		for (int x = 0; x < ROW; x++)
		{
			random = (rand() % 26) + 1;
			*(arr + ((y*COLUMN) + x)) = (91 - random);
		}
	}
}

//arguments: pointer to 2D array, size of each dimention (x, y)
//fills array using pointers
void printArray (char *arr, int r, int c)
{
	for (int y = 0; y < c; y++)		//prints array
	{
		for (int x = 0; x < r; x++)
		{
			if (((x + 1) % ROW) == 0)
			{
				cout << setw(2) << *(arr + ((y*COLUMN) + x)) << endl;
			}
			else
			{
				cout << setw(2) << *(arr + ((y*COLUMN) + x));
			}
		}
	}
}
