
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
      result.append(current.toString());
      current = current.getNext();
    }

    return result.toString();
  }

  public String toStringR() {
    DNode current = head;
    StringBuilder result = new StringBuilder();

    for(int i = numItems-1; i >= 0; i--) {
      current = current.getBack();
      result.append(current.toString());
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
      if(head == null) 
      {
        this.head = new DNode(item);
      }
      else if (index == 0) 
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
      numItems++;
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
    if (index >= 0 && index < numItems) 
    {
      if(numItems == 1)
      {
        head = null;
      }
      else if (index == 0) 
      {
        // delete the first node from the list
        result = head.getItem();
        DNode next = head.getNext();
        DNode back = head.getBack();
        back.setNext(next);
        next.setBack(back);
        this.head = next;
      } 
      else 
      {
        DNode prev = find(index-1);
        DNode target = prev.getNext();
        DNode next = target.getNext();
        result = target.getItem();
        prev.setNext(next);
        next.setBack(prev);
      }
      numItems--;
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