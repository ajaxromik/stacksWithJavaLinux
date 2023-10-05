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

public class Lab4P1Driver {
    
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        StackRA myList = new StackRA();

        System.out.println("Select from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t1. Push item onto the stack\n"
                           +"\t2. Pop item from the stack\n"
                           +"\t3. Display the top item of the stack\n"
                           +"\t4. Display items in the stack\n"
                           +"\t5. Clear the stack\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                pushItem(myList);
                break;
            case 2:
                popItem(myList);
                break;
            case 3:
                topItem(myList);
                break;
            case 4:
                printStack(myList);
                break;
            case 5:
                clearStack(myList);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    //TODO
    public static void pushItem(StackInterface list) throws IOException{
        System.out.print("You are now inserting an item"+
                         " into the list.\n\tEnter item: ");
        String itemName = stdin.readLine().trim();
        System.out.println(itemName);

        System.out.print("\tEnter position to insert item in: ");
        int position = Integer.parseInt(stdin.readLine().trim());
        System.out.println(position);
        if(position < 0 || position > list.size())
            System.out.println("Position specified is out of range!\n");
        else {
            list.add(position, itemName);
            System.out.printf("Item %s inserted into"+
                              " position %d in the list.%n%n", itemName, position);
        }
    }

    //TODO
    public static void popItem(StackInterface list) throws IOException{
        System.out.print("\tEnter position to remove item from: ");
        int position = Integer.parseInt(stdin.readLine().trim());
        System.out.println(position);
        if(position < 0 || position >= list.size())
            System.out.println("Position specified is out of range!\n");
        else {
            System.out.printf("Item %s removed from"+
                                " position %d in the list.%n%n", list.remove(position).toString(), position);
        }
    }

    //TODO
    public static void topItem(StackInterface list) throws IOException{
        System.out.print("\tEnter position to retrieve item from: ");
        int position = Integer.parseInt(stdin.readLine().trim());
        System.out.println(position);
        if(position < 0 || position >= list.size())
            System.out.println("Position specified is out of range!\n");
        else {
            System.out.printf("Item %s retrieved from"+
                              " position %d in the list.%n%n", list.get(position).toString(), position);
        }
    }

    /**
     * Prints list after checking for null/empty
     * @param list //TODO
     */
    public static void printStack(StackInterface list) {
        if(list == null || list.size() == 0)
            System.out.print("List is empty.\n");
        else
            System.out.printf("List of size %d has the following items: %s%n",
                              list.size(), list.toString());
    }

    public static void emptyList(StackInterface list) { // TODO
        list.removeAll();
        System.out.println();
    }

}