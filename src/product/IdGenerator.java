package product;

import java.util.UUID;

public class IdGenerator
{
	public static String generate(Product product)
	{
		String id = "";

		if (product instanceof Movie)
		{
			final String generated = UUID.randomUUID().toString();
			id += "MOV" + generated;
		}
		if (product instanceof Game)
		{
			final String generated = UUID.randomUUID().toString();
			id += "GAM" + generated;
		}
		if (product instanceof Book)
		{
			final String generated = UUID.randomUUID().toString();
			id += "BOO" + generated;
		}
		return id;
	}
}