// Please note that this code is slightly different from the textbook code 
//to reflect the fact that the Node class is implemented using data encapsulation


// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface 
{
  // reference to linked list of items
  private Node head; 

  public ListReferenceBased() 
  {
    head = null;
  }  // end default constructor

  public String toString() { // TODO do not use get or find

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
    if (index >= 0 && index < numItems+1) 
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
      } // end if
      numItems++;
    } 
    else 
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }  // end add

  public Object remove(int index) 
                   throws ListIndexOutOfBoundsException 
  { Object result;
    if (index >= 0 && index < numItems) 
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
      } // end if
      numItems--;
    } // end if
    else 
    {
      throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
    } // end if
    return result;
  }   // end remove

  public void removeAll() 
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage 
    // collection
    head = null;
    numItems = 0;
  } // end removeAll

} // end ListReferenceBased