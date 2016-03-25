
public class LinkedBag {
	
	private int _size;
	private Node _head;
	
	public LinkedBag()
	{
		this._size = 0;
		this._head = null;
	}
	
	public int size()
	{
		return this._size;
	}
	
	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public boolean doesContain(Coin anElement)
	{
		boolean found = false;
		Node searchNode = this._head;
		while(searchNode != null && !found) {
			if(searchNode.element().equals(anElement)) {
				found = true;
			}
			searchNode = searchNode.next();
		}
		return found;
	}
	
	public int frequencyOf(Coin anElement)
	{
		int numbers = 0;
		Node searchNode = this._head;
		while(searchNode != null) {
			if(searchNode.element().equals(anElement)) {
				numbers++;
			}
			searchNode = searchNode.next();
		}
		return numbers;
	}
	
	public int maxElementValue()
	{
		int maxElement = 0;
		Node currentNode = this._head;
		while(currentNode != null) {
			if(currentNode.element().value() > maxElement) {
				maxElement = currentNode.element().value();
			}
			currentNode = currentNode.next();
		}
		return maxElement;
	}
	
	public int sumElementValues()
	{
		int sumElements = 0;
		Node currentNode = this._head;
		while(currentNode != null) {
			sumElements += currentNode.element().value();
			currentNode = currentNode.next();
		}
		return sumElements;
	}
	
	public boolean add(Coin anElement)
	{
		Node addedNode = new Node();
		addedNode.setElement(anElement);
		if(!this.isEmpty()) {
			addedNode.setNext(this._head);
		} 
		this._head = addedNode;
		this._size++;
		return true;
	}
	
	public Coin remove(Coin anElement)
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
				Coin removedCoin = currentNode.element();
				if(currentNode == this._head) {
					this._head = this._head.next();
				} else {
					previousNode.setNext(currentNode.next());
				}
				this._size--;
				return removedCoin;
			}
		}
	}
	
	public Coin removeAny()
	{
		if(this.isEmpty()) {
			return null;
		} else {
			Coin removedCoin = this._head.element();
			this._head = this._head.next();
			this._size--;
			return removedCoin;
		}
	}
	
	public void clear()
	{
		this._size = 0;
		this._head = null;
	}
	
}
