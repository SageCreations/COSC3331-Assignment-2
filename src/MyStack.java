// Stack implementation from the book with some edits
public class MyStack {
    private int maxSize;
    private Item[] stackArray;
    private int top;
    private String name;

    public MyStack(String name, int size) {
        maxSize = size;
        stackArray = new Item[maxSize];
        top = -1;
        this.name = name;
    }

    public void push(Item j) {
        stackArray[++top] = j;
    }

    public Item pop() {
        return stackArray[top--];
    }

    public Item peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }

    public void displayStack() {
        System.out.print(name + " (bottom -> top) : ");

        if (isEmpty()) {
            System.out.println("empty");
            return;
        }

        for(int i = 0; i <= top; i++) {
            if (i != top) {
                System.out.print(stackArray[i] + "   ");
            } else {
                System.out.print(stackArray[i]);
            }
        }

        System.out.println("");

    }
}
