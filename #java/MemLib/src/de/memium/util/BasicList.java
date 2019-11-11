package de.memium.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BasicList<T> implements Iterable<T> {
	Node first;
	Node last;
	private int size = 0;

	public BasicList() {
		first = last = new Node(null);
	}

	public BasicList(ArrayList<T> prev) {
		first = last = new Node(prev.get(0));
		prev.forEach(v->last = (last.next = new Node(v,last)));
		first = first.next;
		this.size=prev.size();
	}

	public BasicList(T[] prev) {
		this(new ArrayList<T>(Arrays.asList(prev)));
	}

	public BasicList(BasicList<T> deepcopy) {
		this();
		deepcopy.forEach(this::add);
	}

	/*
	 * Methods
	 */

	public T get(int i) {
		return this.getNode(i).val;
	}

	Node getNode(int i) {
		Node c;
		if(0>i||i>=size) {
			throw new IndexOutOfBoundsException();
		} else if(size==1) {
			return first;
		} else if(i>size/2) {
			c = last;
			for(int j=size;j>i+1;j--) c=c.prev;
		} else {
			c = first;
			for(int j=0;j<i;j++) c=c.next;
		}
		return c;
	}

	public void add(T nval) {
		if(last.val==null) { last.val = nval; }
		else { last = (last.next = new Node(nval,last)); }
		this.size++;
	}

	public void set(int i, T nval) {
		this.getNode(i).val = nval;
	}

	public void insert(int i, T val) {
		Node prev = this.getNode(i-1);
		Node newNode = new Node(val,prev);
		prev.next.prev = newNode;
		newNode.next = prev.next;
		prev.next = newNode;
	}

	public void remove(int i) {
		this.removeNode(this.getNode(i));
	}

	/**
	 * removes All Elements that are equal to obj
	 * @return the count of removed Elements
	 */
	public int removeAll(T obj) {
		return this.removeMatching(v->v.equals(obj));
	}

	public int removeMatching(Predicate<T> cond) {
		int count = 0;
		Node c = first;
		do {
			if(cond.test(c.val)) {
				this.removeNode(c);
				count++;
			}
			c=c.next;
		} while(c!=null);
		return count;
	}

	public int clear() {
		int prevSize = this.size;
		first = last = new Node(null);
		this.size = 0;
		return prevSize;
	}

	public T popLast() {
		Node tmp = last;
		this.removeNode(last);
		return tmp.val;
	}

	public T popFirst() {
		Node tmp = first;
		this.removeNode(first);
		return tmp.val;
	}

	public T pop(int i) {
		Node tmp = this.getNode(i);
		T val = tmp.val;
		this.removeNode(tmp);
		return val;
	}

	void removeNode(Node n) {
		if(n.equals(first)) {
			first=first.next;
			first.prev=null;
		} else if(n.equals(last)) {
			last=last.prev;
			last.next=null;
		} else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
		this.size--;
	}

	public void concat(BasicList<T> toadd) {
		last.next = toadd.first;
		toadd.first.prev = last;
		last = toadd.last;
	}

	public boolean allMatching(Predicate<T> cond) {
		return this.stream().allMatch(cond);
	}

	public Stream<T> stream() {
		this.updateSize();
		return Stream.iterate(first, c->c.next).limit(this.size()).map(n->n.val);
	}

	Stream<Node> streamNodes() {
		this.updateSize();
		return Stream.iterate(first, c->c.next).limit(this.size());
	}

	@Override
	public void forEach(Consumer<? super T> c) {
		this.stream().forEach(c);
	}

	public void forEachOrdered(Consumer<? super T> c) {
		this.stream().forEachOrdered(c);
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) this.stream().toArray();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node c=first;
			@Override
			public boolean hasNext() {
				return c.next!=null;
			}

			@Override
			public T next() {
				return (c=c.next).val;
			}
		};
	}

	public int size() {
		return size;
	}

	/**
	 * used to update intern size after accessing intern Methods to manipulate List
	 */
	public void updateSize() {
		this.size = this.calcsize();
	}

	int calcsize() {
		Node c = first;
		int cs = 0;
		do {
			cs+=1;
			c=c.next;
		} while(c!=null);
		return cs;
	}

	private class Node {
		private T val;
		private Node next;
		private Node prev;

		public Node(T val) {
			this.val = val;
		}

		public Node(T val, Node prev) {
			this.val=val;
			this.prev=prev;
		}
	}
}