public class Client {
    public static void main(String args[]) {
        String[] accounts = new String[]{"a1", "a2", "a3"};
        String[] passwords1 = new String[]{"p1", "p2", "p3"};
        String[] passwords2 = new String[]{"p4", "p5", "p6"};
        
        ClientThread c1 = new ClientThread(accounts, passwords1, 4, "T1");
        Thread t1 = new Thread(c1);
        t1.start();
        
        ClientThread c2 = new ClientThread(accounts, passwords2, 7, "T2");
        Thread t2 = new Thread(c2);
        t2.start();
    }
}
