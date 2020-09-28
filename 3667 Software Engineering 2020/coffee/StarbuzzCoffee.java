public class StarbuzzCoffee {
 
	public static void main(String args[]) {
 
		Beverage b = new Varietal();
		b = new Milk(b);
		b = new Whip(b);
		b = new Sugar(b);
		
		Beverage beverage = new HouseBlend();
		beverage = new Mocha(beverage);
		beverage = new Mocha(beverage);
		beverage = new Mocha(beverage);
		beverage = new Soy(beverage);
		beverage = new Whip(beverage);
		beverage = new Sugar(beverage);
		
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());
				
		System.out.println(b.getDescription() 
				+ " $" + b.cost());
	}
}