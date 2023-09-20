import java.util.ArrayList;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 09/19/22
 * Submitted:  09/19/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.19
 */

public class ListArrayListBased implements ListInterface{

    protected ArrayList<Object> items;

    public ListArrayListBased() {
        items = new ArrayList<Object>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void add(int index, Object item) throws ListIndexOutOfBoundsException {
        items.add(index, item);
    }

    public Object get(int index) throws ListIndexOutOfBoundsException {
        return items.get(index);
    }

    public Object remove(int index) throws ListIndexOutOfBoundsException {
        return items.remove(index);
    }

    public void removeAll() {
        items.clear();
    }

}