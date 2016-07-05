/**
 * Node object definition
 * 
 * This class provides the Node objects for the LinkedList data structure.
 * The data of each Node is of type Message.
 * This is a modification of code from class notes.
 *
 * @author Amelia Stead
 * 
 * @since Mar 25, 2016
 */

public class Node
{
	//private variables
	private Message msg;
	private Node next;
	
	//constructor
	public Node(Message m, Node n)
	{
		msg = m;
		next = n;
	}
	
	//getters and setters
	public Message getMessage(){return msg;}
	public Node getNext(){return next;}
	public void setMessage(Message m){msg = m;}
	public void setNext(Node n){next = n;}
	
	//toString
	public String toString()
	{
		return msg + "-->";
	}
}
