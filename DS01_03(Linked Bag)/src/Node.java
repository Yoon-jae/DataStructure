
public class Node {
	private Coin _element;
	private Node _next;
	
	public Node()
	{
		this._element = null;
		this._next = null;
	}
	
	public Node(Coin anElement)
	{
		this._element = anElement;
		this._next = null;
	}
	
	public Node(Coin anElement, Node aNode)
	{
		this._element = anElement;
		this._next = aNode;
	}
	
	public Coin element()
	{
		return this._element;
	}
	
	public Node next()
	{
		return this._next;
	}
	
	public void setElement(Coin anElement)
	{
		this._element = anElement;
	}
	
	public void setNext(Node aNode)
	{
		this._next = aNode;
	}
}
