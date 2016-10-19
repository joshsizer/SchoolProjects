#include <iostream>
#include <iomanip>
#include <string>
#include <ctime>

using namespace std;
void magicEightBall(int);

int main()
{
	srand(unsigned(time(0)));
	
	int random = rand() % 20 + 1;
	string question;
	cout << "Please ask Magic 8 ball a question:" << endl;

	getline(cin, question);

	magicEightBall(random);

	cout << endl;
	system("pause");
	return EXIT_SUCCESS;
}

void magicEightBall(int num)
{
	switch (num)
	{
		case 1:
			cout << "It is certain." << endl;
			break;
		case 2:
			cout << "It is decidedly so." << endl;
			break;
		case 3:
			cout << "Without a doubt." << endl;
			break;
		case 4:
			cout << "Yes definitely." << endl;
			break;
		case 5:
			cout << "You may rely on it." << endl;
			break;
		case 6:
			cout << "As I see it, yes." << endl;
			break;
		case 7:
			cout << "Most likely." << endl;
			break;
		case 8:
			cout << "Outlook good." << endl;
			break;
		case 9:
			cout << "Yes." << endl;
			break;
		case 10:
			cout << "Signs point to yes." << endl;
			break;
		case 11:
			cout << "Reply hazy try again." << endl;
			break;
		case 12:
			cout << "Ask again later." << endl;
			break;
		case 13:
			cout << "Better not tell you now." << endl;
			break;
		case 14:
			cout << "Cannot predict now." << endl;
			break;
		case 15:
			cout << "Concentrate and ask again." << endl;
			break;
		case 16:
			cout << "Don't count on it." << endl;
			break;
		case 17:
			cout << "My reply is no." << endl;
			break;
		case 18:
			cout << "My sources say no." << endl;
			break;
		case 19: 
			cout << "Outlook not so good." << endl;
			break;
		case 20:
			cout << "Very doubtful." << endl;
			break;
	}
}
/*
It is certain
It is decidedly so
Without a doubt
Yes definitely
You may rely on it
As I see it, yes
Most likely
Outlook good
Yes
Signs point to yes
Reply hazy try again
Ask again later
Better not tell you now
Cannot predict now
Concentrate and ask again
Don't count on it
My reply is no
My sources say no
Outlook not so good
Very doubtful
*/