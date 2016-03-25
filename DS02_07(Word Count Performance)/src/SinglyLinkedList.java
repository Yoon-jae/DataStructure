
public class SinglyLinkedList {

	private static final int DEFAULT_MAX_SIZE = 1000;
	private int _maxSize;
	private int _size;
	private Node _head;

	public SinglyLinkedList() {
		this._maxSize = SinglyLinkedList.DEFAULT_MAX_SIZE;
		this._size = 0;
		this._head = null;
	}

	public boolean isEmpty() {
		return (this._size == 0 || this._head == null);
	}

	public boolean isFull() {
		return (this._size == this._maxSize);
	}

	public int size() {
		return this._size;
	}

	public String search(String aWord) {
		Node searchNode = this._head;
		while (searchNode != null) {
			if (searchNode.word().equals(aWord)) {
				searchNode.increaseWordCount(); // 찾았을 시에 count++
				return null; // 이미 있는 값이니 null return.
			}
			searchNode = searchNode.next();
		}
		return aWord; // 못찾았으니 그 값을 그대로 return 하여 추가하도록 한다.
	}

	public boolean add(String aWord) {
		if (this.isFull())
			return false;
		else {
			Node addedNode = new Node(aWord);
			if (!this.isEmpty())
				addedNode.setNext(this._head);
			this._head = addedNode; // head에 바로 추가를 해준다.
			this._size++;
			return true;
		}
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		Node currentNode = this._head;
		while (currentNode != null) {
			buf.append(currentNode.word() + " " + currentNode.wordCount() + "\n");
			currentNode = currentNode.next();
		}
		return buf + "";
	}

	private class Node {

		private String _word;
		private int _wordCount;
		private Node _next;

		public Node(String aWord) {
			this._word = aWord;
			this._wordCount = 1;
			this._next = null;
		}

		public String word() {
			return this._word;
		}

		public int wordCount() {
			return this._wordCount;
		}

		public Node next() {
			return this._next;
		}

		public void setNext(Node aNode) {
			this._next = aNode;
		}

		public void increaseWordCount() {
			this._wordCount++;
		}
	}

}
