package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjectServer
{
	ServerMode mode = ServerMode.LOAD;

	static FileInputStream fis;
	static ObjectInputStream ois;
	/*
	 * static FileOutputStream fos; static ObjectOutputStream oos;
	 */

	public ObjectServer()
	{
		System.out.printf("Server started, default mode of server: " + mode.toString() + "\n\n");
		try
		{
			ServerSocket serverSocket = new ServerSocket(666);
			Socket socket = serverSocket.accept();
			System.out.println("Connection of client was successful.");

			ObjectOutputStream streamtoClient = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream streamFromClient = new ObjectInputStream(socket.getInputStream());

			/*
			 * fos = new FileOutputStream("example.txt", true); oos = new
			 * ObjectOutputStream(fos);
			 */

			while (true)
			{
				//
				// EXIT
				//
				if (streamFromClient.read() > -1)
				{
					Object objectFromClient = streamFromClient.readObject();
					if (objectFromClient instanceof Command && ((Command) objectFromClient) == Command.EXIT)
					{
						System.out.println("EXIT");
						break;
					} else if (objectFromClient instanceof Command && ((Command) objectFromClient) == Command.GET)
					{
						//
						// LOADING
						//
						mode = ServerMode.LOAD;
						Object o = load();
						System.out.println("Datas loading for the client..");
						List<Object> castedList = (List<Object>) o;
						streamtoClient.writeObject(o);
					} else if (objectFromClient instanceof Command && ((Command) objectFromClient) == Command.PUT)
					{
						//
						// SAVING
						//
						mode = ServerMode.SAVE;
						System.out.println("Shift to save mode.");
						System.out.printf("Mode of server now: " + mode + "\n\n");

						/*
						 * try { fos = new FileOutputStream("example.txt",
						 * true); oos = new ObjectOutputStream(fos);
						 * oos.close(); fos.close(); } catch (IOException ex) {
						 * ex.printStackTrace(); }
						 */

					} else if (mode == ServerMode.SAVE)
					{
						System.out.println("The datas have saved.");
						// oos.writeObject(objectFromClient);
						save(objectFromClient);
					}

				}

			}
			serverSocket.close();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public ServerMode getMode()
	{
		return mode;
	}

	public void setMode(ServerMode mode)
	{
		this.mode = mode;
	}

	public static List<Object> load() throws IOException, ClassNotFoundException

	{
		List<Object> listOfObjects = new ArrayList<>();
		fis = new FileInputStream("example.txt");
		ois = new ObjectInputStream(fis);
		Object object;
		while ((object = ois.readObject()) != null)
		{
			listOfObjects.add(object);
		}
		ois.close();
		fis.close();

		try
		{
			FileInputStream fis = new FileInputStream("example.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true)
			{
				try
				{
					listOfObjects.add(ois.readObject());
				} catch (Exception e)
				{
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return listOfObjects;
	}

	public static void save(Object o)
	{
		/*
		 * try {
		 * 
		 * FileOutputStream fos = new FileOutputStream("example.txt", true);
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * oos.writeObject(o); oos.close(); fos.close();
		 * 
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
	}

	public static void main(String[] args)
	{
		new ObjectServer();
	}
}