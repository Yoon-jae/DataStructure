
public class SortedArrayDictionary<Key extends Comparable<Key>, Obj> {

	private static final int DEFAULT_MAX_SIZE = 20;
	private int _maxSize;
	private int _size;
	private Element<Key, Obj> [] _element;
	
	public SortedArrayDictionary()
	{
		this._maxSize = SortedArrayDictionary.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._element = new Element[this._maxSize];
		for(int i=0 ; i<this._maxSize; i++){
			this._element[i] = new Element<>();
		}		
	}
	
	public SortedArrayDictionary(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._element = new Element[this._maxSize];
		for(int i=0 ; i<this._maxSize; i++){
			this._element[i] = new Element<>();
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
	
	public int size()
	{
		return this._size;
	}
	
	public boolean keyDoesExist(Key aKey)
	{
		for(int i=0; i<this._size; i++) {
			if(this._element[i].key().compareTo(aKey)==0) {
				return true;
			}
		}
		return false;
	}
	
	public Obj objectForKey(Key aKey)
	{
		if(!isEmpty()) {
			Obj anObject = null;
			for(int i=0; i<this._size; i++) {
				if(this._element[i].key().compareTo(aKey)==0) {
					anObject = this._element[i].object();
					break;
				}
			}
			return anObject;
		} else {
			return null;
		}
	}
	
	public boolean addKeyAndObject(Key aKey, Obj anObject)
	{
		if(!this.isFull()) {
			if(!this.keyDoesExist(aKey)) {
				if(this.isEmpty()) {
					this._element[0].setKey(aKey);
					this._element[0].setObject(anObject);
					this._size++;
					return true;
				} else {
					for(int i=0; i<this._size; i++) {
						if(this._element[i].key().compareTo(aKey) > 0) {
							for(int j = this._size-1; j>=i; j--) {
								this._element[j+1] = this._element[j];
							}
							this._element[i].setKey(aKey);
							this._element[i].setObject(anObject);
							this._size++;
							return true;
						}
					}
					this._element[this._size].setKey(aKey);
					this._element[this._size].setKey(aKey);
					this._size++;
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Obj removeObjectForKey(Key aKey)
	{
		if(!this.isEmpty()) {
			if(this.keyDoesExist(aKey)) {
				Obj removeObj = null;
				for(int i = 0; i < this._size; i++) {
					if(this._element[i].key().compareTo(aKey) == 0){
						removeObj = this._element[i].object();
						for(int j = i; j < this._size - 1; j++) {
							this._element[j] = this._element[j+1];
						}
						this._element[this._size - 1] = null;
						this._size--;
					}
				}
				return removeObj;
			} else {
				return null;
			}
		} else {
			return null;
		}
			
	}
	
	public boolean replaceObjectForKey(Obj newObject, Key aKey)
	{
		if(!this.isEmpty()) {
			for(int i=0; i<this._size; i++) {
				if(this._element[i].key().compareTo(aKey)==0) {
					this._element[i].setObject(newObject);
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
	
	public void clear()
	{
		this._size = 0;
		this._element = null;
	}
}