
public class Node<T extends Comparable> implements Comparable {
	private T _element;
	private Node _next;
	
	public Node()
	{
		this._element = null;
		this._next = null;
	}
	
	public Node(T anElement)
	{
		this._element = anElement;
		this._next = null;
	}
	
	public Node(T anElement, Node aNode)
	{
		this._element = anElement;
		this._next = aNode;
	}
	
	
	public T element() {
		return _element;
	}

	public void setElement(T anElement) {
		this._element = anElement;
	}

	public Node next() {
		return _next;
	}

	public void setNext(Node aNode) {
		this._next = aNode;
	}

	@Override
	public int compareTo(Object o) {
		return (this._element.compareTo(o));
	}
	
	

}
