/*
Name: Josh Sizer
Date: 11/12/14
Purpose of Program:
*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	int num = 0;
	cout << "Please enter a number: ";
	cin >> num; 
    int counter = 2;
	int blah = 0;

	cout << "The prime factors of " << num << " is: " << endl; 
	
	while (counter <= num)
	{
		if (num % counter == 0)
		{
			num /= counter;
			cout << counter << ", ";
		}
		else 
		{
			counter++;
		}
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
