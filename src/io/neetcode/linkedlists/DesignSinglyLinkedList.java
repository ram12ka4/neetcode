package io.neetcode.linkedlists;

import java.util.ArrayList;

public class DesignSinglyLinkedList {

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

	Node head;
	Node tail;

	public DesignSinglyLinkedList() {
		head = new Node(-1);
		tail = head;
	}

	public int get(int index) {
		Node curr = head.next;
		while (index > 0 && curr != null) {
			curr = curr.next;
			index--;
		}
		if (curr != null && index == 0) {
			return curr.val;
		}
		return -1;
	}

	public void insertHead(int val) {
		Node newNode = new Node(val);
		newNode.next = head.next;
		head.next = newNode;
		if (newNode.next == null) {
			tail = newNode;
		}
	}

	public void insertTail(int val) {
		tail.next = new Node(val);
		tail = tail.next;
	}

	public boolean remove(int index) {
		Node curr = head;
		while (index > 0 && curr != null) {
			curr = curr.next;
			index--;
		}
		if (curr != null && curr.next != null) {
			if (curr.next == tail) {
				tail = curr;
			}
			curr.next = curr.next.next;
			return true;
		}
		return false;
	}

	public ArrayList<Integer> getValues() {
		ArrayList<Integer> list = new ArrayList<>();
		Node curr = head.next;
		while (curr != null) {
			list.add(curr.val);
			curr = curr.next;
		}
		return list;
	}

	public static void main(String[] args) {
		DesignSinglyLinkedList obj = new DesignSinglyLinkedList();
		obj.insertHead(1);
		obj.remove(0);
		System.out.println(obj.getValues());
		
	}

}
