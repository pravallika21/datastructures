/* Single linked list creation & other operations */

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
				while(t.next!=null) // traverse or move to the last node
				    t = t.next;		
	
				t.next = temp;
			}
			return head;
		}

		void viewLinkedList(Node head)
		{
			Node temp = head;
			while(temp!=null)
			{
				System.out.print(temp.data+"->");
				temp = temp.next;
			}
			System.out.print("null");
		}
	
		public int count(Node head)
		{
			int c=0;
			Node temp = head;
			while(temp!=null)
			{
				c++;
				temp = temp.next;
			}
			return c;
		}

	public Node concat(Node first, Node second)
	{
		Node temp = first;
		while(temp.next!=null)
			temp = temp.next;

		temp.next = second;

		return first;
	}
	public void reverseDisplay(Node head)
	{
		String stk[] = new String[10];
		int top=0;
		Node temp = head;

		while(temp!=null)
		{
			stk[++top] = temp.data;
			temp = temp.next;
		}
		for(int i=top;i>=0;i--)
			System.out.print(stk[i]+" ");		
	}

	Node insertAtFirst(Node head, String item)
	{
		Node temp = new Node(item); // new node to be inserted
		temp.next = head;
		head = temp;
		return head;		
	}
	public Node insertAtEnd(Node head, String item)
	{
		Node temp = new Node(item);
		Node x = head;
		while(x.next!=null)
			x = x.next;

		x.next = temp;
		return head;
	}
	public Node insertAtMiddle(Node head, int pos, String val)
	{
		Node temp, x;

		temp = new Node(val); // new node is created

		x = head;
		for(int i=1;i<pos;i++) // moving to the location
			x = x.next;
		temp.next = x.next;
		x.next = temp;	
		return head;
	}

	public Node removeFirst(Node head)
	{
		Node x;
		x = head;
		head = head.next;
		System.out.println("\n Removed data = "+x.data);
		x.next = null;
		x = null;
		return head;
	}

	public void sort(Node head)
	{
		Node x, y;

		for(x = head; x!=null; x = x.next)
		{
			for(y = x.next; y!=null; y = y.next)
			{
				if((x.data).compareTo(y.data)>0)
				{
					String temp = x.data;
					x.data = y.data;
					y.data = temp;	
				}
			}
		}		
	}

	public void removeLast(Node head)
	{
		Node x,y;
		x = head; y = head.next;

		while(y.next!= null) // moving x & y till last node
		{
			x = x.next;
			y = y.next;
		}
		x.next = null;
		System.out.println("\nRemoved item = "+y.data);
		y = null;	
	}	
	
	public void search(Node head, String key)
	{
		Node temp = head;
		int p=0;
		while(temp!=null)
		{
			p++;
			if(key.equalsIgnoreCase(temp.data))
			{
				System.out.println(key+" found at "+p);
				return;
			}
			temp = temp.next;
		}
		System.out.println("\nSorry.."+key+" not found in the linked list");
	}
}

public class LinkedListADT_2
{
	public static void main(String args[])
	{
		Node head=null; // head node means starting node
		Node start = null;

		LinkedList obj = new LinkedList();
		
		head = obj.createList(head);
		System.out.println("\nThe list-1 is...\n");
		obj.viewLinkedList(head);

		start = obj.createList(start);
		System.out.println("\nThe list-2 is...\n");
		obj.viewLinkedList(start);

		head = obj.concat(head,start);
		System.out.println("\nAfter concatenation...\n");
		obj.viewLinkedList(head);
		
/*		obj.sort(head);
		System.out.println("\nAfter sorting...\n");
		obj.viewLinkedList(head);

	
		System.out.println("\n after insert at begin....");

		head = obj.insertAtFirst(head,"Pranav");
		obj.viewLinkedList(head);

		System.out.println("\n after insert at begin....");
		head = obj.insertAtFirst(head,"Vijay");
		obj.viewLinkedList(head);
		
		head = obj.insertAtMiddle(head,3,"VVIT");
		obj.viewLinkedList(head);

		obj.search(head,"Vijaya");

		System.out.println("\nNo of nodes = "+obj.count(head)+"\n");

		head = obj.removeFirst(head);
		obj.viewLinkedList(head);

		obj.removeLast(head);
		obj.viewLinkedList(head);

		obj.reverseDisplay(head); */
	}
}
		
	


	