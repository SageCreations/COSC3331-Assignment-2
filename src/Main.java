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
                System.out.print("   ");
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

        // instantiation portion and get first max key
        for (int i = 0; i < size; i++) {
            displayStep(stackOne, stackTwo, queue, outputArray);

            int randomKey = rand.nextInt(10) + 1;
            Item item = new Item(randomKey, i + 1);

            // this will cause stable sorting by resetting the max key even with duplicates.
            // it will push duplicates into the stack in a sorted timeStamp order.
            if (tempMax.getKey() <= item.getKey()) {
                Item temp = tempMax;
                tempMax = item;
                if(temp.getKey() != 0) {
                    stackOne.push(temp);
                }
                outputArray[outputArray.length-1] = tempMax; // just to display the temp max changes
            } else {
                stackOne.push(item);
            }
        }

        for(int i = outputArray.length-1; i >= 0; i--) {
            // will be empty on first pass
            if (!queue.isEmpty()) {
                int constant = queue.size();
                for (int j = (i-constant)+1; j <= i; j++) {
                    outputArray[j] = queue.remove();
                    displayStep(stackOne, stackTwo, queue, outputArray);
                }
                i -= constant;
            }

            outputArray[i] = tempMax; // slot the max into the output array.
            displayStep(stackOne, stackTwo, queue, outputArray);

            tempMax = new Item(0, 0);

            while (!stackOne.isEmpty()) {
                // will cause stable sorting on each change
                // this version ends up storing the smallest timeStamp duplicate
                if (tempMax.getKey() <= stackOne.peek().getKey()) {
                    // stable sorting
                    Item temp = tempMax;
                    tempMax = stackOne.pop();
                    if (temp.getKey() != 0) {
                        stackTwo.push(temp);
                    }
                } else {
                    // just push
                    stackTwo.push(stackOne.pop());
                }
                displayStep(stackOne, stackTwo, queue, outputArray);
            }

            // now with the confirmed new MaxItem
            while(!stackTwo.isEmpty()) {
                // check for duplicates
                if (stackTwo.peek().getKey() == tempMax.getKey()) {
                    //insert dupes into the queue
                    queue.insert(stackTwo.pop());
                } else {
                    // or just pass it back to stackOne, need stackTwo for getting reverse order of queue.
                    stackOne.push(stackTwo.pop());
                }
                displayStep(stackOne, stackTwo, queue, outputArray);
            }
        }
    }
}