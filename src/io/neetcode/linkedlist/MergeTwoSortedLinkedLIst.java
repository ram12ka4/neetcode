package io.neetcode.linkedlist;

public class MergeTwoSortedLinkedLIst {

	class Node {
		int val;
		Node next;
		
		public Node() {
			
		}

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	Node head;
	Node tail;

	public MergeTwoSortedLinkedLIst() {
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

	// Using Recursion
	public Node mergeSortedList(Node list1, Node list2) {

		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		if (list1.val < list2.val) {
			list1.next = mergeSortedList(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeSortedList(list1, list2.next);
			return list2;
		}
	}
	
	// Using Extra Node
	public Node mergeSortedList1(Node list1, Node list2) {
		final Node root = new Node();
		Node prev = root;
		
		while(list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				prev.next = list1;
				list1 = list1.next;
			} else {
				prev.next = list2;
				list2 = list2.next;
			}
			prev = prev.next;
		}
		
		prev.next = list1 == null ? list2 : list1;
		
		return root.next;
	}

	public static void main(String[] args) {

		MergeTwoSortedLinkedLIst list1 = new MergeTwoSortedLinkedLIst();
		MergeTwoSortedLinkedLIst list2 = new MergeTwoSortedLinkedLIst();

		list1.insertEnd(1);
		list1.insertEnd(2);
		list1.insertEnd(4);

		list2.insertEnd(1);
		list2.insertEnd(3);
		list2.insertEnd(4);

		list1.print(list1.head);
		list2.print(list2.head);
		
		Node head = list1.mergeSortedList1(list1.head, list2.head);
		
		list1.print(head.next);
		

	}

}
