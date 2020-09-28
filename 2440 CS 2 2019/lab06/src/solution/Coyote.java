package solution;
/**
 * @author russell Springer
 * @version 1.0
 */

public class Coyote extends Canine
{
    /**
     * @param myZoo . . .
     * @param name . . . 
     */

    public Coyote(Zoo myZoo, String name)
    {
	super(myZoo, name);
    }

    /**
     * . . . . .
     */

    public void makeNoise()
    {
	System.out.println("howl");
    }

    /**
     * . . . . .
     */

    public void eat()
    {
	System.out.println("gnaws");
	setHungerLevel(getHungerLevel() - 2);
    }


}
