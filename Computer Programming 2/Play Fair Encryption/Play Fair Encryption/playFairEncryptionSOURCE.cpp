#include <iomanip>
#include <iostream>
#include <string>
#include <vector>
#include <cctype>
#include <cstdlib>
#include <fstream>

using namespace std;

void printArr(char*, int, int);
void generateKeyTable(char*, string);
string removeRepeats(string);							//remove repeat , specifically in the keyword
string toUpper(string);
string processClearText(string);
string encode(char*, string);
string decode(char*, string);
void toFile(string, string);
string readFile(string);
string safeDataEntry();

int main()
{
	string keyWord;
	string clearText;
	string choice = "0";
	string filename;
	char keyTable[5][5] = //initializes key table
	{
		{ 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0 }
	};

	cout << "Please enter keyword: ";		//user enters desired keyword
	getline(cin, keyWord);

	generateKeyTable(*keyTable, keyWord);	//generates key table based on desired keyword

	printArr(*keyTable, 5, 5);				//prints key table

	toFile("keyword.txt", keyWord);			//writes keyword to file
	cout << endl << "Keyword written to keyword.txt\n\n";

	cout << "Enter 1 to encode text:\nEnter 2 to decode text:" << endl;
	choice = safeDataEntry();
	string data;

	if (choice == "1")	//encode
	{
		system("cls");	//clear console
		printArr(*keyTable, 5, 5);	//print keytable

		cout << "Enter 1 to encode text from console:\nEnter 2 to encode text from file:" << endl;
		choice = safeDataEntry();
		if (choice == "1")	//text from console
		{
			system("cls");	
			printArr(*keyTable, 5, 5);

			cout << "Enter text: ";
			getline(cin, data);							//gets text from user
			data = encode(*keyTable, data);				//encodes txt
			cout << "Encoded text: " << data << endl;	//outputs to console
		}
		else if (choice == "2")	//text from file
		{
			system("cls");
			printArr(*keyTable, 5, 5);

			cout << "Enter filename: ";
			getline(cin, data);							//gets filename from user
			data = readFile(data);						//reads file
			data = encode(*keyTable, data);				//encodes data from file
			cout << "Encoded text: " << data << endl;	//outputs to console
		}
		//saves to file specified by user
		cout << endl << "Enter filename to write text to: ";
		getline(cin, filename);							
		cout << endl << "Encoded text written to " + filename << endl;
		toFile(filename, data);
	}
	else if (choice == "2") //decode
	{
		system("cls");
		printArr(*keyTable, 5, 5);

		cout << "Enter 1 to decode text from console:\nEnter 2 to decode text from file:" << endl;
		choice = safeDataEntry();
		if (choice == "1")	//text from console
		{
			system("cls");
			printArr(*keyTable, 5, 5);

			cout << "Enter text: ";
			getline(cin, data);							//gets text from user
			data = decode(*keyTable, data);				//decodes text
			cout << "Decoded text: " << data << endl;	//outputs to console
		}
		else if (choice == "2")	//text from file
		{
			system("cls");
			printArr(*keyTable, 5, 5);

			cout << "Enter filename: ";
			getline(cin, data);							//gets filename from user
			data = readFile(data);						//reads text in file
			data = decode(*keyTable, data);				//decodes text
			cout <<  "Decoded text: " << data << endl;	//outputs to console
		}
		//saves decoded text to file specified by user. 
		cout << endl << "Enter filename to write text to: ";
		getline(cin, filename);
		cout << endl << "Decoded text written to " + filename << endl;
		toFile(filename, data);
	}


	cout << endl;
	system("pause");
	return 0;
}

