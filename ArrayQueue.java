// package Practice07;

/**
 * Mark Codd
 * Prof. David Guy Brizan
 * TA: Razan Said
 * CS 245-01
 *
 * ArrayQueue class
 * ----------------
 * Implementation of Queue data structure using arrays
 * Allows user to dequeue, enqueue, and check if array is empty
 *
 * @param <T> arr: Template for data structure
 */

public class ArrayQueue<T> implements Queue<T> {

    private T[] arr;  // array of type T
    private int size;  // current size of array
    private int ARRAY_SIZE = 10;  // size of initial array

    /**
     * Function: ArrayQueue
     * --------------------
     * Constructor for class. Initializes array with size ARRAY_SIZE.
     */
    public ArrayQueue(){
        this.arr = (T[])new Object[ARRAY_SIZE];  // initializes size of array
        this.size = 0;  // initializes size of queue
    } // end constructor

    /**
     * Function: grow_array
     * --------------------
     * Doubles the size of the array when needed by
     * the program.
     * Used in function enqueue()
     */
    private void grow_array(){
        int n = this.arr.length + ARRAY_SIZE;  // doubles size of array
        T[] copyArray = (T[]) new Object[n];  // creates new array
        System.arraycopy(this.arr, 0, copyArray, 0, this.arr.length);  // copies current array into new array
        this.arr = copyArray;  // assigns reference to new array
    } // end grow_array()

    /**
     * Function: dequeue
     * -----------------
     * Returns the first element in array and pushes all other elements
     * one position forward.
     * @return data: element at position zero.
     * @throws Exception: empty queue
     */
    public T dequeue() throws Exception {
        if(this.empty()){
            throw new Exception("Queue is empty");
        }
        T data = this.arr[0];  // first element to be returned

        for(int i = 1; i < this.arr.length; i++)
            this.arr[i - 1] = this.arr[i];  // moves elements forward O(n)

        this.size--;  // decreases the size of queue

        return data;
    } // end dequeue

    /**
     * Function: enqueue
     * -----------------
     * Adds element to the back of the array
     * @param item: item to be added
     */
    public void enqueue(T item){
        if(this.arr.length == this.size){
            grow_array();  // grows array if needed
        }
        this.arr[this.size++] = item;  // adds element to the end and increments size
    } // end enqueue()

    /**
     * Function: empty
     * ---------------
     * checks to see if array is empty using variable size
     * @return bool: size of array
     */
    public boolean empty(){
        return this.size == 0;  // checks if empty
    } // end empty()
} // end ArrayQueue
