package product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RentManager
{
	public static void main(String[] args)
	{
		Person buday = new Person("MajdA", "buday", Gender.MALE, 9999);

		// book
		Person agathaChristie = new Person("Agatha", "Christie", Gender.MALE, 5000);
		Person stephenKing = new Person("Stephen", "King", Gender.FEMALE, 5123);

		// bookID
		Product loa = new Book("Life of Agatha", buday, agathaChristie);
		Product los = new Book("Life of Stephen", buday, stephenKing);
		loa.setId(IdGenerator.generateID(loa));
		los.setId(IdGenerator.generateID(los));

		// gameOne
		Person gameOneOne = new Person("Johny", "Bravo", Gender.MALE, 4123);
		Person gameOneTwo = new Person("Michael", "King", Gender.FEMALE, 3123);
		Person gameOneThree = new Person("Trida", "Apple", Gender.MALE, 12321);

		// gameTwo
		Person gameTwoOne = new Person("Blacky", "Green", Gender.MALE, 121);
		Person gameTwoTwo = new Person("Afrodite", "Silver", Gender.FEMALE, 141);
		List<Person> game = new ArrayList<Person>();
		game.add(gameOneOne);
		game.add(gameOneTwo);
		game.add(gameOneThree);
		game.add(gameTwoOne);
		game.add(gameTwoTwo);

		// gameID
		Product gameOne = new Game("gameOne", buday, false, game, 499);
		Product gameTwo = new Game("gameTwo", buday, true, game, 4990);
		gameOne.setId(IdGenerator.generateID(gameOne));
		gameTwo.setId(IdGenerator.generateID(gameTwo));

		// movieOne && movieTwo
		Person johnnyDepp = new Person("Johnny", "Depp", Gender.FEMALE, 44332);
		Person tomCruise = new Person("Tom", "Cruise", Gender.FEMALE, 44223);
		Person beyonceKnowles = new Person("Beyonce", "Knowles", Gender.MALE, 22123);
		Person harisonFord = new Person("Harison", "Ford", Gender.FEMALE, 53232);
		Person tomHanks = new Person("Tom", "Hanks", Gender.FEMALE, 62265);
		List<Person> movieOneCast = new ArrayList<Person>();
		movieOneCast.add(johnnyDepp);
		movieOneCast.add(tomCruise);
		movieOneCast.add(tomHanks);
		List<Person> movieTwoCast = new ArrayList<Person>();
		movieTwoCast.add(beyonceKnowles);
		movieTwoCast.add(harisonFord);
		movieTwoCast.add(tomHanks);

		// filmID
		Product movieA = new Movie("movieA", buday, Genre.SCI_FI, 134, 8, movieOneCast, 12);
		Product movieB = new Movie("movieB", buday, Genre.ACTION, 199, 4, movieTwoCast, 21);
		movieA.setId(IdGenerator.generateID(movieA));
		movieB.setId(IdGenerator.generateID(movieB));

		// Products what are buyable
		List<Buyable> buyables = new ArrayList<Buyable>();
		buyables.add((Game) gameOne);
		buyables.add((Game) gameTwo);
		buyables.add((Movie) movieA);
		buyables.add((Movie) movieA);

		try
		{
			Socket clientSocket = new Socket("localhost", 666);
			System.out.println("Connected to Server\n");
			ObjectOutputStream toServer = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
			Thread.sleep(2000);
			send(toServer, Command.PUT);
			send(toServer, buday);
			send(toServer, Command.GET);
			Object readServer = inFromServer.readObject();
			if (readServer instanceof List)
			{

				List<Object> fromServer = (List<Object>) readServer;
				for (Object object : fromServer)
				{

					System.out.println(object);
				}
			}
			send(toServer, Command.EXIT);
			// clientSocket.close();
		} catch (IOException | ClassNotFoundException | InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	public static int buyableIncome(List<Buyable> buyables)
	{
		int sumMoney = 0;
		for (Buyable buyable : buyables)
		{
			sumMoney += buyable.getPrice();
		}
		return sumMoney;
	}

	public static void send(ObjectOutputStream x, Object object) throws IOException
	{
		x.write(0);
		x.writeObject(object);
	}

}