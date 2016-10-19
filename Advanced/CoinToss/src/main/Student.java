package main;

public class Student 
{
	//instance data
	private String name;
	private int age;
	private double gpa;
	
	//standard default constructor with no arguments
	/*
	 * the job of the constructor is to inialize instance
	 * data
	 */
	public Student()
	{
		name = "No Name on Record";
		setAge(0);
		setGpa(0.0);	
	}
	
	/*
	 * getter ( aka accessor)
	 */
	public String getName()
	{
		return name;
	}

	/*
	 * setter (aka mutator
	 */
	public void setName( String str) 
	{
		name = str;		
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int Age) 
	{
		age = Age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	//toString method
	public String toString()
	{
		String str = name + "\nAge: " + age + "\nGPA: " + gpa;
		return str;
	}

}
