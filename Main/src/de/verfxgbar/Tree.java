package de.verfxgbar;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Tree {
	private Node first, current, last;

	public Tree(Node first, Node last) {
		this.first = first;
		this.last = last;
		this.current = this.first;

	}

	public Node getCurrent() {
		return this.current;
	}

	public Node getFirst() {
		return this.first;
	}

	public Node getLast() {
		return this.last;
	}

	public void next() {
		this.current.setNext((this.current.getNext() == null ? null : this.current.getNext()));
	}

	public void toFirst() {
		this.current = first;
	}

	public void insert(Node n) {
		if (this.current == this.first) {
			n.setNext(this.first);
			this.first = n;

			// Reset
			toFirst();
		}

		Node searchNode = this.first;

		// (searchNode != this.current) prevents errors when current is last
		while (searchNode.getNext() != this.current || searchNode != this.current) {
			searchNode = searchNode.getNext();
		}
		n.setNext(this.current);
		searchNode.setNext(n);

		// Reset
		toFirst();
	}

	public void remove() {
		if (this.current == this.first) {
			this.first = this.current.getNext();
			// this.current.setNext(null); ?

			// Reset
			toFirst();
		}
		Node searchNode = this.first;

		while (searchNode.getNext() != this.current || searchNode != this.current) {
			searchNode = searchNode.getNext();
		}
		searchNode.setNext((this.current.getNext() == null ? null : this.current.getNext()));

		// Reset
		toFirst();
	}

	public void visualize() {
		Node searchNode = this.first;

		int counter = 0;
		while (searchNode.getNext() != null) {
			counter++;
			searchNode = searchNode.getNext();
			System.out.print("[content=" + searchNode.getContent() + ";iteration=" + counter + "] -> ");
		}

		System.out.println("null");
	}
}
