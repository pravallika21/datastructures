/* Single linked list creation & other operations */

import java.util.Scanner;

class Student
{
	int stno;
	String name;
	String branch;
	int year;
	public Student(int no, String nm,String br,int y)
	{
		stno = no; name = nm;
		branch = br; year = y;
	}
	public void get()
	{
		System.out.println(stno+"  "+name+" "+branch+" "+year);
	}
}

class Node
{
	Student data;
	Node next;
	public Node(Student nm)
	{
		data = nm;
		next = null;
	}
}

class LinkedList
{
	Node head; // head node means starting node
	Scanner sc;
		public LinkedList()		
		{
			head = null;
			sc = new Scanner(System.in);
		}
		void createList() // completely creates a linked list
		{
			while(true)
			{
				System.out.println("\nEnter Student name...\n");
				String k = sc.next();		

				insert(k);

				System.out.println("Wish to insert one more Student?");
				String choice = sc.next();

				if(choice.equals("no"))
					return;
			}
		}
		
		void insert(String data) // adds one node at a time to the linked list
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
		}

		void viewLinkedList()
		{
			Node temp = head;
			while(temp!=null)
			{
				System.out.print(temp.data+"->");
				temp = temp.next;
			}
			System.out.print("null");
		}
	
		public int count()
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

	public void reverseDisplay()
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
}

public class LinkedListADT
{
	public static void main(String args[])
	{
		LinkedList obj = new LinkedList();

		obj.createList();
		obj.viewLinkedList();
		System.out.println("\nNo of nodes = "+obj.count());
		obj.reverseDisplay();
	}
}
		
		