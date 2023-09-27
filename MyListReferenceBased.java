
/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 09/26/22
 * Submitted:  09/26/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: William Carr
 * @version: 2023.09.26
 */

public class MyListReferenceBased implements ListInterface 
{
  
  private Node head; 

  public MyListReferenceBased() 
  {
    head = null;
  }

  public String toString() {
    Node current = head;
    StringBuilder result = new StringBuilder();
    boolean first = true;
    while (current != null) {
      result.append((first ? "" : " ")+ current.getItem().toString());
      current = current.getNext();
      if(first)
        first = false;
    }
    return result.toString();
  }

  public boolean isEmpty() 
  {
    return (head == null);
  } 

  public int size() 
  {
    int count = 0;
    Node current = head;
    while(current != null) {
      current = current.getNext();
      count++;
    }
    return count;
  }

  /**
   * Finds the node, assuming that the index is valid
   */
  private Node find(int index) 
  {
    Node curr = head;
    for (int skip = 0; skip < index; skip++) 
    {
      curr = curr.getNext();
    }
    return curr;
  }

  public Object get(int index) 
                throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < size())
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
    if (index >= 0 && index < size()+1) 
    {
      if (index == 0) 
      {
        // insert the new node containing item at
        // beginning of list
        Node newNode = new Node(item, head);
        head = newNode;
      } 
      else 
      {
        Node prev = find(index-1);
        // insert the new node containing item after 
        // the node that prev references
        Node newNode = new Node(item, prev.getNext());
        prev.setNext(newNode);
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