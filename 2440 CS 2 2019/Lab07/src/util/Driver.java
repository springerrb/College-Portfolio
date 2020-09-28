package util;

import solution.DoubleLinkedSeq;
/**
 * A program to edit and experiment with to test your DoubleArraySeq.
 * 
 * @author ???
 * @version ???
 */
public class Driver
{
    public static final double A = 1.1;
    public static final double B = 2.2;
    public static final double C = 3.3;
    public static final double D = 4.4;
    public static final double E = 5.5;
    public static final double F = 6.6;
    public static final double G = 7.7;

    /**
     * The main program.
     * 
     * @param args
     *            unused.
     */
    public static void main(String[] args)
    {
        DoubleLinkedSeq s = test1(new DoubleLinkedSeq());

        DoubleLinkedSeq s1 = test2(new DoubleLinkedSeq());

        System.out.println("S: " + s);
        System.out.println("S1: " + s1);

        s.addAll(s1);

        // S: <[7.7], 4.4, 3.3, 5.5, 2.2, 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3,
        // 4.4>
        System.out.println("S: " + s);

        s.removeCurrent();
        // S: <[4.4], 3.3, 5.5, 2.2, 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        System.out.println("S: " + s);

        s.removeCurrent();
        // S: <[3.3], 5.5, 2.2, 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        System.out.println("S: " + s);

        s.advance();
        s.removeCurrent();
        // S: <3.3, [2.2], 6.6, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        System.out.println("S: " + s);

        s.advance();
        s.removeCurrent();
        // S: <3.3, 2.2, [1.1], 1.1, 6.6, 5.5, 2.2, 3.3, 4.4>
        System.out.println("S: " + s);

        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.removeCurrent();
        // S: <3.3, 2.2, 1.1, 1.1, 6.6, 5.5, 2.2, 3.3>
        System.out.println("S: " + s);

        s.start();
        s.removeCurrent();
        // S: <[2.2], 1.1, 1.1, 6.6, 5.5, 2.2, 3.3>
        System.out.println("S: " + s);
    }

    /**
     * Test 1.
     * 
     * @param s
     *            the sequence.
     * @return a reference to the same sequence.
     */
    private static DoubleLinkedSeq test1(DoubleLinkedSeq s)
    {
        System.out.println(s);

        s.addBefore(A);
        System.out.println(s);

        s.addBefore(B);
        System.out.println(s);

        s.addBefore(C);
        System.out.println(s);

        s.addBefore(D);
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.addBefore(E);
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.addBefore(F);
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.advance();
        System.out.println(s);

        s.addBefore(G);
        System.out.println(s);

        return s;
    }

    /**
     * test 2.
     * 
     * @param s1
     *            The sequence.
     * @return a reference to the same sequence.
     */
    private static DoubleLinkedSeq test2(DoubleLinkedSeq s1)
    {
        System.out.println(s1);

        s1.addAfter(A);
        System.out.println(s1);

        s1.addAfter(B);
        System.out.println(s1);

        s1.addAfter(C);
        System.out.println(s1);

        s1.addAfter(D);
        System.out.println(s1);

        s1.start();
        System.out.println(s1);

        s1.addAfter(E);
        System.out.println(s1);

        s1.addBefore(F);
        System.out.println(s1);

        return s1;
    }
}
