package solution;

import /util/DoubleNode

/**
 * A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a
 * special &quot;current element&quot;, which is specified and accessed through
 * four methods that are not available in the IntArrayBag class (start,
 * getCurrent, advance, and isCurrent).
 * 
 * Limitations:
 * 
 * Beyond Integer.MAX_VALUE element, the size method does not work.
 * 
 * @author Russell Springer
 * @version 1.0
 */
public class DoubleLinkedSeq implements Cloneable
{

    // your non-static fields go here.

	private node head;
	private node tail;
	private node precusor;
	private node cursor;
	private int manyNodes;



    /**
     * Initializes an empty DoubleLinkedSeq.
     * 
     * @postcondition This sequence is empty.
     */
    public DoubleLinkedSeq()
    {
        manyNodes = 0;
	cursor = null;
	tail = null;
	precursor = null;
	head = null;

    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element before the current element. If there was
     *                no current element, then this method places the new
     *                element at the front of this sequence. The newly added
     *                element becomes the new current element of this sequence.
     */
    public void addBefore(double element)
    {
        // code for addBefore
	
	if (manyNodes == 0)
	{
		newNode = new DoubleNode(element);
		head = newNode
		cursor = head;
		precursor = null;
		tail = head;
		manyNodes++;
	}
	else if (manyNodes == 1 && cursor != null)
        {
                newNode = new DoubleNode(element, cursor);
                head = newNode;
                cursor = newNode;
                precursor = null;
                manyNodes++;
	}
	else if (cursor == null)
	{
		newNode = new DoubleNode(element, head);
		head = newNode;
		cursor = newNode;
		precursor = null;
		manyNodes++;
	}
	else 
	{
		newNode = new DoubleNode(element, cursor);
		precursor.setLink(newNode)
		cursor = newNode;
		manyNodes++;
	}
    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element after the current element. If there was no
     *                current element, then this method places the new element
     *                at the end of this sequence. The newly added element
     *                becomes the new current element of this sequence.
     */
    public void addAfter(double element)
    {

        // your code here
	if (manyNodes == 0)
        {
                newNode = new DoubleNode(element);
                head = newNode
                cursor = head;
                precursor = null;
                tail = head;
                manyNodes++;
        }
        else if (manyNodes == 1 && cursor != null)
        {
                newNode = new DoubleNode(element);
                tail.setLink(newNode)
		tail = newNode;
                precursor = cursor;
                cursor = newNode;
                manyNodes++;
        }
        else if (cursor == null)
        {
                newNode = new DoubleNode(element);
		tail.setLink(newNode)
                tail = newNode;
                precursor = cursor;
                cursor = newNode;
                manyNodes++;
        }
        else
        {
                newNode = new DoubleNode(element, cursor.getLink());
                precursor = cursor
		cursor.setLink(newNode)
                cursor = newNode;
                manyNodes++;
        }

    }

    /**
     * Places the contents of another sequence at the end of this sequence.
     * 
     * @precondition other must not be null.
     * 
     * @param other
     *            a sequence show contents will be placed at the end of this
     *            sequence.
     * 
     * @postcondition the elements from other have been placed at the end of
     *                this sequence. The current element of this sequence
     *                remains where it was, and other is unchanged.
     * 
     * @throws NullPointerException
     *             if other is null.
     */
    public void addAll(DoubleLinkedSeq other) throws NullPointerException
    {
        // your code here
	if (other == null)
	{
		throw new NullPointerException("other is null")
	}
	a = listCopyWithTail(this);
	b = listCopyWithTail(other);
	c = a[1].setLink(b[0]).clone();
	c.head = a[0];
	c.tail = b[1];
	c.manyItems = this.manyItems + other.manyItems;
	
	return c;

    }

    /**
     * Move forward so that the current element is now the next element in the
     * sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition If the current element was already the end element of this
     *                sequence (with nothing after it), then there is no longer
     *                any current element. Otherwise, the new element is the
     *                element immediately after the original current element.
     * 
     * @throws IllegalStateException
     *             if there is not current element.
     */
    public void advance() throws IllegalStateException
    {
        // your code here
	if (current == null)
	{
		throw new IllegalStateException("current = null");
	}
	precursor = cursor;
	cursor = cursor.getLink();
	

    }

    /**
     * Creates a copy of this sequence.
     * 
     * @return a copy of this sequence. Subsequent changes to the copy will not
     *         affect the original, nor vice versa.
     * @throws RuntimeException
     *             if this class does not implement Cloneable.
     * 
     */
    public DoubleLinkedSeq clone() throws RuntimeException
    {
        // your code here. see textbook for hints
        // change this return!
        return null;
    }

    /**
     * Creates a new sequence that contains all the elements from s1 followed by
     * all of the elements from s2.
     * 
     * @precondition neither s1 nor s2 are null.
     * 
     * @param s1
     *            the first of two sequences.
     * @param s2
     *            the second of two sequences.
     * 
     * @return a new sequence that has the elements of s1 followed by the
     *         elements of s2 (with no current element).
     * 
     * @throws NullPointerException
     *             if s1 or s2 are null.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1,
            DoubleLinkedSeq s2) throws NullPointerException
    {
        // your code here.
        // change this return!
        return null;
    }

    /**
     * Returns a copy of the current element in this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @return the current element of this sequence.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public double getCurrent() throws IllegalStateException
    {
        // your code goes here
        // change this return!
        return -Double.NEGATIVE_INFINITY;
    }

    /**
     * Determines whether this sequence has specified a current element.
     * 
     * @return true if there is a current element, or false otherwise.
     */
    public boolean isCurrent()
    {
        // your code
        return false;
    }

    /**
     * Removes the current element from this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition The current element has been removed from this sequence,
     *                and the following element (if there is one) is now the new
     *                current element. If there was no following element, then
     *                there is now no current element.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public void removeCurrent() throws IllegalStateException
    {
        // your code goes here
    }

    /**
     * Determines the number of elements in this sequence.
     * 
     * @return the number of elements in this sequence.
     */
    public int size()
    {
        // your code goes here
        return Integer.MIN_VALUE;
    }

    /**
     * Sets the current element at the front of this sequence.
     * 
     * @postcondition If this sequence is not empty, the front element of this
     *                sequence is now the current element; otherwise, there is
     *                no current element.
     */
    public void start()
    {
        // your code goes here.
    }

    /**
     * Returns a String representation of this sequence. If the sequence is
     * empty, the method should return &quot;&lt;&gt;&quot;. If the sequence has
     * one item, say 1.1, and that item is not the current item, the method
     * should return &quot;&lt;1.1&gt;&quot;. If the sequence has more than one
     * item, they should be separated by commas, for example: &quot;&lt;1.1,
     * 2.2, 3.3&gt;&quot;. If there exists a current item, then that item should
     * be surrounded by square braces. For example, if the second item is the
     * current item, the method should return: &quot;&lt;1.1, [2.2],
     * 3.3&gt;&quot;.
     * 
     * @return a String representation of this sequence.
     */
    @Override
    public String toString()
    {
        // your code here.
        // change this return!
        return null;
    }

    /**
     * Determines if this object is equal to the other object.
     * 
     * @param other
     *            The other object (possibly a DoubleLinkedSequence).
     * @return true if this object is equal to the other object, false
     *         otherwise. Two sequences are equal if they have the same number
     *         of elements, and each corresponding element is equal
     */
    public boolean equals(Object other)
    {
        // your code goes here
        // change this return!
        return false;
    }
}
