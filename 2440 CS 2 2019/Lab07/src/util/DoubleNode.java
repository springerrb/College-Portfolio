package util;
/**
 * A DoubleNode provides a node for a linked list with double data in each node.
 * 
 * note: Lists of nodes can be made of any length, limited only by the amount of
 * free memory in the heap. Beyond Integer.MAX_VALUE (2,147,483,647), the answer
 * from listLength is incorrect because of arithmetic overflow.
 * 
 * @author Michael Main
 * @author ??? 
 * added constructors, special exceptions, and refactored
 * @author Mitch Parry 
 * formatted for style
 * @author Daniel Wilkins
 * fixed error in removeNodeAfter
 * @version 2015/10/21
 */
public class DoubleNode
{
    // Invariant of the DoubleNode class:
    // 1. The node's double data is in the instance variable data.
    // 2. For the final node of a list, the link part is null.
    // Otherwise, the link part is a reference to the
    // next node of the list.

    /** The value associated with this node in the list. */
    private double data;

    /**
     * The link to the next node in the list, or null if this is the last node
     * in the the list.
     */
    private DoubleNode link;

    /**
     * Initializes a node with a specified initial data and link to the next
     * node. Note that the initialLink may be the null reference, which
     * indicates that the new node has nothing after it.
     * 
     * @param initialData
     *            the initial data of this new node
     * @param initialLink
     *            a reference to the node after this new node &ndash; this
     *            reference may be null to indicate that there is no node after
     *            this new node.
     * 
     * @postcondition This node contains the specified data and link to the next
     *                node.
     */
    public DoubleNode(double initialData, DoubleNode initialLink)
    {
        data = initialData;
        link = initialLink;
    }

    /**
     * No-args constructor.
     */
    public DoubleNode()
    {
        data = 0.0;
        link = null;
    }

    /**
     * Constructor takes an initial value.
     * 
     * @param value
     *            The data value for the new node.
     */
    public DoubleNode(double value)
    {
        data = value;
        link = null;
    }

    /**
     * Add a new node after this node.
     * 
     * @param item
     *            the data to place in the new node
     * 
     * @postcondition A new node has been created and placed after this node.
     *                The data for the new node is item. Any other nodes that
     *                used to be after this node are now after the new node.
     */
    public void addNodeAfter(double item)
    {
        link = new DoubleNode(item, link);
    }

    /**
     * Accessor method to get the data from this node.
     * 
     * @return the data from this node
     */
    public double getData()
    {
        return data;
    }

    /**
     * Gets a reference to the next node after this node.
     * 
     * @return a reference to the node after this node (or the null reference if
     *         there is nothing after this node).
     */
    public DoubleNode getLink()
    {
        return link;
    }

    /**
     * Builds a copy of the specified list, returning only a reference to the
     * head of the copy.
     * 
     * @param source
     *            the head of a linked list that will be copied (that may be an
     *            empty list in where source is null)
     * 
     * @return the head reference for the copy.
     * 
     * @postcondition The method has made a copy of the linked list starting at
     *                source.
     */
    public static DoubleNode listCopy(DoubleNode source)
    {
        DoubleNode copyHead = null;

        // Handle the special case of the empty list.
        if (source != null)
        {
            // Make the first node for the newly created list.
            copyHead = new DoubleNode(source.data, null);
            DoubleNode copyTail = copyHead;

            // Make the rest of the nodes for the newly created list.
            while (source.link != null)
            {
                source = source.link;
                copyTail.addNodeAfter(source.data);
                copyTail = copyTail.link;
            }
        }

        // Return the head reference for the new list.
        return copyHead;
    }

    /**
     * Build a copy of the specified list, returning both a head and tail
     * reference for the copy.
     * 
     * @param source
     *            the head of a linked list that will be copied (that may be an
     *            empty list in where source is null)
     * 
     * @return an array where the [0] element is a head reference for the copy
     *         and the [1] element is a tail reference for the copy.
     * 
     * @postcondition The method has made a copy of the linked list starting at
     *                source.
     */
    public static DoubleNode[] listCopyWithTail(DoubleNode source)
    {
        DoubleNode[] answer = new DoubleNode[2];

        // Handle the special case of the empty list.
        if (source != null)
        {
            // Make the first node for the newly created list.
            DoubleNode copyHead = new DoubleNode(source.data, null);
            DoubleNode copyTail = copyHead;

            // Make the rest of the nodes for the newly created list.
            while (source.link != null)
            {
                source = source.link;
                copyTail.addNodeAfter(source.data);
                copyTail = copyTail.link;
            }

            // Return the head and tail references.
            answer[0] = copyHead;
            answer[1] = copyTail;
        }

        return answer;
    }

    /**
     * Computes the number of nodes in a linked list.
     * 
     * @param head
     *            the head reference for a linked list (that may be an empty
     *            list with a null head)
     * 
     * @return the number of nodes in the list with the given head
     */
    public static int listLength(DoubleNode head)
    {
        int answer;

        answer = 0;
        for (DoubleNode cursor = head; cursor != null; cursor = cursor.link)
        {
            answer++;
        }

        return answer;
    }

