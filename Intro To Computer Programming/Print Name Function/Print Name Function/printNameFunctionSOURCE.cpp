#include <iostream>
#include <iomanip>

using namespace std;
void fancyName (int);

int main()
{
	int value;
	cout << "Enter number of times you wish to print your fancy name: ";
	cin >> value;

	//passes user entered value into fancyName function
	fancyName(value);

	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}

/*
precondition: any positive integer can be passed
postcondition: outputs fancy name "value" times
*/
void fancyName(int value)
{
	for (int i = 0; i < value; i++)
	{
		cout << "       ___         ___           ___           ___     "								   << endl;
		cout << "      /\\  \\       /\\  \\         /\\  \\         /\\__\\    "						   << endl;
		cout << "      \\:\\  \\     /::\\  \\       /::\\  \\       /:/  /    "						   << endl;
 		cout << "  ___ /::\\__\\   /:/\\:\\  \\     /:/\\ \\  \\     /:/__/     "						   << endl;
		cout << " /\\  /:/\\/__/  /:/  \\:\\  \\   _\\:\\~\\ \\  \\   /::\\  \\ ___ "					   << endl;
 		cout << " \\:\\/:/  /    /:/__/ \\:\\__\\ /\\ \\:\\ \\ \\__\\ /:/\\:\\  /\\__\\"				   << endl;
 		cout << "  \\::/  /     \\:\\  \\ /:/  / \\:\\ \\:\\ \\/__/ \\/__\\:\\/:/  /"					   << endl;
 		cout << "   \\/__/       \\:\\  /:/  /   \\:\\ \\:\\__\\        \\::/  / "						   << endl;
		cout << "                \\:\\/:/  /     \\:\\/:/  /        /:/  /  "							   << endl;
		cout << "                 \\::/  /       \\::/  /        /:/  /   "								   << endl;
 		cout << "                  \\/__/         \\/__/         \\/__/    "							   << endl;
		cout << "      ___                       ___           ___           ___     "					   << endl;
		cout << "     /\\  \\          ___        /\\  \\         /\\  \\         /\\  \\    "			   << endl;
		cout << "    /::\\  \\        /\\  \\       \\:\\  \\       /::\\  \\       /::\\  \\   "		   << endl;
		cout << "   /:/\\ \\  \\       \\:\\  \\       \\:\\  \\     /:/\\:\\  \\     /:/\\:\\  \\  "	   << endl;
		cout << "  _\\:\\~\\ \\  \\      /::\\__\\       \\:\\  \\   /::\\~\\:\\  \\   /::\\~\\:\\  \\ "   << endl;
		cout << " /\\ \\:\\ \\ \\__\\  __/:/\\/__/ _______\\:\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\" << endl;
		cout << " \\:\\ \\:\\ \\/__/ /\\/:/  /    \\::::::::/__/ \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /"	   << endl;
		cout << "  \\:\\ \\:\\__\\   \\::/__/      \\:\\~~\\~~      \\:\\ \\:\\__\\      |:|::/  / "	   << endl;
		cout << "   \\:\\/:/  /    \\:\\__\\       \\:\\  \\        \\:\\ \\/__/      |:|\\/__/  "		   << endl;
		cout << "    \\::/  /      \\/__/        \\:\\__\\        \\:\\__\\        |:|  |    "			   << endl;
		cout << "     \\/__/                     \\/__/         \\/__/         \\|__|    \n\n"             << endl;
	}
}