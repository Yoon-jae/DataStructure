
public class SortedLinkedBag {

	private int _size;
	private Node _head;
	
	public SortedLinkedBag()
	{
		this._size = 0;
		this._head = null;
	}
	
	public SortedLinkedBag(int aTestSize)
	{
		this._size = 0;
		this._head = null;
	}
	
	public void add(Coin aCoin) {
		Node currentNode = this._head;
		Node previousNode = null;
		
		Node addedNode = new Node();
		addedNode.setElement(aCoin);
		
		while(currentNode != null) {
			if(aCoin.value() < currentNode.element().value()) {
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		
		if(currentNode == this._head) {
			addedNode.setNext(currentNode);
			this._head = addedNode;
		} else {
			addedNode.setNext(currentNode);
			previousNode.setNext(addedNode);
		}
		
		this._size++;
	}

	public Coin maxElement() {
		Node currentNode = this._head;
		while(currentNode.next() != null) {
			currentNode = currentNode.next();
		}
		Coin maxCoin = new Coin(currentNode.element().value());
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
