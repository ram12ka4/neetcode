package io.neetcode.linkedlist;

public class SinglyLinkedLilst {

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	Node head;
	Node tail;

	public SinglyLinkedLilst() {
		head = new Node(-1);
		tail = head;
	}

	public void insertEnd(int val) {
		tail.next = new Node(val);
		tail = tail.next;
	}

	public void print(Node head) {
		Node curr = head.next;
		while (curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println("NULL");
	}

	public Node mergeTwoSortedLists(Node a, Node b) {
		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.val < b.val) {
			head = tail = a;
			a = a.next;
		} else {
			head = tail = b;
			b = b.next;
		}

		while (a != null && b != null) {
			if (a.val < b.val) {
				tail.next = a;
				tail = a;
				a = a.next;
			} else {
				tail.next = b;
				tail = b;
				b = b.next;
			}
		}

		if (a == null)
			tail.next = b;
		else
			tail.next = a;

		return head;
	}

	public static void main(String[] args) {

		SinglyLinkedLilst list1 = new SinglyLinkedLilst();
		SinglyLinkedLilst list2 = new SinglyLinkedLilst();

		list1.insertEnd(1);
		list1.insertEnd(2);
		list1.insertEnd(4);

		list2.insertEnd(1);
		list2.insertEnd(3);
		list2.insertEnd(4);

		list1.print(list1.head);
		list2.print(list2.head);
		
		Node head = list1.mergeTwoSortedLists(list1.head, list2.head);
		
		list1.print(head.next);
		

	}

}
