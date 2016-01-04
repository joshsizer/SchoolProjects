#include <iostream>
#include <string>
#include "joshLibrary.h"

using namespace std;
const int ARRAYSIZE = 5;

int main()
{
	
	char arr[ARRAYSIZE] = {'z', '4', 'd', 'a', 'j'};
	int arr2[ARRAYSIZE] = {4, 2, 22, 8, 9};
	string arr3[ARRAYSIZE] = {"string", "yellow", "apple", "elephant", "bacon"};

	bubbleSort(arr, ARRAYSIZE);
	//bubbleSort(arr3, ARRAYSIZE);

	int pos = linearSearch (arr2, 22, ARRAYSIZE);


	for (int i = 0; i < ARRAYSIZE; i++)
	{
		cout << pos << endl;
	}

	cout << endl;
	system("pause");
	return 0;
}