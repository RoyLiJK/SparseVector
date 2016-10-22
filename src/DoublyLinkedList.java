import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import javax.xml.crypto.Data;

public class DoublyLinkedList<AnyType> implements List<AnyType>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> prev;
    private Node<AnyType> next;

    public Node(AnyType d, Node<AnyType> p, Node<AnyType> n)
    {
      setData(d);
      setPrev(p);
      setNext(n);
    }

    public AnyType getData() { return data; }

    public void setData(AnyType d) { data = d; }

    public Node<AnyType> getPrev() { return prev; }

    public void setPrev(Node<AnyType> p) { prev = p; }

    public Node<AnyType> getNext() { return next; }

    public void setNext(Node<AnyType> n) { next = n; }
  }

  private int theSize;
  private int modCount;
  private Node<AnyType> header;
  private Node<AnyType> trailer;

  public DoublyLinkedList()
  {
    header = new Node<AnyType>(null, null, null);
    trailer = new Node<AnyType>(null, null, null);
    modCount = 0;
    clear();
  }

  public void clear()
  {
    header.setNext(trailer);
    trailer.setPrev(header);
    theSize = 0;
  }

  public int size()
  {
    return theSize;
  }

  public boolean isEmpty()
  {
    return (size() == 0);
  }

  public AnyType get(int index) // Write code here to implement this method.
  {
	  Node p = header;
    for(int i = 0; i< index; i++)
    {
    	p =p.getNext();
    	  
    }
    	return (AnyType) p;
  }

  public  AnyType set(int index, AnyType newValue) // Write code here to implement this method.
  {
	  if (index < 0  || index > size()) 
      {
          String message = String.valueOf(index);
          throw new IndexOutOfBoundsException(message);
      }
      
      // Index is at least 0
      if (index == 0)
      {
          // New element goes at beginning
          Node p = header;            // Old first
          header = new Node(newValue, p, null);
          if (p != null)
              p.prev = header;             
          if (trailer == null)
        	  trailer = header;
          
      }
      
      // pred will point to the predecessor of the new node.
			
      Node pred = header;       
      for (int k = 1; k <= index - 1; k++)        
      {
         pred = pred.next;           
      }
      
      // Splice in a node with the new element
      // We want to go from  pred-- succ to 
      // pred--middle--succ
      Node succ = pred.next;
      Node middle = new Node(newValue, succ, pred);
      pred.next = middle;  
      if (succ == null)             
    	  trailer = middle;       
      else            
          succ.prev = middle;
	return newValue;  
  }

  public boolean add(AnyType newValue)
  {
    add(size(), newValue);
    return true;
  }

  public void add(int index, AnyType newValue) // Write code here to implement this method.
  {
      if (index < 0  || index > size()) 
      {
          String message = String.valueOf(index);
          throw new IndexOutOfBoundsException(message);
      }
      
      // Index is at least 0
      if (index == 0)
      {
          // New element goes at beginning
          Node p = header;            // Old first
          header = new Node(newValue, p, null);
          if (p != null)
              p.prev = header;             
          if (trailer == null)
        	  trailer = header;
          return;
      }
      
      // pred will point to the predecessor of the new node.
			
      Node pred = header;       
      for (int k = 1; k <= index - 1; k++)        
      {
         pred = pred.next;           
      }
      
      // Splice in a node with the new element
      // We want to go from  pred-- succ to 
      // pred--middle--succ
      Node succ = pred.next;
      Node middle = new Node(newValue, succ, pred);
      pred.next = middle;  
      if (succ == null)             
    	  trailer = middle;       
      else            
          succ.prev = middle;                     
 }

  public AnyType remove(int index)
  {
    return remove(getNode(index));
  }

  public Iterator<AnyType> iterator()
  {
    return new LinkedListIterator();    
  }

  private Node<AnyType> getNode(int index)
  {
    return (getNode(index, 0, size()-1));
  }

  private Node<AnyType> getNode(int index, int lower, int upper) // Write code here to implement this method.
  {
	  Node currentNode = header;
	  for( int i = lower; i< upper; i++)
	  {
		  currentNode = currentNode.getNext();
		  
	  }
	  return currentNode;
  }

  private AnyType remove(Node<AnyType> currNode) // Write code here to implement this method.
  {
	  isEmpty();
     
      // Locate the node targeted for removal
      Node target = header;  
      while (target != null  && !currNode.equals(target.data))
          target = target.next;
   
      Node pred = target.prev;        // Node before the target
      Node succ = target.next;        // Node after the target
      
      // Route forward and back pointers around
      // the node to be removed
      if (pred == null)       
    	  header = succ;
      else
          pred.next = succ;
      
      if (succ == null)
    	  trailer = pred;
      else
          succ.prev = pred;
	return (AnyType) target;      
   
 
   
  }

  private class LinkedListIterator implements Iterator<AnyType>
  {
    private Node<AnyType> current;
    private int expectedModCount;
    private boolean okToRemove;

    LinkedListIterator()
    {
      current = header.getNext();
      expectedModCount = modCount;
      okToRemove = false;
    }

    public boolean hasNext()
    {
      return (current != trailer);
    }

    public AnyType next()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!hasNext())
        throw new NoSuchElementException();

      AnyType nextValue = current.getData();
      current = current.getNext();
      okToRemove = true;
      return nextValue;
    }

    public void remove()
    {
      if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
      if (!okToRemove)
        throw new IllegalStateException();

      DoublyLinkedList.this.remove(current.getPrev());
      expectedModCount++;
      okToRemove = false;
    }
  }
}