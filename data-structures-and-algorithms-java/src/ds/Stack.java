/**
 * Java has a built-in class called Stack in java.util package
 * But here we define our own Stack interface  
 */

package ds;

public interface Stack {
    //accessor methods
	public int size();
	public boolean isEmpty() throws StackEmptyException ;
	public Object top();
	
	//update methods
	public void push(Object element);
	public Object pop() throws StackEmptyException;    
}
