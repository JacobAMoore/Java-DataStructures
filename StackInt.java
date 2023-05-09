package CS_Stack;

public interface StackInt<E> 
{
	
	/**
	 * Pushes an item onto the top of the stack and returns the item pushed
	 * @param obj The object to be inserted
	 * @return The object inserted
	 */
	E push(E obj);
	
	
	/*
	 * Returns the object at the top of the stack without removing it.
	 */
	E peek();
	
	
	/*
	 * Returns the object at the top stack and removes it
	 */
	E pop();
	
	/*
	 * Determines if the stack is empty
	 */
	boolean isEmpty();
	
	
	
	

}
