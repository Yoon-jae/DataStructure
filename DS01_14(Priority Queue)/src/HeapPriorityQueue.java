
public class HeapPriorityQueue<T extends Comparable> implements PriorityQueue<T> {

	private static final int DEFAULT_CAPACITY = 20;
	private static final int ROOT = 1;
	private int _maxSize;
	private int _size;
	private T [] _tree;
	
	public HeapPriorityQueue()
	{
		this._maxSize = HeapPriorityQueue.DEFAULT_CAPACITY;
		this._size = 0;
		this._tree = (T[])new Comparable[HeapPriorityQueue.DEFAULT_CAPACITY+1];
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
	public boolean add(T anElement){
		if(this.isFull()) {
			return false;
		}
		else {
			if(!(anElement instanceof Comparable))
				throw new IllegalArgumentException();
			this._size++;
			int i = this._size;
			Comparable<T> x = (Comparable<T>)anElement;
			while( (i > ROOT) && ( x.compareTo((T) this._tree[i/2]) > 0) ) {
				this._tree[i] = this._tree[i/2];
				i /= 2; // i = i/2;
			}
			this._tree[i] = anElement;
			return true;
		}
	}

	@Override
	public T max() {
		if(!this.isEmpty()) {
			return (T)this._tree[ROOT];
		} else 
			return null;
	}

	@Override
	public T removeMax() {
		if(!this.isEmpty()) {
			T rootElement = (T) this._tree[ROOT];
			this._size--;
			if(this._size > 0) {
				// ���� �� �Ŀ� ��� �ϳ��� ���Ұ� �����ִ�.
				// �׷��Ƿ� ������ ��ġ (this._size+1)�� ���Ҹ� �����,
				// root ��ġ (1)�κ��� �Ʒ������� ���ο� ��ġ�� ã�� ��������.
				T lastElement = (T)this._tree[this._size+1]; // ����������
				int parent = ROOT;
				int biggerChild;
				while( (parent*2) <= this._size) {
					// child�� ����. left, right �߿��� �� ū key���� ���� child�� biggerChild�� �Ѵ�.
					biggerChild = parent*2;
					Comparable<T> comparable = (Comparable<T>)this._tree[biggerChild];
					if( (biggerChild < this._size) && (comparable.compareTo(this._tree[biggerChild+1]) < 0))
						biggerChild++;
					
					Comparable<T> comparable2 = (Comparable<T>) lastElement;
					if(comparable2.compareTo((T) this._tree[biggerChild]) >= 0)
						break; // lastElement�� �� �̻� �Ʒ��� ������ �ʿ䰡 ����. ������ parent ��ġ�� �����ϸ� �ȴ�.
					// child ���Ҹ� parent ��ġ�� �÷�������. child ��ġ�� ���ο� parent ��ġ�� �ȴ�.
					this._tree[parent] = this._tree[biggerChild];
					parent = biggerChild;
				}
				this._tree[parent] = lastElement;
			}
			return rootElement;
		} else 
			return null;
	}

	@Override
	public int size() {
		return this._size;
	}

	public PriorityQueueIterator<T> priorityQueueIterator()
	{
		return new PriorityQueueIterator();
	}
	
	public class PriorityQueueIterator<T> implements Iterator<T> {

		private int _nextPosition;
		
		private PriorityQueueIterator()
		{
			this._nextPosition = 0;
		}
		
		@Override
		public boolean hasNext() {
			return(this._nextPosition < size());
		}

		@Override
		public T next() {
			if(this._nextPosition == size())
				return null;
			else {
				@SuppressWarnings("unchecked")
				T element = (T)_tree[this._nextPosition + 1];
				this._nextPosition++;
				return element;
			}
		}
		
	}
}
