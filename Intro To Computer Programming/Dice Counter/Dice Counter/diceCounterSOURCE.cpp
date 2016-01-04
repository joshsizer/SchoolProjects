#include <iostream>
#include <iomanip>

using namespace std;

int main ()
{
	int rolls;
	int counter[7];
	srand(unsigned(time(0)));

	//initalize counter to 0
	for (int i = 0; i < 7; i++)
	{
		counter[i] = 0;
	}

	//asks user to input the number of rolls they want
	cout << "How many times would you like to roll a dice? ";
	cin >> rolls;
	cout << endl;

	//adds one to the counter at a random index between 1 and 6
	for (int i = 0; i < rolls; i++)
	{
		counter[(rand() % 6) + 1]++;
	}

	//outputs how many times each number of the dice was rolled
	for (int i = 1; i < 7; i++)
	{
		cout << "You have rolled " << setw(2) << counter[i] << " " << i << "'s" << endl;
	}

	//finds which number was rolled the most
	int largest = counter[1];
	int temp = 0;

	for (int i = 2; i < 7; i++)
	{
		if (counter[i] > largest)
		{
			largest = counter[i];
		}
	}

	//Outputs all of the sides that were rolled the most
	cout << "\nSide(s) ";

	for (int i = 1; i < 7; i++)
	{ 
		if (counter[i] == largest)
		{
			cout << i;
			cout << ", ";
			temp++;
		}
	}

	//if one side, use "was" ----- if more than one side, use "were"
	if (temp > 1)
	{
		cout << "were rolled the most." << endl;
	}
	else
	{
		cout << "was rolled the most." << endl;
	}


	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}