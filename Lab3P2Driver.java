import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 09/26/22
 * Submitted:  09/26/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.26
 */

public class Lab3P2Driver {
    
    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        MyListReferenceBased myList = new MyListReferenceBased();

        System.out.println("Select from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t1. Insert item into the list\n"
                           +"\t2. Remove item from the list\n"
                           +"\t3. Get item from the list\n"
                           +"\t4. Clear the list\n"
                           +"\t5. Display size and content of the list\n"
                           +"\t6. Delete the smallest and largest item in the list\n"
                           +"\t7. Reverse the list\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                addToList(myList);
                break;
            case 2:
                removeFromList(myList);
                break;
            case 3:
                getFromList(myList);
                break;
            case 4:
                emptyList(myList);
                break;
            case 5:
                printList(myList);
                break;
            case 6:
                displayAndDeleteLargeAndSmall(myList);
                break;
            case 7:
                reverseList(myList);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

    public static void addToList(ListInterface list) throws IOException{
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

    public static void removeFromList(ListInterface list) throws IOException{
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

    public static void getFromList(ListInterface list) throws IOException{
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

    public static void emptyList(ListInterface list) {
        list.removeAll();
        System.out.println();
    }

    /**
     * Prints list after checking for null/empty
     * @param list
     */
    public static void printList(ListInterface list) {
        if(list == null || list.size() == 0)
            System.out.println("\tList is empty.\n");
        else
            System.out.printf("\tList of size %d has the following items: %s%n%n",
                              list.size(), list.toString());
    }

    /**
     * Assumes the list is not empty and that indices has a length of 2
     */
    private static void findIndexLargeAndSmall(MyListReferenceBased list, int[] indices) {
        indices[0] = -1;
        indices[1] = -1;
        int listSize = list.size();

        if(listSize == 1) {
            indices[0] = 0;
        } else if(listSize > 0) {

            String minString = (String)list.get(0);
            indices[0] = 0;
            String maxString = (String)list.get(0);
            indices[1] = 0;

            for(int i = 1; i < listSize; i++) {
                String current = (String)list.get(i);
                if(minString.compareTo(current) > 0) { 
                // if the current string is smaller than the min
                    minString = current;
                    indices[0] = i;

                } else if (maxString.compareTo(current) < 0) { 
                // else if the current string is bigger than the max
                    maxString = current;
                    indices[1] = i;

                } //otherwise nothing changes
            }
        }
    }

    public static void displayAndDeleteLargeAndSmall(MyListReferenceBased list) {
        int[] indices = new int[2];
        findIndexLargeAndSmall(list, indices);

        if(indices[0] == -1)
            System.out.println("List empty, nothing to delete!\n");
        else if(indices[1] == -1)
            System.out.printf("Item %s deleted.%n%n", list.remove(0));
        else {
            if(indices[0] > indices[1])
                System.out.printf("Smallest item %s and largest item %s deleted.%n%n",
                    list.remove(indices[0]), list.remove(indices[1]));
            else
                System.out.printf("Smallest item %s and largest item %s deleted.%n%n",
                    list.remove(indices[0]), list.remove(indices[1]-1));
        }

    }

    public static void reverseList(MyListReferenceBased list) {
        if(list == null || list.size() == 0)
            System.out.println("List is empty.. nothing to reverse!\n");
        else {
            int listSize = list.size();
            for(int i = 0; i < listSize; i++) {
                //'current' starts at the last index,
                // but traverses the array by values of each index changing
                Object current = list.get(listSize-1);
                list.add(i, current); // add current to first pos
                list.remove(listSize); // removes where current was
            }
            System.out.printf("List has been reversed.\n" +
                " Here is the content: %s%n%n",
                list.toString());
        }
    }

}