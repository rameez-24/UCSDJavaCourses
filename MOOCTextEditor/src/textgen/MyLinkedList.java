package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		// TODO: Implement this method
		
		if (element != null) {
			this.size++;
			LLNode<E> temp = new LLNode<E>(element);
			LLNode<E> prevNode = this.tail.prev;
			temp.prev = prevNode;
			temp.next = this.tail;
			
			prevNode.next = temp;
			this.tail.prev = temp;
			
			return true;
		}
		else {
			throw new NullPointerException("Cannot add a null element to the list");
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if (index >= 0 && index < this.size) {
			LLNode<E> temp = head.next;
			int i = index;
			while(i!=0) {
				i--;
				temp = temp.next;
			}
			return temp.data;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds. The item does not exist! Check the index");
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Cannot add a null element to the list");
		}
		if (index<0 || index>this.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds. The item does not exist! Check the index");
		}
		size++;
		LLNode<E> temp = new LLNode<E>(element);
		LLNode<E> prevNode = head;
		int i = index;
		while(i!=0) {
			i--;
			prevNode = prevNode.next;
		}
		temp.prev = prevNode;
		temp.next = prevNode.next;
		
		(prevNode.next).prev = temp;
		prevNode.next = temp;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= 0 && index < this.size()) {
			size--;
			LLNode<E> currNode = head.next;
			int i = index;
			while(i!=0) {
				i--;
				currNode = currNode.next;
			}
			//Feeling confident gibberish
			(currNode.prev).next = currNode.next;
			(currNode.next).prev = currNode.prev;
			currNode.prev = null;
			currNode.next = null;
			return currNode.data;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds. The item does not exist! Check the index");
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Cannot add a null element to the list");
		}
		if (index<0 || index>this.size()-1) {
			throw new IndexOutOfBoundsException("Index out of bounds. The item does not exist! Check the index");
		}
		LLNode<E> currNode = head.next;
		int i = index;
		while(i!=0) {
			i--;
			currNode = currNode.next;
		}
		E oldData = currNode.data;
		currNode.data = element;
		return oldData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
