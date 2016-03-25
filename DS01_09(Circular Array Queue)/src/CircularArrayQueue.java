
public class CircularArrayQueue<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 7;
	private int _maxSize;
	private int _front;
	private int _rear;
	private T[] _elements;
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue()
	{
		this._maxSize = CircularArrayQueue.DEFAULT_INITIAL_CAPACITY;
		this._front = 0;
		this._rear = 0;
		this._elements = (T[])new Object[CircularArrayQueue.DEFAULT_INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initialCapacity)
	{
		this._maxSize = initialCapacity;
		this._front = 0;
		this._rear = 0;
		this._elements = (T[])new Object[initialCapacity];
	}
	
	public int front()
	{
		return (this._front + 1) % this._maxSize;
	}
	
	public int rear()
	{
		return (this._rear + 1) % this._maxSize;
	}
	
	public int maxSize()
	{
		return this._maxSize;
	}
	
	public boolean isEmpty()
	{
		return (this._front == this._rear);
	}
	
	public boolean isFull()
	{
		return (this._front == (this._rear + 1) % this._maxSize);
	}
	
	public int size()
	{
		if(this._front <= this._rear) {
			return this._rear - this._front;
		} else {
			return this._rear + this._maxSize - this._front;
		}
	}
	
	public T frontElement()
	{
		if(this.isEmpty()) {
			return null;
		} else {
			return this._elements[(this._front + 1) % this._maxSize];
		}
	}
	
	public boolean enQueue(T anElement)
	{
		if(this.isFull()) {
			return false;
		} else {
			this._rear = (this._rear + 1) % this._maxSize;
			this._elements[this._rear] = anElement;
			return true;
		}
	}
	
	public T deQueue()
	{
		T frontElement = null;
		if(!this.isEmpty()) {
			frontElement = this._elements[(this._front + 1) % this._maxSize];
			this._elements[(this._front + 1) % this._maxSize] = null;
			this._front = (this._front + 1) % this._maxSize;
		}
		return frontElement;
	}
	
	public void clear()
	{
		for(int i = 0; i < this.size(); i++) {
			this._elements[(this._front+i) % this._maxSize] = null;
		}
		this._front = 0;
		this._rear = 0;
	}
	
	public T elementAt(int givenPosition)
	{
		if(this.isEmpty()) {
			return null;
		} else {
			if(0 <= givenPosition && givenPosition <= this.size())
				return this._elements[givenPosition];
			else
				return null;
		}
	}
	
}
