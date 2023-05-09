package CS_Set;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class CSSet<E extends Comparable<E>> implements Iterable<E> 
{

	private TreeSet<E> set;
	
	//no arg constructor
	public CSSet()
	{
		set = new TreeSet<>();
	}
	
	
	//arg constructor
	public CSSet(CSSet<E> x)
	{
		set = new TreeSet<E>(x.set);
	}
	
	
	/**
	 * Add this key to the set
	 * @param key
	 * @return true if successful or not
	 */
	public boolean add(E key)
	{
		if(key == null)
		{
			throw new IllegalArgumentException("Called add() with a null key");
		}
		set.add(key);
		return true;
	}
	
	public boolean delete(E key)
	{
		if(key == null)
		{
			throw new IllegalArgumentException("called delete() with a null key");
		}
		set.remove(key);
		return true;
	}
	
	
	public boolean contains(E key)
	{
		if(key == null)
		{
			throw new IllegalArgumentException("Called delete() with a null key");
		}
		return set.contains(key);
		
	}
	
	/*
	 * Returns number of keys in the set
	 */
	public int size()
	{
		return set.size();
	}
	
	
	/*
	 * Checks to see if the set is empty
	 */
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	/**
	 * Returns all of the keys in this set, as an iterator.
	 */
	@Override
	public Iterator<E> iterator()
	{
		return set.iterator();
	}
	
	
	public E max()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Called max() on empty set");
		}
		return set.last();
	}
	
	
	public E min()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Called min() on empty set");
		}
		return set.first();
	}
	
	
	public E ceiling(E key)
	{
		if(key == null)
		{
			throw new IllegalArgumentException("Called ceiling() with null kehy");
		}
		E k = set.ceiling(key);
		if(k == null)
		{
			throw new NoSuchElementException("all keys are less than" + key);
		}
		return k;
	}
	
	
	public E floor(E key)
	{
		if(key == null)
		{
			throw new IllegalArgumentException("Called floor() with a null key");
		}
		E k = set.floor(key);
		if(k == null)
		{
			throw new NoSuchElementException("all keys are greater than" + key);
		}
		return k;
	}
	
	/**
	 * Checks the smaller set for shared values between the two sets this and that
	 * @param that The list to be compared to this.obj
	 * @return c The list containing the values shared between this and that
	 */
	public CSSet<E> union(CSSet<E> that)
	{
		if(that == null)
		{
			throw new IllegalArgumentException("called Union() with null key");
		}
		CSSet<E> c = new CSSet<>();
		for(E x : this)
		{
			c.add(x);
		}
		for(E x : that)
		{
			c.add(x);
		}
		return c;
	}
	
	public CSSet<E> intersects(CSSet<E> that)
	{
		if(that == null)
		{
			throw new IllegalArgumentException("Called intersects() with null argument");
		}
		CSSet<E> c = new CSSet<>();
		if(this.size() < that.size())
		{
			for(E x : this)
			{
				if(that.contains(x))
				{
					c.add(x);
				}
			}
		}
		else
		{
			for(E x : that)
			{
				if(this.contains(x))
				{
					c.add(x);
				}
			}
		}
		return c;
	}
	
	
	/**
	 * Checks whether or not two sets are equal
	 */
	@Override
	public boolean equals(Object other)
	{
		if(other == this)
			{
				return true;
			}
		if(other == null)
			{
				return false;
			}
		if(other.getClass() != this.getClass())
			{
				return false;
			}
		
		CSSet that = (CSSet) other;
		return this.set.equals(that.set);
	}

	public String toString()
	{
		String s = set.toString();
		return "{ " + s.substring(1, s.length() - 1) + " }";
	}
	
	@Override
	public int hashCode()
	{
		throw new UnsupportedOperationException("hashCode() is not supported because sets are mutable");
	}
}
