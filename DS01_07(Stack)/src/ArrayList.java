
public class ArrayList<T> implements Stack<T> {

	private static final int DEFAULT_MAX_STACK_SIZE = 5;
	private int _maxSize;
	private int _top;
	private T[] _elements;
	
	@SuppressWarnings("unchecked")
	public ArrayList()
	{
		this._maxSize = ArrayList.DEFAULT_MAX_STACK_SIZE;
		this._top = -1;
		this._elements = (T[])new Object[ArrayList.DEFAULT_MAX_STACK_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int givenMaxSize)
	{
		this._maxSize = givenMaxSize;
		this._top = -1;
		this._elements = (T[])new Object[givenMaxSize];
	}
	
	public boolean isEmpty()
	{
		return (this._top == -1);
	}
	
	public boolean isFull()
	{
		return (this._top + 1 == this._maxSize);
	}
	
	public int size()
	{
		return this._top + 1;
	}

	public Character elementAt(int index) {
		if(!this.isEmpty()) {
			if(0 <= index && index < this.size()) {
				return ((Character) this._elements[index]);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public boolean push(T anElement) {
		if(this.isFull()) {
			return false;
		} else {
			this._top++;
			this._elements[this._top] = anElement;
			return true;
		}
	}

	@Override
	public T pop() {
		if(this.isEmpty()) {
			return null;
		} else {
			T topElement = this._elements[this._top];
			this._elements[this._top] = null;
			this._top--;
			return topElement;
		}
	}

	@Override
	public T peek() {
		if(this.isEmpty()) {
			return null;
		} else {
			return this._elements[this._top];
		}
	}
}
