#include <iostream>

using namespace std;
void cubeIt(int *);

int main()
{
	int a;

	cout << "Please enter an integer to be cubed" << endl;
	cin >> a;

	cubeIt(&a);
		
	cout << a << endl;

	cout << endl;
	system("pause");
	return 0;
}

void cubeIt(int *p)
{
	*p = *p * *p * *p;
}