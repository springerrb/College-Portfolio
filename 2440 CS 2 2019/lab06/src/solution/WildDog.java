package solution;

public class WildDog extends Canine
{
	public WildDog(Zoo myZoo, String name)
	{
		super(myZoo, name);
	}

	public void makeNoise()
	{
		System.out.println("bark...");
	}

	public void eat()
	{
		System.out.println("slop...");
		setHungerLevel(getHungerLevel() - 3);
	}


}
