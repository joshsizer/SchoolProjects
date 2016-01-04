#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

string addSpace(string);

int main()
{
	string firstName;
	string lastName;
	string adress;
	string city;
	string state;
	string zipcode;
	string firstLine;
	string thirdLine;
	string completeString;

	//Asks users to enter adress
	cout << "Please enter the following: " << endl;
	cout << "First name: ";
	getline(cin, firstName);
	cout << "Last name: ";
	getline(cin, lastName);
	cout << "Adress: ";
	getline(cin, adress);
	cout << "City: ";
	getline(cin, city);
	cout << "State: ";
	getline(cin, state);
	cout << "zipcode: ";
	getline(cin, zipcode);

	//CLEARS CONSOLE WINDOW
	system("CLS");

	//Adds together the first line and third line
	firstLine = firstName + " " + lastName;
	thirdLine = city + " " + state + ", " + zipcode;

	//adds spaces before each line and adds end line after
	firstLine = addSpace(firstLine);
	adress = addSpace(adress);
	thirdLine = addSpace(thirdLine);

	//Add vertical space 
	for (int i = 0; i < 10; i++)
	{
		completeString += "\n";
	}

	completeString += firstLine + adress + thirdLine;

	cout << completeString;

	for (int i = 0; i < 10; i++)
	{
		cout << endl;
	}

	system("pause");
	return 0;
}

//ADDS SPACES BEFORE EACH STRING
string addSpace(string str)
{
	int spaces = (80 - str.size()) / 2;
	string temp = "";

	for (int i = 0; i < spaces; i++)
	{
		temp += " ";
	}

	temp += str;
	
	temp += "\n";

	return temp;
}