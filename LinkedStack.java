package CS_Stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInt<E>
{
	//Reference to the first stack node
	private Node<E> topOfStackRef = null;
	
	
	@Override
	public E push(E obj) 
	{
		topOfStackRef = new Node<E>(obj, topOfStackRef);
		return obj;
		
	}

	@Override
	public E peek() 
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			return topOfStackRef.data;
		}
		
	}

	@Override
	public E pop() 
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			E result = topOfStackRef.data;
			topOfStackRef = topOfStackRef.next;
			return result;
		}
	}
	
	
	/*
	 * as long as the Stack is populated
	 * pops all elements in the stack
	*/
	public ArrayList<E> popAll()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			ArrayList<E> elements = new ArrayList<E>();
			while(!isEmpty())
			{
			elements.add(pop());
			}
	    return elements;
		}
	}
	

	@Override
	public boolean isEmpty() 
	{
		return topOfStackRef == null;
	}
	
	
	//inner Node class for working with each item in the Stack
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		
		
		private Node(E dataItem)
		{
			data = dataItem;
			next = null;
		}
		
		private Node(E dataItem, Node<E> nodeRef)
		{
			data = dataItem;
			next = nodeRef;
		}
			
	}
	
	
	
	

}
