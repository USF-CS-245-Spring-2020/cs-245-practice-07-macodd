// package Practice07;

/**
 * Mark Codd
 * Prof. David Guy Brizan
 * TA: Razan Said
 * CS 245-01
 *
 * ArrayStack class
 * ----------------
 * Implementation of Stack data structure using arrays
 * Allows user to pop, push, peek, and check if array is empty
 *
 * @param <T> arr: Template for data structure
 */

public class ArrayStack<T> implements Stack<T> {

    private T[] arr;  // array of type T
    private int top;  // current top of array
    private int ARRAY_SIZE = 10;  // size of initial array

    /**
     * Function: ArrayStack
     * --------------------
     * Constructor for class. Initializes array with size ARRAY_SIZE.
     */
    public ArrayStack(){
        this.arr = (T[]) new Object[ARRAY_SIZE];  // initializes size of array
        this.top = -1;  // initializes top of stack
    } // end constructor

    /**
     * Function: grow_array
     * --------------------
     * Doubles the size of the array when needed by
     * the program.
     * Used in function push()
     */
    private void grow_array(){
        int n = this.arr.length + ARRAY_SIZE;  // doubles size of array
        T[] copyArray = (T[]) new Object[n];  // creates new array
        System.arraycopy(this.arr, 0, copyArray, 0, this.arr.length);  // copies current array into new array
        this.arr = copyArray;  // assigns reference to new array
    } // end grow_array()

    /**
     * Function: push
     * --------------
     * adds item to end of array and assigns it as the top of stack
     * @param item: element to be added
     */
    public void push(T item){
        if(this.top == this.arr.length - 1)
            grow_array();  // checks to see if array needs to be double in size

        this.arr[++this.top] = item;  // increments top and assigns item to it
    } // end push()

    /**
     * Function: pop
     * -------------
     * returns elemnt located at index top and assigns top to element at top minus one
     * @return T: element at index top
     * @throws Exception: empty stack
     */
    public T pop() throws Exception{
        if(this.empty()){
            throw new Exception("Stack is empty");
        }
        return this.arr[this.top--]; // returns element and then decreases index top
    } // end pop()

    /**
     * Function: peek
     * --------------
     * checks element at index top without modifying array
     * @return T: element at index top
     * @throws Exception: empty stack
     */
    public T peek() throws Exception{
        if(this.empty()){
            throw new Exception("Stack is empty");
        }
        return this.arr[this.top];  // returns element at index top
    } // end peek()

    /**
     * Function: empty
     * ---------------
     * checks to see if array is empty using variable size
     * @return bool: size of array
     */
    public boolean empty(){
        return this.top == -1;
    } // end empty()
} // end Stack
