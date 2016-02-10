package product;

public class Person
{
	String firstName;
	String lastName;
	Gender gender;
	int salary;

	public Person(String firstName, String lastName, Gender gender, int salary)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.salary = salary;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public String toString()
	{
		return "\n\tFirst name: " + firstName + "\n\tLast name: " + lastName + "\n\tGender: " + gender + "\n\tSalary: "
				+ salary + ("\n");
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}
}