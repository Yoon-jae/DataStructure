
public class LinkedQueue<T> {

	private int _size;
	private Node<T> _front;
	private Node<T> _rear;
	
	public LinkedQueue()
	{
		this._size = 0;
		this._front = null;
		this._rear = null;
	}

	public int maxSize()
	{
		return this._size;
	}
	
	public int size()
	{
		return this._size;
	}
	
	public boolean isEmpty()
	{
		return (this._rear == null);
	}
	
	public boolean isFull()
	{
		return false;
	}
	
	public T frontElement()
	{
		if(this.isEmpty()){
			return null;
		} else {
			return this._front.element();
		}
	}
	
	public boolean enQueue(T anElement)
	{
		if(this.isFull()) {
			return false;
		} else {
			Node<T> newNode = new Node<T>(anElement);
			if(this.isEmpty()) {
				this._front = newNode;
			} else {
				this._rear.setNext(newNode);
			}
			this._rear = newNode;
			this._size++;
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T deQueue()
	{
		T frontElement = null;
		if(!this.isEmpty()) {
			frontElement = this._front.element();
			this._front = this._front.next();
			if (this._front == null) {
				this._rear = null;
			}
			this._size--;
		}
		return frontElement;		
	}
	
	public void clear()
	{
		this._front = null;
		this._rear = null;
		this._size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public T elementAt(int givenPosition)
	{
		Node<T> currentNode = this._front;
		if (!this.isEmpty()) {
			for (int i = 0; i < givenPosition; i++) {
				currentNode = currentNode.next();
			}
			return currentNode.element();
		} else {
			return null;
		}
	}

}
