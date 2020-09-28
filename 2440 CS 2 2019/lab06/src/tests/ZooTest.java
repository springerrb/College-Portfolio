package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import solution.Cat;
import solution.Coyote;
import solution.Dog;
import solution.FeralCat;
import solution.Hippo;
import solution.Lion;
import solution.WildDog;
import solution.Wolf;
import solution.Zoo;

/**
 * A simple test class that tests some of the Zoo
 * specification/design/implementation.
 * 
 * @author Mitch Parry
 * @version 2013-09-17
 * 
 */
public class ZooTest
{

    /**
     * Main test method that provides full coverage.
     */
    @Test
    public void test1()
    {
        final double EPS = 1e-9;
        Zoo zoo = new Zoo("theZoo", 1, 2);

        zoo.setName("NewName");
        assertEquals("Zoo: set/get name does not work.", "NewName",
                zoo.getName());
        assertEquals("Zoo: getLongitude does not work.", 1, zoo.getLatitude(),
                EPS);
        assertEquals("Zoo: getLongitude does not work.", 2, zoo.getLongitude(),
                EPS);

        Cat cat = new Cat(zoo, "Cat");
        cat.setHungerLevel(-1);
        assertEquals("setHungerLevel does not work.", 0, cat.getHungerLevel());
        cat.setHungerLevel(11);
        assertEquals("setHungerLevel does not work.", 10, cat.getHungerLevel());
        cat.setName("TheCat");
        assertEquals("get/set name does not work.", "TheCat", cat.getName());
    }

    /**
     * Second test method for the Zoo class.
     */
    @Test
    public void test2()
    {
        Zoo zoo = new Zoo("theZoo", 1, 2);
        Cat cat = new Cat(zoo, "Cat");
        Coyote coyote = new Coyote(zoo, "Coyote");
        Dog dog = new Dog(zoo, "Dog");
        FeralCat feralCat = new FeralCat(zoo, "FeralCat");
        Hippo hippo = new Hippo(zoo, "Hippo");
        Lion lion = new Lion(zoo, "Lion");
        WildDog wildDog = new WildDog(zoo, "WildDog");
        Wolf wolf = new Wolf(zoo, "Wolf");

        zoo.addAnimal(cat);
        zoo.addAnimal(coyote);
        zoo.addAnimal(dog);
        zoo.addAnimal(feralCat);
        zoo.addAnimal(hippo);
        zoo.addAnimal(lion);
        zoo.addAnimal(wildDog);
        zoo.addAnimal(wolf);
        assertEquals("Zoo: getNumOfAnimals does not work.", 8,
                zoo.getNumOfAnimals());

        Zoo.main(new String[] {});
    }

}

