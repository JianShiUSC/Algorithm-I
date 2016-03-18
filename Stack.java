public class Stack<Item>    //generic type name
{
    private Node first = null;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }
}


//Stack iterator: linked-list implementation
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
{
    ...
    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()    { return current != null; }
        public void remove()        { /* not supported */ }
        public Item next()
        {
            Item item = current.item;
            current   = current.next;
            return item;
        }
    }
}


//stack iteration: array implementation
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
{
    ...
    public Iterator<Item> iterator()
    { return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;

        public boolean hasNext()    { return i > 0; }
        public void remove()        { /* not supported */ }
        public Item next()          { return s[--i]; }
    }
}
