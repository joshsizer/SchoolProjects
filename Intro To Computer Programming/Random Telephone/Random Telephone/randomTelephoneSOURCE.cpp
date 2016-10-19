/*

Name: Josh Sizer
Date: 10/10/14
Purpose of Program: To explore for loops by creating 50 random telephone numbers

*/
#include <iostream>
#include <iomanip>
#include <ctime> 

using namespace std;

int main() 
{
	int i;
	int first;
	int second;
	int third;
	srand(unsigned(time(0))); 

	cout << "The range of the first three digits is 208 - 341." << endl;
	cout << "The range of the second three digits is 500 - 600." << endl;
	cout << "The range of the last four digits is 7000 - 9000." << endl;

	for (i = 1; i <= 50; i++)
	{
		first = (rand() % 134) + 208;
		second = (rand() % 101) + 500;
		third = (rand() % 2001) + 7000;

		cout << setw(2) << i << ". " << first << "-" << second << "-" << third << endl;
	}
    

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
