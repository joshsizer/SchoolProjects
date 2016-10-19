#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>

using namespace std;

string mergeFiles (string, string);
void createCopy (string);
string replaceWith$ (string);
string readFile (string);
void appFile (string, string);
void writeToFile (string, string);

int main()
{
	string toDo = "";
	cout << "Please enter what you wish this program to perform: " << endl;
	cout << "Append one file to the end of another: Press 1: " << endl;
	cout << "Enter text to add to a file: Press 2: " << endl;
	cout << "Create copy of a file: Enter 3: " << endl;
	cout << "Replace all 's's with dollar signs: Press 4: " << endl << endl;

	getline (cin, toDo);

	if (toDo == "1")
	{
		string filename1 = "";
		string filename2 = "";
		cout << "Enter filename of the file you want to add to: " << endl;
		getline (cin, filename1);
		cout << "Enter filename of the file that is to be appended to first file: " << endl;;
		getline (cin, filename2);

		string mergedFiles = mergeFiles (filename1, filename2);
	}
	else if (toDo == "2")
	{
		string filename1 = "";
		string userInput = "";
		cout << "Enter filename of the file you want to add to: ";
		getline (cin, filename1);
		cout << "Enter the text you wish to add to the file: ";
		getline (cin, userInput);

		appFile (filename1, userInput);

	}
	else if (toDo == "3")
	{
		string filename1 = "";
		cout << "Enter filename of the file you want copy: " << endl;
		getline (cin, filename1);
		createCopy (filename1);
	}
	else if (toDo == "4")
	{
		string filename1 = "";
		cout << "Enter filename of the file you want to replace s's with: " << endl;
		getline (cin, filename1);
		
		string blah = replaceWith$(filename1);
	}

	cout << "\n\n===============Success==============" << endl;

	cout << endl;
	system("pause");
	return 0;
}

//inputs are the two filenames to be merged
//outputs to the file and returns resulting string
string mergeFiles (string filename, string filename2)
{
	string data = readFile(filename2);
	appFile(filename, data);

	return readFile(filename);
}


//input is the source file to be copied
//creates copy file
void createCopy (string filename)
{
	string filename1; //filename of the copy file
	for (int i = 0; i < filename.size() - 4; i++) //creates copy filename without .txt extension
	{
			filename1 += filename[i];
	}

	filename1 += "(1).txt";

	writeToFile (filename1, readFile(filename));
}


//input is the filename, target character, and letter to replace target
//outputs to console and file
string replaceWith$ (string filename)
{
	string data = readFile(filename);
	string newData;

	for (int i = 0; i < data.size(); i++)
	{
		if (data[i] == 's' || data[i] == 'S')
		{
			newData += '$';
		}
		else 
		{
			newData += data[i];
		}
	}

	writeToFile (filename, newData);

	return newData;
}

//input is the filename
//output is the string created from reading file
string readFile (string filename)
{
	string input_line = "";
	string data = "";
	ifstream fin (filename);
	
	if (!fin)
	{
		cout << "ERROR: An error occured when attempting to read from file2" << endl;
		return "ERROR: An error occured when attempting to read from file2";
	}

	for (int i = 1; !fin.eof(); i++)
	{
		getline (fin, input_line);
		data += input_line;
		data += "\n";
	}
	return data;
}

//input is the filename and data to be appended to file
void appFile (string filename, string data)
{
	ofstream fout (filename, ios::app);
	fout << "\n" + data;
	fout.close();
}

//input is the filename and data to be written to file
void writeToFile (string filename, string data)
{
	ofstream fout (filename);
	fout << data;
	fout.close();
}