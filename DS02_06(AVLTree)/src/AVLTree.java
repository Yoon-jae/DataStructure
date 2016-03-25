
public class AVLTree {

	private int _key, _height;
	private AVLTree _left, _right;
	
	public static final AVLTree NIL = new AVLTree();

	private AVLTree() { // constructs the empty tree
		this._left = this._right = this;
		this._height = -1;
	}

	public AVLTree(int key) {
		this._key = key;
		this._left = this._right = NIL;
	}

	public AVLTree(int key, AVLTree left, AVLTree right) {
		this._key = key;
		this._left = left;
		this._right = right;
		this._height = 1 + Math.max(this._left._height, this._right._height);
	}

	public boolean add(int addKey) {
		int oldsize = this.size();
		this.grow(addKey);
		return this.size() > oldsize;
	}

	public AVLTree grow(int newKey) {
		if (this == NIL)
			return new AVLTree(newKey); // 트리 처음 생성시
		if (newKey == this._key)
			return this; // prevent key duplication
		if (newKey < this._key)
			this._left = this._left.grow(newKey);
		else
			this._right = this._right.grow(newKey);
		
		this.rebalance();
		this._height = 1 + Math.max(this._left._height, this._right._height);
		return this;
	}
	
	public boolean delete(int deleteKey) {
		int oldSize = size();
		decrease(deleteKey);
		return size() < oldSize;
	}
	
	private AVLTree decrease(int deleteKey) { 
		if(deleteKey == this._key) {
			if(this._left == NIL && this._right == NIL)
				return NIL;
			if(this._left == NIL) 
				return this._right;
			if(this._right == NIL)
				return this._left;
			else { // 양쪽 모두 자식이 존재하는 경우.
				if(this._right._left==NIL) // right.left가 없는경우 right을 root로
					return new AVLTree(this._right._key, this._left, this._right._right);
				else { // right의 most left를 root로
					AVLTree leftMostOfRightTree;
					for(leftMostOfRightTree = this._right; leftMostOfRightTree._left != NIL; leftMostOfRightTree = leftMostOfRightTree._left)
						;
					int replaceKey = leftMostOfRightTree._key;
					this.decrease(leftMostOfRightTree._key);
					this._key = replaceKey;
					return new AVLTree(replaceKey, this._left, this._right);
				}
			}
		} 
		if(deleteKey < this._key)
			this._left = this._left.decrease(deleteKey);
		else
			this._right = this._right.decrease(deleteKey);
		
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
		return this._right + " " + this._key + " " + this._left;
	}

	private void rebalance() {
		StringBuffer buf = new StringBuffer("Need rebalance !\n");
		if (this._right._height > this._left._height + 1) {
			if (this._right._left._height > this._right._right._height) {
				this._right.rotateRight();
				buf.append("right.");
			}			
			this.rotateLeft();
			buf.append("left로 ");		
		} else if (this._left._height > this._right._height + 1) {
			if (this._left._right._height > this._left._left._height) {
				this._left.rotateLeft();
				buf.append("left.");
			}			
			this.rotateRight();			
			buf.append("right로 ");		
		}
		
		if (buf.length() != 17) { // rebalance가 되었다면
			buf.append("수정된 Tree");
			this.showTree();
			System.out.println(buf);
		}
	}

	private void rotateLeft() {
		this._left = new AVLTree(this._key, this._left, this._right._left);
		this._key = this._right._key;
		this._right = this._right._right;
	}

	private void rotateRight() {
		this._right = new AVLTree(this._key, this._left._right, this._right);
		this._key = this._left._key;
		this._left = this._left._left;
	}
	
	public void showTree() {
		this.showTreeRecursively(this, 1);
	}

	private void showTreeRecursively(AVLTree currentNode, int depth) {
		if(currentNode != NIL) {
			showTreeRecursively(currentNode._right, depth+1);
			for(int i = 0; i< depth - 1; i++) {
				System.out.printf("      ");
			}
			System.out.printf("( %2d )\n",currentNode._key);
			showTreeRecursively(currentNode._left, depth+1);
			
		}
	}
}
