package solution;
/**
 * . . .
 * @author russell springer
 * @version 1.0
 */
public abstract class Animal
{ 
    private String name;
    private Zoo zoo;
    private int hungerLevel;

    /**
     *@param myZoo is a zoo
     *@param animalName is an animals name
     */

    public Animal(Zoo myZoo, String animalName)
    {
	zoo = myZoo;
        name = animalName;
    }

    /**
     *@return Hungerlevel  . . .
     */

    public int getHungerLevel()
    {
	return hungerLevel;
    }

    /**
     *@param level . . .
     */
	
    public void setHungerLevel(int level)
    {
	if (level >= 0 && level <= 10)
	{
	    hungerLevel = level;
	}
	else if (level > 10)
	{
	    hungerLevel = 10;
	}
	else 
	{
            hungerLevel = 0;
	}
    }
	
    /**
     *@return name  . . .
     */
	
    public String getName()
    {
	return name;
    }

    /**
     *@param name is a Zoos name
     */
	
    public void setName(String name)
    {
	this.name = name;
    }

    /**
     * . . .
     */
	
    public void sleep()
    {
	System.out.println("sleeping...");
	setHungerLevel(50);
    }

    /**
     * . . .
     */
	
    public void roam()
    {
	System.out.println("moving around..");
	setHungerLevel(getHungerLevel() + 1);
    }

    /**
     * . . .
     */

    public abstract void makeNoise();
    
    /**
     * . . .
     */

    public abstract void eat(); 
}
