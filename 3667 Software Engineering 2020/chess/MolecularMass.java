public class MolecularMass
{
	public static IntStack stack;
	
	
	public static void main(String[] args)
	{
		String string;
		int mass;
		
		System.out.print("Enter the molecule: ");
		// do some code
		
		string = System.console().readLine();
		
		mass = convert(string);
		
		System.out.printf("\nThe Molecular Mass of %s is %d\n", string, mass);
		
	}
	
	public static int convert(String s)
	{
		stack = new IntStack();
		int count;
		
		for (int i = 0; i < s.length(); i++)
		{
			if (Character.isDigit(s.charAt(i)))
			{
				stack.push(Character.getNumericValue(s.charAt(i)) * stack.pop());
				System.out.println("I see a " + Character.getNumericValue(s.charAt(i)) + " in convert");
			}
			else if (s.charAt(i) == 'C')
			{
				stack.push(12);
				System.out.println("I see a C in convert");
			}
			else if (s.charAt(i) == 'O')
			{
				stack.push(16);
				System.out.println("I see a O in convert");
			}
			else if (s.charAt(i) == 'H')
			{
				stack.push(1);
				System.out.println("I see a H in convert");
			}
			else if (s.charAt(i) == '(')
			{
				System.out.println("I see a ( in convert");
				count = newGroup(s.substring(i));
				for (int j = 0; j < count; j++)
						i++; //new group will return an int for how many characters it processed
					//and will actually push(entire group value)
				//stack.push(calculate(group));
			}
			System.out.println("i = " + i);
			
		}
		return calculate(stack);
	}
	
	public static int newGroup(String s)
	{
		int count = 1; // starts after ( and also skips ) 
		IntStack group = new IntStack();
		
		while (s.charAt(count) != ')')
		{
			if (Character.isDigit(s.charAt(count)))
			{
				group.push(Character.getNumericValue(s.charAt(count)) * group.pop());
					System.out.println("I see a " + Character.getNumericValue(s.charAt(count)) + " in group");
			}
			else if (s.charAt(count) == 'C')
			{
				group.push(12);
					System.out.println("I see a C in group");
			}
			else if (s.charAt(count) == 'O')
			{
				group.push(16);
					System.out.println("I see a O in group");
			}
			else if (s.charAt(count) == 'H')
			{
				group.push(1);
				System.out.println("I see a H in group");
			}
			else if (s.charAt(count) == '(')
			{
				System.out.println("I see a ( in group");
				for (int j = 0; j < newGroup(s.substring(count)); j++)
						count++; //new group will return an int for how many characters it processed
					//and will actually push(entire group value)
				group.push(calculate(group));
			}
			
			count++;
		}
		System.out.println("the value for group pushed onto the stack would be" + calculate(group));
		System.out.println("the string I was working with was " + s);
		System.out.printf("after counting %d chars and incrementing count my string is %s\n", count, s.substring(count));
		stack.push(calculate(group)); // pushes group value
		
		return count; // returns how many chars processed
	}
	
	public static int calculate(IntStack i)
	{
		int runningTot = i.pop();
		int temp;
		while(true) // inf loop will be stopped by if statement when stack is empty
		{
			
			
			temp = (runningTot + i.pop()); //add the top of the stack to the curr total
			if (temp < runningTot) //if pop gave -1
			{
				i.push(runningTot);
				return runningTot;
			}
			runningTot = temp;// set tot1 to the current total
		}
		
		
	}
}