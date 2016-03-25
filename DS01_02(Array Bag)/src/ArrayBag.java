
public class ArrayBag {

	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Coin _elements[];
	
	public ArrayBag()
	{
		this._maxSize = ArrayBag.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._elements = new Coin[ArrayBag.DEFAULT_MAX_SIZE];
	}
	
	public ArrayBag(int givenMaxSize)
	{
		this._maxSize = givenMaxSize;
		this._size = 0;
		this._elements = new Coin[givenMaxSize];
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
	
	public boolean doesContain(Coin anElement)
	{
		boolean found = false;
		for(int i = 0; i < this._size && !found; i++) {
			if(this._elements[i].equals(anElement)) {
				found = true;
			}
		}
		return found;
	}
	
	public int frequencyOf(Coin anElement)
	{
		int numbers = 0;
		for(int i = 0; i < this._size; i++) {
			if(this._elements[i].equals(anElement)) {
				numbers++;
			}
		}		
		return numbers;
	}
	
	public int maxElementValue()
	{
		int maxElement = 0;
		for(int i = 0; i < this._size; i++) {
			if(this._elements[i].value() > maxElement) {
				maxElement = this._elements[i].value();
			} 
		}
		return maxElement;
	}
	
	public int sumElementValues()
	{
		int sumElements = 0;
		for(int i = 0; i < this._size; i++) {
			sumElements += this._elements[i].value();
		}
		return sumElements;
	}
	
	public boolean add(Coin anElement)
	{
		if(this.isFull()) {
			return false;
		} else {
			this._elements[this._size] = anElement;
			this._size++;
			return true;
		}
	}
	
	public boolean remove(Coin anElement)
	{
		if(this.isEmpty()) {
			return false;
		} else {
			int foundIndex;
			boolean found = false;
			
			for(foundIndex = 0; foundIndex < this._size && !found; foundIndex++) {
				if(this._elements[foundIndex].equals(anElement)) {
					found = true;
				}
			}
			
			if(!found) {
				return false;
			} else {
				for(int i = foundIndex; i < this._size - 1; i++) {
					this._elements[i] = this._elements[i+1];
				}
				this._elements[this._size-1] = null;
				this._size--;
				return true;
			}
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
