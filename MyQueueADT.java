class QueueADT
{
	String queue[];
	final int MAX=5;
	int front, rear;

	public QueueADT() // initializing the queue
	{
		queue = new String[MAX];
		front = rear = 0;
	}
	
	public void enqueue(String e) // to insert one element at a time
	{
		if(isQueueFull())
		{
			System.out.println("Queue is Overflow..!");
			return;
		}
		queue[rear++] = e;
		System.out.println(e+" Inserted successfully....");
	}

	public void dequeue() // to remove one element at a time.
	{
		if(isQueueEmpty())
		{
			System.out.println("Queue is Underflow...!");
			return;
		}
		String v = queue[front++];
		System.out.println("\nElement removed is..."+v);
	}

	public boolean isQueueEmpty()
	{
		return (front==rear)?true:false;
	}

	public boolean isQueueFull()
	{
		return (rear==MAX)?true:false;
	}

	public void viewQueue() // to show the content of the queue
	{
		if(isQueueEmpty())
		{
		 	System.out.println("No data found...!");
			return;
		}
		System.out.println("\nThe content is...");
		for(int i=front;i!=rear;i++)
		System.out.print(queue[i]+"  ");
	}
}



public class MyQueueADT
{
	public static void main(String args[])
	{
		QueueADT q = new QueueADT();
		String k [] = {"Ramu","Ravi","Kiran","Asha","Vasu","Vinay"};
		for(int i=0;i<k.length;i++)
			q.enqueue(k[i]);

		q.viewQueue();
		q.dequeue();
		q.dequeue();
		q.viewQueue();
		q.dequeue();q.dequeue();q.dequeue();q.dequeue();
		q.viewQueue();
	}
}
			