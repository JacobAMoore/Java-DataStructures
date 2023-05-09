package CS_Hashmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class HashMapChain<K, V> implements Cloneable
{
	/**
	 * The array holding the elements in the table. 
	 */
	private LinkedList<Entry<K, V>>[] table;
	
	/**
	 * The number of keys in this table.
	 * @author 12052
	 */
	private int numKeys;
	private static final int INITIAL_CAPACITY = 13;
	private static final double LOAD_THRESHOLD = 3.0;
	
	
	
	private static class Entry<K, V>
	{

		private K key;
		private V value;
		
		/**
		 * Creates new key-value pair
		 * @param key The key
		 * @param value The value
		 */
		private Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
			System.out.println("New entry made.");
		}
		
		@Override
		public boolean equals(Object other)
		{
			return other instanceof Entry && key.equals(((Entry<K, V>)other).key);
		}
		
		@Override
		public int hashCode()
		{
			int hash = 5;
			hash = 41 * hash + Objects.hashCode(this.key);
			hash = 41 * hash + Objects.hashCode(this.value);
			return hash;
		}
		
		@Override
		public String toString()
		{
			return "(" + key + " " + value + ")";
		}
	}
	
	/**
	 * Construct empty hash table
	 */
	public HashMapChain()
	{
		table = new LinkedList[INITIAL_CAPACITY];
		System.out.println("New table built");
	}
	
	public V get(K key)
	{
		System.out.println("in get " + key);
		int index = hash(key);
		
		if(table[index] != null) 
		{
			for(Entry<K, V> nextItem: table[index])
			{
				if(nextItem.key.equals(key))
				{
					return nextItem.value;
				}
			}
		}
		return null;	
	}
	
	public void put(K key, V value)
	{
		System.out.println("In put: " + key + " " + value);
		int index = hash(key);
		
		if(table[index] == null)
		{
			//create new linked list at table[index]
			table[index] = new LinkedList<>();
		}
		
		//Search list at the table[index] to find the key
		for(Entry<K, V> nextItem : table[index])
		{
			//if search successful replace old value
			if(nextItem.key.equals(key))
			{
				nextItem.value = value;
				return;
			}
		}
		
		table[index].addFirst(new Entry<>(key, value));
		numKeys++;
		double loadFactor = (double)numKeys / table.length;
	}

	
	public boolean containsKey(K key)
	{
		int index = hash(key);
		return table[index] != null && table[index].contains(new Entry<>(key, null));
	}
	
	
	private int hash(K key)
	{
		return(key.hashCode() & 0x7fffffff) % table.length;
	}
	
	public int size()
	{
		return numKeys;
	}
	
	public boolean isEmpty()
	{
		return numKeys == 0;
	}
	
	//Remove a key-value pair from this table
	public void remove(K key)
	{
		int index = hash(key);
		
		if(table[index] != null && table[index].remove(new Entry<K,V>(key, null)))
		{
			numKeys--;
		}
	}
	
	private void rehash()
	{
		System.out.println("Rehashing... " + Arrays.toString(table));
		LinkedList<Entry<K,V>>[] oldTable = table;
		
		table = new LinkedList[2 * table.length];
		numKeys = 0;
		
		for(LinkedList<Entry<K,V>> l : oldTable)
		{
			if(l != null)
			{
				for(Entry<K,V> e : l)
				{
					put(e.key, e.value);
				}
			}
		}
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder("[");
		for(LinkedList<Entry<K,V>> l : table)
		{
			if(l != null)
			{
				builder.append(l);
				builder.append(" ");
			}
		}
		
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * A faithful copy of the table
	 */
	public HashMapChain<K, V> clone()
	{
		System.out.println("Cloning...");
		try
		{
			HashMapChain<K, V> result = (HashMapChain<K,V>)super.clone();
			result.table = table.clone();
			for(int i = 0; i < table.length; i++)
			{
				result.table[i] = new LinkedList<Entry<K,V>>();
				for(Entry<K,V> e : table[i])
				{
					result.table[i].add(new Entry<K,V>(e.key, e.value));
				}
			}
			return result;
		}
		catch(CloneNotSupportedException e)
		{
			throw new InternalError(e.toString());
		}	
	}
	
	
	public boolean equals(Object other)
	{
		return this == other || other instanceof HashMapChain && equalTables((HashMapChain<K, V>) other);
	}
	
	/**
	 * Checks two tables to see whether or not they are equal tables
	 * @param other The table to compare to
	 * @return boolean true/ false if the tables are equal or not
	 */
	private boolean equalTables(HashMapChain<K,V> other)
	{
		if(numKeys != other.numKeys)
		{
			return false;
		}
		
		for(LinkedList<Entry<K,V>> l : table)
		{
			if(l != null)
			{
				for(Entry<K, V> e : l)
				{
					if(!e.value.equals(other.get(e.key)))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	

}//end of HashMapChain class
