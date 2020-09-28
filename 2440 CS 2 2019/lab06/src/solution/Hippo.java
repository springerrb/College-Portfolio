package solution;

public class Hippo extends Animal
{
	public Hippo(Zoo myZoo, String name)
	{
		super(myZoo, name);
	}

	public void makeNoise()
	{
		System.out.println("blub...");
	}

	public void eat()
	{
		System.out.println("slurp");
		setHungerLevel(getHungerLevel() - 1);
	}


}
