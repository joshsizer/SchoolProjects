#include <iostream>
#include <string>
#include <vector>

using namespace std;
struct Course;

struct Student
{
	string studentName;
	vector<Course*> courseEnrolled;
};

struct Course
{
	string courseName;
	vector<Student*> studentsInCourse;
};

void printStudent( Student* );
void printCourse( Course* );
void enroll(Student*, Course*);

int main()
{

	Student Josh;
	Josh.studentName = "Josh";
	Student Bob;
	Bob.studentName = "Bob";
	Student Jimmy;
	Jimmy.studentName = "Jimmy";

	Course Math;
	Math.courseName = "Math";
	Course Biology;
	Biology.courseName = "Biology";
	Course English;
	English.courseName = "English";

	enroll (&Josh, &Math);
	enroll (&Josh, &Biology);

	printStudent(&Josh);
	printCourse(&Biology);



	cout << endl;
	system("pause");
	return 0;
}

 void printStudent( Student *s )
 {
	 cout << "Student name: " << s -> studentName << endl;
	 cout << "The student is enrolled in these courses: " << endl;
	 for (int i = 0; i < (s -> courseEnrolled.size()); i++)
	 {
		 cout << ((s -> courseEnrolled[i]) -> courseName) << endl;
	 }
	 cout << endl;
 }

 
 void printCourse( Course *c )
 {
	 
	 cout << "Course name: " << c -> courseName << endl;
	 cout << "Students enrolled in this course: " << endl;
	 for (int i = 0; i < (c -> studentsInCourse.size()); i++)
	 {
		 cout << ((c -> studentsInCourse[i]) -> studentName) << endl;
	 }
	 cout << endl;
 }

 void enroll(Student *s, Course *c)
 {
	 s->courseEnrolled.push_back(c);
	 c->studentsInCourse.push_back(s);
 }
 