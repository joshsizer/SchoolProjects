#include <iostream>
#include <string>
#include <cctype>

using namespace std;

int main()
{
	string sentence;
	int spaces[500];
	int position = 0;
	int x;


	cout << "Enter a sentence: \n\t::";
	getline(cin, sentence);

	for (int i = 0; i < (int)sentence.size(); i++)
	{
		if (isspace(sentence[i]))
		{
			spaces[position] = i;
			position++;
		}
	}


	/*
	1) what is the purpose of this for loop?

	The purpose is to run through every character in "sentence" and determine if it is a space.
	If it is a space, then the position of the first space is recorded, and then the position of the second, and so on.


	2) what does line 21 do? 

	Line 21 checks if the current character in the string is a space or not. 


	3) Explain why the i is significant in line 23 and why position must be incremented here

	"i" is significant in line 23 because it is the index of the string "sentence" where a space has been found.
	"position" must be incremented because each time another space is found, you must store it's position into the next 
	index of the spaces array. 
	*/
	//////////////////////////////////////////////////////////////////////////////////////////////////////////


	int spaceCounter = 0;
	string word;

	for (int k = 0; spaceCounter < position + 1; k++)
	{
		word = sentence.substr(k, spaces[spaceCounter] - k);
		cout << word << endl;
		k = spaces[spaceCounter];
		spaceCounter++;
	}

	/*
	1) what is the purpose of this for loop?
		
	This for loop prints out each token in the sentence the user enters

	2) what is the spaceCounter counting, and why does this loop run until
		"spaceCounter < posistion + 1" instead of "spaceCounter < posistion"?

	The spaceCounter is counting how many spaces you have gone through in the sentence. It has to be position +1 because 
	arrays are 0 based. The third space will be stored in spaces[2]; To make the for loop run the correct number of times
	you must make it run to position + 1;

	3) In line 44, why do I have to subtract k from spaces[spaceCounter]?

	You have to subtract k because the second argument is how long the substr is, not where it ends. Therefore you must
	give it how long it runs by doing endpoint(spaces[spaceCounter]) - starting point(k)

	4) if you wanted to store these tokens in a string array, what line of code could you add to the for loop to accomplish this?

	if you had a string array names tokenArray, and the "number of words you've had" counter, wordCounter, you could put:

	tokenArray[wordCounter] = word;
	wordCounter++;
	*/

	cout << endl;
	system("pause");
	return 0;
}