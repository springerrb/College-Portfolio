package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import solution.DoubleLinkedSeq;
/**
 * JUnit test class for DoubleLinkedSeq.
 * 
 * @author Brandon C. Eason, Mitch Parry
 * @version 2013.09.30
 */
public class DoubleLinkedSeqTest
{
    private static final double A = 1.1;
    private static final double B = 2.2;
    private static final double C = 3.3;
    private static final double D = 4.4;
    private static final double E = 5.5;
    private static final double F = 6.6;
    private static final double G = 7.7;
    private static final double H = 8.8;
    private static final double I = 9.9;
    private static final double A2 = 1.2;
    private static final double B3 = 2.3;

    /**
     * A helper method that increments the pass/fail counters and prints an
     * appropriate message based on the value of the specified condition.
     * 
     * @param condition
     *            A condition for which to test. If the condition is true, the
     *            test passed; otherwise, it fails.
     * @param message
     *            A message to print indicating the context for the test.
     */
    private void test(boolean condition, String message)
    {
        testLinked();
        if (condition)
        {
            System.out.println("\nPASSED: " + message);
        }
        else
        {
            System.out.println("\nFAILED: " + message);
        }
        assertTrue(message, condition);
    }

    /**
     * Tests the constructor.
     */
    @Test
    public void testConstructor()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();

