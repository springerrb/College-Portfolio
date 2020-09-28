package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import solution.DoubleLinkedSeq;

/**
 * The class <code>TestDoubleLinkedSeq.java</code> tests the constructors and
 * public methods of class <code>DoubleArraySeq</code> using a console menu.
 * When the program pauses, the user should enter one of the following with one
 * that is appropriate dependent on the context:
 * <p>
 * <ul>
 * <li>a single integer menu choice</li>
 * <li>a single double value</li>
 * <li>several double values separated by blanks</li>
 * </ul>
 * Exceptions <code>IllegalArgumentException</code> and
 * <code>IllegalStateException</code> are caught by the <code>main</code>
 * method. No other exceptions are caught.
 * <p>
 * The <code>DoubleArraySeq</code> methods <code>clone</code>, <code>size</code>
 * , and <code>getCapacity</code> are implicitly tested by the
 * <code>display</code> method.
 * <p>
 * The original version of this file was downloaded from:
 * http://ctas.east.asu.edu/millard/CET230/proj/proj2/TestDoubleArraySeq.java
 * 
 * @author Dr. Mark A. Holliday
 * @author Bob Houston
 * @version 25 February 2011 (was 23 January 2000)
 */
public class TestDoubleLinkedSeq
{
    private BufferedReader stdin = new BufferedReader(
            new InputStreamReader(System.in));

    /**
     * First part of switch statement.
     * 
     * @param choice
     *            The menu choice.
     * @param seq
     *            The sequence.
     * @return The sequence.
     * @throws IOException
     *             if user input cannot be read from stdin.
     */
    public DoubleLinkedSeq switch1(int choice, DoubleLinkedSeq seq)
        throws IOException
    {
        switch (choice)
        {
            case 1:
                seq = newDASeq();
                break;
            case 2:
                testAddAfter(seq);
                break;
            case 3:
                testAddBefore(seq);
                break;
            case 4:
                seq.removeCurrent();
                break;
            case 5:
                testIsCurrent(seq);
                break;
            case 6:
                testGetCurrent(seq);
                break;
            case 7:
                seq.start();
                break;
            default:

        }
        return seq;
    }

    /**
     * Second part of switch statement.
     * 
     * @param choice
     *            The menu choice.
     * @param seq
     *            The sequence.
     * @return The sequence.
     * @throws IOException
     *             if user input cannot be read from stdin.
     */
    public DoubleLinkedSeq switch2(int choice, DoubleLinkedSeq seq)
        throws IOException
    {
        switch (choice)
        {
            case 8:
                seq.advance();
                break;
            case 11:
                testAddAll(seq);
                break;
            case 12:
                testConcatenation(seq);
                break;
            case 13:
                testToString(seq);
                break;
            case 14:
                testEquals(seq);
                break;
            default:
        }
        return seq;

    }

    /**
     * Runs the tests.
     * 
     * @throws IOException
     *             when menu choice cannot be read.
     */
    public void runTests() throws IOException
    {
        DoubleLinkedSeq seq = new DoubleLinkedSeq();
        boolean done = false;

        display("seq", seq);

        while (!done)
        {
            try
            {
                int choice = getMenuChoice();
                done = choice == 0;
                seq = switch1(choice, seq);
                seq = switch2(choice, seq);

            }
            catch (IllegalArgumentException e1)
            {
                System.out.println();
                System.out.print("CAUGHT: IllegalArgumentException: ");
                System.out.println(e1.getMessage());
            }
            catch (IllegalStateException e2)
            {
                System.out.println();
                System.out.print("CAUGHT: IllegalStateException: ");
                System.out.println(e2.getMessage());
            }

            display("seq", seq);
        }
    }

    /**
     * Displays the sequence.
     * 
     * @param label
     *            A label for the sequence.
     * @param seq
     *            The sequence.
     */
    private void display(String label, DoubleLinkedSeq seq)
    {
        DoubleLinkedSeq temp = seq.clone();
        int currPos = posOfCurrent(seq.clone());
        String outElement;

        System.out.println();
        System.out.print(label + ": {");

        temp.start();
        for (int i = 0; i < temp.size(); i++)
        {
            outElement = Double.toString(temp.getCurrent());

            if (i == currPos)
            {
                System.out.print("[" + outElement + "]");
            }
            else
            {
                System.out.print("<" + outElement + ">");
            }

            temp.advance();
        }

        System.out.println("}");
    }

    /**
     * Searches for the current node in the sequence.
     * 
     * @param seq
     *            The sequence.
     * @return the position of the current node.
     */
    private int posOfCurrent(DoubleLinkedSeq seq)
    {
        int count = 0;

        while (seq.isCurrent())
        {
            seq.advance();
            count++;
        }

        return seq.size() - count;
    }

