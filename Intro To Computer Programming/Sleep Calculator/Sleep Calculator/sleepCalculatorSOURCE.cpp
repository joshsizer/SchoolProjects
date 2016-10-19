/*
template.cpp
this is a file that students can use to set up the code
in a standard C++ program written in Visual Studio


Name: Josh Sizer
Date: 9/23/14
Purpose of Program: To calculate the number of hours of sleep a person has had in their life time. 

*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	int birthDay;
	int birthMonth;
	int birthYear;

	int toDay;
	int toMonth;
	int toYear;
	
	int dayDif;
	int monthDif;
	int yearDif;\

	int numDay;
	int hoursOfSleep;
	
	//Your birthday
	cout << "Please enter your date of birth: " << endl;

	cout << "	Month: ";
	cin >> birthMonth;

	cout << "	Day:   ";
	cin >> birthDay;

	cout << "	Year:  ";
	cin >>  birthYear;
    
	//Today's date
	cout << "Please enter today's date: " << endl;

	cout << "	Month: ";
	cin >> toMonth;

	cout << "	Day:   ";
	cin >> toDay;

	cout << "	Year:  ";
	cin >> toYear;

	cout << "=====================================" << endl;

	//calculate total number of days between two dates
	dayDif = toDay - birthDay;
	monthDif = toMonth - birthMonth;
	yearDif = toYear - birthYear;

	numDay = dayDif + (monthDif*30) + (yearDif*365);

	hoursOfSleep =  numDay * 8;

	cout << "\nYou have been alive for " << numDay << " days." << endl;
	cout << "\nYou have slept for " << hoursOfSleep << " hours." << endl;

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
