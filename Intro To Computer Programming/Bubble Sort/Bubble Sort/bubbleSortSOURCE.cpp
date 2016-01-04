#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	const int ARRAYSIZE = 15;
	int bubble[ARRAYSIZE];
	srand(unsigned(time(0)));

	//fills array with random integers
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		bubble[i] = rand() % ARRAYSIZE + 1;
	}

	//Outputs original array
	cout << "Original:";
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << setw(4) << bubble[i];
	}

	//BUBBLE SORT
	for (int pass = 0; pass < ARRAYSIZE - 1; pass++)
	{
		for (int i = 0; i < ARRAYSIZE - 1; i++)
		{
			if (bubble[i] > bubble[i+1])
			{
				int temp = bubble[i];
				bubble[i] = bubble [i+1];
				bubble[i+1] = temp;
			}
		}
	}
	
	//outputs final sort
	cout << endl << "Final:   ";
	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << setw(4) << bubble[i];
	}





	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}