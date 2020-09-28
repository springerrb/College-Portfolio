package solution;
/**
 * @author russell springer
 * @version 1.0
 */

public class Cat extends Feline implements Pet
{
    /**
     * @param myZoo . . . 
     * @param name . . . .
     */

    public Cat(Zoo myZoo, String name)
    {
	super(myZoo, name);
    }
    /**
     * . . . . .
     */

    public void makeNoise()
    {
	System.out.println("meow...");
    }
    /**
     * . . . . .
     */

    public void eat()
    {
	System.out.println("pick...");
	setHungerLevel(getHungerLevel() - 3);
    }
    /**
     * . . . . .
     */

    public void play()
    {
    	System.out.println("frolic...");
    }
    /**
     * . . . . .
     */

    public void beFriendly()
    {
        System.out.println("purr...");
    }



}
