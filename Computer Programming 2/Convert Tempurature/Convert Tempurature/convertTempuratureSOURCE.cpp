#include <iostream>
#include <iomanip>
#include <cctype>

using namespace std;
void convert_F2Ctemp (double *);
void convert_C2Ftemp (double *);
void convert_F2Ktemp (double *);
void convert_C2Ktemp (double *);

int main()
{
	double temp;
	double *tempPnt;
	int choice = 0;

	cout << "Which conversion would you like to perform?/n" << endl;
	cout << "Fahrenheit to Centigrade (enter 1)\nCentigrade to Fahrenheit (enter 2)\nFahrenheit to Kelvin     (enter 3)\nCentigrade to Kelvin     (enter 4)" << endl;
	cin >> choice;
	cout << "\nEnter input tempurature: ";
	cin >> temp;

	tempPnt = &temp;
	
	switch (choice) 
	{
		case 1:
			convert_F2Ctemp(tempPnt);
			break;
		case 2:
			convert_C2Ftemp(tempPnt);
			break;
		case 3:
			convert_F2Ktemp(tempPnt);
			break;
		case 4:
			convert_C2Ktemp(tempPnt);
			break;
	}

	cout << "\n" << *tempPnt;

	cout << endl;
	system("pause");
	return 0;
}

void convert_F2Ctemp (double *temp2)
{
	*temp2 = (*temp2 - 32) * (.55555556);
}
void convert_C2Ftemp (double *temp2)
{
	*temp2 = (*temp2 * 1.8) + 32;
}
void convert_F2Ktemp (double *temp2)
{
	*temp2 = (*temp2 - 32) * (.55555556);
	*temp2 += 273;
}
void convert_C2Ktemp (double *temp2)
{
	*temp2 += 273;
}

