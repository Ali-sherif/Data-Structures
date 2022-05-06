package com.mycompany.mavenproject2;

// import java.util.Arrays;  using will cause run time error becouse array cant be cast to ListEntry
/**
 *
 * @author Ali
 * @param <ListEntry>
 */
class ListNode<ListEntry> {

    ListEntry entry;
    ListNode next;

    public ListNode(ListEntry entry, ListNode next) {
        this.entry = entry;
        this.next = next;
    }
}

public class List<ListEntry> {

    private int size;
    private ListNode head;

    public List() {
        size = 0;
        head = null;
    }

    public int listEmpty() {
        return (size == 0) ? 1 : 0; // or  head != null
    }

    public int listFull() {
        return 0;
    }

    public void distroyList() {
        ListNode pq;
        pq = head;
        while (head != null) {
            pq = head.next;
            head = null;
            head = pq;
        }
        pq = null;
        size = 0;

    }

    public int ListSize() {
        return size;
    }

    // same precondition as DeleteList. And the list is unchanged
    public ListEntry retrieveList(int p) {

        ListNode pn = head;
        int i = 0;
        for (; i < p; i++) {
            pn = pn.next;
        }

        return (ListEntry) pn.entry;
    }

    // same precondition as DeleteList. And the list is unchanged
    public void replaceList(int p, ListEntry e) {
        ListNode pn = head;
        int i = 0;
        for (; i < p; i++) {
            pn = pn.next;
        }
        pn.entry = e;
        pn = null;
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

        ListNode pn = new ListNode(e, null);
        ListNode pq;
        if (p == 0) {
            pn.next = head;
            head = pn;
        } else {
            pq = head;
            for (int i = 0; i < p - 1; i++) {
                pq = pq.next;
            }
            pn.next = pq.next;
            pq.next = pn;

        }
        size++;

    }

    /*
    Precondition: The list pl has been created, not empty, and 0 <= p <= size-1.
    Postcondition: e has been retrieved from position p, and all elements at old positions p+1, …, size-1 are decremented by 1. size decreases by 1.
     */
 /*The loop shifts down all the elements in 	the range [p+1, size-1] to free the pth 	location*/
    public ListEntry deleteList(int p) {

        ListNode pn;
        ListNode pq;

        if (p == 0) {
            pn = head;
            head = head.next;
        
        } else {
            pq = head;
            for (int i = 0; i < p - 1; i++) {
                pq = pq.next;
            }
            pn = pq.next;
            pq = pq.next.next;
        }
        size--;
        return (ListEntry) pn.entry;
    }
}