/*
ARGUMENTS:	Pointer to the array to be filled with the key table
			String keyword that holds the desired keyword

PURPOSE:	Fills an array with a generated key table based on the desired keyword
*/
void generateKeyTable(char* arr, string keyWord)
{
	char alphebet[26];							//alphabet array 
	keyWord = removeRepeats(keyWord);			//removes repeat characters in keyWord

	for (int i = 0; i < 26; i++)				//initializes alphebet array to have all characters in alphebet
	{
		alphebet[i] = (char)65 + i;

	}


	int counter = 0;							
	for (int y = 0; y < 5; y++)					//inserts keyword into table
	{
		for (int x = 0; x < 5; x++)
		{
			if (counter < keyWord.size())		//runs until the keyword is filled
			{
				*(arr + ((y*5) + x)) = keyWord[counter++];	//calculates memory offset for desired corrdinate
			}
		}
	}

	int letter = 0;											//keeps track of which letter iteration
	bool isUsed = true;
	for (int x = 0; x < 5; x++)								//fills the rest of the table with alphebet, exculding 'J'
	{
		for (int y = 0; y < 5; y++)
		{
			while (isUsed)
			{
				isUsed = false;
				for (int i = 0; i < keyWord.size(); i++)	//goes through each letter in keyword
				{
					if (alphebet[letter] == keyWord[i])		//checks if current letter is in keyword
					{
						isUsed = true;
					}
				}
				if (isUsed)									//if current letter is in keyword, skip over it
				{
					letter++;
				}
			}

			if (*(arr + ((y*5) + x)) == 0)					//if current coordinate is not filled with letter, then add it into key table
			{
				if (letter == 9)							//skip 'J'
				{
					letter++;
				}
				*(arr + ((y*5) + x)) = alphebet[letter++];
			}

			isUsed = true;	//resets isUsed
		}
	}

}
/*
ARGUMENTS:	Desired key word
RETURNS:	Key word with repeat characters removed

PURPOSE:	Remove all repeat characters in a keyword
*/
string removeRepeats(string keyWord)
{
	string temp;								//string with removed repeat characters
	bool isRepeat = false;
	keyWord = toUpper(keyWord);					//converts keyWord to all upper case and removes spaces and punctuation

	for (int a = 0; a < keyWord.size(); a++)	//iterates through every character in keyWord
	{
		if (keyWord[a] == 'J')					//replaces 'J' with 'I'
		{
			keyWord[a] = 'I';
		}
		for (int b = 0; b < temp.size(); b++)	//sets isRepeat to true if current character in keyWord is a repeat
		{
			if (temp[b] == keyWord[a])
			{
				isRepeat = true;
			}
		}
		if (!isRepeat)							//adds character to temp if it is not a repeat
		{
			temp += keyWord[a];
		}
		isRepeat = false;
	}
	return temp;								//returns temp with removed repeat characters
}

/*
ARGUMENTS:	String to convert to all uppercase 
RETURNS:	All uppercase string

PURPOSE:	Convert all lowercase characters to uppercase and remove punction and spaces
*/
string toUpper(string word)
{
	string temp;

	for (int i = 0; i < word.size(); i++)		//goes through each character in word
	{
		if (islower(word[i]))					//if it is lowercase, then set it to upercase
		{
			word[i] = word[i] - 32;
		}
		if (!isspace(word[i]) && !ispunct(word[i]))					//if it is not a space or punctuation then add it to temp
		{
			temp += word[i];						//add the character to temp
		}
	}
	return temp;
}

/*
ARGUMENTS:	clear text to be processed
RETURNS:	processed clear text

PURPOSE:	To prepare cleartext to be encoded by adding 'X's inbetween repeat letters,
			replacing 'J's with 'I's,
			and adding 'X' to the end of processed text if there is an odd amount of letters (to complete the last pair)
*/
string processClearText(string clearText)
{
	clearText = toUpper(clearText);				//converts all characters to upper case and removes punctuation and spaces
	string processedDouble;						//string to hold processed clear text with added 'X's

	for (int i = 0; i < clearText.size(); i++)	//replaces all 'J's with 'I's
	{
		if (clearText[i] == 'J')
		{
			clearText[i] = 'I';
		}
	}

	for (int i = 0; i < clearText.size() - 1; i++)	//goes through each character in clear text
	{
		processedDouble += clearText[i];
		if (clearText[i] == clearText[i + 1])		//if current character is equal to the next character, add an 'X' to processedDouble
		{
			processedDouble += 'X';
		}
	}
	if (!ispunct(clearText[clearText.size() - 1]))	//if the last character in clearText is not punctuation, add it to processedDouble
	{
		processedDouble += clearText[clearText.size() - 1];	
	}

	if (processedDouble.size() % 2 != 0)			//adds 'X' to end of processedDouble if there's and odd number of characters
	{
		processedDouble += 'X';
	}

	return processedDouble;
}

