import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import javax.xml.crypto.Data;

public class DoublyLinkedList<AnyType> implements List<AnyType> {
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> prev;
		private Node<AnyType> next;

		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
			setData(d);
			setPrev(p);
			setNext(n);
		}

		public AnyType getData() {
			return data;
		}

		public void setData(AnyType d) {
			data = d;
		}

		public Node<AnyType> getPrev() {
			return prev;
		}

		public void setPrev(Node<AnyType> p) {
			prev = p;
		}

		public Node<AnyType> getNext() {
			return next;
		}

		public void setNext(Node<AnyType> n) {
			next = n;
		}
	}

	private int theSize;
	private int modCount;
	private Node<AnyType> header;
	private Node<AnyType> trailer;

	public DoublyLinkedList() {
		header = new Node<AnyType>(null, null, null);
		trailer = new Node<AnyType>(null, null, null);
		modCount = 0;
		clear();
	}

	public void clear() {
		header.setNext(trailer);
		trailer.setPrev(header);
		theSize = 0;
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public AnyType get(int index) // Write code here to implement this method.
	{
		Node<AnyType> p = header;

		for (int i = 0; i < index; i++)
		{
			p = p.getNext();
		}
		return p.getData();
	}

	public AnyType set(int index, AnyType newValue) // Write code here to
													// implement this method.
	{
		if (index < 0 || index > size()) 
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		if (index == 0) // Index is at least 0
		{		
			Node<AnyType> p = new Node<AnyType>(newValue, header, trailer); 																		
			header.setNext(p);
			trailer.setPrev(p);
		} else 
		{
			// pred will point to the predecessor of the new node.
			Node<AnyType> pred = header;
			for (int k = 1; k <= index - 1; k++)
			{
				pred = pred.next;
			}
			
			// We want to go from pred-- succ to pred--middle--succ			
			Node<AnyType> succ = pred.next;
			Node<AnyType> middle = new Node<AnyType>(newValue, succ, pred);
			pred.next = middle;
			if (succ == null)
				{trailer = middle;}
			else
				{succ.prev = middle;}
		}
		return newValue;
	}

	public boolean add(AnyType newValue) {
		add(size(), newValue);
		return true;
	}

	public void add(int index, AnyType newValue) // Write code here to implement this method.												
	{
		if (index < 0 || index > size()) 
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		// Index is at least 0
		if (index == 0) 
		{
			
			header = new Node<AnyType>(newValue, null, null);
			header.setNext(header);
			header.setPrev(header);
			trailer = header;
		} 
		else if (index == 1) 
		{
			trailer = new Node<AnyType>(newValue, header, header);
			header.setNext(trailer);
			header.setPrev(trailer);
		} 
		else
		{
			Node<AnyType> old = trailer;
			trailer = new Node<AnyType>(newValue, old, header);
			old.setNext(trailer);
		}
		theSize++;
	}

	public AnyType remove(int index) {
		return remove(getNode(index));
	}

	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}

	private Node<AnyType> getNode(int index) {
		return (getNode(index, 0, size() - 1));
	}

	private Node<AnyType> getNode(int index, int lower, int upper) //Write code here to implement this method.
																
	{
		if (index > upper)
		{
			return null;
		}
		Node<AnyType> currentNode = header;
		for (int i = lower; i < index; i++) 
		{
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	private AnyType remove(Node<AnyType> currNode) // Write code here to implement this method.
													
	{
		AnyType retVal = null;
		if (isEmpty() || currNode == null) 
		{
			return null;
		} else if (size() == 1)
		{
			if (currNode.equals(header)) 
			{
				retVal = header.getData();
			}
			clear();
		} 
		else if (size() == 2)
		{
			if (currNode.equals(header)) 
			{
				retVal = header.getData();
				header = trailer;
				trailer.setNext(header);
				trailer.setPrev(header);
			}
			if (currNode.equals(trailer)) 
			{
				retVal = trailer.getData();
				trailer = header;
				header.setNext(trailer);
				header.setPrev(trailer);
			}
		}
		else 
		{
			if (currNode.equals(header))
			{
				Node<AnyType> old = header;
				header = header.getNext();
				trailer.setNext(header);
				retVal = old.getData();
			} else

			if (currNode.equals(trailer)) 
			{
				Node<AnyType> old = trailer;
				trailer = trailer.getPrev();
				header.setPrev(trailer);
				retVal = old.getData();
			}
			else
			{

			// Locate the node targeted for removal
			Node<AnyType> target = header;
			for (int i = 0; i < size(); i++) {
				target = target.next;
				if (target != null && target.equals(currNode)) 
				{
					break;
				}
			}

			Node<AnyType> pred = target.prev; // Node before the target
			Node<AnyType> succ = target.next; // Node after the target
			
			// Route forward and back pointers around the node to be removed	
			pred.next = succ;
			succ.prev = pred;
			retVal = target.getData();}
		}
		theSize--;
		return retVal;
	}

	private class LinkedListIterator implements Iterator<AnyType> {
		private Node<AnyType> current;
		private int expectedModCount;
		private boolean okToRemove;

		LinkedListIterator() {
			current = header.getNext();
			expectedModCount = modCount;
			okToRemove = false;
		}

		public boolean hasNext() {
			return (current != trailer);
		}

		public AnyType next() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if (!hasNext())
				throw new NoSuchElementException();

			AnyType nextValue = current.getData();
			current = current.getNext();
			okToRemove = true;
			return nextValue;
		}

		public void remove() {
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