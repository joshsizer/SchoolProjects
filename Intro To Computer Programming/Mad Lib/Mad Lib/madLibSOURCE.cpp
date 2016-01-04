/*
Name: Josh Sizer
Date: 10/6/14
Purpose of Program: To use strings in a program

*/
#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

int main() 
{
	string little;
	string baby;
	string say;
	string word;
	string papa;
	string mockingbird;
	string sing;
	string diamond;
	string brass;
	string looking;

	cout  << "Please enter one word answers." << endl;
	cout << "Enter a size: ";
	cin >> little;

	cout << "Enter an animal: ";
	cin >> baby;

	cout << "Enter a verb: ";
	cin >> say;

	cout << "Enter a noun: ";
	cin >> word;

	cout << "Enter a person: ";
	cin >> papa;

	cout << "Enter an item: ";
	cin >> mockingbird;

	cout << "Enter an action word: "; 
	cin >> sing;

	cout << "Enter a shape: ";
	cin >> diamond;

	cout << "Enter a color: ";
	cin >> brass;

	cout << "Enter a -ing word; ";
	cin >> looking;

	cout <<"\n========================================================\n\n";

    cout << "Hush, little baby, don't say a word." << endl;
	cout << "Papa's gonna buy you a mockingbird" << endl;

	cout << "And if that mockingbird won't sing," << endl;
	cout << "Papa's gonna buy you a diamond ring" << endl;

	cout << "And if that diamond ring turns brass," << endl;
	cout << "Papa's gonna buy you a looking glass" << endl;

	cout <<"\n========================================================\n\n";
	
    cout << "Hush, " << little  << " " << baby << ", don't " << say << " a " << word << endl;
	cout << papa << "'s gonna buy you a " << mockingbird << endl;

	cout << "And if that " << mockingbird << " won't " << sing << endl;
	cout << papa << "'s gonna buy you a " << diamond << " ring" << endl;

	cout << "And if that " << diamond << " ring turns " << brass << endl;
	cout << papa << " gonna buy you a " << looking << " glass" << endl;




	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
