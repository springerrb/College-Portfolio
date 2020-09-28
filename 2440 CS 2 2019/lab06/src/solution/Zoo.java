package solution;

import java.util.ArrayList;

public class Zoo implements AnimalLocation
{
	private String name;
	private double lattitude;
	private double longitude;
	private ArrayList<Animal> zooAnimals;
		

	public Zoo(String name, double lat, double loong)
	{
		lattitude = lat;
		longitude = loong;
		this.name = name;
		zooAnimals = new ArrayList<>();
	}

	public double getLatitude()
	{
		return lattitude;
	}

	public double getLongitude()
        {
                return longitude;
        }

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumOfAnimals()
	{
		return zooAnimals.size();
	}

	public void addAnimal(Animal animal)
	{
		zooAnimals.add(animal);
	}

	public void testAnimals()
	{
		System.out.println(name);
		System.out.println(longitude);
		System.out.println(lattitude);
		System.out.println(zooAnimals.size());
		for (Animal animales : zooAnimals)
		{
			animales.sleep();
			animales.makeNoise();
			animales.eat();
			animales.roam();
			if (animales instanceof Pet)
			{
				((Pet)animales).play();
				((Pet)animales).beFriendly();
			}
		}
	}

	public static void main(String[] args)
	{
		Zoo knewZoo = new Zoo("Mr. Magorium's Wonder Emporium", 100.68, 512.6);
		Dog dogbert = new Dog(knewZoo, "Dogbert");
		Lion leon = new Lion(knewZoo, "Leon");
		FeralCat scatCat = new FeralCat(knewZoo, "scatCat");
		Cat sweetPea = new Cat(knewZoo, "Sweetpea");
		Coyote wiley = new Coyote(knewZoo, "Wiley");
		Wolf alpha = new Wolf(knewZoo, "Alpha");
		WildDog shenzi = new WildDog(knewZoo, "Shenzi");
		
		knewZoo.addAnimal(dogbert);
		knewZoo.addAnimal(leon);
		knewZoo.addAnimal(scatCat);
		knewZoo.addAnimal(sweetPea);
		knewZoo.addAnimal(wiley);
		knewZoo.addAnimal(alpha);	
		knewZoo.addAnimal(shenzi);
	}
	
	



}
