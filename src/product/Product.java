package product;

import java.io.Serializable;

public class Product implements Serializable
{
	String id;
	String title;
	Person person;

	public Product(String title, Person person)
	{
		// this.id = IdGenerator.generateID(this);
		this.title = title;
		this.person = person;
	}

	public String getTitle()
	{
		return title;
	}

	public Person getPerson()
	{
		return person;
	}

	public String toString()
	{
		return "Id: " + id + "\nTitle: " + title + "\nPerson: " + person;
	}

	public long getInvestement()
	{
		return 0;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}