import java.util.ArrayList;

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

public class ListArrayListBased extends ListArrayListBased {

    public String toString() {
        return items.toString();
    }

    public void reverse() {
        int size = items.size();
        for(int i = 0; i < size/2; i++) {
            Object temp = items.get(i);
            items.set(i, items.get(size-1-i));
            items.set(size-1-i, temp);
        }
    }

    public void add(int index, Object item) {
        resize();
        super.add(index, item);
    }

    public void resize() {
        int currentLen = items.size();
        if(numItems == currentLen) // if max is reached
            items.ensureCapacity(currentLen*2);
    }

}