#include <iostream>
#include <iomanip>
#include <cctype>
#include <string>

using namespace std;
const int wordArrSize = 26;

int main()
{
	string sentence;
	int spaces[500];
	int position = 0;
	int x;
	string wordArray[wordArrSize];

	for (int i = 0; i < wordArrSize; i++) // initializes wordArray so that every unsused value will be greater than any word, 					
	{									// so the token will be sorted to the begining of the wordArray
		wordArray[i] = (char)254;
	}

	cout << "Enter a sentence: \n\t";		//user input
	getline(cin, sentence);

	for (int i = 0; i < (int)sentence.size(); i++) //fills spaces array with position of each space
	{
		if (isspace(sentence[i]))
		{
			spaces[position] = i;
			position++;
		}
	}

	int spaceCounter = 0;
	string word;
	int wordCounter = 0;

	for (int k = 0; spaceCounter < position + 1; k++)		//creats substring of each token and stores it in wordArray
	{
		word = sentence.substr(k, spaces[spaceCounter] - k);
		cout << word << endl;
		k = spaces[spaceCounter];
		spaceCounter++;
		wordArray[wordCounter++] = word;
	}

	for (int i = 0; i < wordArrSize - 1; i++)				//sorts all elements in wordArray from smallest to largest
	{
		for (int i = 0; i < wordArrSize - 1; i++)
		{
			if (wordArray[i].compare(wordArray[i+1].c_str()) > 0)
			{
				string temp = "";
				temp = wordArray[i];
				wordArray[i] = wordArray[i+1];
				wordArray[i+1] = temp;
			}
		}
	}

	cout << endl; 
	for (int i = 0; i < wordCounter; i++) //outputs sorted word array
	{
		cout << wordArray[i] << endl;
	}

	cout << endl;
	system("pause");
	return 0;
}
