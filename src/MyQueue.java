// Queue implementation from the book with some edits
public class MyQueue {
    private int maxSize;
    private Item[] queArray;
    private int front;
    private int rear;
    private int nItems;
    private String name;

    public MyQueue(String name, int size) {
        maxSize = size;
        queArray = new Item[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        this.name = name;
    }

    public void insert(Item j) {
        if (rear == maxSize-1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public Item remove() {
        Item temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public Item peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public void displayQueue() {
        System.out.print(name + " (front -> rear) : ");
        MyQueue tempQueue = this;

        if (nItems == 0)
        {
            System.out.print("empty");
        }

        for(int i = 0; i < nItems; i++) {
            if (i != nItems-1) {
                System.out.print(tempQueue.remove() + ",  ");
            } else {
                System.out.print(tempQueue.remove());
            }
        }
        System.out.println("");
    }
}
