package solution;
/**
 * @author russell springer
 * @version 1.0
 */

public abstract class Canine extends Animal
{

    /**
     * @param myZoo . . .
     * @param name . . .
     */
	
    public Canine(Zoo myZoo, String name)
    {
	super(myZoo, name);
    }

    /**
     * . . . . .
     */

    public void roam()
    {
	System.out.println("like canines roam in packs...");
	setHungerLevel(getHungerLevel() + 1);
    }

    /**
     * . . . . .
     */

    public abstract void makeNoise();
    
    /**
     * . . . . .
     */

    public abstract void eat();


}
