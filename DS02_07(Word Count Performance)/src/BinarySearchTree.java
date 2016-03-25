
public class BinarySearchTree {

	private BinaryNode _root;
	private int _size;
	StringBuffer buf = new StringBuffer();
	
	public BinarySearchTree() {
		this._root = null;
		this._size = 0;
	}

	public BinarySearchTree(int aTestSize) {
		this._root = null;
		this._size = aTestSize;
	}
	
	public String search(String aWord) {
		return this.keyDoesExistInTree(this._root, aWord);
	}
	
	private String keyDoesExistInTree(BinaryNode currentRoot, String aWord) {
		if (currentRoot == null) { // 없다면 word를 추가하기 위해 그대로 return
			return aWord;
		} else {
			if (currentRoot.word().compareTo(aWord) == 0) {
				currentRoot.increaseWordCount(); // 찾았으면 count++ && null을 return.
				return null;
			} else if (currentRoot.word().compareTo(aWord) > 0) {
				return this.keyDoesExistInTree(currentRoot.left(), aWord);
			} else {
				return this.keyDoesExistInTree(currentRoot.right(), aWord);
			}
		}
	}
	
	public boolean add(String aWord) {
		if (this._root == null) {
			this._root = new BinaryNode(aWord);
			this._size++;
			return true;
		} else {
			return addKeyAndObjectToSubtree(this._root, aWord);
		}
	}

	private boolean addKeyAndObjectToSubtree(BinaryNode currentRoot, String aWord) {
		BinaryNode newNode = null;
		if (currentRoot.word().compareTo(aWord) == 0) {
			return false;
		} else if (currentRoot.word().compareTo(aWord) > 0) {
			if (currentRoot.left() == null) {
				newNode = new BinaryNode(aWord);
				currentRoot.setLeft(newNode);
				this._size++;
				return true;
			} else {
				return addKeyAndObjectToSubtree(currentRoot.left(), aWord);
			}
		} else {
			if (currentRoot.right() == null) {
				newNode = new BinaryNode(aWord);
				currentRoot.setRight(newNode);
				this._size++;
				return true;
			} else {
				return addKeyAndObjectToSubtree(currentRoot.right(), aWord);

			}
		}
	}	

	public void showDictionary() {
		this.showTreeRecursively(this._root, 1);
	}

	private void showTreeRecursively(BinaryNode currentNode, int depth) {
		if (currentNode != null) {
			showTreeRecursively(currentNode.right(), depth + 1);
			for (int i = 0; i < depth - 1; i++) {
				System.out.printf("       ");
			}
			System.out.println("(" + currentNode.word() + ")");
			showTreeRecursively(currentNode.left(), depth + 1);

		}
	}

	public String toString() {
		// TODO Auto-generated method stub
		this.inOrderRecursively(this._root);
		return buf + "";
	}
	
	public int size() {
		return this._size;
	}

	private void inOrderRecursively(BinaryNode aRoot) {
		if (aRoot != null) {
			this.inOrderRecursively(aRoot.left());
			buf.append(aRoot.word() + " " + aRoot.wordCount() + "\n");
			this.inOrderRecursively(aRoot.right());
		}
	}

	private class BinaryNode {

		private String _word;
		private int _wordCount;
		private BinaryNode _left;
		private BinaryNode _right;

		public BinaryNode(String aWord) {
			this._word = aWord;
			this._wordCount = 1;
			this._left = null;
			this._right = null;
		}

		public String word() {
			return this._word;
		}
		
		public int wordCount() {
			return this._wordCount;
		}

		public BinaryNode left() {
			return this._left;
		}

		public BinaryNode right() {
			return this._right;
		}
		
		public void setLeft(BinaryNode aLeft) {
			this._left = aLeft;
		}

		public void setRight(BinaryNode aRight) {
			this._right = aRight;
		}
		
		public void increaseWordCount() {
			this._wordCount++;
		}

	}

}
