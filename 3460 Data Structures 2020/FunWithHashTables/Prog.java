import java.lang.Integer;

public class Prog {
	
	private static HashTable h;

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		h = new HashTable(n);
		
		for (int i = 0; i < n * n; i += n)
			h.insert(i, 1); // add n multiples of n into list
		
		h.print(h.longest()); // print only the node list with the largest amount of values
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.	
	}

	private static void prog2(int n) {
		h = new HashTable(n);
		
		for (int i = 0; i < n; i++)
			h.insert(i, 2); // add numbers 1 to n into the list
		
		h.print(h.longest()); // print only the node list with the largest amount of values
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.	
	}

	private static void prog3(int n) {
		h = new HashTable(n);

		
		//hash all values less than p
		for (int i = 0; i < 128189; i++)
		{
			if (i < (n * n)) // if p < c
				h.insert(i, 3);  // insert 
		}
			
		
		//find greatest length in table
		Node N = h.longest();
		for (int i = 0; i < n - h.getLength(); i++) // size = (n - h.length()) + h.length()
		{
			if ((N.data() + 128189) < (n * n)) // if n + p < c
			{
				h.insert((int)(N.data()) + 128189, 3); // insert n + p
			}
		}			
			
		h.print(h.longest());
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.	
	}

	private static void prog4(int n) {
		h = new HashTable(n);
		
		for (int i = 1; i <= (n * n); i++)
			h.insert(i, 4);
		
		h.print(h.longest());
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.	
	}
}
