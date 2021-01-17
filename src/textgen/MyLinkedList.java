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
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> node = new LLNode<>(element);
		LLNode<E> prev = tail.prev;
		prev.next = node;
		node.prev = prev;
		node.next = tail;
		tail.prev = node;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> cur = head;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int i = -1; i < index; i++) {
				cur = cur.next;
			}
		}
		return cur.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> cur = head;
		LLNode<E> node = new LLNode<>(element);
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int i = -1; i < index-1; i++) {
				cur = cur.next;
			}
			LLNode<E> next = cur.next;
			cur.next = node;
			node.next = next;
			node.prev = cur;
			next.prev = node;
			size++;
		}
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
		LLNode<E> cur = head;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int i = -1; i < index; i++) {
				cur = cur.next;
			}
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			size--;
		}
		return cur.data;
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
			throw new NullPointerException();
		}
		LLNode<E> cur = head;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int i = -1; i < index; i++) {
				cur = cur.next;
			}
		}
		E replaced = cur.data;
		cur.data = element;
		return replaced;
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
