
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("************ 3 ���� ************");
		AVLTree avlTree = new AVLTree(3);
		avlTree.showTree();
		
		System.out.println("************ 5 ���� ************");
		avlTree.add(5);
		avlTree.showTree();
		
		System.out.println("************ 1 ���� ************");
		avlTree.add(1);
		avlTree.showTree();
		
		System.out.println("************ 8 ���� ************");
		avlTree.add(8);
		avlTree.showTree();
		
		System.out.println("************ 6 ���� ************");
		avlTree.add(6);
		avlTree.showTree();
		
		System.out.println("************ 2 ���� ************");
		avlTree.add(2);
		avlTree.showTree();
		
		System.out.println("************ 11 ���� ************");
		avlTree.add(11);
		avlTree.showTree();
		
		System.out.println("************ 4 ���� ************");
		avlTree.add(4);
		avlTree.showTree();
		
		System.out.println("************ 10 ���� ************");
		avlTree.add(10);
		avlTree.showTree();
		
		System.out.println("************ 9 ���� ************");
		avlTree.add(9);
		avlTree.showTree();
		
		System.out.println("************ 7 ���� ************");
		avlTree.add(7);
		avlTree.showTree();
		
		System.out.println("\n*********** add �Ϸ� ***********\n");
		System.out.println(avlTree);
		
		
		System.out.println("\n************ 3 ���� ************");		
		avlTree.delete(3);
		avlTree.showTree();
		
		System.out.println("************ 5 ���� ************");
		avlTree.delete(5);
		avlTree.showTree();
		
		System.out.println("************ 1 ���� ************");
		avlTree.delete(1);
		avlTree.showTree();
		
		System.out.println("************ 8 ���� ************");
		avlTree.delete(8);
		avlTree.showTree();
		
		System.out.println("************ 6 ���� ************");
		avlTree.delete(6);
		avlTree.showTree();
		
		System.out.println("\n********** delete �Ϸ� **********\n");
		System.out.println(avlTree);
	}

}
