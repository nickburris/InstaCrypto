/**
 * LinkedList object definition
 * 
 * This class provides a LinkedList data structure for Message objects.
 * This is a modification of code from class notes.
 *
 * @author Amelia Stead
 * 
 * @since Mar 25, 2016
 */

public class LinkedList
{
	private Node front;
	private int count;
	
	//constructor	
	public LinkedList()
	{
		front = null;
		count = 0;
	}
	
	//returns count
	public int getCount()
	{
		return count;
	}
	
	//add a node to the front of the linked list
	public void addToFront(Message msg)
	{
		Node n;
		n = new Node(msg, front);
		front = n;
		count++;
	}
	
	//get the current size of the list
	public int size()
	{
		return count;
	}
	
	//check if the list is empty
	public boolean isEmpty()
	{
		if (front==null)
			return true;
		else
			return false;
	}
	
	//clear the list
	public void clear()
	{
		front = null;
		count = 0;
	}
	
	//get the content of the first node
	public Message getFrontData()
	{
		if (front==null)
			return null;
		else
			return front.getMessage();
	}
	
	//new method added - get the first node
	public Node getFront()
	{
		return front;
	}
	
	//scan the list and print contents
	public void enumerate()
	{
		Node curr = front;
		while (curr!=null)
		{
			System.out.print(curr);
			curr = curr.getNext();
		}
		System.out.println(".");
	}
	
	//remove front node
	public void removeFront()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			front = front.getNext();
			count--;
		}
	}
	
	//add a node to the end
	public void addToEnd(Message msg)
	{
		Node n = new Node(msg, null);
		Node curr = front;
		if (front==null)
			front = n;
		else
		{
			while (curr.getNext()!=null)
				curr = curr.getNext();
			curr.setNext(n);
		}
		count++;		
	}
	
	//remove last node
	public void removeLast()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else if (front.getNext()==null)
		{
			front = null;
			count--;
		}
		else
		{
			Node curr = front;
			while (curr.getNext().getNext()!=null)
				curr = curr.getNext();
			curr.setNext(null);
			count--;
		}
			
	}

	//search for a given data and return the index of the node (first occurrence)
	//return -1 if not found
	public int contains(Message msg)
	{
		Node curr = front;
		boolean found = false;
		int index = -1;
		while (curr!=null&&!found)
		{
			index++;
			if (curr.getMessage().equals(msg))
				found=true;
			curr= curr.getNext();
		}
		if (!found)
			return -1;
		else
			return index;
		
	}
	
	//add a node at a given index
	public void add(int index, Message msg)
	{
		if (index<0 || index>size())
			System.out.println("Can't add. Index out of bounds");
		else
		{
	
			if (index==0)
				addToFront(msg);
			else
			{
				Node curr = front;
				for(int i=0; i<index-1; i++)
					curr = curr.getNext();
				Node n = new Node(msg,curr.getNext());
				curr.setNext(n);
				count++;
			}
		}
	}
	
	//remove a node at a given index
	public void remove(int index)
	{
		if (index<0 || index>=size())
			System.out.println("Can't remove. Index out of bounds");
		else if (index==0)
			removeFront();
		else if (index==size()-1)
			removeLast();
		else
		{
			Node curr = front;
			for(int i=0;i<index-1;i++)
				curr = curr.getNext();
			curr.setNext(curr.getNext().getNext());
			count--;
		}
	}
	
	//removes msg if they are in the list
	public void remove (Message msg)
	{
		int i = contains(msg);
		if (i != -1)
			remove(i);
	}
	
	//get a node data given an index
	public Message get(int index)
	{
		Node curr = front;
		int i=0;
		while (curr!=null && i!=index)
		{
			curr=curr.getNext();
			i++;
		}
		if (curr==null)
			return null;
		else
			return curr.getMessage();
	}
	
	//toString
	//returns String formatted the same as enumerate().
	public String toString()
	{
		String result = "";
		
		Node curr = front;
		while (curr!=null)
		{
			result += curr;
			curr = curr.getNext();
		}
		result += ".";
		return result;
	}
	
	//returns true if both lists contain the same elements, regardless of order or duplication.
	public boolean equals(LinkedList list2)
	{
		//check if each element in this list is in list2.
		Node curr = front;
		while (curr != null) {
			if (list2.contains(curr.getMessage()) == -1)
				return false;
			curr = curr.getNext();
		}
			
		//check if each element in list2 is in this list.
		curr = list2.getFront();
		while (curr != null) {
			if (contains(curr.getMessage()) == -1)
				return false;
			curr = curr.getNext();
		}
		
		return true;
	}
}