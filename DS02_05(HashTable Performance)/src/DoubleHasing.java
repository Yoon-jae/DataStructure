
public class DoubleHasing implements HashTable{
	
	private Entry[] _entries;
	private int _size, _used;
	private float _loadFactor;
	private final Entry NIL = new Entry(null, null);
	
	private int _numOfRecords;
	private int _numOfCollisons;
	private StringBuffer _LinearProbingBuf;
	
	public DoubleHasing(int capacity, float loadFactor) {
		this._size = 0;
		this._used = 0;
		this._entries = new Entry[capacity];
		this._loadFactor = loadFactor;
		
		this._numOfRecords = 0;
		this._numOfCollisons = 0;
		this._LinearProbingBuf = new StringBuffer("Starting Double hashing:\n");
	}

	public DoubleHasing(int capacity) {
		this(capacity, 0.75F);
	}
	
	public DoubleHasing() {
		this(17);
	}
	
	@Override
	public Object getValue(Object key) throws IllegalAccessException {
		// TODO Auto-generated method stub
		int h = hash(key);
		int d = hash2(key);
		for(int i = 0; i < this._entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry anEntry = this._entries[j];
			if(anEntry == null) break;
			if(anEntry == NIL) continue;
			if(anEntry.key().equals(key)) 
				return anEntry.value();
		}
		return null; // failure : key not found
	}

	@Override
	public Object put(Object newKey, Object newValue) throws IllegalAccessException {
		// TODO Auto-generated method stub
		this._LinearProbingBuf.append(++this._numOfRecords + "." + newKey);
		
		if(this._used > this._loadFactor * this._entries.length) 
			rehash();
		int h = hash(newKey);
		int d = hash2(newKey);
		for(int i = 0; i < this._entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry anEntry = this._entries[j];
			if(anEntry == null) {
				this._LinearProbingBuf.append(" -> " + j + "\n");
				this._entries[j] = new Entry(newKey, newValue);
				++this._size;
				++this._used;
				break; // insertion success 
			}
			if(anEntry == NIL) 
				continue;
			if(anEntry.key().equals(newKey)) {
				Object oldValue = anEntry.value();
				this._entries[j].setValue(newValue);
				return oldValue;
			}
			this._numOfCollisons++;
			this._LinearProbingBuf.append(" -> " + j);
		}
		return null; // failure : table overflow
	}

	@Override
	public void putAll() throws IllegalAccessException {
		this.put("AT", new Country("Austria", "German", 32378, 8139299));
		this.put("BE", new Country("Belgium", "Dutch", 11800, 10182034));
		this.put("DE", new Country("Germany", "German", 137800, 82087361));
		this.put("DK", new Country("Denmark", "Danish", 16639, 5356845));
		this.put("ES", new Country("Spain", "Spanish", 194880, 39167744));
		this.put("FR", new Country("France", "French", 211200, 58978172));
		this.put("IT", new Country("Italy", "Italian", 116300, 56735130));
		this.put("LU", new Country("Luxembourg", "French", 998, 429080));
		this.put("SE", new Country("Sweden", "Portuguese", 35672, 9918040));
		this._LinearProbingBuf.append(this._numOfCollisons + " Collisons\n");
		System.out.println(this._LinearProbingBuf);
	}
	
	@Override
	public Object remove(Object removingKey) throws IllegalAccessException {
		// TODO Auto-generated method stub
		int h = hash(removingKey);
		int d = hash2(removingKey);
		for(int i = 0; i < this._entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry anEntry = this._entries[j];
			if(anEntry == null)
				break;
			if(anEntry == NIL)
				continue;
			if(anEntry.key().equals(removingKey)) {
				Object oldValue = anEntry.value();
				this._entries[j] = NIL;
				--this._size;
				return oldValue; // success
			}
		}
		return null;
	}
	
	private int hash(Object key) throws IllegalAccessException {
		if(key == null)
			throw new IllegalAccessException();
		return (key.hashCode() & 0x7FFFFFFF) % this._entries.length;
	}
	
	private int hash2(Object key) throws IllegalAccessException {
		if(key == null)
			throw new IllegalAccessException();
		return 1 + (key.hashCode() & 0x7FFFFFFF) % (this._entries.length - 1);
	}
	
	private int nextProbe(int h, int d, int i) {
		return (h + d*i) % this._entries.length;
	}

	@Override
	public void rehash() throws IllegalAccessException {
		// TODO Auto-generated method stub
		Entry[] oldEntries = this._entries;
		this._entries = new Entry[2 * oldEntries.length + 1];
		for(int k = 0; k < oldEntries.length; k++) {
			Entry anEntry = oldEntries[k];
			if(anEntry == null || anEntry == NIL)
				continue;
			int h = hash(anEntry.key());
			int d = hash2(anEntry.key());
			for(int i = 0; i < this._entries.length; i++) {
				int j = nextProbe(h, d, i);
				if(this._entries[j] == null) {
					this._entries[j] = anEntry;
					break;
				}
			}
		}
		this._used = this._size;
	}
}
