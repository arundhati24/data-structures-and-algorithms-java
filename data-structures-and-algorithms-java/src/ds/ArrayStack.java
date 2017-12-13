/**
 * Implementation of the Stack interface using an array
 */

package ds;

import java.util.*;

public class ArrayStack {
    
    private static final int CAPACITY = 1024;    //default capacity of the stack
    private static final String STACK_EMPTY = "Stack is Empty!";
    private static final String STACK_FULL = "Stack is Full!";
    
    private static int mCapacity;               //maximium capacity of the stack
    private static Object mStack[];         //holds the elements of the stack
    private static int mTopIndex = -1;           //the topmost element of the stack
    
    /**
     * Initializes the stack with default capacity
     */
    public ArrayStack(){
        mCapacity = CAPACITY;
    }
    
    /**
     * Initializes the stack with capacity {@param size} 
     * @param size
     */
    public ArrayStack(int size){
        mCapacity = size;
        mStack = new Object[mCapacity];
    }
    
    /**
     * Returns the current size of the Stack
     */
    public static int size(){
        return (mTopIndex + 1);
    }
    
    /**
     * Returns true if the Stack is empty
     */
    public static boolean isEmpty(){
        return (mTopIndex < 0);
    }
    
    /**
     * Pushes a new element to the Stack
     * @param obj
     * @throws StackFullException 
     */
    public static void push(Object obj) throws StackFullException{
        
        if(size() == mCapacity){
            throw new StackFullException(STACK_FULL);
        }
        mStack[++mTopIndex] = obj;
    }
    
    /**
     * Returns the topmost element of the Stack 
     * without deleting it from the Stack
     * @return
     * @throws StackEmptyException 
     */
    public static Object top() throws StackEmptyException{
        
        if(isEmpty()){
            throw new StackEmptyException(STACK_EMPTY);
        }
        
        return mStack[mTopIndex];
    }
    
    /**
     * Pops off the topmost element of the Stack 
     * @return
     * @throws StackEmptyException 
     */
    public static Object pop() throws StackEmptyException{
        
        Object element;
        
        if(isEmpty()){
            throw new StackEmptyException(STACK_EMPTY);
        }
        element = mStack[mTopIndex];
        mStack[mTopIndex--] = null;
        
        return element;
    }
    
    public static void display(){
        
        if(isEmpty()){
            throw new StackEmptyException(STACK_EMPTY);
        }
        
        for(int i = mTopIndex ; i >= 0 ; i--){
            System.out.println(mStack[i]);
        }
    }
    
    /**
     * Driver function to test all other functions
     * @param args 
     */
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int capacity, ch;
        
        System.out.println("Enter the size of the Stack...");
        capacity = sc.nextInt();
        
        ArrayStack arrayStackObj = new ArrayStack(capacity);
        
        while(true){
            
            System.out.println("Enter your choice as per the following menu :\n");
            System.out.println("1 - Push an element into the Stack \n"
                    + "2 - Pop an element off the Stack \n"
                    + "3 - Check the topmost element of the Stack \n"
                    + "4 - Check the current size of the Stack \n"
                    + "5 - Check the capacity of the Stack \n"
                    + "6 - Display Stack elements");
            ch = sc.nextInt();
        
            switch(ch){
                case 1 :
                    System.out.println("Enter an element to be pushed...");
                    int element = sc.nextInt();
                    arrayStackObj.push(element);
                break;
            
                case 2 :
                    System.out.println("Popped element : " + arrayStackObj.pop());
                break;
            
                case 3 : 
                    System.out.println("Topmost element of the Stack : " 
                            + arrayStackObj.top());
                break;
                 
                case 4 : 
                    System.out.println("Current size of the Stack : " 
                            + arrayStackObj.size());
                break;
            
                case 5 :
                    System.out.println("Capacity of the Stack : " + mCapacity);
                break;
            
                case 6 : 
                    System.out.println("Stack elements : ");
                    arrayStackObj.display();
                break;
            
                default : 
                    System.out.println("Invalid choice! Please try again!");
            }
            
            System.out.println("Press 1 to continue or 0 to exit...");
            int choice = sc.nextInt();
            
            if(choice != 1){
                System.exit(0);
            }
        }
    }
}
    
