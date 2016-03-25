
public class UnsortedLinkedBag {

	private int _size;
	private Node _head;
	
	public UnsortedLinkedBag()
	{
		this._size = 0;
		this._head = null;
	}
	
	public UnsortedLinkedBag(int aTestSize)
	{
		this._size = 0;
		this._head = null;
	}

	public void add(Coin coin) {
		Node addedNode = new Node();
		addedNode.setElement(coin);
		if(!this.isEmpty()) {
			addedNode.setNext(this._head);
		} 
		this._head = addedNode;
		this._size++;
	}

	public Coin maxElement() {
		int maxElement = 0;
		Node currentNode = this._head;
		while(currentNode != null) {
			if(currentNode.element().value() > maxElement) {
				maxElement = currentNode.element().value();
			}
			currentNode = currentNode.next();
		}
		Coin maxCoin = new Coin(maxElement);
		return maxCoin;
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
}
