
public class AVLTree {

	private String _word;
	private int _height;
	private int _wordCount;
	private AVLTree _left, _right;

	public static final AVLTree NIL = new AVLTree();

	private AVLTree() { // constructs the empty tree
		this._left = this._right = this;
		this._height = -1;
	}

	public AVLTree(String aWord, int aCount) {
		this._word = aWord;
		this._wordCount = aCount;
		this._left = this._right = NIL;
	}

	public AVLTree(String aWord, int aCount, AVLTree left, AVLTree right) {
		this._word = aWord;
		this._wordCount = aCount;
		this._left = left;
		this._right = right;
		this._height = 1 + Math.max(this._left._height, this._right._height);
	}

	public String search(String aWord) {
		if (this == NIL || this == null) // 찾지 못한 경우 그대로 return
			return aWord;
		if (aWord.compareTo(this._word) == 0) { // 찾은 경우 count++ && return null
			this._wordCount++;
			return null;
		} else if (aWord.compareTo(this._word) < 0)
			return this._left.search(aWord);
		else
			return this._right.search(aWord);
	}

	public boolean add(String aWord) {
		int oldsize = this.size();
		this.grow(aWord);
		return this.size() > oldsize;
	}

	public AVLTree grow(String aWord) {
		if (this == NIL) 
			return new AVLTree(aWord, 1); // 트리 처음 생성시
		if (aWord.equals(this._word)) 
			return this;
		else if (aWord.compareTo(this._word) < 0)
			this._left = this._left.grow(aWord);
		else
			this._right = this._right.grow(aWord);

		this.rebalance();
		this._height = 1 + Math.max(this._left._height, this._right._height);
		return this;
	}

	public boolean delete(String aWord) {
		int oldSize = size();
		decrease(aWord);
		return size() < oldSize;
	}

	private AVLTree decrease(String aWord) {
		if (aWord == this._word) {
			if (this._left == NIL && this._right == NIL)
				return NIL;
			if (this._left == NIL)
				return this._right;
			if (this._right == NIL)
				return this._left;
			else { // 양쪽 모두 자식이 존재하는 경우.
				if (this._right._left == NIL) // right.left가 없는경우 right을 root로
					return new AVLTree(this._right._word, 0, this._left, this._right._right);
				else { // right의 most left를 root로
					AVLTree leftMostOfRightTree;
					for (leftMostOfRightTree = this._right; leftMostOfRightTree._left != NIL; leftMostOfRightTree = leftMostOfRightTree._left)
						;
					String replaceWord = leftMostOfRightTree._word;
					this.decrease(leftMostOfRightTree._word);
					this._word = replaceWord;
					return new AVLTree(replaceWord, 0, this._left, this._right);
				}
			}
		}
		if (aWord.compareTo(this._word) < 0)
			this._left = this._left.decrease(aWord);
		else
			this._right = this._right.decrease(aWord);

		this.rebalance();
		this._height = 1 + Math.max(this._left._height, this._right._height);
		return this;
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + this._left.size() + this._right.size();
	}

	public String toString() {
		if (this == NIL)
			return "";
		return this._left + this._word + " " + this._wordCount + "\n" + this._right;
	}

	private void rebalance() {
		if (this._right._height > this._left._height + 1) {
			if (this._right._left._height > this._right._right._height)
				this._right.rotateRight();
			this.rotateLeft();
		} else if (this._left._height > this._right._height + 1) {
			if (this._left._right._height > this._left._left._height)
				this._left.rotateLeft();
			this.rotateRight();
		}
	}

	private void rotateLeft() {
		this._left = new AVLTree(this._word, this._wordCount, this._left, this._right._left);
		this._word = this._right._word;
		this._right = this._right._right;
		this._wordCount = this._right._wordCount;
	}

	private void rotateRight() {
		this._right = new AVLTree(this._word, this._wordCount, this._left._right, this._right);
		this._word = this._left._word;
		this._left = this._left._left;
		this._wordCount = this._left._wordCount;
	}

	public void showTree() {
		this.showTreeRecursively(this, 1);
	}

	private void showTreeRecursively(AVLTree currentNode, int depth) {
		if (currentNode != NIL) {
			showTreeRecursively(currentNode._right, depth + 1);
			for (int i = 0; i < depth - 1; i++) {
				System.out.printf("      ");
			}
			System.out.printf("( %2s )\n", currentNode._word);
			showTreeRecursively(currentNode._left, depth + 1);

		}
	}
}
