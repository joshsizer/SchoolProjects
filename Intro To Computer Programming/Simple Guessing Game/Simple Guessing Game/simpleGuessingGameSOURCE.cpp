/*
Name: Josh Sizer
Date: 11/12/14
Purpose of Program: To Explore While Loops
*/
#include <iostream>
#include <iomanip>
#include <ctime>

using namespace std;

int main() 
{
	int playAgain = 1;
	srand(unsigned(time(0)));
	int win = 0;
	int loss = 0;

	while (playAgain == 1)
	{
		int randNum = rand() % 10 + 1;
		int guess;
		int counter = 0;

		cout << "Please guess a number between 1 and 10 " << endl;
		cin >> guess;

		while (guess != randNum)
		{
			cout << "Please try again." << endl;
			cin >> guess;
			counter++;
		}

		if (counter < 4)
		{
			cout << "That's correct! You have won! Would you like to play again? (Yes = 1. No = 0)" << endl;
			win++;
		}
		else
		{
			cout << "That's correct! Howver, you have lost. Would you like to play again? \n(Yes = 1. No = 0)" << endl;
			loss++;
		}

		cin >> playAgain;
		cout << endl;

	}

	cout << "Wins: " << win << endl;
	cout << "Losses: " << loss << endl;

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
