
public class SortedArrayBag {

	private static final int DEFAULT_MAX_SIZE = 50000;
	private int _size;
	private int _maxSize;
	private Coin _elements[];
	
	public SortedArrayBag()
	{
		this._size = 0;
		this._maxSize = SortedArrayBag.DEFAULT_MAX_SIZE;
		this._elements = new Coin[SortedArrayBag.DEFAULT_MAX_SIZE];
	}
	
	public SortedArrayBag(int givenMaxSize)
	{
		this._size = 0;
		this._maxSize = givenMaxSize;
		this._elements = new Coin[givenMaxSize];
	}

	public void add(Coin aCoin)
	{
		if(!this.isFull()) {
			int i;
			for(i = 0; i < this._size; i++) {
				if(aCoin.value() < this._elements[i].value()) {
					break;
				}
			}
			if(i < this._size) {
				for(int j = this._size - 1; j >= i; j--) {
					this._elements[j+1] = this._elements[j];
				}
				this._elements[i] = aCoin;
				this._size++;
			} else {
				this._elements[this._size] = aCoin;
				this._size++;
			}
		} 		
	}

	public Coin maxElement() {
		if(!this.isEmpty()) {
			return this._elements[this._size-1];
		} else {
			return null;
		}
	}

	public boolean isEmpty()
	{
		return (this._size == 0);
	}
	
	public boolean isFull()
	{
		return (this._size == this._maxSize);
	}
}
