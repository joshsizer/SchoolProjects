/*
Name: Josh Sizer
Date: 9/11/2014
Purpose of Program: To ask user 5 questions and output their responses. 
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	//declaring variables
	int favNumber;
	int animal;
	int computer;
	int page;
	int gpa;

	//initializing variables
	favNumber = -999;
	animal = -999;
	computer = -999;
	page = -999;
	gpa = -999;

	//asking questions
	cout << "What is your favorite number?  ";
	cin >> favNumber;
	cout << endl;

	cout << "How many animals do you own?  ";
	cin >> animal;
	cout << endl;

	cout << "How many computers do you own?  ";
	cin >> computer;
	cout << endl;

	cout << "What is the highest amount of pages you've read at once?  ";
	cin >> page;
	cout << endl;

	cout << "What is your GPA (grade point average) rounded to the nearest hundreth?  ";
	cin >> gpa;
	cout << endl;

	//outputing answers
	cout << "\n=========================================================================\n\nYour answers:\n\n";

	cout << "Wow! " << favNumber << " is a cool number!\n" << endl;

	cout << "You must be a real animal lover if you own " << animal << " animal(s)!\n" << endl; 

	cout << "Ha! You own " << computer << " computer(s)? Nerd!\n" << endl;

	cout << "Woah man. " << page << " page(S) at once? Slow down!\n" << endl; 

	if (gpa < 3)
	{ 
			cout << "Your GPA is " << gpa << "? You need to study more!\n" << endl;
	}

	if (gpa >= 3)
	{
		cout << "Dude you're so smart! " << gpa << " GPA? Keep up the good work!\n" << endl;
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
