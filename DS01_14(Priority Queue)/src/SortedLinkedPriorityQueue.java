
public class SortedLinkedPriorityQueue<T extends Comparable> implements PriorityQueue<T> {

	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private Node _head;
	
	public SortedLinkedPriorityQueue()
	{
		this._maxSize = SortedLinkedPriorityQueue.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._head = null;
	}
	
	public SortedLinkedPriorityQueue(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}
	
	@Override
	public boolean isEmpty() {
		return (this._size == 0 || this._head == null);
	}

	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}

	@Override
	public boolean add(T anElement) {
		if(!this.isFull()) {
			Node currentNode = this._head;
			Node previousNode = null;
			Node newNode = new Node();
			newNode.setElement((T)anElement);
			
			if(this.isEmpty()) {
				this._head = newNode;
				this._size++;
				return true;
			} else {
				while(currentNode.next() != null) {
					if(currentNode.element().compareTo(anElement) > 0) 
						break;
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
				
				if(currentNode.next() == null) { // 맨마지막으로 newNode가 넘어간경우
					if(currentNode.element().compareTo(anElement) > 0) {
						if(previousNode == null) { // node가 1개만 존재하는 경우
							newNode.setNext(currentNode);
							this._head = newNode;
						} else {
							previousNode.setNext(newNode);
							newNode.setNext(currentNode);
						}
					} else // 맨뒤에 삽입하는 경우
						currentNode.setNext(newNode);
					
					this._size++;
					return true;
				} else { // newNode의 위치가 중간인 경우
					if(previousNode == null) { // node가 1개만 존재하는 경우
						newNode.setNext(currentNode);
						this._head = newNode;
					} else {
						newNode.setNext(currentNode);
						previousNode.setNext(newNode);
					}
					this._size++;
					return true;
				}
			}
			
		} else
			return false;
	}

	@Override
	public T max() {
		if(!this.isEmpty()) {
			Node currentNode = this._head;
			while(currentNode.next() != null)
				currentNode = currentNode.next();
			return (T)currentNode.element();
		} else 
			return null;
	}

	@Override
	public T removeMax() {
		if(!this.isEmpty()) {
			Node removedNode = null;
			if(this._size == 1) {
				removedNode = this._head;
				this._head = this._head.next();
			} else {
				Node previousNode = this._head;
				while(previousNode.next().next() != null)
					previousNode = previousNode.next();
				
				removedNode = previousNode.next();
				previousNode.setNext(removedNode.next());
			}
			this._size--;
			return (T)removedNode.element();
		} else 
			return null;
	}

	@Override
	public int size() {
		return this._size;
	}
	
	public  PriorityQueueIterator<T> priorityQueueIterator() {
		return new PriorityQueueIterator();
	}

	public class PriorityQueueIterator<T> implements Iterator<T> {

		private Node _nextNode;

		private PriorityQueueIterator() {
			this._nextNode = _head;
		}

		@Override
		public boolean hasNext() {
			return (this._nextNode != null);
		}

		@Override
		public T next() {
			if (this._nextNode == null)
				return null;
			else {
				@SuppressWarnings("unchecked")
				T element = (T) this._nextNode.element();
				this._nextNode = this._nextNode.next();
				return element;
			}
		}
	}
	

}
