#include <iostream>
#include <vector>

using namespace std;

vector<int> append (vector<int>, vector<int>);
vector<int> merge (vector<int>, vector<int>);

int main()
{
	vector<int> vec1;
	vector<int> vec2;
	vec1.push_back(1);
	vec1.push_back(4); 
	vec1.push_back(9);
	vec1.push_back(16);

	vec2.push_back(9);
	vec2.push_back(7); 
	vec2.push_back(4);
	vec2.push_back(9);
	vec2.push_back(11);
	
	vector<int> appVec = append (vec1, vec2);
	vector<int> mergeVec = merge (vec1, vec2);

	cout << "Append Vector: \n\n";

	printVector(appVec);

	cout << "\nMerged Vector: \n\n";

	printVector(mergeVec);

	cout << endl;
	system("pause");
	return 0;

}

//input is two vectors. 
//Second vector will be added to the end of the second vector

vector<int> append (vector<int> a, vector<int> b)
{
	for (int i = 0; i < b.size(); i++)
	{
		a.push_back(b[i]); //adds vector b to the end of vector a
	}
	return a;
}
//Function merges two vectors
//Inputs two vectors
vector<int> merge (vector<int> a, vector<int> b)
{
	vector<int> finalVec;

	//finds which vector has the bigger size
	int greatest = a.size();
	if (b.size() > a.size())
	{
		greatest = b.size();
	}

	//for loop runs for 1 less than the size of the bigger vector
	for (int i = 0; i < greatest; i++)
	{
		if (i < a.size()) //determines if all elements in vector a has already been added to new vector
		{
			finalVec.push_back(a[i]);
		}
		if (i < b.size()) //determines if all elements in vector b has already been added to new vector
		{
			finalVec.push_back(b[i]);
		}
	}

	return finalVec;
}

void printVector (vector<int> a)
{
	for (int i = 0; i < a.size(); i++)
	{
		cout << a[i] << endl;
	}
}