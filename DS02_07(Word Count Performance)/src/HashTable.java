
public class HashTable {
	
	private Entry[] _entries;
	private int _size, _used;
	private float _loadFactor;
	private final Entry NIL = new Entry(null);
	
	public HashTable(int capacity, float loadFactor) {
		this._size = 0;
		this._used = 0;
		this._entries = new Entry[capacity];
		this._loadFactor = loadFactor;
	}

	public HashTable(int capacity) {
		this(capacity, 0.75F);
	}
	
	public HashTable() {
		this(17);
	}
	
	public String search(String aWord) throws IllegalAccessException {
		// TODO Auto-generated method stub
		int h = hash(aWord);
		int d = hash2(aWord);
		for(int i = 0; i < this._entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry anEntry = this._entries[j];
			if(anEntry == null) break;
			if(anEntry == NIL) continue;
			if(anEntry.word().equals(aWord)) { 
				anEntry.increaseWordCount();
				return null; // 찾았으니 count++ && return null
			}
		}
		return aWord; // 찾지 못헀으니 추가하기 위해 그대로 return
	}
	
	public String add(String aWord) throws IllegalAccessException {
		
		if(this._used > this._loadFactor * this._entries.length) 
			rehash();
		int h = hash(aWord);
		int d = hash2(aWord);
		for(int i = 0; i < this._entries.length; i++) {
			int j = nextProbe(h, d, i);
			Entry anEntry = this._entries[j];
			if(anEntry == null) {
				this._entries[j] = new Entry(aWord);
				++this._size;
				++this._used;
				break; // insertion success 
			}
			if(anEntry == NIL) 
				continue;
		}
		return null; // failure : table overflow
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
	
	public void rehash() throws IllegalAccessException {
		Entry[] oldEntries = this._entries;
		this._entries = new Entry[2 * oldEntries.length + 1];
		for(int k = 0; k < oldEntries.length; k++) {
			Entry anEntry = oldEntries[k];
			if(anEntry == null || anEntry == NIL)
				continue;
			int h = hash(anEntry.word());
			int d = hash2(anEntry.word());
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

	public int size() {
		return this._size;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<this._entries.length; i++) {
			if(this._entries[i] != null && this._entries[i] != NIL) {
				buf.append(this._entries[i].word() + " " + this._entries[i].wordCount() + "\n");
			}
		}
		return buf + "";
	}
	
	private class Entry {

		private Object _word;
		private int _wordCount;

		public Entry(Object aWord) {
			this._word = aWord;
			this._wordCount = 1;
		}

		public Object word() {
			return this._word;
		}

		public int wordCount() {
			return this._wordCount;
		}

		public void increaseWordCount() {
			this._wordCount++;
		}

	}

}
