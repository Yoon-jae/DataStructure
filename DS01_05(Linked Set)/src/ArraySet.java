
public class ArraySet {

	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Star _elements[];
	
	public ArraySet()
	{
		this._maxSize = ArraySet.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._elements = new Star[ArraySet.DEFAULT_MAX_SIZE];
	}
	
	public ArraySet(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._elements = new Star[aMaxSize];
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
		return (this._size == this._maxSize);
	}
	
	public boolean doesContain(Star anElement)
	{
		for(int i = 0; i < this._size; i++) {
			if(this._elements[i].equals(anElement)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean add(Star anElement)
	{
		if(this.isFull()) {
			return false;
		} else {
			for(int i = 0; i < this._size; i++) {
				if(this._elements[i].equals(anElement)) {
					return false;
				} 
			}
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}
	
	public Star remove(Star anElement)
	{
		Star removedStar = null;
		if(this.isEmpty()) {
			return null;
		} else {
			for(int i = 0; i < this._size; i++) {
				if(this._elements[i].equals(anElement)) {
					removedStar = this._elements[i];
					for(int j = i; j < this._size - 1; j++) {
						this._elements[j] = this._elements[j+1];
					}
					this._elements[this._size-1] = null;
					this._size--;
					return removedStar;
				}
			}
			return null;
		}
	}
	
	public Star removeAny()
	{
		if(this.isEmpty()) {
			return null;
		} else {
			Star removedElement = this._elements[this._size-1];
			this._elements[this._size-1] = null;
			this._size--;
			return removedElement;
		}
	}
	
	public void clear()
	{
		for(int i = 0; i < this._size; i++) {
			this._elements[i] = null;
		}
		this._size = 0;
	}
}
