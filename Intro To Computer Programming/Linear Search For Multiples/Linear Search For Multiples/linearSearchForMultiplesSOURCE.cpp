/* 
Name: Josh Sizer
Date: 12/1/14
*/
#include <iomanip>
#include <iostream>

using namespace std;

int main()
{
	srand(unsigned(time(0)));
	const int ARRAYSIZE = 1000;
	int blah[ARRAYSIZE];
	int target; 
	int counter = 0;

	cout << "Enter a target number: ";
	cin >> target;

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		blah[i] = (rand() % ARRAYSIZE) + 1;
	}

	for (int i = 0; i < ARRAYSIZE; i++)
	{
		if (blah[i] % target == 0)
		{
			cout << "The number " << blah[i] << " is a multiple of your target number.\nIt was found at postition " << i << endl << endl;
			counter++;
		}
	}

	cout << "A multiple of your number was found " << counter << " time(s)." << endl;

	cout << endl;
	system("PAUSE");
	return EXIT_SUCCESS;
}