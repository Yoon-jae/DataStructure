
public class Node {
	private Star _element;
	private Node _next;
	
	public Node()
	{
		this._element = null;
		this._next = null;
	}
	
	public Node(Star anElement)
	{
		this._element = anElement;
		this._next = null;
	}
	
	public Node(Star anElement, Node aNode)
	{
		this._element = anElement;
		this._next = aNode;
	}
	
	public Star element()
	{
		return this._element;
	}
	
	public Node next()
	{
		return this._next;
	}
	
	public void setElement(Star anElement)
	{
		this._element = anElement;
	}
	
	public void setNext(Node aNode)
	{
		this._next = aNode;
	}
}
