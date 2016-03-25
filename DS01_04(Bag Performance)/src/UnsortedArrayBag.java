
public class UnsortedArrayBag {
	
	private static final int DEFAULT_MAX_SIZE = 50000;
	private int _size;
	private int _maxSize;
	private Coin _elements[];
	
	public UnsortedArrayBag()
	{
		this._size = 0;
		this._maxSize = UnsortedArrayBag.DEFAULT_MAX_SIZE;
		this._elements = new Coin[UnsortedArrayBag.DEFAULT_MAX_SIZE];
	}
	
	public UnsortedArrayBag(int givenMaxSize)
	{
		this._size = 0;
		this._maxSize = givenMaxSize;
		this._elements = new Coin[givenMaxSize];
	}

	public void add(Coin aCoin) {
		if(!this.isFull()) {
			this._elements[this._size] = aCoin;
			this._size++;
		}		
	}

	public Coin maxElement() {
		int maxElement = 0;
		if(!this.isEmpty()) {
			for(int i = 0; i < this._size; i++) {
				if(maxElement < this._elements[i].value()) {
					maxElement = this._elements[i].value();
				}
			}
			Coin maxCoin = new Coin(maxElement);
			return maxCoin;
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
