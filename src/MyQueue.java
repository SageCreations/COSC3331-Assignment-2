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

        if (isEmpty()) {
            System.out.println("empty");
            return;
        }

        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queArray[i] + " ");
            }
        } else {
            // from front to end of array
            for (int i = front; i < maxSize; i++) {
                System.out.print(queArray[i] + " ");
            }
            // from start of array to rear
            for (int i = 0; i <= rear; i++) {
                System.out.print(queArray[i] + " ");
            }
        }


        System.out.println("");
    }
}
