
public class BinarySearchTree<Key extends Comparable<Key>, Obj> {

	private BinaryNode<Key, Obj> _root;
	private int _size;
	private VisitEventForTreeTraversal _callerForVisitEvent;
	
	public BinarySearchTree()
	{
		this._root = null;
		this._size = 0;
	}
	
	public BinarySearchTree(int aTestSize)
	{
		this._root = null;
		this._size = aTestSize;
	}
	
	// 비공개 함수
	private boolean keyDoesExistInTree(BinaryNode<Key, Obj> currentRoot, Key aKey)
	{
		if(currentRoot == null) {
			return false;
		} else {
			if(currentRoot.element().key().compareTo(aKey) == 0) {
				return true;
			} else if(currentRoot.element().key().compareTo(aKey) > 0) {
				return this.keyDoesExistInTree(currentRoot.left(), aKey);
			} else {
				return this.keyDoesExistInTree(currentRoot.right(), aKey);
			}
		}
	}
	
	private boolean addKeyAndObjectToSubtree(BinaryNode<Key, Obj> currentRoot, Key aKey, Obj anObject)
	{
		BinaryNode<Key, Obj> newNode = null;
		if(currentRoot.element().key().compareTo(aKey) == 0) {
			return false;
		} else if(currentRoot.element().key().compareTo(aKey) > 0) {
			if(currentRoot.left() == null) {
				newNode = new BinaryNode<Key, Obj>(new Element<Key,Obj>(aKey,anObject),null,null);
				currentRoot.setLeft(newNode);
				this._size++;
				return true;
			} else {
				return addKeyAndObjectToSubtree(currentRoot.left(), aKey, anObject);
			}
		} else {
			if(currentRoot.right() == null) {
				newNode = new BinaryNode<Key, Obj>(new Element<Key,Obj>(aKey,anObject),null,null);
				currentRoot.setRight(newNode);
				this._size++;
				return true;
			} else {
				return addKeyAndObjectToSubtree(currentRoot.right(), aKey, anObject);

			}
		}
	}
	
	private BinaryNode removeRightMostOfLeftTree(BinaryNode<Key, Obj> currentRoot)
	{
		BinaryNode<Key,Obj> leftOfCurrentRoot = currentRoot.left();
		if(leftOfCurrentRoot == null) {
			return null;
		}
		if(leftOfCurrentRoot.right() == null) {
			currentRoot.setLeft(leftOfCurrentRoot.left());
			return leftOfCurrentRoot;
		} else {
			BinaryNode<Key, Obj> parentOfRightMost = leftOfCurrentRoot;
			BinaryNode<Key, Obj> rightMost = leftOfCurrentRoot.right();
			while(rightMost.right() != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right();
			}
			parentOfRightMost.setRight(rightMost.left());
			rightMost.setLeft(null);
			return rightMost;
		}
	}
	
	private Obj removeObjectForKeyFromSubtree(BinaryNode<Key, Obj> currentRoot, Key aKey)
	{
		// 이 시점에, currentRoot는 null이 아니고, currentRoot의 key는 aKey와 일치하지 않는다.
				if (currentRoot.element().key().compareTo(aKey) > 0) { // left subtree에서 삭제해야한다.
					BinaryNode<Key, Obj> child = currentRoot.left();
					if(child == null) {
						return null;
					} else {
						if (child.element().key().compareTo(aKey) == 0) {
							Obj removedObject = child.element().object();
							if (child.left() == null && child.right() == null) { // child가 leaf
								currentRoot.setLeft(null);
							} else if (child.left() == null) { // child와 left tree가 없다.
								currentRoot.setLeft(child.right());
							} else if (child.right() == null) { // child의 right tree가 없다.
								currentRoot.setLeft(child.left());
							} else { // child의 left, right tree가 모두 있다.
								BinaryNode<Key, Obj> newChild = removeRightMostOfLeftTree(child);
								newChild.setLeft(child.left());
								newChild.setRight(child.right());
								currentRoot.setLeft(newChild);
							}
							this._size--;
							return removedObject;
						} else {
							return removeObjectForKeyFromSubtree(child, aKey);
						}
					}
				} else { // right subtree에서 삭제해야한다.
					BinaryNode<Key, Obj> child = currentRoot.right();
					if ( child == null) {
						return null;
					} else {
						if (child.element().key().compareTo(aKey) == 0) {
							Obj removedObject = child.element().object();
							if (child.left() == null && child.right() == null) { // child가 leaf
								currentRoot.setRight(null);
							} else if (child.left() == null) { // child의 left tree가 없다.
								currentRoot.setRight(child.right());
							} else if (child.right() == null) { // child의 right tree가 없다.
								currentRoot.setRight(child.left());
							} else { // child의 left, right tree가 모두 있다.
								BinaryNode<Key, Obj> newChild = removeRightMostOfLeftTree(child);
								newChild.setLeft(child.left());
								newChild.setRight(child.right());
								currentRoot.setRight(newChild);
							}
							this._size--;
							return removedObject;
						} else {
							return removeObjectForKeyFromSubtree(child, aKey);
						}
					}
				}
	}
	
