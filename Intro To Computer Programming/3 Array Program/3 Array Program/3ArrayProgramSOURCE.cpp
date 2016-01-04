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
	
	int arr1[] = {5, 15, 25, 35, 45, 55, 65, 75};

	cout << "Array 1:" << endl;

	for (int i = 0; i <8; i++)
	{
		cout << arr1[i] << ", ";
	}



	int arr2[] = {10, 22, 13, 99, 4, 5};
	int sum = 0;

	cout << "\n\nArray 2:\tSum: " << endl;

	for (int i = 0; i < 6; i++)
	{
		sum += arr2[i];
		cout << arr2[i] << "\t\t" << sum << endl;;
	}

	int arr3[7];
	sum = 0;
	cout << endl;

	for (int i = 0; i < 7; i++)
	{
		cout << "Please enter the " << i+1 << " number for the array." << endl;
		cin >> arr3[i];
	}

	cout << "\nArray 2:\tSum: " << endl;

	for (int i = 0; i < 7; i++)
	{
		sum += arr3[i];
		cout << arr3[i] << "\t\t" << sum << endl;;
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
