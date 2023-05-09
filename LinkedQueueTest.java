package CS_Queue;

import CS_FlightApplication.CommercialFlight;

public class LinkedQueueTest 
{

	public static void main(String[] args) 
	{
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		
		for(int i = 0; i < 10; i++)
		{
			queue.enqueue(i);
		}
		
		System.out.println(queue.toString());
		
		while(!queue.isEmpty())
		{
			System.out.println(queue.dequeue());
		}
		
		//Queue filled with Commercial Flight objects
		System.out.println("Commercial Flights Queue: ");
		LinkedQueue<CommercialFlight> flights = new LinkedQueue<CommercialFlight>();
		flights.enqueue(new CommercialFlight(1, 0, "123", "Chicago", "Chattanooga", 0, 0, 0, 0, "B52", 0, 0, 0));
		flights.enqueue(new CommercialFlight(2, 0, "456", "Detroit", "Chattanooga", 0, 0, 0, 0, "AWACS", 0, 0, 0));
		
		while(!flights.isEmpty())
		{
			System.out.println(flights.dequeue());
		}

	}

}
