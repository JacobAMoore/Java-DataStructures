package CS_Set;

import java.util.Iterator;

public class CSSetTest 
{

	public static void main(String[] args)
	{
		
		String[] hockey = {"Chicago", "Detroit", "New York", "Boston", "Buffalo", "Florida", "Montreal", "Ottawa", "Tampa Bay", "Toronto"};
		String[] baseball = {"Detroit", "Chicago", "New York", "Baltimore", "Cleveland", "Pheonix", "Atlanta", "Houston", "Boston"};
		
		
		CSSet<String> setHockey = new CSSet<>();
		CSSet<String> setBaseball = new CSSet<>();
		
		for(String s : hockey)
		{
			setHockey.add(s);
		}

		for(String s : baseball)
		{
			setBaseball.add(s);
		}
		
		System.out.println(setHockey.toString());
		System.out.println(setBaseball.toString());
		
		System.out.println("Does Hockey have Houston? " + setHockey.contains("Houston"));
		System.out.println("Does Hockey have Chicago? " + setHockey.contains("Chicago"));
		
		//intersects() test
		System.out.println("Intersection");
		System.out.println(setHockey.intersects(setBaseball));
		
		//union() test
		System.out.println("Union");
		System.out.println("Before Union: " +setHockey.toString());
		System.out.println(setHockey.union(setBaseball));
		System.out.println("After Union: " + setHockey.toString());
		
		//floor() test
		System.out.println("Floor");
		System.out.println(setHockey.floor("Chattanooga"));
		
		//ceiling() test
		System.out.println("Ceiling");
		System.out.println(setHockey.ceiling("Chattanooga"));
		
		//Create an Iterator to setBaseball
		Iterator<String> setBaseballIter = setBaseball.iterator();
		while(setBaseballIter.hasNext())
		{
			String nextItem = setBaseballIter.next();
			System.out.println(nextItem);
		}
		
		
		//test of the delete() and equals() methods
		System.out.println(setBaseball.toString());
		setBaseball.delete("Chicago");
		System.out.println(setBaseball.toString());
		
		System.out.println(setBaseball.equals(null));
		System.out.println(setBaseball.equals(setBaseball));
		System.out.println(setBaseball.equals(setHockey));
		
		//test of the min() and max() methods
		System.out.println(setBaseball.min());
        System.out.println(setBaseball.max());		
        
		
	}

}
