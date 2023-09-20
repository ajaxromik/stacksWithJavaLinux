import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/19/22
 * Submitted:  09/19/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.19
 */

public class Lab2P1Driver {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        ListArrayBasedPlus myList = new ListArrayBasedPlus();

        System.out.println("Select from the following menu:\n"
            +"\t0. Exit program\n"
            +"\t1. Insert item into the list\n"
            +"\t2. Remove item from the list\n"
            +"\t3. Get item from the list\n"
            +"\t4. Clear the list\n"
            +"\t5. Print size and content of the list\n"
            +"\t6. Reverse the list\n");
    
        int selection, position;
        boolean continuing = true;
        String itemName;
        Object returned;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
                case 1:
                    System.out.print("You are now inserting an item"+
                    " into the list.\n\tEnter item: ");
                    itemName = stdin.readLine().trim();
                    System.out.println(itemName);

                    System.out.print("\tEnter position to insert item in: ");
                    position = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(position);
                    if(position < 0 || position > myList.size())
                        System.out.println("Position specified is out of range!\n");
                    else {
                        myList.add(position, itemName);
                        System.out.printf("Item %s inserted into"+
                    " position %d in the list.%n%n", itemName, position);
                    }
                    break;
                case 2:
                    System.out.print("\tEnter position to remove item from: ");
                    position = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(position);
                    if(position < 0 || position >= myList.size())
                        System.out.println("Position specified is out of range!\n");
                    else {
                        returned = myList.remove(position);
                        System.out.printf("Item %s removed from"+
                    " position %d in the list.%n%n", returned.toString(), position);
                    }
                    break;
                case 3:
                    System.out.print("\tEnter position to retrieve item from: ");
                    position = Integer.parseInt(stdin.readLine().trim());
                    System.out.println(position);
                    if(position < 0 || position >= myList.size())
                        System.out.println("Position specified is out of range!\n");
                    else {
                        returned = myList.get(position);
                        System.out.printf("Item %s retrieved from"+
                    " position %d in the list.%n%n", returned.toString(), position);
                    }
                    break;
                case 4:
                    myList.removeAll();
                    System.out.println();
                    break;
                case 5:
                    printList(myList);
                    break;
                case 6:
                    myList.reverse();
                    System.out.println("List reversed\n");
                    break;
                default: // continuing unless told to stop
                    continuing = false;
                    System.out.println("Exiting program... Goodbye!");
                    break;
            }

        }while(continuing);
        
    }

    /**
     * Prints list after checking for null/empty
     * @param list
     */
    private static void printList(ListArrayBasedPlus list) {
        if(list == null || list.size() == 0)
            System.out.println("\tList is empty.\n");
        else
            System.out.printf("\tList of size %d has the following items: %s%n%n", 
            list.size(), list.toString());
    }

}