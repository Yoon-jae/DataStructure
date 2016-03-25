
public interface PriorityQueue<T> {
	public boolean isEmpty();
	public boolean isFull();
	
	public boolean add(T anElement);
	public T max();
	public T removeMax();
	public int size();
}
