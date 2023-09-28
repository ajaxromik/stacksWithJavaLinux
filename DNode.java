
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
 
public class DNode 
{
  private Object item;
  private DNode next;
  private DNode back;

  public DNode(Object item) 
  {
    this.item = item;
    this.next = this;
    this.back = this;
  }

  public DNode(Object item, DNode next, DNode back) 
  {
    this.item = item;
    this.next = next;
    this.back = back;
  } 

  public void setItem(Object newItem) 
  {
    item = newItem;
  }

  public Object getItem() 
  {
    return item;
  }

  public void setNext(DNode next) 
  {
    this.next = next;
  }

  public DNode getNext() 
  {
    return next;
  }

  public void setBack(DNode back) 
  {
    this.back = back;
  }

  public DNode getBack() 
  {
    return back;
  }
 
  public String toString()
  { 
    return item+" ";
  }
}