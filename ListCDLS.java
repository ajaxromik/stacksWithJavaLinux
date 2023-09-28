
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/28/22
 * Submitted:  09/28/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.28
 */

public class ListCDLS implements ListInterfaceR 
{
  
  private DNode head; 
  private int numItems;

  public ListCDLS() 
  {
    head = null;
    numItems = 0;
  }

  public String toString() {
    DNode current = head;
    StringBuilder result = new StringBuilder();

    for(int i = 0; i < numItems; i++) {
      result.append((i == 0 ? "" : " ") + current.getItem().toString());
      current = current.getNext();
    }

    return result.toString();
  }

  public String toStringR() {
    DNode current = head;
    StringBuilder result = new StringBuilder();

    for(int i = numItems-1; i >= 0; i--) {
      current = current.getBack();
      result.append((i == numItems-1 ? "" : " ") + current.getItem().toString());
    }

    return result.toString();
  }

  public boolean isEmpty() 
  {
    return (head == null);
  } 

  public int size() 
  {
    return numItems;
  }

  /**
   * Finds the Dnode, assuming that the index is valid
   */
  private DNode find(int index) 
  {
    DNode curr = head;

    if(index <= numItems/2) {
      for(int i = 0; i < index; i++) {
        curr = curr.getNext();
      }
    }
    else {
      for(int i = numItems; i > index; i--) {
        curr = curr.getBack();
      }
    }

    return curr;
  }

  public Object get(int index) 
                throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < numItems)
      return find(index).getItem();
    else 
    {
      throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
    }
  }

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < numItems+1) 
    {
      if (index == 0) 
      {
        DNode back = head.getBack();
        DNode newDNode = new DNode(item, head, back);
        head.setBack(newDNode);
        this.head = newDNode;
        back.setNext(newDNode);
      } 
      else 
      {
        DNode prev = find(index-1);
        DNode next = prev.getNext();
        DNode newDNode = new DNode(item, next, prev);
        next.setBack(newDNode);
        prev.setNext(newDNode);
      }
    } 
    else 
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    }
  }

  public Object remove(int index) 
                   throws ListIndexOutOfBoundsException 
  { Object result;
    if (index >= 0 && index < size()) 
    {
      if (index == 0) 
      {
        // delete the first node from the list
        result = head.getItem();
        head = head.getNext();
      } 
      else 
      {
        Node prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        Node curr = prev.getNext(); 
        result = curr.getItem();
        prev.setNext(curr.getNext());
      }
    }
    else 
    {
      throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
    }
    return result;
  }

  public void removeAll() 
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage 
    // collection
    head = null;
  }
}