
public class SortedLinkedDictionary<Key extends Comparable<Key>, Obj> {

	private static final int DEFAULT_INITIAL_CAPACITY = 20;
	private int _maxSize;
	private int _size;
	private Node<Key,Obj> _head;
	
	public SortedLinkedDictionary()
	{
		this._maxSize = SortedLinkedDictionary.DEFAULT_INITIAL_CAPACITY;
		this._size = 0;
		this._head = null;
	}
	
	public SortedLinkedDictionary(int aMaxSize)
	{
		this._maxSize = aMaxSize;
		this._size = 0;
		this._head = null;
	}
	
	public boolean isEmpty()
	{
		return (this._size == 0 || this._head == null);
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
		if(this.isEmpty()) {
			return false;
		} else {
			Node<Key, Obj> currentNode = this._head;
			while(currentNode != null) {
				if(currentNode.element().compareTo(aKey) == 0) {
					return true;
				}
				currentNode = currentNode.next();
			}
			return false;
		}
	}
	
	public Obj objectForKey(Key aKey)
	{
		Obj anObject = null;
		if(!this.isEmpty()) {			
			Node<Key, Obj> currentNode = this._head;
			while(currentNode != null) {
				if(currentNode.element().compareTo(aKey) == 0) {
					anObject = currentNode.element().object();
					return anObject;
				}
				currentNode = currentNode.next();
			}
			return anObject;
		} else {
			return anObject;
		}
	}
	
	public boolean addKeyAndObject(Key aKey, Obj anObject)
	{
//		System.out.println("add 시작");
		if(!this.isFull()) {
			if(!this.keyDoesExist(aKey)) {
				Node<Key, Obj> currentNode = this._head;
				Node<Key, Obj> previousNode = null;
				Node<Key, Obj> newNode = new Node<Key,Obj>();
				
				newNode.element().setKey(aKey);
				newNode.element().setObject(anObject);
				
				if(this.isEmpty()) {
					this._head = newNode;
					this._size++;
					return true;
				} else {
					while(currentNode != null) {
						if (currentNode.element().compareTo(aKey) > 0) {
							break;
						}
						previousNode = currentNode;
						currentNode = currentNode.next();
					}
					
					if(currentNode == this._head) { // previousNode == null 인 상태
						newNode.setNext(this._head);
						this._head = newNode;
					} else {
						if(currentNode == null) {
							previousNode.setNext(newNode);
						} else {
							newNode.setNext(currentNode);
							previousNode.setNext(newNode);
						}
						this._size++;
						return true;
					}
				}
			}
		} else {
			return false;
		}
		return true;
	}
	
	public Obj removeObjectForKey(Key aKey)
	{
//		System.out.println("remove 시작");
		if(!this.isEmpty()) {
			if(this.keyDoesExist(aKey)) {
				Node<Key, Obj> removeNode = null;
				if(this._head.element().key().compareTo(aKey) == 0) {
					removeNode = this._head;
					this._head = this._head.next();
				} else {
					Node<Key, Obj> previousNode = this._head;
					while( !(previousNode.next().element().key().compareTo(aKey) == 0)) {
						previousNode = previousNode.next();
					}
					removeNode = previousNode.next();
					previousNode.setNext(removeNode.next());
				}
				this._size--;
				return removeNode.element().object();
			} else {
				return null;
			}			
		} else {
			return null;
		}

	}
	
	public boolean replaceObjectForKey(Obj newObject, Key aKey)
	{
		System.out.println("rearch 시작");

		if(!this.isEmpty()) {
			if(!this.keyDoesExist(aKey)) {
				Node<Key, Obj> currentNode = this._head;
				while( ! (currentNode.element().key().compareTo(aKey) == 0)) {
					currentNode = currentNode.next();
				}
				currentNode.element().setObject(newObject);
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	
	public void clear()
	{
		this._size = 0;
		this._head = null;
	}
}
