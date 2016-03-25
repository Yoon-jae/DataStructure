
@SuppressWarnings("rawtypes")
public class SortedArrayList<T extends Comparable> implements List {
	
	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private T [] _element;
	
	@SuppressWarnings("unchecked")
	public SortedArrayList()
	{
		this._maxSize = DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = (T[])new Comparable[SortedArrayList.DEFAULT_MAX_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public SortedArrayList(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = (T[])new Comparable[aMaxSize];
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this._size = 0;
		this._element = (T[]) new Comparable[_maxSize];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this._size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object anElement) {
		boolean found = false;
		for(int i=0; i<this._size; i++) {
			if(this._element[i].compareTo(anElement) == 0)
				found = true;
		}
		return found;
	}

	@Override
	public boolean isFull() {
		return (this._size == this._maxSize);
	}

	@Override
	public boolean isEmpty() {
		return (this._size == 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object anElement) {
		if(this.isFull())
			return false;
		else {
			int i;
			for(i=0; i<this._size; i++) {
				if(this._element[i].compareTo(anElement) > 0) 
					break;
			}
			if(i < this._size) {
				for(int j=this._size-1; j>=i; j--) {
					this._element[j+1] = this._element[j];
				}
				this._element[i] = (T) anElement;
				this._size++;
				return true;
			} else {
				this._element[this._size] = (T) anElement;
				this._size++;
				return true;
			}
		}
	}

	@Override
	public Object removeMin() {
		if(this.isEmpty()) {
			return null;
		} else {
			Object removedObj = this._element[0];
			for(int i=1; i<=this._size-1; i++) {
				this._element[i-1] = this._element[i];
			}
			this._element[this._size-1] = null;
			this._size--;
			return removedObj;
		}
	}

	@Override
	public Object removeMax() {
		if(this.isEmpty()) {
			return null;
		} else {
			Object removedObj = this._element[this._size-1];
			this._element[this._size-1] = null;
			this._size--;
			return removedObj;
		}
	}

	@Override
	public Object removeFrom(int aPosition) {
		if(this.isEmpty()) {
			return null;
		} else {
			if(aPosition < 0 || this._size <= aPosition) {
				return null;
			} else {
				Object removedObj = this._element[aPosition];
				for(int i=aPosition; i<=this._size-2; i++) {
					this._element[i] = this._element[i+1];
				}
				this._element[this._size-1] = null;
				this._size--;
				return removedObj;
			}
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public ListIterator<T> listIterator()
	{
		return new ListIterator();
	}

	@SuppressWarnings("hiding")
	public class ListIterator<T> implements Iterator
	{
		private int _nextPosition;
		
		private ListIterator()
		{
			this._nextPosition = 0;
		}
		
		public boolean hasNext()
		{
			return (this._nextPosition < size());
		}
		
		public T next()
		{
			if(this._nextPosition == size()) {
				return null;
			} else {
				@SuppressWarnings("unchecked")
				T t = (T)_element[this._nextPosition];
				this._nextPosition++;
				return t;
			}
		}
	}
}
