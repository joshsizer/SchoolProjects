#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>

using namespace std;

bool isLeap (int);
int startDay (int, int);
string digitToMonth (int);
int daysInMonth (int, int);
string drawCalendar (int, int);
string inttostring (int);
void toFile (string, string);

int main()
{
	int year;
	int month;

	cout << "Month: ";
	cin >> month;

	cout << "Year: ";
	cin >> year;

	int firstOfMonth = startDay (month, year);
	int days = daysInMonth(month, year);

	string drawnCalendar = "";
	drawnCalendar += digitToMonth (month) + " " + to_string(static_cast<long long>(year)) + "\n\n";
	drawnCalendar += drawCalendar(firstOfMonth, days);
	cout << endl << drawnCalendar << endl;

	toFile("DRAWN calendar.txt", drawnCalendar);

	cout << endl;
	system("pause");
	return 0;
}

bool isLeap (int year)
{
	bool isleap = false;
	
	if  (((year % 100) == 0) && ((year % 400) != 0))
	{
		isleap = false;
	}
	else if (((year % 100) == 0) && ((year % 400) == 0))
	{
		isleap = true;
	}
	else if (year % 4 == 0)
	{
		isleap = true;
	}

	return isleap;
}

int startDay (int m, int y)
{
	if (m == 1 || m == 2)
	{
		m += 12;
		y -= 1;
	}

	int h;
	const int q = 1;
	h = (q + ((((m+1)*26))/10) + y + (y/4) + (6*(y/100)) + (y/400)) % 7;
	
	return h;
}

string digitToMonth (int blah)
{
	string month;
	switch (blah)
	{
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		default:
			cout << "ERROR IN DIGITTOMONTH SWITCH" << endl;
			break;
	}
	return month;
}

int daysInMonth (int month, int year)
{
	switch (month)
	{
		case 1:
			month = 31;
			break;
		case 2:
			if (isLeap(year))
			{
				month = 29;
			}
			else
			{
				month = 29;
			}
			break;
		case 3:
			month = 31;
			break;
		case 4:
			month = 30;
			break;
		case 5:
			month = 31;
			break;
		case 6:
			month = 30;
			break;
		case 7:
			month = 31;
			break;
		case 8:
			month = 31;
			break;
		case 9:
			month = 30;
			break;
		case 10:
			month = 31;
			break;
		case 11:
			month = 30;
			break;
		case 12:
			month = 31;
			break;
		default:
			cout << "ERROR IN DAYSINMONTH SWITCH" << endl;
			break;
	}
	return month;
}

string drawCalendar (int start, int numOfDays)
{
	int dayOfWeek = 0;
	int spaces = 0;
	string Calendar = "";
	Calendar += "  S  M  T  W  T  F  S\n";

	if (start == 0)
	{
		dayOfWeek = 7;
	}
	else
	{
		dayOfWeek = start;
	}

	for (int i = 0; i < (dayOfWeek - 1); i++)
	{
		Calendar += "   ";
	}

	for (int i = 1; i <= numOfDays; i++)
	{
		int date = i;
		if (dayOfWeek > 7)
		{
			Calendar += "\n";
			dayOfWeek = 1;
		}

		if (i >= 10)
		{
			Calendar += " " + inttostring(i);
		}
		else
		{
			Calendar += "  " + inttostring(i);
		}

		dayOfWeek++;
	}
	return Calendar;
}

string inttostring (int value)
{
	int blah = value / 10;
	string stringvalue; 
	switch (blah)
	{
		case 1: 
			stringvalue += "1";
			break;
		case 2: 
			stringvalue += "2";
			break;
		case 3: 
			stringvalue += "3";
			break;
		case 4: 
			stringvalue += "4";
			break;
		case 5: 
			stringvalue += "5";
			break;
		case 6: 
			stringvalue += "6";
			break;
		case 7: 
			stringvalue += "7";
			break;
		case 8: 
			stringvalue += "8";
			break;
		case 9: 
			stringvalue += "9";
			break;
	}
	blah = value % 10;
	switch (blah)
	{
		case 1: 
			stringvalue += "1";
			break;
		case 2: 
			stringvalue += "2";
			break;
		case 3: 
			stringvalue += "3";
			break;
		case 4: 
			stringvalue += "4";
			break;
		case 5: 
			stringvalue += "5";
			break;
		case 6: 
			stringvalue += "6";
			break;
		case 7: 
			stringvalue += "7";
			break;
		case 8: 
			stringvalue += "8";
			break;
		case 9: 
			stringvalue += "9";
			break;
		case 0: 
			stringvalue += "0";
			break;
	}
	return stringvalue;
}

void toFile (string fileName, string toBeWritten)
{
	ofstream fout(fileName);
	fout << toBeWritten;
	fout.close();
}

