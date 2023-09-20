
/*
 * Purpose: Data Structure and Algorithms Lab 2 Extra Credit
 * Status: Complete and thoroughly tested
 * Last update: 09/19/22
 * Submitted:  09/19/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.19
 */

public class ListArrayBasedPlusMore extends ListArrayBasedPlus {

    /**
     * More efficient version of add
     */
    public void add(int index, Object item) {
        resize();
        if (index >= 0 && index <= numItems)
        {
            System.arraycopy(items, index, items, index+1, numItems - index);
            items[index] = item;
            numItems++;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }
    }

}