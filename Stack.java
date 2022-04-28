package com.mycompany.mavenproject2;

/**
 *
 * @author Ali
 * @param <StackEntry>
 */
public class Stack<StackEntry> {

    private final Object[] entry;
    private final int MAXSTACK;
    private int top;

    // constructor
    public Stack() {
        MAXSTACK = 10;
        entry = new Object[MAXSTACK];
        this.top = 0;
    }

    public Stack(int MAXSTACK) {
        this.MAXSTACK = MAXSTACK;
        entry = new Object[MAXSTACK];
        this.top = 0;
    }
    
    /* Pre: The stack is initialized and not full
       Post: The element e has been stored at the top of the stack; and e does not change*/
    public void Push(StackEntry e) {

        entry[top++] = e;
    }
    
    /* Pre: The stack is initialized and not empty
       Post: The last element entered is returned*/
    public StackEntry Pop() {

        return (StackEntry) entry[--top];
    }
    
    /* Pre: The stack is initialized and not empty
       Post: The last element entered is returned*/
    public int StackEmpty() {
        return (top == 0) ? 1 : 0;
    }
    
    /* Pre: The stack is initialized and not full
       Post: The new element entered is inserted*/
    public int StackFull() {
        return (top == MAXSTACK) ? 1 : 0;
    }
    
    /* Pre: The stack is initialized and not empty
       Post: The last element entered is returned*/
    public StackEntry StackTop() {
        return (StackEntry) entry[top - 1];
    }
    
    /* Pre: Stack is initialized.
       Post: returns how many elements exist.*/
    public int StackSize() {
        return top;
    }
    
    /* Pre: Stack is initialized.
       Post: destroy all elements; stack looks initialized.*/
    public void ClearStack() {
        top = 0;
    }   
    
}
