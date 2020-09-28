import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ClientThread implements Runnable {
    Account account;
    Scanner in = new Scanner(System.in);
    String[] accounts;
    String[] passwords;
    int i = 0;
    int sleep;
    String threadName;
    
    public ClientThread (String[] accounts, String[] passwords, int sleep, String threadName) {
        this.accounts = accounts;
        this.passwords = passwords;
        account = Account.getInstance();
        this.sleep = sleep;
        this.threadName = threadName;
    }
    
    @Override
	public void run() {
	    double r;
	    String accountName;
	    String password;
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			accountName = accounts[i];
			System.out.println("Thread: " + threadName + " Account: " + accountName);
			r = Math.random() * 3;
			if (r <= 1.0) { // Add
			    password = passwords[i];
			    account.add(accountName, password);
			    System.out.println("Add: " + "Added " + accountName + " with password: " + password);
			}
			 else if ( r <= 2.0) { // get
			     password = account.get(accountName);
			     if (password == null)
			        System.out.println ("Get: " + accountName + " not found.");
			     else
			        System.out.println ("Get: " + "The password for " + accountName + " is " + password);
			}
			else { // remove
			   if (account.get(accountName) != null) {
			      account.remove(accountName);
			      System.out.println(accountName + " has been removed.");
			   }
			   else
			      System.out.println("Remove: " + accountName +" not found");
			}
			i = (i+1) % 3;
			System.out.println();
        }
	}
}