    /**
     * Copies part of a list, returning a head and tail reference for the new
     * copy.
     * 
     * @param start
     *            a reference to a DoubleNode that represents the starting point
     *            for the copy.
     * 
     * @param end
     *            a reference to a DoubleNode that represents the ending point
     *            for the copy.
     * 
     * @precondition start and end are non-null references to nodes on the same
     *               linked list, with the start node at or before the end node.
     * 
     * @return The return value is an array where the [0] component is a head
     *         reference for the copy and the [1] component is a tail reference
     *         for the copy.
     * 
     * @postcondition The method has made a copy of the part of a linked list,
     *                from the specified start node to the specified end node.
     *                The original list has not been changed.
     * 
     * @throws IllegalArgumentException
     *             Indicates that start and end are not references to nodes on
     *             the same list.
     * 
     * @throws NullPointerException
     *             Indicates that start or end is null.
     */
    public static DoubleNode[] listPart(DoubleNode start, DoubleNode end)
        throws IllegalArgumentException, NullPointerException
    {
        if (start == null)
        {
            throw new NullPointerException("start may not be null");
        }
        if (end == null)
        {
            throw new NullPointerException("end may not be null");
        }

        DoubleNode cursor;

        // Make the first node for the newly created list. Notice that this will
        // cause a NullPointerException if start is null.
        DoubleNode copyHead = new DoubleNode(start.data, null);
        DoubleNode copyTail = copyHead;
        cursor = start;

        // Make the rest of the nodes for the newly created list.
        while (cursor != end)
        {
            cursor = cursor.link;
            if (cursor == null)
            {
                throw new IllegalArgumentException("end node was not found "
                        + "on the list");
            }
            copyTail.addNodeAfter(cursor.data);
            copyTail = copyTail.link;
        }

        // Return the head and tail references
        DoubleNode[] answer = new DoubleNode[2];
        answer[0] = copyHead;
        answer[1] = copyTail;

        return answer;
    }

    /**
     * Finds a node at a specified position in a linked list.
     * 
     * @param head
     *            the head reference for a linked list (that may be an empty
     *            list in which case the head is null)
     * @param position
     *            a node number
     * 
     * @precondition position &gt; 0.
     * 
     * @return The return value is a reference to the node at the specified
     *         position in the list. (The head node is position 1, the next node
     *         is position 2, and so on.) If there is no such position (because
     *         the list is too short), then the null reference is returned.
     * 
     * @throws IllegalArgumentException
     *             Indicates that position is not positive.
     */
    public static DoubleNode listPosition(DoubleNode head, int position)
        throws IllegalArgumentException
    {
        if (position <= 0)
        {
            throw new IllegalArgumentException("Position is not positive: "
                    + position);
        }

        DoubleNode cursor = head;
        for (int i = 1; (i < position) && (cursor != null); i++)
        {
            cursor = cursor.link;
        }

        return cursor;
    }

    /**
     * Searches for a particular piece of data in a linked list.
     * 
     * @param head
     *            the head reference for a linked list (that may be an empty
     *            list in which case the head is null)
     * @param target
     *            a piece of data to search for
     * 
     * @return a reference to the first node that contains the specified target.
     *         If there is no such node, the null reference is returned.
     */
    public static DoubleNode listSearch(DoubleNode head, double target)
    {
        DoubleNode targetNode = null;

        for (DoubleNode cursor = head; targetNode == null
                && cursor != null; cursor = cursor.link)
        {
            if (target == cursor.data)
            {
                targetNode = cursor;
            }
        }

        return targetNode;
    }

    /**
     * Removes the node after this node in a linked list.
     * 
     * @precondition This node must not be the tail node of the list.
     * 
     * @postcondition The node after this node has been removed from the linked
     *                list. If there were further nodes after that one, they are
     *                still present on the list.
     * 
     * @throws NullPointerException
     *             Indicates that this was the tail node of the list, so there
     *             is nothing after it to remove.
     */
    public void removeNodeAfter() throws NullPointerException
    {
        /*
         * Thanks to Daniel Wilkins (CS 2440 student, Fall 2015) for finding 
         * an error in checking for the last element in the list.  Previously, 
         * it checked "if (link.link == null)."
         */
        if (link == null)
        {
            throw new NullPointerException("Cannot remove the node after the"
                    + "last node in the list.");
        }
        link = link.link;
    }

    /**
     * Sets the data in this node of a linked list.
     * 
     * @param newData
     *            the new data to place in this node
     * 
     * @postcondition The data of this node has been set to newData.
     */
    public void setData(double newData)
    {
        data = newData;
    }

    /**
     * Set the link to the next node after this node.
     * 
     * @param newLink
     *            a reference to the node that should appear after this node in
     *            the linked list, or the null reference if there is no node
     *            after this node.
     * 
     * @postcondition The link to the node after this node has been set to
     *                newLink. Any other node that used to be in this link is no
     *                longer connected to this node.
     */
    public void setLink(DoubleNode newLink)
    {
        link = newLink;
    }
}
