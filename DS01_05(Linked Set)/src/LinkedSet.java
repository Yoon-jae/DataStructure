
public class LinkedSet {

	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Node _head;
	
	public LinkedSet()
	{
		this._maxSize = LinkedSet.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._head = null;
	}
	
	public LinkedSet(int givenMaxSize)
	{
		this._maxSize = givenMaxSize;
		this._size = 0;
		this._head = null;
	}
	
	public boolean isEmpty()
	{
		return (this._size == 0 || this._head == null);
	}
	
	public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
	
	public int size()
	{
		return this._size;
	}
	
	public boolean doesContain(Star anElement)
	{
		Node searchNode = this._head;
		while(searchNode != null) {
			if(searchNode.element().equals(anElement)) {
				return true;
			}
			searchNode = searchNode.next();
		}
		return false;
	}
	
	public boolean add(Star anElement)
	{
		if(this.isFull()) {
			return false;
		} else {
			Node newNode = new Node(anElement);
			Node currentNode = this._head;
			while(currentNode != null) {
				if(currentNode.element().equals(anElement)) {
					return false;
				}
				currentNode = currentNode.next();
			}
			if(!this.isEmpty()) {
				newNode.setNext(currentNode);
			}
			this._head = newNode;
			this._size++;
			return true;
		}
	}
	
	public Star remove(Star anElement)
	{
		if(this.isEmpty()) {
			return null;
		} else {
			boolean found = false;
			Node previousNode = null;
			Node currentNode = this._head;
			while(currentNode != null && !found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.next();
			}
			if(!found) {
				return null;
			} else {
				Star removedStar = currentNode.element();
				if(currentNode == this._head) {
					this._head = this._head.next();
				} else {
					previousNode.setNext(currentNode.next());
				}
				this._size--;
				return removedStar;
			}
		}
	}
	
	public Star removeAny()
	{
		if(this.isEmpty()) {
			return null;
		} else {
			Node currentNode = this._head;
			Star removedStar = currentNode.element();
			this._head = currentNode.next();
			this._size--;
			return removedStar;
		}
	}
	
	public void clear()
	{
		this._size = 0;
		this._head = null;
	}
}
