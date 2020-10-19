/* Circular linked list creation & view */

import java.util.Scanner;

class Node
{
	String data;
	Node next;
	public Node(String nm)
	{
		data = nm;
		next = null;
	}
}

class LinkedList
{
		Scanner sc;
		public LinkedList()		
		{
			sc = new Scanner(System.in);
		}
		Node createList(Node head) // completely creates a linked list
		{
			while(true)
			{
				System.out.println("\nEnter Student name...\n");
				String k = sc.next();		

				head = insert(head, k);

				System.out.println("Wish to insert one more Student?");
				String choice = sc.next();

				if(choice.equals("no"))
					return head;
			}
		}
		
		Node insert(Node head, String data) // adds one node at a time to the linked list
		{
			Node temp, t;

			temp = new Node(data);	// creation of a new node
		
			if(head==null)
				head = temp;			
			else
			{
				t = head;
				while(t.next!=head) // traverse or move to the last node
				    t = t.next;		

				t.next = temp;
			}
			temp.next = head;
			return head;
		}

		void viewLinkedList(Node head)
		{
			Node temp = head;
			System.out.print("head->");
			do
			{
				System.out.print(temp.data+"->");
				temp = temp.next;
			}
			while(temp!=head);
			System.out.print("head");
		}
}

public class CircularListADT
{
	public static void main(String args[])
	{
		Node head=null; // head node means starting node

		LinkedList obj = new LinkedList();
		
		head = obj.createList(head);
		System.out.println("\nThe Cicular List is...\n");
		obj.viewLinkedList(head);

	}
}
		
	


	