/*
ARGUMENTS:	pointer ot key table, 
			clear text to be encoded
RETURNS:	encoded clear text

PURPOSE:	to encode proccessed clear text into cypher text
*/
string encode(char* keyTable, string clearText)
{
	clearText = processClearText(clearText);
	string encodedText;
	int x1, x2, y1, y2;

	for (int i = 0; i < clearText.size(); i += 2)			// goes through pairs of characters in in the clear text
	{
		for (int y = 0; y < 5; y++)							//finds coordinates of the two characters in a pair
		{
			for (int x = 0; x < 5; x++)
			{
				if (*(keyTable + ((y * 5) + x)) ==  clearText[i]) 
				{
					x1 = x;
					y1 = y;
				}
				else if (*(keyTable + ((y * 5) + x)) == clearText[i+1])
				{
					x2 = x;
					y2 = y;
				}
			}
		}

		if (y1 == y2)										//if pair of characters are on same row, add one to the x coordinate
		{
			x1 = ((x1 + 1) % 5);
			x2 = ((x2 + 1) % 5);
			encodedText += *(keyTable + ((y1 * 5) + x1));	//adds coded character to encodedText string
			encodedText += *(keyTable + ((y2 * 5) + x2));
		}
		else if (x1 == x2)									//if pair of characters are on same row, add one to the y coordinate
		{
			y1 = ((y1 + 1) % 5);
			y2 = ((y2 + 1) % 5);
			encodedText += *(keyTable + ((y1 * 5) + x1));	//adds coded character to encodedText string
			encodedText += *(keyTable + ((y2 * 5) + x2));	
		}
		else
		{
			encodedText += *(keyTable + ((y1 * 5) + x2));	//if they are not in same row or column, switch the x coordinates of pair of characters
			encodedText += *(keyTable + ((y2 * 5) + x1));
		}
		
	}
	return encodedText;
}

/*
ARGUMENTS:	coded text to be decoded
RETURNS:	processed clear text

PURPOSE:	To decode coded text
*/
string decode(char* keyTable, string codedText)
{
	string encodedText;
	codedText = toUpper(codedText);
	int x1, x2, y1, y2;

	for (int i = 0; i < codedText.size(); i += 2)		//iterates through each pair of characters in coded text
	{
		for (int y = 0; y < 5; y++)						//finds coordinates of each character
		{
			for (int x = 0; x < 5; x++)
			{
				if (*(keyTable + ((y * 5) + x)) == codedText[i])
				{
					x1 = x;
					y1 = y;
				}
				else if (*(keyTable + ((y * 5) + x)) == codedText[i + 1])
				{
					x2 = x;
					y2 = y;
				}
			}
		}

		if (y1 == y2)										//if they're in the same row, subtract one from x value
		{
			x1 -= 1;
			if (x1 == -1)
			{
				x1 = 4;
			}
			encodedText += *(keyTable + ((y1 * 5) + x1));

			x2 -= 1;
			if (x2 == -1)
			{
				x2 = 4;
			}
			encodedText += *(keyTable + ((y2 * 5) + x2));
		}
		else if (x1 == x2)									//if they're in the same column, subtract one from y value
		{
			y1 -= 1;
			if (y1 == -1)
			{
				y1 = 4;
			}
			encodedText += *(keyTable + ((y1 * 5) + x1));

			y2 -= 1;
			if (y2 == -1)
			{
				y2 = 4;
			}
			encodedText += *(keyTable + ((y2 * 5) + x2));
		}
		else
		{
			encodedText += *(keyTable + ((y1 * 5) + x2));	//else switch x and y coordinates
			encodedText += *(keyTable + ((y2 * 5) + x1));
		}

	}
	return encodedText;
}

/*
ARGUMENTS:	character array
			height and width of array

PURPOSE:	to print character array to console
*/
void printArr(char* arr, int R, int C)
{
	for (int y = 0; y < C; y++)
	{
		for (int x = 0; x < R; x++)
		{
			cout << setw(2) << *(arr + ((y*C) + x));
		}
		cout << endl;
	}
}

string readFile(string filename)
{
	ifstream fin (filename);
	string input_line;
	string fileData;

	if (!fin)
	{
		return "An error has occurred reading in file.";
	}

	for (int i = 1; !fin.eof(); i++)
	{
		getline(fin, input_line);		//reads in one line from file into input_line
		fileData += input_line;			//concatenate input_line onto fileData
		fileData += "\n";				//concatenate a newLine onto fileData
	}

	return fileData;
}

void toFile(string filename, string data)
{
	ofstream fout(filename);
	fout << data;
	fout.close();
}

string safeDataEntry()
{
	string data;
	bool isValid = true;
	while (isValid)
	{
		getline(cin, data);
		if (data == "1")
		{
			isValid = false;
		}
		else if (data == "2")
		{
			isValid = false;
		}
	}
	return data;
}