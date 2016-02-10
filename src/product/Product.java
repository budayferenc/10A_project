package product;

public class Product
{
	String id;
	String title;
	Person person;

	public Product(String id, String title, Person person)
	{
		super();
		this.id = id;
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
}