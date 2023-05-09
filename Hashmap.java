package CS_Hashmap;

public interface Hashmap<K, V>
{
	
	public V get(Object key);
	
	public boolean isEmpty();
	
	public V put(K key, V value);
	
	public int size();
	

}
