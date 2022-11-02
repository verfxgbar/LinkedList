package de.verfxgbar;

public class Node<T> {

	private T content;

	private Node<T> next;

	public Node(T content, Node<T> next) {
		this.content = content;
		this.next = next;
	}

	public Node<T> getNext() {
		return next;
	}

	public T getContent() {
		return content;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}
