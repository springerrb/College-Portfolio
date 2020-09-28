
	import java.util.HashMap;
public class Account
{
	// the singleton pattern is best because we want to enforce that there
	// can only be one instantiation of our account.


	
	private static volatile Account uniqueInstance;
	private HashMap<String, String> hm = new HashMap<String, String>(); //default works?
	
	public static Account getInstance()
	{
		if (uniqueInstance == null)
		{
			synchronized (Account .class)
			{
				if (uniqueInstance == null)
					uniqueInstance = new Account();
			}			
			
		}
		
		return uniqueInstance;
	}
	
	// modify the hashmap 
	public void add(String account, String passwd)
	{
		hm.put(account, passwd);
	}
	
	public void remove(String account)
	{
		hm.remove(account);
	}
	
	public String get(String account)
	{
		String passwd = "";
		passwd = hm.get(account);
		
		return passwd;
	}
	
	
}