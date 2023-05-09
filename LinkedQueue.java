package CS_Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Iterable<E>
{
	private int n; //number of elements on queue
	private Node first; //beginning of queue
	private Node last; //end of queue
	
	
	//initialize an empty queue
	public LinkedQueue()
	{
		first = null;
	    last = null;
	}
	
	/*
	 * Is this queue empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return first == null;
	}
	
	//returns size of queue
	public int size()
	{
		return n;
	}
	
	/**
	 * Returns the item least recently added to this queue
	 */
	public E element()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Queue under-flow");
		}
		
		return first.item;
	}
	

	public E peek()
	{
		if(isEmpty())
		{
			return null;
		}
		
		return first.item;
	}
	
	/**
	 * Adds new item into the Queue and then increments queues size 'n'
	 * @param item
	 */
	public void enqueue(E item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
		{
			first = last;
		}
		else
		{
			oldlast.next = last;
		}
		n++;
	}
	
	/**
	 * Removes an element from queue at the back of queue?
	 * @param item
	 *
	 */
	public void remove(E item)
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Queue under-flow");
		}
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
	}
	
	/**
	 * Does not throw exception
	 * @return item or null if list is empty
	 */
	public E poll()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			E item = first.item;
			first = first.next;
			n--;
			return item;
		}
	}
	
	/**
	 * Remove and returns item that was least recently added.
	 * @return the item on this queue least recently added
	 *@throws java.util.NoSuchElementException
	 */
	public E dequeue()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Queue under-flow");
		}
		else
		{
			E item = first.item;
			first = first.next;
			n--;
			if(isEmpty())
			{
				last = null; //avoid loitering
			}
			return item;
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for(E item: this)
		{
			s.append(item + " "); 
		}
		return s.toString();
	}
	
	
	@Override
	public Iterator<E> iterator() 
	{
		return new ListIterator();
	}
	
	//inner Node class for the Queue
	private class Node
	{
		private E item;
		private Node next;
			
	}
	
	//inner iterator class to iterate through the Queue
	private class ListIterator implements Iterator<E>
	{
		private Node current = first;
		
		//checks if the Iterable list is populated at the next element
		public boolean hasNext()
		{
			return current != null;
		}
		
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
		//traverses to next element in the queue
		public E next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				E item = current.item;
				current = current.next;
				return item;
			}
		}

	}

	
}
