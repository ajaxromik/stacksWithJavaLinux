import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 0
 * Status: Complete and thoroughly tested
 * Last update: 10/05/23
 * Submitted:  10/05/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.10.05
 */

public class Lab5P1Driver {
    
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        StackInterface<String> myStack;
        try{
            myStack = (StackInterface<String>)Class.forName(args[0]).newInstance();
        }
        catch(Exception e) {
            myStack = new StackRA<String>();
        }

        System.out.println(" --- "+args[0]+" ver. --- "
                           +"\nSelect from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t\t1. Push item onto the stack\n"
                           +"\t\t2. Pop item from the stack\n"
                           +"\t\t3. Display the top item of the stack\n"
                           +"\t\t4. Display items in the stack\n"
                           +"\t\t5. Clear the stack\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                pushItem(myStack);
                break;
            case 2:
                popItem(myStack);
                break;
            case 3:
                topItem(myStack);
                break;
            case 4:
                printStack(myStack);
                break;
            case 5:
                clearStack(myStack);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    public static void pushItem(StackInterface<String> stack) throws IOException{
        System.out.print("You are now inserting an item"+
                         " onto the top of the stack.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        stack.push(itemName);
        System.out.printf("Item %s inserted onto"+
                          " the top of the stack.%n%n", itemName);
    }

    public static void popItem(StackInterface<String> stack) {
        if(stack.isEmpty())
            System.out.println("Stack is empty\n\n");
        else {
            System.out.printf("Item %s popped from"+
                              " the stack.%n%n", stack.pop());
        }
    }

    public static void topItem(StackInterface<String> stack) {
        if(stack.isEmpty())
            System.out.println("Stack is empty\n\n");
        else {
            System.out.printf("Item %s retrieved from"+
                              " the top of the stack.%n%n", 
                              stack.peek());
        }
    }

    /**
     * Prints stack after checking for null/empty
     * @param stack
     */
    public static void printStack(StackInterface<String> stack) {
        if(stack == null || stack.isEmpty())
            System.out.print("Stack is empty.\n\n");
        else
            System.out.printf("Stack has the following items: %s%n%n",
                               stack.toString());
    }

    public static void clearStack(StackInterface<String> stack) {
        stack.popAll();
        System.out.println();
    }

}