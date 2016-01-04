/*

Name: Josh Sizer
Date: 10/16/14
Purpose of Program: To explore nested for loops

*/
#include <iostream>
#include <iomanip>

using namespace std;

int main() 
{
	for (int i = 1; i <= 3; i++)
	{
		cout << "Outer loop: i = " << i << ";" << endl;

		for (int j = 1; j <= 4; j++)
		{
			cout << "\tInner loop: j = " << j << ";" << endl;
		}
	}

	cout << "\n===============================\n" << endl;

	//added another variable, v, to hold the 5th number
	int v, w, x, y, z;
	cout << "v w x y z" << endl;
	//added additional for loop for the 5th number
	for (v = 0; v <= 1; v++)
	{
		for (w = 0; w <= 1; w++)
		{
			for (w = 0; w <= 1; w++)
			{
				for (x = 0; x <= 1; x++)
				{
					for (y = 0; y <= 1; y++)
					{
						for (z = 0; z <= 1; z++)
						{
							cout << v << " " << w << " " << x << " " << y << " " << z << " " << endl;
						}
					}
				}
			}
		}
	}

	cout << endl;
	system("pause");
    return EXIT_SUCCESS; 
}
