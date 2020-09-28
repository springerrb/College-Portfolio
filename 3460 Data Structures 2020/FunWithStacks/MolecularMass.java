public class MolecularMass
{
	//public static IntStack stack = new IntStack();
	public static IntStack[] groups = new IntStack[50];
	
	//groups[0] = stack;
	public static int groupCount = 0;
	
	
	
	public static void main(String[] args)
	{
		String string;
		int mass;
		
		//for (IntStack group : groups)
		//{
			//group = new IntStack();
		//}
		
		System.out.print("Enter the molecule: ");
		// do some code
		
		string = System.console().readLine();
		
		mass = convert(string);
		
		System.out.printf("\nThe Molecular Mass of %s is %d\n", string, mass);
		
	}
	
	public static int convert(String s)
	{
		//stack = new IntStack();
		int count;
		
		groups[groupCount] = new IntStack(); //instead of populating all at once, 
		//each group is instantiated when it is needed
		
		for (int i = 0; i < s.length(); i++)
		{
			if (Character.isDigit(s.charAt(i)))
			{
				groups[0].push(Character.getNumericValue(s.charAt(i)) * groups[0].pop());
				System.out.println("I see a " + Character.getNumericValue(s.charAt(i)) + " in convert");
			}
			else if (s.charAt(i) == 'C')
			{
				groups[0].push(12);
				System.out.println("I see a C in convert");
			}
			else if (s.charAt(i) == 'O')
			{
				groups[0].push(16);
				System.out.println("I see a O in convert");
			}
			else if (s.charAt(i) == 'H')
			{
				groups[0].push(1);
				System.out.println("I see a H in convert");
			}
			else if (s.charAt(i) == '(')
			{
				groupCount++; //we have our first group
				System.out.println("I see a ( in convert");
				count = newGroup(s.substring(i));
				for (int j = 0; j < count; j++)
						i++; //new group will return an int for how many characters it processed
					//and will actually push(entire group value)
				//stack.push(calculate(group));
				groupCount--; // we have finished working with the forst group, groupCount should be 0
			}
			System.out.println("i = " + i);
			
		}
		return calculate(groups[0]);
	}
	
	public static int newGroup(String s)
	{
		int count = 1; // starts after ( and also skips ) 
		int staticCount = 0;
		int loopCount = 0;
		
		groups[groupCount] = new IntStack();
		
		while (s.charAt(count) != ')')
		{
			if (Character.isDigit(s.charAt(count)))
			{
				groups[groupCount].push(Character.getNumericValue(s.charAt(count)) * groups[groupCount].pop());
					System.out.println("I see a " + Character.getNumericValue(s.charAt(count)) + " in group");
			}
			else if (s.charAt(count) == 'C')
			{
				groups[groupCount].push(12);
					System.out.println("I see a C in group");
			}
			else if (s.charAt(count) == 'O')
			{
				groups[groupCount].push(16);
					System.out.println("I see a O in group");
			}
			else if (s.charAt(count) == 'H')
			{
				groups[groupCount].push(1);
				System.out.println("I see a H in group");
			}
			else if (s.charAt(count) == '(')
			{
				groupCount++; // we have another group
				System.out.println("I see a ( in group");
				staticCount = count;
				loopCount = newGroup(s.substring(staticCount));
				for (int j = 0; j < loopCount; j++)
				{
						count++; //new group will return an int for how many characters it processed
					//and will actually push(entire group value)
						System.out.println(count + " is the value of count");
				}
				groups[groupCount-1].push(calculate(groups[groupCount]) + 1); // pushes group value up one stack
				
				groupCount--; // we finished working with a group
			}
			
			count++;
		}
		//System.out.println("the value for group pushed onto the stack would be" + calculate(groups[groupCount]));
		System.out.println("the string I was working with was " + s);
		System.out.printf("after counting %d chars and incrementing count my string is %s\n", count, s.substring(count));
		groups[groupCount - 1].push(calculate(groups[groupCount])); // pushes group value up one stack
		
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
				//i.push(runningTot);
				return runningTot;
			}
			runningTot = temp;// set tot1 to the current total
		}
		
		
	}
}