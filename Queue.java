package com.mycompany.mavenproject2;

/**
 *
 * @author Ali
 * @param <QueueEntry>
 */
public class Queue<QueueEntry> {

    private int front;
    private int rear;
    private int size;
    private int MAXSIZE;
    private Object[] entry;
    
    // constructor
    public Queue() {
        
        front = 0;
        rear = -1;
        size = 0;
        MAXSIZE = 10;
        entry = new Object[MAXSIZE];
    }

    public Queue(int MAXSIZE) {
        this();
        this.MAXSIZE = MAXSIZE;
        entry = new Object[MAXSIZE];
    }

     /* Pre: The queue is initialized and not full
       Post: The element e has been stored at the rear of the queue; */
    public void enqueue(QueueEntry e) {
        
        rear = (rear + 1) % MAXSIZE;

        size++;
        entry[rear] =  e;
    }
    
     /* Pre: The queue is initialized and not empty
       Post: The first element entered is returned*/
    public QueueEntry dequeue() {
        
        QueueEntry e = (QueueEntry) entry[front];
        front = (front + 1) % MAXSIZE;
        size--;
        
        return e;
    }
    
    /* Pre: The queue is initialized and not empty
       Post: The first element entered is returned*/
    public QueueEntry retrive() {

        return  (QueueEntry) entry[front];
    }
    
    /* Pre: The queue is initialized and not empty
       Post: returned 1 or 0*/
    public int queueEmpty() {

        return (size == 0) ? 1 : 0;
    }
    
    /* Pre: The queue is initialized and not full
       Post: returned 1 or 0 */
    public int queueFull() {

        return (size == MAXSIZE) ? 1 : 0;
    }
    
    /* Pre: queue is initialized.
       Post: destroy all elements; queue looks initialized.*/
    public void clearQueue() {

        front = 0;
        rear = -1;
        size = 0;
    }
    
    /* Pre: queue is initialized.
       Post: returns how many elements exist */
    public int queueSize() {
        
        return size;
    }
}
