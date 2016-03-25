
public class SortedArrayPriorityQueue<T extends Comparable> implements PriorityQueue<T> {

	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private T [] _element;
	
	public SortedArrayPriorityQueue()
	{
		this._maxSize = SortedArrayPriorityQueue.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = (T[])new Comparable[SortedArrayPriorityQueue.DEFAULT_MAX_SIZE];
	}
	
	public SortedArrayPriorityQueue(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = (T[])new Comparable[aMaxSize];
	}
	
	
	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}

	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}

	@Override
	public boolean add(T anElement) {
		if(!this.isFull()) {
			if(this.isEmpty())
				this._element[0] = (T)anElement;
			else {
				for(int i=0; i < this._size; i++) {
					if(this._element[i].compareTo(anElement) > 0) {
						for(int j=this._size-1; j>=i; j--) {
							this._element[j+1] = this._element[j];
						}
						this._element[i] = (T)anElement;
						break;
					}
				}
				if(this._element[this._size-1].compareTo(anElement) < 0) 
					this._element[this._size] = (T)anElement;
			}
			this._size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T max() {
		if(!this.isEmpty()) 
			return this._element[this._size-1];
		else 
			return null;
	}

	@Override
	public T removeMax() {
		if(!this.isEmpty()) {
			T maxElement = this._element[this._size-1];
			this._element[this._size-1] = null;
			this._size--;
			return maxElement;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return this._size;
	}

	public PriorityQueueIterator<T> priorityQueueIterator() {
		return new PriorityQueueIterator();
	}
	
	public class PriorityQueueIterator<T> implements Iterator<T> {
		private int _nextPosition;

		private PriorityQueueIterator() {
			this._nextPosition = 0;
		}

		public boolean hasNext() {
			return (this._nextPosition < size());
		}

		@SuppressWarnings("unchecked")
		public T next() {
			if (this._nextPosition == size()) {
				return null;
			} else {
				T t = (T) _element[this._nextPosition];
				this._nextPosition++;
				return t;
			}
		}
	}
}
