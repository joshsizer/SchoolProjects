#include <iostream>
#include <iomanip>
#include <cctype>
#include <string>

using namespace std;
bool isVowel(char);

int main()
{
	
	string userIn;
	//counters to count number of each type of character
	int charCount = 0;
	int spaceCount = 0; 
	int	digitCount = 0;
	int alphaNumCount = 0;
	int alphabetCount = 0;
	int vowelCount = 0;
	int upperCount = 0;
	int lowerCount = 0;
	int puncCount = 0;

	cout << "This program will give you statistics about the text you enter!\nPlease enter some stuff: " << endl;
	getline(cin, userIn);

	int size = userIn.size();

	//goes through each char in string userIn and checks what type of char it is
	for (int i = 0; i < size; i++)
	{
		char a = userIn[i];

		if (isspace(a))
		{
			spaceCount++;
		}

		if (isdigit(a))
		{
			digitCount++;
		}

		if (isalnum(a))
		{
			alphaNumCount++;
		}

		if (isalpha(a))
		{
			alphabetCount++;
		}

		if (isVowel(a))
		{
			vowelCount++;
		}

		if (isupper(a))
		{
			upperCount++;
		}

		if (islower(a))
		{
			lowerCount++;
		}

		if (ispunct(a))
		{
			puncCount++;
		}
	}

	cout << "The text you entered is " << (userIn.size()) << " characters long. " << endl;

	cout << "There are " << spaceCount << " spaces in the text you entered. " << endl;

	cout << "There are " << digitCount << " digits in the text you entered. " << endl;

	cout << "There are " << alphaNumCount << " alphanumeric characters in the text you entered. " << endl;

	cout << "There are " << alphabetCount << " alphabetic characters in the text you entered. " << endl;

	cout << "There are " << vowelCount << " vowels in the text you entered. " << endl;

	cout << "There are " << upperCount << " uppercase letters in the text you entered. " << endl;

	cout << "There are " << lowerCount << " lowercase letters in the text you entered. " << endl;

	cout << "There are " << puncCount << " punctuation marks in the text you entered. " << endl;

	cout << endl;
	system("pause");
	return 0;
}


//this function take in a character to check. If it is a vowel, it returns true. If it is not a vowel, return false
bool isVowel(char letter)
{
	switch (letter)
	{
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':

		return true;
		break;

		default:
		return false;
		break;
	}
}