import java.io.*;

/*
 * Purpose: Data Structure and Algorithms Lab 2 EC Extra Credit
 * Status: Complete and thoroughly tested
 * Last update: 09/19/22
 * Submitted:  09/19/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.19
 */

public class Lab2ECDriver {

    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        ListArrayBasedPlusMore myList = new ListArrayBasedPlusMore();

        System.out.println("Select from the following menu:\n"
                           +"\t0. Exit program\n"
                           +"\t1. Insert item into the list\n"
                           +"\t2. Remove item from the list\n"
                           +"\t3. Get item from the list\n"
                           +"\t4. Clear the list\n"
                           +"\t5. Print size and content of the list\n"
                           +"\t6. Reverse the list\n");

        int selection;
        boolean continuing = true;
        do {

            System.out.print("Make your menu selection now: ");
            selection = Integer.parseInt(stdin.readLine().trim());
            System.out.println(selection);

            switch(selection) {
            case 1:
                Lab2P1Driver.addToList(myList);
                break;
            case 2:
                Lab2P1Driver.removeFromList(myList);
                break;
            case 3:
                Lab2P1Driver.getFromList(myList);
                break;
            case 4:
                Lab2P1Driver.emptyList(myList);
                break;
            case 5:
                Lab2P1Driver.printList(myList);
                break;
            case 6:
                Lab2P1Driver.reverseList(myList);
                break;
            default: // continuing unless told to stop
                continuing = false;
                System.out.println("Exiting program... Goodbye!");
                break;
            }

        } while(continuing);

    }

}