package com.mycompany.mavenproject2;

/**
 *
 * @author Ali
 * @param <QueueEntry>
 */
class QueueNode<QueueEntry> {

    QueueEntry entry;
    QueueNode next;

    public QueueNode(QueueEntry entry, QueueNode next) {
        this.entry = entry;
        this.next = next;
    }
}

public class Queue<QueueEntry> {

    private QueueNode front;
    private QueueNode rear;
    private int size;

    // constructor
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }


    /* Pre: The queue is initialized and not full
       Post: The element e has been stored at the rear of the queue; */
    public int enqueue(QueueEntry e) {

        QueueNode pn = new QueueNode(e, null);
        
        if(pn == null) // if it cannot create object for any reason
            return 0;
     
        /*  there is a special case becouse if it first element in queue becouse // run time error
             1- rear.next = null
             2- front still ref for null value so we need to make it point to the only node exist
         */
        if (rear == null) {
            front = rear = pn;

        } else {
            rear.next = pn;
            rear = pn;
        }
        pn = null;
        size++;
        
        return 1;
        
    }

    /* Pre: The queue is initialized and not empty
       Post: The first element entered is returned*/
    public QueueEntry dequeue() {

        QueueNode pn = front;
        QueueEntry pe = (QueueEntry) pn.entry; // becouse i want to free pn 

        front = pn.next;
        pn = null;
        /*
          there is a special case becouse if it there on;y one element in queue becouse // run time error
           1- front will point to null and rear still point to removed node // 1
         */
        if (front == null) {
            rear = null;
        }
        size--;

        return pe;
    }

    /* Pre: The queue is initialized and not empty
       Post: The first element entered is returned*/
    public QueueEntry retrive() {

        return (QueueEntry) front.entry;
    }

    /* Pre: The queue is initialized and not empty
       Post: returned 1 or 0*/
    public int queueEmpty() {

        return (size == 0) ? 1 : 0; // we can use rear or front if there equal to null 
    }

    /* Pre: The queue is initialized and not full
       Post: returned 1 or 0 */
    public int queueFull() {

        return 0;
    }

    /* Pre: queue is initialized.
       Post: destroy all elements; queue looks initialized.*/
    public void clearQueue() {

        while (front != null) {
            rear  = front.next;   // 1 2 3 4 5
            front = null;  
            front = rear; 
        }
        size = 0;
    }

    /* Pre: queue is initialized.
       Post: returns how many elements exist */
    public int queueSize() {

        return size;
    }
}
