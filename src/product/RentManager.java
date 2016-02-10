package product;

import java.util.ArrayList;
import java.util.List;

public class RentManager
{
	public static void main(String[] args)
	{
		// book
		Person agathaChristie = new Person("Agatha", "Christie", Gender.MALE, 5000);
		Person stephenKing = new Person("Stephen", "King", Gender.FEMALE, 5123);

		// gameOne
		Person gameOneOne = new Person("Johny", "Bravo", Gender.MALE, 4123);
		Person gameOneTwo = new Person("Michael", "King", Gender.FEMALE, 3123);
		Person gameOneThree = new Person("Trida", "Apple", Gender.MALE, 12321);
		List<Person> gameOne = new ArrayList<Person>();
		gameOne.add(gameOneOne);
		gameOne.add(gameOneTwo);
		gameOne.add(gameOneThree);

		// gameTwo
		Person gameTwoOne = new Person("Blacky", "Green", Gender.MALE, 121);
		Person gameTwoTwo = new Person("Afrodite", "Silver", Gender.FEMALE, 141);
		List<Person> gameTwo = new ArrayList<Person>();
		gameTwo.add(gameTwoOne);
		gameTwo.add(gameTwoTwo);

		// movieOne && movieTwo
		Person johnnyDepp = new Person("Johnny", "Depp", Gender.FEMALE, 44332);
		Person tomCruise = new Person("Tom", "Cruise", Gender.FEMALE, 44223);
		Person beyonceKnowles = new Person("Beyonce", "Knowles", Gender.MALE, 22123);
		Person harisonFord = new Person("Harison", "Ford", Gender.FEMALE, 53232);
		Person tomHanks = new Person("Tom", "Hanks", Gender.FEMALE, 62265);
		List<Person> movieOne = new ArrayList<Person>();
		movieOne.add(johnnyDepp);
		movieOne.add(tomCruise);
		movieOne.add(tomHanks);
		List<Person> movieTwo = new ArrayList<Person>();
		movieTwo.add(beyonceKnowles);
		movieTwo.add(harisonFord);
		movieTwo.add(tomHanks);

		// books
		Product bookA = new Book(agathaChristie, "LOA", "Life of Agatha", null);
		Product bookB = new Book(stephenKing, "LOS", "Life of Stephen", null);

		// games
		Product gameA = new Game("CSGO", "Counter Strike: Global Offensive", gameOneOne, true, gameOne, 10);
		Product gameB = new Game("BR", "Big Rigs: Over the Road Racing", gameTwoOne, false, gameTwo, 15);

		// movies
		Product movieA = new Movie("moA", "movieA", johnnyDepp, Genre.SCI_FI, 134, 8, movieOne, 12);
		Product movieB = new Movie("moB", "movieB", beyonceKnowles, Genre.ACTION, 199, 4, movieTwo, 21);

		System.out.println("Books:\n\n" + bookA + "\n" + bookB + "\n");
		System.out.println("\nGames:\n\n" + gameA + "\n" + gameB + "\n");
		System.out.println("\nMovies:\n\n" + movieA + "\n" + movieB + "\n");
	}

}