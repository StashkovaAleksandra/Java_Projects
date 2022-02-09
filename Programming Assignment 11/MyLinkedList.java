/**
 * Name: Aleksandra Stashkova
 * Email: astashko@ucsd.edu
 * Sources used: none
 */

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/** 
 * Class MyLinkedList and its methods.
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		this.head = new Node(null);
		this.tail = new Node(null);
		this.head.setNext(tail);
		this.tail.setPrev(head);
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) {
		return (E) getNth(index).getElement();
	}

	@Override
	public void add(int index, E data) {
		if (data == null){
			throw new NullPointerException();
		}
		if (index > size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		Node temp = new Node(data);
		Node temp2 = head;
		for (int i = 0; i < index; i++){
			temp2 = temp2.getNext();
		}
		temp.setPrev(temp2);
		temp.setNext(temp2.getNext());
		temp.getPrev().setNext(temp);
		temp.getNext().setPrev(temp);
		size++;
	}

	public boolean add(E data) {
		if (data == null){
			throw new NullPointerException();
		}
		Node temp = new Node(data);
		temp.setNext(this.tail);
		temp.setPrev(tail.getPrev());
		temp.getPrev().setNext(temp);
		tail.setPrev(temp);
		size++;
		return true;
	}

	public E set(int index, E data) {
		if (data == null){
			throw new NullPointerException();
		}
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		Node temp = this.getNth(index);
		E temp2 = temp.getElement();
		temp.setElement(data);
		return (E) temp2;
	}

	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node temp = this.getNth(index);
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());
		size--;
		return (E) temp.getElement();
	}

	public void clear() {
		size = 0;
		this.head.setNext(tail);
		this.tail.setPrev(head);
	}

	public boolean isEmpty() {
		return head.getNext() == tail;
	}

	protected Node getNth(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node newNode = head.getNext();
		for (int i = 0; i < index; i++){
			newNode = newNode.getNext();
		}
		return (Node) newNode;
	}

	public ListIterator<E> listIterator(){
		return new MyListIterator();
	}

	public Iterator<E> iterator(){
		return new MyListIterator();
	}

	protected class MyListIterator implements ListIterator<E> {
		Node left, right;
		int idx;
		boolean forward;
		boolean canRemoveOrSet;

		public MyListIterator(){
			left = head;
			right = head.getNext();
			idx = 0;
			forward = true;
			canRemoveOrSet = false;
		}

		public boolean hasNext(){
			return right != null && right != tail;
		}

		public E next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			left = left.getNext();
			right = right.getNext();
			idx++;
			forward = true;
			canRemoveOrSet = true;
			return (E) left.getElement();
		}

		public boolean hasPrevious(){
			return left != head && left != null;
		}

		public E previous(){
			if (!hasPrevious()){
				throw new NoSuchElementException();
			}
			left = left.getPrev();
			right = right.getPrev();
			idx--;
			forward = false;
			canRemoveOrSet = true;
			return (E) right.getElement();
		}

		public int nextIndex(){
			return idx;
		}

		public int previousIndex(){
			return idx - 1;
		}

		public void add(E element){
			if (element == null){
				throw new NullPointerException();
			}
			Node newNode = new Node(element);
			newNode.setNext(right);
			newNode.setPrev(left);
			right.setNext(newNode);
			left.setPrev(newNode);
			left = newNode;
			canRemoveOrSet = false;
			idx++;
			size++;
		}

		public void set(E element){
			if (element == null){
				throw new NullPointerException();
			}
			if (!canRemoveOrSet){
				throw new IllegalStateException();
			}
			if (forward){
				left.setElement(element);
			}
			else {
				right.setElement(element);
			}
			canRemoveOrSet = false;
		}

		public void remove(){
			if (!canRemoveOrSet){
				throw new IllegalStateException();
			}
			if (forward){
				left = left.getPrev();
				idx--;
			}
			else {
				right = right.getNext();
			}
			left.setNext(right);
			right.setPrev(left);
			canRemoveOrSet = false;
			size--;
		}
	}
}