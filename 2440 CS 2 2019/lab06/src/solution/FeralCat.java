package solution;

public class FeralCat extends Feline
{
	public FeralCat(Zoo myZoo, String name)
	{
		super(myZoo, name);
	}

	public void makeNoise()
	{
		System.out.println("meow...");
	}

	public void eat()
	{
		System.out.println("pick...");
		setHungerLevel(getHungerLevel() - 3);
	}


}
