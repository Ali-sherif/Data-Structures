package com.mycompany.mavenproject2;

// import java.util.Arrays;  using will cause run time error becouse array cant be cast to ListEntry
/**
 *
 * @author Ali
 * @param <ListEntry>
 */
public class List<ListEntry> {

    private int size;
    private int MAXSIZE;
    private Object[] entry;

    public List() {
        size = 0;
        MAXSIZE = 10;
        entry = new Object[MAXSIZE];
    }

    public List(int MAXSIZE) {
        this();
        this.MAXSIZE = MAXSIZE;
        entry = new Object[MAXSIZE];
    }

    public int listEmpty() {
        return (size == 0) ? 1 : 0;
    }

    public int listFull() {
        return (size == MAXSIZE) ? 1 : 0;
    }

    public void distroyList() {
        size = 0;
    }

    public int ListSize() {
        return size;
    }

    // same precondition as DeleteList. And the list is unchanged
    public ListEntry retrieveList(int p) {
        return (ListEntry) entry[p];
    }

    // same precondition as DeleteList. And the list is unchanged
    public void replaceList(int p, ListEntry e) {
        entry[p] = e;
    }

    /* Precondition: 
        1- The list pl has been created.
        2- not 0 <= p <= size
       Postcondition: 
        1- e has been inserted at position p
        2- all elements at old positions p, p+1, …, size-1 are incremented by 1.
        3- size increases by 1.
     */
    // The loop shifts up all the elements in 	the range [p, size-1] to free the pth 	location 
    public void insertList(int p, ListEntry e) {

        for (int i = size - 1; i >= p; i--) {
            entry[i + 1] = entry[i];
        }
        entry[p] = e;
        size++;
    }

    /*
    Precondition: The list pl has been created, not empty, and 0 <= p <= size-1.
    Postcondition: e has been retrieved from position p, and all elements at old positions p+1, …, size-1 are decremented by 1. size decreases by 1.
     */
 /*The loop shifts down all the elements in 	the range [p+1, size-1] to free the pth 	location*/
    public ListEntry deleteList(int p) {
        ListEntry e = (ListEntry) entry[p];
        for (int i = p + 1; i <= size - 1; i++) {
            entry[i - 1] = entry[i];
        }
        size--;

        return e;
    }
}