	// 공개함수
	public boolean keyDoesExist(Key aKey)
	{
		return this.keyDoesExistInTree(this._root, aKey);
	}
	
	public boolean addKeyAndObject(Key aKey, Obj anObject)
	{
		if(this._root == null) {
			this._root = new BinaryNode<Key,Obj>(new Element<Key,Obj>(aKey,anObject),null,null);
			this._size++;
			return true;
		} else {
			return addKeyAndObjectToSubtree(this._root, aKey, anObject);
		}
	}
	
	public Obj objectForKey(Key aKey)
	{
		boolean found = false;
		BinaryNode<Key,Obj> currentRoot = this._root;
		while ( !(found) && (currentRoot != null) ) {
			if(currentRoot.element().key().compareTo(aKey) == 0) {
				found = true;
			} else if(currentRoot.element().key().compareTo(aKey) > 0) {
				currentRoot = currentRoot.left();
			} else {
				currentRoot = currentRoot.right();
			}
		}
		if(found) {
			return currentRoot.element().object();
		} else {
			return null;
		}
	}
	
	public Obj removeObjectForKey(Key aKey)
	{
		Obj removedObject = null;
		if(this._root == null) {
			return null;
		} else if(this._root.element().key().compareTo(aKey) == 0) {
			removedObject = this._root.element().object();
			if((this._root.left() == null) && (this._root.right() == null)) {
				this._root = null;
			} else if(this._root.left() == null) {
				this._root = this._root.right();
			} else if(this._root.right() == null) {
				this._root = this._root.left();
			} else {
				BinaryNode<Key,Obj> newRoot = removeRightMostOfLeftTree(this._root);
				newRoot.setLeft(this._root.left());
				newRoot.setRight(this._root.right());
				this._root = newRoot;
			}
			this._size--;
			return removedObject;
		} else {
			return removeObjectForKeyFromSubtree(this._root, aKey);
		}
	}
	
	public boolean replaceObjectForKey(Obj newObject, Key aKey)
	{
		boolean found = false;
		BinaryNode<Key,Obj> currentRoot = this._root;
		while( (!found) && (currentRoot != null) ) {
			if(this._root.element().key().compareTo(aKey) == 0) {
				found = true;
			} else if(this._root.element().key().compareTo(aKey) > 0) {
				currentRoot = currentRoot.left();
			} else {
				currentRoot = currentRoot.right();
			}
		}
		if(found) {
			currentRoot.element().setObject(newObject);
			return true;
		} else {
			return false;
		}
	}
	
	public void setCallerForVisitEvent(VisitEventForTreeTraversal aCaller)
	{
		this._callerForVisitEvent = aCaller;
	}
	
	public void visit(Obj anObj)
	{
		this._callerForVisitEvent.processVisitByCallback(anObj);
	}
		
	public void showDictionary()
	{
		this.showTreeRecursively(this._root, 1);
	}

	private void showTreeRecursively(BinaryNode<Key, Obj> currentNode, int depth)
	{
		if(currentNode != null) {
			showTreeRecursively(currentNode.right(), depth+1);
			for(int i = 0; i< depth - 1; i++) {
				System.out.printf("       ");
			}
			System.out.println("(" + currentNode.element().key() + ", " + currentNode.element().object() + ")");
			showTreeRecursively(currentNode.left(), depth+1);
			
		}
	}

	public void inOrder() {
		// TODO Auto-generated method stub
		this.inOrderRecursively(this._root);
	}
	
	private void inOrderRecursively(BinaryNode<Key, Obj> aRoot)
	{
		if(aRoot != null) {
			this.inOrderRecursively(aRoot.left());
			this.visit(aRoot.element().object());
			this.inOrderRecursively(aRoot.right());
		}
	}

	public void preOrder() {
		// TODO Auto-generated method stub
		this.preOrderRecursively(this._root);
	}
	
	private void preOrderRecursively(BinaryNode<Key, Obj> aRoot)
	{
		if(aRoot != null) {
			this.visit(aRoot.element().object());
			this.preOrderRecursively(aRoot.left());
			this.preOrderRecursively(aRoot.right());
		}
	}

	public void postOrder() {
		// TODO Auto-generated method stub
		this.postOrderRecursively(this._root);
	}
	
	private void postOrderRecursively(BinaryNode<Key, Obj> aRoot)
	{
		if(aRoot != null) {
			this.postOrderRecursively(aRoot.left());
			this.postOrderRecursively(aRoot.right());
			this.visit((Obj) aRoot.element().object());
		}
	}
}
