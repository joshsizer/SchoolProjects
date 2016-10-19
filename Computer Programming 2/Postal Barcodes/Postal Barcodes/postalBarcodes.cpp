#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <vector>
#include <cctype>

using namespace std;

void printBarcode (int);
string userInput(int);
string convertToBarcode(string);

int main()
{
	int numOfBarcodes;
	vector<string> zipcode;
	string barcode = "|  ";

	cout << "This program coverts zipcodes to barcodes." << endl;
	cout << "\nPlease enter how many barcodes you wish to convert: ";
	cin >> numOfBarcodes;

	for (int i = 0; i < numOfBarcodes; i++)
	{
		zipcode.push_back(userInput(i + 1));
	}

	barcode += convertToBarcode(zipcode[0]);

	cout << barcode;

	cout << endl;
	system("pause");
	return 0;
}


string userInput(int i)
{
	bool isValid = false;
	string ZipCode;
	while (isValid == false)
	{
		cout << "Enter zipcode number " << i << ": ";
		cin >> ZipCode;

		if (ZipCode.size() == 5)
		{
			for (int i = 0; i < ZipCode.size(); i++)
			{
				if (isdigit(ZipCode[i]))
				{
					isValid = true;
				}
				else
				{
					isValid = false;
				}	
			}
		}
	}
	return ZipCode;
}

string convertToBarcode (string zipcode)
{
	string barcode;
	for (int i = 0; i < zipcode[i]; i++)
	{
		char blah = zipcode[i];
		int digit = blah;
		switch (digit)
		{
			case 0:
				barcode = "|  |  :  :  :";
				break;
			case 1:
				barcode = ":  :  :  |  |";
				break;
			case 2:
				barcode = ":  :  |  :  |";
				break;
			case 3:
				barcode = ":  :  |  |  :";
				break;
			case 4:
				barcode = ":  |  :  :  |";
				break;
			case 5:
				barcode = ":  |  :  |  :";
				break;
			case 6:
				barcode = ":  |  |  :  :";
				break;
			case 7:
				barcode = "|  :  :  :  |";
				break;
			case 8:
				barcode = "|  :  :  |  :";
				break;
			case 9:
				barcode = "|  :  |  :  :";
				break;
		}
	}
	return barcode;
}