
public interface HashTable { // hashMethod를 사용하는 method들.
	public Object getValue(Object key) throws IllegalAccessException;
	public Object put(Object newKey, Object newValue) throws IllegalAccessException;
	public void putAll() throws IllegalAccessException;
	public Object remove(Object removingKey) throws IllegalAccessException;
	public void rehash() throws IllegalAccessException;
}
