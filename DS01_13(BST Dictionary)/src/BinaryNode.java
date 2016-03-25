
public class BinaryNode<Key extends Comparable<Key>, Obj> {
	
	private Element<Key,Obj> _element;
	private BinaryNode<Key,Obj> _left;
	private BinaryNode<Key,Obj> _right;
	
	public BinaryNode()
	{
		this._element = null;
		this._left = null;
		this._right = null;
	}
	
	public BinaryNode(Element anElement)
	{
		this._element = anElement;
		this._left = null;
		this._right = null;
	}
	
	public BinaryNode(BinaryNode<Key,Obj> aLeft, BinaryNode<Key,Obj> aRight)
	{
		this._element = null;
		this._left = aLeft;
		this._right = aRight;
	}
	
	public BinaryNode(Element anElement, BinaryNode<Key,Obj> aLeft, BinaryNode<Key,Obj> aRight)
	{
		this._element = anElement;
		this._left = aLeft;
		this._right = aRight;
	}

	public Element<Key, Obj> element() {
		return this._element;
	}

	public void setElement(Element<Key, Obj> _element) {
		this._element = _element;
	}

	public BinaryNode<Key, Obj> left() {
		return this._left;
	}

	public void setLeft(BinaryNode<Key, Obj> _left) {
		this._left = _left;
	}

	public BinaryNode<Key, Obj> right() {
		return this._right;
	}

	public void setRight(BinaryNode<Key, Obj> _right) {
		this._right = _right;
	}
	
	
}
