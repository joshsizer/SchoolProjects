#include <iostream>
#include <iomanip>
#include <sstream>
#include <cctype>
#include <string>
#include <fstream>

using namespace std;

static string FILENAME = "worldpopulations.txt";

int main()
{
	unsigned int totalPop = 0;						//total population
	string line = "";						//current line
	string countryName = "";				//name of country
	ifstream fin (FILENAME);				//declares file input stream			
	char ch;								//current character

	for (int i = 1; !fin.eof(); i++)		//iterates through each line
	{
		istringstream strm;	
		getline (fin, line);
		strm.str(line);
		int countryPop = 0;					//population of country

		while (strm.get(ch))				//gets country name
		{
			if (isalpha(ch) || isspace(ch) || ispunct(ch))
			{
				if (ch != ' ')
				{
					countryName += ch;
				}
				else if (ch == ' ')
				{
					countryName += '*';
				}
				
			}
			else if (isdigit)
			{
				strm.unget();
				strm >> countryPop;
			}
		}

		if (countryName != "European*Union*")
		{
			totalPop += countryPop;
		}
		cout << countryName << " " << countryPop << endl;

		countryName = "";
		line = "";
	}

	cout << "Total Population: " << totalPop << endl;

	cout << endl;
	system("pause");
	return 0;
}
