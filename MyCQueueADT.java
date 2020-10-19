class CQueueADT
{
	int queue[];
	final int MAX=5;
	int front, rear;

	public CQueueADT() // initializing the queue
	{
		queue = new int[MAX];
		front = rear = 0;
	}
	
	public void enqueue(int e) // to insert one element at a time
	{
		if(isQueueFull())
		{
			System.out.println("CQueue is Overflow..!");
			return;
		}
		queue[rear] = e;
		rear = (rear+1) % MAX;
		System.out.println("\n"+e+" Inserted successfully....");
	}

	public void dequeue() // to remove one element at a time.
	{
		if(isQueueEmpty())
		{
			System.out.println("Queue is Underflow...!");
			return;
		}
		int v = queue[front];	
		front = (front+1) % MAX;
		System.out.println("\nElement removed is..."+v);
	}

	public boolean isQueueEmpty()
	{
		return (front==rear)?true:false;
	}

	public boolean isQueueFull()
	{
		return (front == (rear+1)%MAX )?true:false;
	}

	public void viewQueue() // to show the content of the queue
	{
		if(isQueueEmpty())
		{
		 	System.out.println("No data found...!");
			return;
		}
		System.out.println("\nThe content is...");
		for(int i=front;i!=rear;i=(i+1)%MAX)
		  System.out.print(queue[i]+"  ");
	}
}



public class MyCQueueADT
{
	public static void main(String args[])
	{
		CQueueADT q = new CQueueADT();
		int k [] = {11,33,22,44,55};
		for(int i=0;i<k.length;i++)
			q.enqueue(k[i]);

		q.viewQueue();

		q.dequeue(); q.dequeue();
		q.viewQueue();
		q.enqueue(80);q.enqueue(90);
		q.viewQueue();
		q.dequeue();q.dequeue();
		q.dequeue();q.dequeue();
		q.dequeue();q.dequeue();
	
		q.enqueue(100); q.enqueue(110);
		q.viewQueue();
	}
}
			