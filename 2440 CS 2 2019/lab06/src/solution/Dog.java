package solution;
/**
 * @author russell springer
 * @version 1.0
 */

public class Dog extends Canine implements Pet
{
    /**
     *@param myZoo . . .
     *@param name . . . .
     */

    public Dog(Zoo myZoo, String name)
    {
	super(myZoo, name);
    }
    /**
     * . . . . .
     */

    public void makeNoise()
    {
	System.out.println("bark...");
    }
    /**
     * . . . . .
     */

    public void eat()
    {
	System.out.println("slop...");
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
        System.out.println("yap...");
    }



}
