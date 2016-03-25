
public class AppController implements VisitEventForTreeTraversal {
	private AppView _appView;
	PMDictionary _pmDictionary;
	private static final int MaxTestSize = 500;
	private static final int FirstTestSize = 100;
	private static final int SizeIncrement = 100;
	
	public AppController()
	{
		this._appView = new AppView();
	}
	
	public void run()
	{
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._pmDictionary = new PMDictionary(AppController.MaxTestSize);
		this._pmDictionary.generateData();
		this.testSortedArray();
		this.testSortedLinkedList();
		this.testBinarySearchTree();
		this._appView.outputMessage(MessageID.Notice_EndProgram);
		
		this.testTraverse();
	}
	
	private void testSortedArray()
	{
		this._appView.outputMessage(MessageID.Notice_ResultSortedArray);
		for(int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement) {
			TestResult testResult = this._pmDictionary.doSortedArray(testSize);
			this._appView.outputResult(testResult.testSize(), testResult.testInsertTime(), testResult.testSearchTime(), testResult.testRemoveTime());
		}
	}
	
	private void testSortedLinkedList()
	{
		this._appView.outputMessage(MessageID.Notice_ResultSortedLinkedList);
		for(int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement) {
			TestResult testResult = this._pmDictionary.doSortedLinkedList(testSize);
			this._appView.outputResult(testResult.testSize(), testResult.testInsertTime(), testResult.testSearchTime(), testResult.testRemoveTime());
		}
	}
	
	private void testBinarySearchTree()
	{
		this._appView.outputMessage(MessageID.Notice_ResultBinarySearchTree);
		for(int testSize = FirstTestSize; testSize <= MaxTestSize; testSize += SizeIncrement) {
			TestResult testResult = this._pmDictionary.doBinarySearchTree(testSize);
			this._appView.outputResult(testResult.testSize(), testResult.testInsertTime(), testResult.testSearchTime(), testResult.testRemoveTime());
		}
	}

	private void testTraverse()
	{
		BinarySearchTree<Integer, Character> binaryTree = new BinarySearchTree<Integer, Character>();
		char value = 'A';
		int[] input = new int[]{50, 30, 70, 10, 40, 60, 80, 0, 20};
		for(int i = 0; i < input.length; i++) {
			binaryTree.addKeyAndObject(input[i], value++);
		}
		// show BinarySearchTree
		this._appView.nextLine();
		binaryTree.showDictionary();
		
		binaryTree.setCallerForVisitEvent(this);
		this._appView.nextLine();
		
		// inorder traversal
		this._appView.outputMessage(MessageID.Notice_InorderTraverse);
		binaryTree.inOrder();
		this._appView.nextLine();
		
		// preorder traversal
		this._appView.outputMessage(MessageID.Notice_PreorderTraverse);
		binaryTree.preOrder();
		this._appView.nextLine();
		
		// postorder traversal
		this._appView.outputMessage(MessageID.Notice_PostorderTraverse);
		binaryTree.postOrder();
		this._appView.nextLine();
	}
	@Override
	public void processVisitByCallback(Object anObj) {
		// TODO Auto-generated method stub
		this._appView.outputTraverse((char)anObj);
	}
}
