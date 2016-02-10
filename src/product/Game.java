package product;

import java.util.ArrayList;
import java.util.List;

public class Game extends Product implements Buyable
{
	private boolean preOrdered;
	private List<Person> staff = new ArrayList<Person>();
	private int price;

	public Game(String id, String title, Person person, boolean preOrdered, List<Person> staff, int price)
	{
		super(id, title, person);
		this.preOrdered = preOrdered;
		this.staff = staff;
		if (preOrdered)
		{
			this.price = (int) (price * 0.8);
		} else
		{
			this.price = price;
		}

	}

	public boolean isPreOrdered()
	{
		return preOrdered;
	}

	public void setPreOrdered(boolean preOrdered)
	{
		this.preOrdered = preOrdered;
	}

	public List<Person> getStaff()
	{
		return staff;
	}

	public void setStaff(List<Person> staff)
	{
		this.staff = staff;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;

	}

	public long getInvestement()
	{
		long summaSalary = 0;
		for (Person person : staff)
		{
			summaSalary += person.getSalary();
		}
		return summaSalary;
	}

	public String toString()
	{
		return "Id: " + id + "\nTitle: " + title + "\nAuthor: " + person + "\nPreordered: " + preOrdered + "\nStaff:\n "
				+ staff + "\nPrice: " + price + "\nInvestment: " + getInvestement();
	}
}