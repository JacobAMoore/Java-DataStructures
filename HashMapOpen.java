package CS_Hashmap;

public class HashMapOpen<K, V> implements Hashmap<K, V>
{
	//data fields
	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 1; //starting capacity low to show many collisions (lecture purposes)
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);
	
	
	//Constructor
	public HashMapOpen()
	{
		table = new Entry[START_CAPACITY];
	}
	
	
	public V remove(Object key)
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	
	private int find(Object key)
	{
		//calculate the starting index
		int index = key.hashCode() % table.length; //<-- pay attention to hashCode
	    if(index < 0)
	    {
	    	index += table.length;
	    }
	    
	    //increment index until empty slot is reached or the key is found
	    while((table[index] != null) && (!key.equals(table[index].key)))
	    {
	    	index++;
	    }
	    //check for wrap around
	    if(index >= table.length)
	    {
	    	index = 0; //wrap around
	    }
	    
	    return index;
	}//end of find() 
	
	
	
	@Override
	public V get(Object key)
	{
		//find the first table element that is empty or table element that contains the key
		int index = find(key);
		
		//if search successful return value
		if(table[index] != null)
		{
			return table[index].value;
		}
		else
		{
			return null; //key not found
		}
				
	}//end of get() 
	
	@Override
	public V put(K key, V value)
	{
		//find the first table element that is empty or table element that contains the key
		int index = find(key);
		
		//if an emepty element was found, insert new entry
		if(table[index] == null)
		{
			table[index] = new Entry<K, V>(key, value);
			numKeys++;
			//check whether rehash is needed
			double loadFactor = (double)(numKeys + numDeletes)/ table.length;
			if(loadFactor > LOAD_THRESHOLD)
			{
				rehash();
				return null;
			}
		}
		
		//Assert: table element that contains the key was found
		//Replace the value for this key
		V oldVal = table[index].value;
		table[index].value = value;
		return oldVal;
	}//end of put() 
	
	@Override
	public int size()
	{
		return numKeys;
	}
	
	private void rehash()
	{
		//save reference to old table
		Entry<K, V>[] oldTable = table;
		
		//double capacity of this table
		int newTableSize = 2 * oldTable.length+1;
		table = new Entry[newTableSize];
		System.out.println("Rehashing from " + oldTable.length + " " + newTableSize);
		
		//Reinsert all items in old table into expanded table
		numKeys = 0;
		numDeletes = 0;
		for(int i = 0; i < oldTable.length; i++)
		{
			if((oldTable[i] != null) && (oldTable[i] != DELETED))
			{
				//insert entry in expanded table
				put(oldTable[i].key, oldTable[i].value);
			}
		}
	}
	
	
	@Override
	public boolean isEmpty()
	{
		return numKeys == 0;
	}
	
	public void printAll()
	{
		for(int i = 0; i < this.numKeys; i++)
		{
			System.out.println(i + " " + this.get(i));
		}
		System.out.println("====");
	}
	
	//internal class
	public static class Entry<K, V>
	{
		/*The key*/
		private K key;
		/*The value*/
		private V value;
		
		/**
		 *Creates new Key Value pair
		 *@param key The key
		 *@param value The value
		 */
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		/**Retrieves the key
		 * @return The key
		 */
		public K getKey()
		{
			return key;
		}
		
		/**
		 * Retrieves the value
		 * @return The value
		 */
		public V getValue()
		{
			return value;
		}
		
		/**
		 * Sets the value
		 * @param The new value
		 * @return The old value
		 */
		public V setValue(V val)
		{
			V oldVal = value;
			value = val;
			return oldVal;
		}
		 
		
	}//end of inner Entry class

}//end of HashMapOpen class
