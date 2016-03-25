import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

public class Main {

	double SLLSearch = 0, SLLAdd = 0;
	double BSTSearch = 0, BSTAdd = 0;
	double AVLSearch = 0, AVLAdd = 0;
	double HASHSearch = 0, HASHAdd = 0;
	
	public Main(String file) throws IllegalAccessException{
		
		SinglyLinkedList SLL = new SinglyLinkedList();
		BinarySearchTree BST = new BinarySearchTree();
		AVLTree AVL = new AVLTree("THE", 0);
		HashTable HASH = new HashTable();
				
		int lineNumber = 0;
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while(line != null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()){
					String word = parser.nextToken().toUpperCase();
					
					searchAndAddInSLL(SLL, word);
					
					searchAndAddInBST(BST, word);
					
					searchAndAddInAVL(AVL, word);
					
					searchAndAddInHASH(HASH, word);
				}
				line = in.readLine();
			}
			in.close();
			
		} catch(IOException e){
			System.out.println(e);
		}
		

		System.out.println("========== Starting SLL performance ==========");
		System.out.println(SLL);
		System.out.println("lines: " + lineNumber);
		System.out.println("distinct words: " + SLL.size());
		
		System.out.println("\n========== Starting BST performance ==========");
		System.out.println(BST);
		System.out.println("lines: " + lineNumber);
		System.out.println("distinct words: " + BST.size());
		
		System.out.println("\n========== Starting AVL performance ==========");
		System.out.println(AVL);		
		System.out.println("lines: " + lineNumber);
		System.out.println("distinct words: " + AVL.size());
		
		System.out.println("\n========== Starting HASH performance ==========");
		System.out.println(HASH);		
		System.out.println("lines: " + lineNumber);
		System.out.println("distinct words: " + HASH.size());
		
		System.out.println("\n========== Performance result ==========");
		
		System.out.println("SLLSearch  : " + SLLSearch);
		System.out.println("BSTSearch  : " + BSTSearch);
		System.out.println("AVLSearch  : " + AVLSearch);
		System.out.println("HASHSearch : " + HASHSearch + "\n");
	
		System.out.println("SLLAdd  : " + SLLAdd);
		System.out.println("BSTAdd  : " + BSTAdd);
		System.out.println("AVLAdd  : " + AVLAdd);
		System.out.println("HASHAdd : " + HASHAdd);

	}

	private void searchAndAddInSLL(SinglyLinkedList SLL, String word) {
		long start, end;
		
		start = System.nanoTime();
		String list = SLL.search(word);
		end = System.nanoTime();
		
		SLLSearch += (double)(end - start);
				
		if(list != null) { 
			start = System.nanoTime();
			SLL.add(list);
			end = System.nanoTime();
		}
		SLLAdd += (double)(end - start);
	}

	private void searchAndAddInBST(BinarySearchTree BST, String word) {
		long start, end;
		
		start = System.nanoTime();
		String list = BST.search(word);
		end = System.nanoTime();
		
		BSTSearch += (double)(end - start);
		
		
		if(list != null)  {
			start = System.nanoTime();
			BST.add(list);
			end = System.nanoTime();
		}
		
		BSTAdd += (double)(end - start);
	}

	private void searchAndAddInAVL(AVLTree AVL, String word) {
		long start, end;
		
		start = System.nanoTime();
		String list = AVL.search(word);
		end = System.nanoTime();
		
		AVLSearch += (double)(end - start);
		
		if(list != null) {
			start = System.nanoTime();
			AVL.add(list);
			end = System.nanoTime();
		}
		
		AVLAdd += (double)(end - start);
	}

	private void searchAndAddInHASH(HashTable HASH, String word) throws IllegalAccessException {
		long start, end;
		
		start = System.nanoTime();
		String list = HASH.search(word);
		end = System.nanoTime();
		
		HASHSearch += (double)(end - start);
		
		if(list != null) {
			start = System.nanoTime();
			HASH.add(list);
			end = System.nanoTime();
		}
		
		HASHAdd += (double)(end - start);
	
	}
	
	public static void main(String[] args) throws IllegalAccessException{
		new Main("example");
	}

}
