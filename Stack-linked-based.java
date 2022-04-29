package com.mycompany.mavenproject2;

/**
 *
 * @author Ali
 * @param <StackEntry>
 */
class StackNode<StackEntry> {

    StackEntry entry;
    StackNode next;

    // constructor
    public StackNode(StackEntry entry, StackNode next) {
        this.entry = entry;
        this.next = next;
    }

}

public class Stack<StackEntry> {

    private StackNode top;
    private int size;

    // constructor
    public Stack() {
        top = null;
        size = 0;
    }

    /* Pre: The stack exists and is initialized.
       Post: The argument item has been stored at the top of the stack */
    public void push(StackEntry e) {

        StackNode pn = new StackNode(e, this.top);
        top = pn;
        size++;
    }

    /* Pre: The stack exists and it is not empty.
       Post: The item at the top of the stack has been removed and returned */
    public StackEntry pop() {

        StackEntry pe;
        StackNode pn;

        // save current value before i free it
        pe = (StackEntry) top.entry;
        
        // free node that will delete
        pn = top;
        top = top.next;
        pn = null;
        size--;
        
        return pe;
    }
    
    /* Pre: The stack is initialized and not empty
       Post: The last element entered is returned */
    public StackEntry StackTop() {

        return (StackEntry) top.entry;
    }
    
    /* Pre: The stack exists
       Post: returns the status, 1 or 0 */
    public int StackEmpty() {

        return (top == null) ? 1 : 0;
    }
    
    /* Pre: The stack exists
       Post: returns the status, 1 becouse it depend on memory size */
    public int StackFull() {

        return 0;
    }
    /* Pre: The stack exists
       Post: All the elements freed */

    public int ClearStack() {
        StackNode pn = top;

        while (pn != null) {
            pn = pn.next;
            top = null;
            top = pn;
        }
        size = 0;
        return 0;
    }
    /* Pre: The stack exists
       Post: returns the number of elements */

    public int StackSize() {
        return size;
    }
}