        test(!s.isCurrent(),
                "isCurrent returns false: " + s.isCurrent());
        test(s.size() == 0,
                "size returns 0: " + s.size());
        test(s.toString().equals("<>"),
                "toString returns \"<>\": " + s.toString());
    }

    /**
     * Tests equals on empty sequences.
     */
    @Test
    public void testEquals()
    {
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        test(s.equals(s2),
                "Two empty sequences are equal: " + s.equals(s2));
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter1()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);

        test(s.toString().equals("<[1.1]>"),
                "After addAfter(1.1), toString returns <[1.1]>: "
                        + s.toString());
        test(s.getCurrent() == A,
                "Current is 1.1: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 1,
                "size is 1: " + s.size());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter2()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);

        test(s.toString().equals("<1.1, [2.2]>"),
                "After addAfter(2.2), toString returns <1.1, [2.2]>: "
                        + s.toString());
        test(s.getCurrent() == B,
                "Current is 2.2: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 2,
                "size is 2: " + s.size());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter3()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);

        test(s.toString().equals("<1.1, 2.2, [3.3]>"),
                "After addAfter(3.3), toString returns <1.1, 2.2, [3.3]>:\n"
                        + "        " + s.toString());
        test(s.getCurrent() == C,
                "Current is 3.3: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 3,
                "size is 3: " + s.size());
    }

    /**
     * Tests start.
     */
    @Test
    public void testStart1()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        test(s.toString().equals("<[1.1], 2.2, 3.3>"),
                "After start, toString returns <[1.1], 2.2, 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter4()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        test(s.toString().equals("<1.1, [4.4], 2.2, 3.3>"),
                "After addAfter(4.4), toString returns "
                        + "<1.1, [4.4], 2.2, 3.3>:\n        " + s.toString());
        test(s.getCurrent() == D,
                "Current is 4.4: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 4,
                "size is 4: " + s.size());
    }

    /**
     * Tests advance.
     */
    @Test
    public void testAdvance1()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();

        test(s.toString().equals("<1.1, 4.4, [2.2], 3.3>"),
                "After advance, toString returns <1.1, 4.4, [2.2], 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter5()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);

        test(s.toString().equals("<1.1, 4.4, 2.2, [5.5], 3.3>"),
                "After addAfter(5.5), toString returns "
                        + "<1.1, 4.4, 2.2, [5.5], 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests advance.
     */
    @Test
    public void testAdvance2()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3>"),
                "After 2x advance(), toString returns "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter6()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();
        s.addAfter(F);

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3, [6.6]>"),
                "After addAfter(6.6), toString returns "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3, [6.6]>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter7()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();
        s.addAfter(F);
        s.addAfter(G);
        s.addAfter(H);
        s.addAfter(I);
        s.addAfter(A2);

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, "
                + "8.8, 9.9, [1.2]>"),
                "After adding 4 more, toString returns\n        "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, 8.8,"
                        + " 9.9, [1.2]>:\n" + "        " + s.toString());
        test(s.size() == 10,
                "size returns 10: " + s.size());
    }

    /**
     * Tests addAfter.
     */
    @Test
    public void testAddAfter8()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addAfter(A);
        s.addAfter(B);
        s.addAfter(C);
        s.start();
        s.addAfter(D);
        s.advance();
        s.addAfter(E);
        s.advance();
        s.advance();
        s.addAfter(F);
        s.addAfter(G);
        s.addAfter(H);
        s.addAfter(I);
        s.addAfter(A2);
        s.addAfter(B3);

        test(s.toString().equals("<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, "
                + "8.8, 9.9, 1.2, [2.3]>"),
                "After adding 1 more, toString returns\n        "
                        + "<1.1, 4.4, 2.2, 5.5, 3.3, 6.6, 7.7, 8.8,"
                        + "9.9, 1.2, [2.3]>:\n        " + s.toString());
        test(s.size() == 11,
                "size returns 11: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore1()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);

        test(s.toString().equals("<[1.1]>"),
                "After addBefore(1.1), toString returns <[1.1]>: "
                        + s.toString());
        test(s.getCurrent() == A,
                "Current is 1.1: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 1,
                "size is 1: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore2()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);

        test(s.toString().equals("<[2.2], 1.1>"),
                "After addBefore(2.2), toString returns <[2.2], 1.1>: "
                        + s.toString());
        test(s.getCurrent() == B,
                "Current is 2.2: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 2,
                "size is 2: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore3()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);

        test(s.toString().equals("<[3.3], 2.2, 1.1>"),
                "After addBefore(3.3), toString returns <[3.3], 2.2, 1.1>:\n"
                        + "        " + s.toString());
        test(s.getCurrent() == C,
                "Current is 3.3: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 3,
                "size is 3: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAdvance3()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();

        test(s.toString().equals("<3.3, [2.2], 1.1>"),
                "After advance(), toString returns <3.3, [2.2], 1.1>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore4()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);

        test(s.toString().equals("<3.3, [4.4], 2.2, 1.1>"),
                "After addBefore(4.4), toString returns " + "<3.3, [4.4], 2.2,"
                        + "1.1>:\n" + "        " + s.toString());
        test(s.getCurrent() == D,
                "Current is 4.4: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 4,
                "size is 4: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAdvance4()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();

        test(s.toString().equals("<3.3, 4.4, 2.2, 1.1>"),
                "After 3x advance(), toString returns <3.3, 4.4, 2.2, 1.1>:\n"
                        + "        " + s.toString());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore5()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();
        s.addBefore(E);

        test(s.toString().equals("<[5.5], 3.3, 4.4, 2.2, 1.1>"),
                "After addBefore(5.5), toString returns "
                        + "<[5.5], 3.3, 4.4, 2.2, 1.1>:\n        "
                        + s.toString());
        test(s.getCurrent() == E,
                "Current is 5.5: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 5,
                "size is 5: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore6()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();
        s.addBefore(E);
        s.addBefore(F);
        s.addBefore(G);
        s.addBefore(H);
        s.addBefore(I);
        s.addBefore(A2);

        test(s.getCurrent() == A2,
                "Current is 1.2: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 10,
                "size is 10: " + s.size());
    }

    /**
     * Tests addBefore.
     */
    @Test
    public void testAddBefore7()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        s.addBefore(A);
        s.addBefore(B);
        s.addBefore(C);
        s.advance();
        s.addBefore(D);
        s.advance();
        s.advance();
        s.advance();
        s.addBefore(E);
        s.addBefore(F);
        s.addBefore(G);
        s.addBefore(H);
        s.addBefore(I);
        s.addBefore(A2);
        s.addBefore(B3);

        test(s.getCurrent() == B3,
                "Current is 2.3: " + s.getCurrent());
        test(s.isCurrent(),
                "isCurrent() returns true: " + s.isCurrent());
        test(s.size() == 11,
                "size is 11: " + s.size());
    }

    /**
     * Tests addAll.
     */
    @Test
    public void testAddAll1()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s1.addAfter(A);
        s1.addAfter(C);
        s1.addBefore(B);

        s2.addAfter(D);
        s2.addAfter(E);
        s2.addAfter(F);

        s1.addAll(s2);

        test(s1.toString().equals("<1.1, [2.2], 3.3, 4.4, 5.5, 6.6>"),
                "After addAll(s2), s1 is <1.1, [2.2], 3.3, 4.4, 5.5, 6.6>");
        test(s1.size() == 6,
                "s1's size is 6: " + s1.size());
    }

    /**
     * Tests addAll.
     */
    @Test
    public void testAddAll2()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s1.addAfter(A);
        s1.addAfter(C);
        s1.addBefore(B);

        s2.addAfter(D);
        s2.addAfter(E);
        s2.addAfter(F);

        s1.addAll(s2);

        test(s2.toString().equals("<4.4, 5.5, [6.6]>"),
                "After addAll(), s2 is <4.4, 5.5, [6.6]>");
        test(s2.size() == 3,
                "s2's size is 3: " + s2.size());
    }

    /**
     * Tests addAll.
     */
    @Test
    public void testAddAll3()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s1.addAfter(A);
        s1.addAfter(C);
        s1.addBefore(B);

        s2.addAfter(D);
        s2.addAfter(E);
        s2.addAfter(F);

        s1.addAll(s2);
        s1.addAll(s1);

        test(s1.toString().equals("<1.1, [2.2], 3.3, 4.4, 5.5, 6.6, 1.1, "
                + "2.2, 3.3, 4.4, 5.5, 6.6>"),
                "After addAll(s1), s1 is\n        <1.1, [2.2], 3.3, 4.4, 5.5, "
                        + "6.6, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6>:\n        "
                        + s1.toString());
        test(s1.size() == 12,
                "s1's size is 12: " + s1.size());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone1()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleLinkedSeq s2 = s1.clone();

        test(s1.equals(s2),
                "The clone and the original are equal: " + s1.equals(s2));

        test(s1.toString().equals("<1.1, [2.2], 3.3>"),
                "s1 is <1.1, [2.2], 3.3>: " + s1.toString());
        test(s1.size() == 3,
                "The size of the original is 3: " + s1.size());
        test(s1.getCurrent() == B,
                "The current of the original is 2.2: " + s1.getCurrent());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone2()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleLinkedSeq s2 = s1.clone();

        test(s2.toString().equals("<1.1, [2.2], 3.3>"),
                "s2 is <1.1, [2.2], 3.3>: " + s2.toString());
        test(s2.size() == 3,
                "The size of the clone is 3: " + s2.size());
        test(s2.getCurrent() == B,
                "The current of the clone is 2.2: " + s2.getCurrent());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone3()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleLinkedSeq s2 = s1.clone();
        s2.addAfter(D);

        test(s1.toString().equals("<1.1, [2.2], 3.3>"),
                "s1 is <1.1, [2.2], 3.3>: " + s1.toString());
        test(s1.size() == 3,
                "The size of the original is 3: " + s1.size());
        test(s1.getCurrent() == B,
                "The current of the original is 2.2: " + s1.getCurrent());
    }

    /**
     * Tests clone.
     */
    @Test
    public void testClone4()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        s1.addBefore(A);
        s1.addAfter(C);
        s1.addBefore(B);

        DoubleLinkedSeq s2 = s1.clone();
        s2.addAfter(D);

        test(s2.toString().equals("<1.1, 2.2, [4.4], 3.3>"),
                "s2 is <1.1, 2.2, [4.4], 3.3>: " + s2.toString());
        test(s2.size() == 4,
                "The size of the clone is 4: " + s2.size());
        test(s2.getCurrent() == D,
                "The current of the clone is 4.4: " + s2.getCurrent());
    }

    /**
     * Tests the concatenation method.
     */
    @Test
    public void testConcatenation1()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        s1.addAfter(A);
        s1.addAfter(B);

        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s2.addBefore(B);
        s2.addBefore(A);

        DoubleLinkedSeq.concatenation(s1, s2);

        test(s1.toString().equals("<1.1, [2.2]>"),
                "s1 is still <1.1, [2.2]>: " + s1.toString());
        test(s2.toString().equals("<[1.1], 2.2>"),
                "s2 is still <[1.1], 2.2>: " + s2.toString());
    }

    /**
     * Tests the concatenation method.
     */
    @Test
    public void testConcatenation2()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        s1.addAfter(A);
        s1.addAfter(B);

        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        s2.addBefore(B);
        s2.addBefore(A);

        DoubleLinkedSeq s3 = DoubleLinkedSeq.concatenation(s1, s2);

        test(s3.toString().equals("<1.1, 2.2, 1.1, 2.2>"),
                "New seq is: <1.1, 2.2, 1.1, 2.2>: " + s3.toString());
        test(s3.size() == 4,
                "New seq's size is 4: " + s3.size());
        test(!s3.isCurrent(),
                "New seq has a current (false): " + s3.isCurrent());
    }

    /**
     * Initialize sequence.
     * 
     * @param s
     *            the sequence
     */
    private void initialize(DoubleLinkedSeq s)
    {
        s.addAfter(1.0);
        s.addAfter(2.0);
        s.addAfter(3.0);
        s.addAfter(4.0);
        s.addAfter(5.0);
        s.addAfter(6.0);
        s.addAfter(7.0);
        s.addAfter(8.0);
        s.addAfter(9.0);
        s.addAfter(1.0);
        s.addAfter(A);
    }

    /**
     * Update sequence.
     * 
     * @param s
     *            the sequence
     */
    private void update(DoubleLinkedSeq s)
    {
        s.start();
        s.removeCurrent();
        s.advance();
        s.removeCurrent();
        s.advance();
        s.advance();
        s.removeCurrent();
    }

    /**
     * Tests the start method.
     */
    @Test
    public void testStart2()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();
        initialize(s);

        s.start();
        test(s.toString().equals("<[1.0], 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, "
                + "8.0, 9.0, 1.0, 1.1>"),
                "Seq is: <[1.0], 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, "
                        + "8.0, 9.0, 1.0, 1.1>:\n        " + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent1()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();

        initialize(s);

        s.start();
        s.removeCurrent();

        test(s.size() == 10, "size is 10: " + s.size());
        test(s.toString().equals("<[2.0], 3.0, 4.0, 5.0, 6.0, 7.0, "
                + "8.0, 9.0, 1.0, 1.1>"),
                "After removeCurrent: <[2.0], 3.0, 4.0, 5.0, 6.0, 7.0, "
                        + "8.0, 9.0, 1.0, 1.1>:\n        " + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent2()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();

        initialize(s);

        s.start();
        s.removeCurrent();
        s.advance();
        s.removeCurrent();

        test(s.size() == 9, "size is 9: " + s.size());
        test(s.toString().equals("<2.0, [4.0], 5.0, 6.0, 7.0, "
                + "8.0, 9.0, 1.0, 1.1>"),
                "After advance/removeCurrent:\n        <2.0, [4.0], 5.0, 6.0, "
                        + "7.0, 8.0, 9.0, 1.0, 1.1>:\n        " + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent3()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();

        initialize(s);

        update(s);

        test(s.size() == 8, "size is 8: " + s.size());
        test(s.toString().equals("<2.0, 4.0, 5.0, [7.0], "
                + "8.0, 9.0, 1.0, 1.1>"),
                "After advance/advance/removeCurrent:\n        <2.0, 4.0, 5.0, "
                        + "[7.0], 8.0, 9.0, 1.0, 1.1>:\n        "
                        + s.toString());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent4()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();

        initialize(s);

        update(s);

        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.removeCurrent();

        test(s.size() == 7, "size is 7: " + s.size());
        test(s.toString().equals("<2.0, 4.0, 5.0, 7.0, "
                + "8.0, 9.0, 1.0>"),
                "After 4x advance/removeCurrent:  <2.0, 4.0, 5.0, "
                        + "7.0, 8.0, 9.0, 1.0>:\n        " + s.toString());
        test(!s.isCurrent(),
                "Is there a current: (false): " + s.isCurrent());
    }

    /**
     * Tests the removeCurrent method.
     */
    @Test
    public void testRemoveCurrent5()
    {
        DoubleLinkedSeq s = new DoubleLinkedSeq();

        initialize(s);

        update(s);

        s.advance();
        s.advance();
        s.advance();
        s.advance();
        s.removeCurrent();
        s.start();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();
        s.removeCurrent();

        test(s.size() == 0, "size is 0: " + s.size());
        test(s.toString().equals("<>"), "After removing everything: <>: "
                + s.toString());
        test(!s.isCurrent(),
                "Is there a current: (false): " + s.isCurrent());
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals1()
    {
        DoubleLinkedSeq s1 = new DoubleLinkedSeq();
        DoubleLinkedSeq s2 = new DoubleLinkedSeq();
        DoubleLinkedSeq s3 = new DoubleLinkedSeq();
        DoubleLinkedSeq s4 = new DoubleLinkedSeq();
        DoubleLinkedSeq s5 = new DoubleLinkedSeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s5.addAfter(A);
        s5.addAfter(B);

        test(s1.equals(s1),
                "An empty sequence is equal to itself: " + s1.equals(s1));
        test(s1.equals(s2),
                "An empty sequence is equal to an empty sequence : "
                        + s1.equals(s2));
        test(!s1.equals(s3),
                "An empty sequence is not equal to a non-empty one: (false): "
                        + s1.equals(s3));
        test(s3.equals(s4),
                "Two non-empty equal sequences are equal: " + s3.equals(s4));
        test(!s3.equals(s5),
                "Two non-empty, non-equal sequences are equal (false): "
                        + s3.equals(s5));
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals2()
    {
        DoubleLinkedSeq s3 = new DoubleLinkedSeq();
        DoubleLinkedSeq s4 = new DoubleLinkedSeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s3.addAfter(B);
        s4.addAfter(B);
        s3.start();

        test(!s3.equals(s4),
                "Two sequence w/ same element but different current "
                        + "are equal (false): " + s3.equals(s4));
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals3()
    {
        DoubleLinkedSeq s3 = new DoubleLinkedSeq();
        DoubleLinkedSeq s4 = new DoubleLinkedSeq();
        s3.addAfter(A);
        s4.addAfter(A);
        s3.addAfter(B);
        s4.addAfter(B);
        s3.start();
        s4.advance();

        test(!s3.equals(s4),
                "Two sequence w/ same element but different current "
                        + "are equal (false): " + s3.equals(s4));
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions1()
    {
        try
        {
            DoubleLinkedSeq s = new DoubleLinkedSeq();
            s.addAll(null);
            test(false, "addAll(null) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "addAll(null) should throw a NPE: " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "addAll(null) should throw a NPE, got: "
                    + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions2()
    {
        try
        {
            DoubleLinkedSeq s = new DoubleLinkedSeq();
            s.advance();
            test(false, "advance() with no current should throw a ISE");
        }
        catch (IllegalStateException ex)
        {
            test(true, "advance() with no current should throw a ISE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "advance() with no current should throw a ISE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions3()
    {
        try
        {
            DoubleLinkedSeq.concatenation(null, null);
            test(false, "concatenation(null, null) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "concatenation(null, null) should throw a NPE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "concatenation(null, null) should throw a NPE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions4()
    {
        try
        {
            DoubleLinkedSeq s = new DoubleLinkedSeq();
            DoubleLinkedSeq.concatenation(null, s);
            test(false, "concatenation(null, s) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "concatenation(null, s) should throw a NPE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "concatenation(null, s) should throw a NPE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions5()
    {
        try
        {
            DoubleLinkedSeq s = new DoubleLinkedSeq();
            DoubleLinkedSeq.concatenation(s, null);
            test(false, "concatenation(s, null) should throw a NPE");
        }
        catch (NullPointerException ex)
        {
            test(true, "concatenation(s, null) should throw a NPE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "concatenation(s, null) should throw a NPE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions6()
    {
        try
        {
            DoubleLinkedSeq s = new DoubleLinkedSeq();
            s.getCurrent();
            test(false, "getCurrent() w/ no current should throw a ISE");
        }
        catch (IllegalStateException ex)
        {
            test(true, "getCurrent() w/ no current should throw a ISE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "getCurrent() w/ no current should throw a ISE, got:\n"
                    + "        " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests some preconditions.
     */
    @Test
    public void testPreconditions7()
    {
        try
        {
            DoubleLinkedSeq s = new DoubleLinkedSeq();
            s.removeCurrent();
            test(false, "removeCurrent() w/ no current should throw a ISE");
        }
        catch (IllegalStateException ex)
        {
            test(true, "removeCurrent() w/ no current should throw a ISE:\n"
                    + "        " + ex.getMessage());
        }
        catch (Throwable ex)
        {
            test(false, "removeCurrent() w/ no current should throw a ISE,\n"
                    + "        got: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Tests that the DoubleLinkedSeq uses a linked data structure.
     */
    @Test
    public void testLinked()
    {
        String[] regexes = {
            "private;int;.+",
            "private;util\\.DoubleNode;.+"
        };
        checkFieldsSubset(DoubleLinkedSeq.class, regexes);
    }

    /**
     * Checks that the class contains a subset of the fields represented in
     * stringFields.
     * 
     * @param c
     *            The class
     * @param fieldRegexes
     *            An array of regular expressions for each required field.
     */
    public static void checkFieldsSubset(Class<?> c, String[] fieldRegexes)
    {
        Field[] f = c.getDeclaredFields();
        if (fieldRegexes.length == 0)
        {
            assertEquals(c.getName() + ": should not contain fields.", 0,
                    f.length);
        }
        String[] fields = fieldsAsStrings(f);
        String message =
                c.getName() + ": Fields must match one of the following: "
                        + Arrays.toString(fieldRegexes);
        checkStringsSubset(fields, fieldRegexes, message);
    }

    /**
     * Checks that the class contains exactly the strings in regexes.
     * 
     * @param strings
     *            The strings representing fields or methods for example.
     * @param regexes
     *            The regular expressions to compare against.
     * @param message
     *            A message to print if there is an error.
     */
    public static void checkStringsSubset(String[] strings, String[] regexes,
            String message)
    {
        for (String s : strings)
        {
            if (indexOfRegex(s, regexes) < 0)
            {
                fail(message + "\n" + s);
            }
        }
    }

    /**
     * Converts an array of fields into an array of their string
     * representations.
     * 
     * @param fields
     *            The array of fields
     * @return The array of string representations of fields.
     */
    public static String[] fieldsAsStrings(Field[] fields)
    {
        ArrayList<String> fieldStrings = new ArrayList<String>();
        int k = 0;
        for (int i = 0; i < fields.length; i++)
        {
            if (!fields[i].isSynthetic())
            {
                fieldStrings.add(fieldAsString(fields[i]));
                k++;
            }
        }
        return fieldStrings.toArray(new String[k]);
    }

    /**
     * Converts a field into a string (like a declaration).
     * 
     * @param field
     *            The field
     * @return The string representation
     */
    public static String fieldAsString(Field field)
    {
        String name = field.getName();
        String mod =
                Modifier.toString(field.getModifiers());
        String type = field.getType().getName();
        return mod + ";" + type + ";" + name;
    }

    /**
     * Compares the string to an array of regular expressions, returning the
     * first index that matches.
     * 
     * @param s
     *            The string
     * @param regexes
     *            The regular expressions.
     * @return The index of the first regex that matches or -1 if none match.
     */
    public static int indexOfRegex(String s, String[] regexes)
    {
        for (int i = 0; i < regexes.length; i++)
        {
            String regex = regexes[i];
            if (s.matches(regex))
            {
                return i;
            }
        }
        return -1;
    }

}
