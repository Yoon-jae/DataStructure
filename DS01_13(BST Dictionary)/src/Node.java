
public class Node<Key extends Comparable<Key>, Obj> {
	private Element<Key, Obj> _element;
	private Node<Key, Obj> _next;
	
	public Node()
	{
		this._element = new Element<Key, Obj>();
		this._next = null;
	}
	
	public Node(Node<Key, Obj> aNode, Element<Key, Obj> anElement)
	{
		this._element = anElement;
		this._next = aNode;
	}
	
	public Element<Key, Obj> element()
	{
		return this._element;
	}
	
	public void setElement(Element<Key, Obj> anElement)
	{
		this._element = anElement;
	}
		
	public Node<Key, Obj> next()
	{
		return this._next;
	}
	
	public void setNext(Node<Key, Obj> aNode)
	{
		this._next = aNode;
	}
}
