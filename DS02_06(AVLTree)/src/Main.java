
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("************ 3 »ğÀÔ ************");
		AVLTree avlTree = new AVLTree(3);
		avlTree.showTree();
		
		System.out.println("************ 5 »ğÀÔ ************");
		avlTree.add(5);
		avlTree.showTree();
		
		System.out.println("************ 1 »ğÀÔ ************");
		avlTree.add(1);
		avlTree.showTree();
		
		System.out.println("************ 8 »ğÀÔ ************");
		avlTree.add(8);
		avlTree.showTree();
		
		System.out.println("************ 6 »ğÀÔ ************");
		avlTree.add(6);
		avlTree.showTree();
		
		System.out.println("************ 2 »ğÀÔ ************");
		avlTree.add(2);
		avlTree.showTree();
		
		System.out.println("************ 11 »ğÀÔ ************");
		avlTree.add(11);
		avlTree.showTree();
		
		System.out.println("************ 4 »ğÀÔ ************");
		avlTree.add(4);
		avlTree.showTree();
		
		System.out.println("************ 10 »ğÀÔ ************");
		avlTree.add(10);
		avlTree.showTree();
		
		System.out.println("************ 9 »ğÀÔ ************");
		avlTree.add(9);
		avlTree.showTree();
		
		System.out.println("************ 7 »ğÀÔ ************");
		avlTree.add(7);
		avlTree.showTree();
		
		System.out.println("\n*********** add ¿Ï·á ***********\n");
		System.out.println(avlTree);
		
		
		System.out.println("\n************ 3 »èÁ¦ ************");		
		avlTree.delete(3);
		avlTree.showTree();
		
		System.out.println("************ 5 »èÁ¦ ************");
		avlTree.delete(5);
		avlTree.showTree();
		
		System.out.println("************ 1 »èÁ¦ ************");
		avlTree.delete(1);
		avlTree.showTree();
		
		System.out.println("************ 8 »èÁ¦ ************");
		avlTree.delete(8);
		avlTree.showTree();
		
		System.out.println("************ 6 »èÁ¦ ************");
		avlTree.delete(6);
		avlTree.showTree();
		
		System.out.println("\n********** delete ¿Ï·á **********\n");
		System.out.println(avlTree);
	}

}
