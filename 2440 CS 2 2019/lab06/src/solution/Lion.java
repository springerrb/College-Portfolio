package solution;

public class Lion extends Feline
{
	public Lion(Zoo myZoo, String name)
	{
		super(myZoo, name);
	}

	public void makeNoise()
	{
		System.out.println("roar");
	}

	public void eat()
	{
		System.out.println("rip with teeth");
		setHungerLevel(getHungerLevel() - 2);
	}


}
