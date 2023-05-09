package CS_Stack;

import CS_FlightApplication.CommercialFlight;

public class LinkedStackTest 
{

	public static void main(String[] args) 
	{
		
		//create LinkedStack object
		LinkedStack<Integer> stack = new LinkedStack<>();
		
		//test isEmpty before populating stack
		System.out.println("Before adding " + stack.isEmpty());
		
		//populate stack
		for(int i = 0; i < 10; i++)
		{
			stack.push(i);
		}
		
		System.out.println("After adding " + stack.isEmpty());
		
		while(!stack.isEmpty())
		{
			System.out.println("Pop: " + stack.pop());
		}
		
		
		//create Stack of CommercialFlights
		LinkedStack<CommercialFlight> flights = new LinkedStack<CommercialFlight>();
		
		//populate Stack of Flights
		flights.push(new CommercialFlight(1, 0, "123", "Chicago", "Chattanooga", 0, 0, 0, 0, "B52", 0, 0, 0));
		flights.push(new CommercialFlight(2, 0, "456", "Detroit", "Chattanooga", 0, 0, 0, 0, "AWACS", 0, 0, 0));
		
		//check if stack is empty
		System.out.println("isEmpty? " + flights.isEmpty());
	
		
		//pop all of the elements in Flights stack
		System.out.println("Pop all: " + flights.popAll());
		
		System.out.println("Pop all Integers: \n" + stack.popAll());
		
		

	}

}
