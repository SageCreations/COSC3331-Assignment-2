import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void displayOutputArray(Item[] arr) {
        System.out.print("OutputArray: ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.print(arr[i].toString());
            } else {
                System.out.print("0:0");
            }
            if (i == arr.length - 1) {
                System.out.println("");
            } else {
                System.out.print(",  ");
            }
        }
    }

    public static void displayStep(MyStack A, MyStack B, MyQueue Q, Item[] arr) {
        A.displayStack();
        B.displayStack();
        Q.displayQueue();
        displayOutputArray(arr);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        int size;
        boolean acceptedSize = false;
        do {
            System.out.print("Please give the set a size between 1 and 20 inclusive: ");

            size = reader.nextInt();


            if (size >= 1 && size <= 20) {
                acceptedSize = true;
                reader.close();
            } else {
                System.out.println("Your number is not in the valid range, try again.");
            }
        } while (!acceptedSize);


        MyStack stackOne = new MyStack("Stack 1", size);
        MyStack stackTwo = new MyStack("Stack 2", size);
        MyQueue queue = new MyQueue("Queue", size);

        Item tempMax = new Item(0, 0);
        Item[] outputArray = new Item[size];

        for (int i = 0; i < size; i++) {
            int randomKey = rand.nextInt(10) + 1;
            Item item = new Item(randomKey, i + 1);

            // store the max sized item into a variable
            if (tempMax.getKey() <= item.getKey()) {
                tempMax = item;
            }

            while (!stackOne.isEmpty() && stackOne.peek().getKey() > item.getKey()) {
                stackTwo.push(stackOne.pop()); // push stackOne's top into stackTwo

                displayStep(stackOne, stackTwo, queue, outputArray); // display output of step
            }

            stackOne.push(item);

            displayStep(stackOne, stackTwo, queue, outputArray); // display output of step

            // once the item is pushed into stackOne, we can push everything back over.
            while (!stackTwo.isEmpty()) {
                stackOne.push(stackTwo.pop()); // push stackTwo's top back into stackOne

                displayStep(stackOne, stackTwo, queue, outputArray); // display output of step
            }

            // empty the queue
            while (!queue.isEmpty()) {
                queue.remove();
            }

        }






    }


}