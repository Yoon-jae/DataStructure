
@SuppressWarnings("rawtypes")
public class SortedLinkedList<T extends Comparable> implements List {
	private static final int DEFAULT_MAX_SIZE = 20;
	@SuppressWarnings("unused")
	private int _maxSize;
	private int _size;
	private Node _head;
	
	public SortedLinkedList()
	{
		this._maxSize = SortedLinkedList.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._head = null;
	}
	
	public SortedLinkedList(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}
	
	
	@Override
	public void clear() {
		this._size = 0;
		this._head = null;
	}
	@Override
	public int size() {
		return this._size;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object anElement) {
		Node currentNode = this._head;		
		while(currentNode != null) {
			if(currentNode.element().compareTo(anElement) == 0)
				return true;
			currentNode = currentNode.next();
		}
		return false;
	}
	@Override
	public boolean isFull() {
		return false;
	}
	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object anElement) {
		Node currentNode = this._head;
		Node previousNode = null;
		
		Node addedNode = new Node();
		addedNode.setElement((T)anElement);
		
		while(currentNode != null) {
			if(currentNode.element().compareTo(anElement) > 0) {
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
		return true;
	}
	@Override
	public Object removeMin() {
		return removeFrom(0);
	}
	@Override
	public Object removeMax() {
		return removeFrom(this._size - 1);
	}
	@Override
	public Object removeFrom(int aPosition) {
		if(this.isEmpty())
			return null;
		else {
			if (aPosition < 0 || this._size <= aPosition)
				return null;
			else {
				Node removeNode = null;
				if (aPosition == 0) {
					removeNode = this._head;
					this._head = this._head.next();
				} else {
					Node previousNode = this._head;
					for (int i = 1; i < aPosition; i++) {
						previousNode = previousNode.next();
					}
					removeNode = previousNode.next();
					previousNode.setNext(removeNode.next());
				}
				this._size--;
				return removeNode.element();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public ListIterator<T> listIterator()
	{
		return new ListIterator();
	}
	
	@SuppressWarnings("hiding")
	public class ListIterator<T> implements Iterator
	{
		private Node _nextNode;
	
		private ListIterator()
		{
			this._nextNode = _head;
		}
		
		public boolean hasNext()
		{
			return (this._nextNode != null);
		}
		
		@SuppressWarnings("unchecked")
		public T next()
		{
			if(this._nextNode == null) {
				return null;
			}
			else {
				T element = (T) this._nextNode.element();
				this._nextNode = this._nextNode.next();
				return element;
			}
		}
	}
}
