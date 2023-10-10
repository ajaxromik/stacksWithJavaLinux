import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/05/23
 * Submitted:  10/05/23
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.10.05
 */

public class Lab5P2Driver {
    
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        StackInterface<Sample> myStack;
        try{
            myStack = (StackInterface<Sample>)Class.forName(args[0]).newInstance();
        }
        catch(Exception e) {
            myStack = new StackRA<Sample>();
        }

        Bag<Package> deliveryBag = new Bag(myStack); //TODO make sure this doesn't have them work on the same thing
        Bag<Sample> sampleBag = new Bag(myStack); // i don't think it should since java passes by value

        System.out.println("\nSelect from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t\t1. Pick up order\n"
                           +"\t\t2. Drop off order\n"
                           +"\t\t3. Display delivery bag info: number of packages, weight, and content\n"
                           +"\t\t4. Display samples bag info: number of samples, weight, and content\n"
                           +"\t\t5. Enjoy an item from samples bag\n"
                           +"\t\t5. Enjoy all the samples in the samples bag\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                pushOrder(deliveryBag);
                break;
            case 2:
                dropOrder(deliveryBag, sampleBag);
                break;
            case 3:
                bagInfo("Delivery",deliveryBag);
                break;
            case 4:
                bagInfo(sampleBag);
                break;
            case 5:
                enjoySample(sampleBag);
                break;
            case 6:
                enjoyAllSamples(sampleBag);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        double inputDouble;
        try {
            inputDouble = Double.parseDouble(stdin.readLine().trim());
            System.out.print(inputDouble);
        } catch(Exception ex) {
            inputDouble = 0;
        }
        return inputDouble;
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        int inputDouble;
        try {
            inputDouble = Integer.parseInt(stdin.readLine().trim());
            System.out.print(inputDouble);
        } catch(Exception ex) {
            inputDouble = 0;
        }
        return inputDouble;
    }

    public static void pushOrder(Bag b) throws IOException{
        System.out.print("Please specify package info: "+
                         "\nitem name: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        double itemWeight = readDouble("item weight: ");
        int numItems = readInt("number of items: ");

        System.out.print("is this a healthy item?(Y/N): ");
        char healthy = 
        (stdin.readLine().toUpperCase().trim().charAt(0));
        System.out.println(healthy);

        System.out.print("sender: ");
        String sender = stdin.readLine().trim();
        System.out.println(sender);

        System.out.print("reciever: ");
        String reciever = stdin.readLine().trim();
        System.out.println(reciever);

        try{
            b.addItem(new Package(itemName, itemWeight, 
            numItems, healthy == 'Y', sender, reciever));

            System.out.printf("A package of %ss, each weighing %.2f"+
                " lbs are now in the delivery bag.%n%n", itemName, itemWeight);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void dropOrder(Bag<String> stack) {
        if(stack.isEmpty())
            System.out.println("Stack is empty\n\n");
        else {
            System.out.printf("Item %s popped from"+
                              " the stack.%n%n", stack.pop());
        }
    }

    public static void topItem(Bag<String> stack) {
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
    public static void printStack(Bag<String> stack) {
        if(stack == null || stack.isEmpty())
            System.out.print("Stack is empty.\n\n");
        else
            System.out.printf("Stack has the following items: %s%n%n",
                               stack.toString());
    }

    public static void clearStack(Bag<String> stack) {
        stack.popAll();
        System.out.println();
    }

}