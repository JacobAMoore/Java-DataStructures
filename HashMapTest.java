package CS_Hashmap;

public class HashMapTest 
{

	public static void main(String[] args) 
	{
		
		System.out.println("Open Addressing");
		HashMapOpen <Integer, String> openHash = new HashMapOpen<>();
		
		System.out.println("Is openHash empty? " + openHash.isEmpty());
		openHash.put(0, "Moore");
		openHash.put(1, "Geller");
		openHash.put(2, "Williams");
		openHash.put(3, "Tribiani");
		openHash.put(4, "Bing");
		
		//display all the key pair values in the hash map
		openHash.printAll();
		
		//display value at a given key
		System.out.println(openHash.get(2));
		
		openHash.put(3, "new value");
		
		openHash.printAll();
		
		openHash.put(5, "after last");
		
		openHash.printAll();
		
		openHash.get(6);

	}

}