    /**
     * Prints the menu and receives the user's selection.
     * 
     * @return The menu item chosen.
     * @throws IOException
     *             If it cannot read the user's choice.
     */
    private int getMenuChoice() throws IOException
    {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("------------------------------------------------");
        System.out.println("1 Constructor   6 getCurrent     11 addAll    ");
        System.out.println("2 addAfter      7 start          12 concatenation");
        System.out.println("3 addBefore     8 advance        13 toString");
        System.out.println("4 removeCurrent                  14 equals ");
        System.out.println("5 isCurrent");
        System.out.println("------------------------------------------------");
        System.out.print("Number of method to test (0 to quit): ");

        return Integer.parseInt(stdin.readLine());
    }

    /**
     * @return a new sequence.
     */
    private DoubleLinkedSeq newDASeq()
    {
        return new DoubleLinkedSeq();
    }

    /**
     * Tests the addAfter method.
     * 
     * @param seq
     *            The sequence.
     * @throws IOException
     *             if it cannot read a line from stdin.
     */
    private void testAddAfter(DoubleLinkedSeq seq) throws IOException
    {
        System.out.println();
        System.out.print("Enter double value to be added: ");
        seq.addAfter(Double.parseDouble(stdin.readLine()));
    }

    /**
     * Tests the addBefore method.
     * 
     * @param seq
     *            The sequence.
     * @throws IOException
     *             if it cannot read a line from stdin.
     */
    private void testAddBefore(DoubleLinkedSeq seq) throws IOException
    {
        System.out.println();
        System.out.print("Enter double value to be added: ");
        seq.addBefore(Double.parseDouble(stdin.readLine()));
    }

    /**
     * Tests the isCurrent method.
     * 
     * @param seq
     *            The sequence.
     */
    private void testIsCurrent(DoubleLinkedSeq seq)
    {
        System.out.println();
        if (seq.isCurrent())
        {
            System.out.println("A current element exists.");
        }
        else
        {
            System.out.println("No current element exists.");
        }
    }

    /**
     * Tests the getCurrent method.
     * 
     * @param seq
     *            The sequence.
     */
    private void testGetCurrent(DoubleLinkedSeq seq)
    {
        System.out.println();
        System.out.println("Current element: "
                + Double.toString(seq.getCurrent()));
    }

    /**
     * Tests the addAll method.
     * 
     * @param seq
     *            The sequence.
     * @throws IOException
     *             if the input cannot be read from stdin.
     */
    private void testAddAll(DoubleLinkedSeq seq) throws IOException
    {
        DoubleLinkedSeq addend = new DoubleLinkedSeq();

        System.out.println();
        System.out.print("Enter 0 or more double values for addend: ");
        StringTokenizer st = new StringTokenizer(stdin.readLine(), " ,");

        while (st.hasMoreTokens())
        {
            addend.addAfter(Double.parseDouble(st.nextToken()));
        }
        display("addend", addend);

        seq.addAll(addend);
    }

    /**
     * Tests the concatenation method.
     * 
     * @param s1
     *            The sequence.
     * @throws IOException
     *             if user input cannot be read from stdin.
     */
    private void testConcatenation(DoubleLinkedSeq s1) throws IOException
    {
        StringTokenizer st;
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();

        display("s1", s1);
        System.out.println();
        System.out.print("Enter 0 or more double values for s2: ");
        String s = stdin.readLine();
        if (s != null)
        {
            st = new StringTokenizer(s, " ,");

            while (st.hasMoreTokens())
            {
                s2.addAfter(Double.parseDouble(st.nextToken()));
            }
            display("s2", s2);

            display("result", DoubleLinkedSeq.concatenation(s1, s2));
        }
    }

    /**
     * Tests the toString method.
     * 
     * @param seq
     *            The sequence.
     */
    private void testToString(DoubleLinkedSeq seq)
    {
        System.out.println();
        System.out.println(seq.toString());
    }

    /**
     * Tests the equals method.
     * 
     * @param seq
     *            The sequence.
     */
    private void testEquals(DoubleLinkedSeq seq)
    {
        final double A = 2.5;
        System.out.println();
        DoubleLinkedSeq s1 = seq;
        System.out.println(seq.equals(s1) + " " + s1.equals(seq));
        s1 = new DoubleLinkedSeq();
        s1.addAfter(A);
        s1.addAfter(4.0);
        System.out.println(seq.equals(s1) + " " + s1.equals(seq));
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s2.addAfter(4.0);
        s2.addAfter(A);
        System.out.println(s2.equals(s1) + " " + s1.equals(s2));
    }

    /**
     * The main method to run the program.
     * 
     * @param args
     *            unused.
     * @throws IOException
     *             If user input cannot be read from Standard input.
     */
    public static void main(String[] args) throws IOException
    {
        TestDoubleLinkedSeq tester = new TestDoubleLinkedSeq();
        tester.runTests();
    }
}
