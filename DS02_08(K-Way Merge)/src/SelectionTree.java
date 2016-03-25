
public class SelectionTree {
	
	private int subfile[][] = {
			{1,9,11,19,21,31,41,51,61,71},  // [0][], node[7]
			{7,17,27,37,47,50,57,60,67,77}, // [1][], node[8]
			{2,12,22,29,32,39,42,52,62,72}, // [2][], node[9]
			{4,14,24,34,44,54,64,69,74,79}, // [3][], node[10]
			{8,18,28,38,48,58,68,70,78,80}, // [4][], node[11]
			{5,10,15,20,25,35,45,55,65,75}, // [5][], node[12]
			{3,13,23,33,43,49,53,59,63,73}, // [6][], node[13]
			{6,16,26,30,36,40,46,56,66,76}  // [7][], node[14]
	};
		
	private Node[] node;
	private StringBuffer sortedList;
	
	public SelectionTree() {
		node = new Node[15];
		sortedList = new StringBuffer();
	}

	/* 초기화 : Leaf node의 설정과, 배열 트리의 노드 생성 */ 
	public void init() { 
		for(int i=0; i<=6; i++)
			node[i] = new Node(0);
		for(int i=7; i<=14; i++) 
			node[i] = new Node(subfile[i-7][0]);
		
		/* Level 4 : 2개의 노드중 value가 작은것을 parent로 올려준다. */
		if(node[7].value <= node[8].value)
			node[3].setNode(node[7].value, node[7]);
		else
			node[3].setNode(node[8].value, node[8]);
		
		if(node[9].value <= node[10].value)
			node[4].setNode(node[9].value, node[9]);
		else
			node[4].setNode(node[10].value, node[10]);
		
		if(node[11].value <= node[12].value)
			node[5].setNode(node[11].value, node[11]);
		else
			node[5].setNode(node[12].value, node[12]);
		
		if(node[13].value <= node[14].value)
			node[6].setNode(node[13].value, node[13]);
		else
			node[6].setNode(node[14].value, node[14]);		
			
		
		/* Level 3 : 2개의 노드중 value가 작은것을 parent로 올려준다. */
		if(node[3].value <= node[4].value)
			node[1].setNode(node[3].value, node[3]);
		else
			node[1].setNode(node[4].value, node[4]);
		
		if(node[5].value <= node[6].value)
			node[2].setNode(node[5].value, node[5]);
		else
			node[2].setNode(node[6].value, node[6]);
		
		/* Level 2 : 2개의 노드중 value가 작은것을 parent로 올려준다. */
		if(node[1].value <= node[2].value)
			node[0].setNode(node[1].value, node[1]);
		else
			node[0].setNode(node[2].value, node[2]);
		
	}
	
	/* k-way merge sort */
	public void kWayMergeSort() { 
		
		int count = 0;
		
		while(count != 80) {			
			
			/* Level 1 : Root에 올라온 node의 value값을 Sorted List에 추가한다. */
			if(node[0].value < 10)
				sortedList.append(" " + node[0].value + " ");
			else
				sortedList.append(node[0].value + " ");
			
			/* Root까지 올라온 value의 출처는 어떤 Leaf node인가? */
			Node temp;
			for(temp = node[0]; temp.prev != null; temp = temp.prev)
				;
			
			/* Leaf node의 index를 찾아주고, 그 곳에 해당하는 subfile의 다음 index를 가져온다. */
			int leafIndex = nodeIndex(temp);
			int nextIndex = subfileIndex(leafIndex-7, temp.value);

			/* Leaf node를 업데이트 해주고, 만약 마지막 index라면 Infinity값을 넣어준다. */
			if(nextIndex != 10) {
//				System.out.printf("node[%d] = subfile[%d][%d++] = %d\n",leafIndex,leafIndex-7,nextIndex-1,subfile[leafIndex-7][nextIndex]);
				node[leafIndex].value = subfile[leafIndex-7][nextIndex];
			} else 
				node[leafIndex].value = Integer.MAX_VALUE;
			
			if(count == 19 || count == 39 || count == 59)
				sortedList.append("\n");
			
			/* update된 노드의 값을 경로를 따라 다시 root까지 모두 update*/
			while(leafIndex != 0) {
				
				/* Leaf node의 index가 짝수인 경우*/
				if(leafIndex % 2 == 0) {
					if(node[leafIndex-1].value <= node[leafIndex].value)
						node[(leafIndex-1)/2].setNode(node[leafIndex-1].value, node[leafIndex-1]);
					else
						node[(leafIndex-1)/2].setNode(node[leafIndex].value, node[leafIndex]);
				} 
				
				/* Leaf node의 index가 홀수인 경우*/
				else {
					if(node[leafIndex].value <= node[leafIndex+1].value)
						node[(leafIndex-1)/2].setNode(node[leafIndex].value, node[leafIndex]);
					else
						node[(leafIndex-1)/2].setNode(node[leafIndex+1].value, node[leafIndex+1]);
				}
				
				leafIndex = (leafIndex-1)/2;
			}		
			count++;
		}
	}
	
	private int nodeIndex(Node aNode) {
		for(int i=0; i<=14; i++) 
			if(node[i].equals(aNode))
				return i;
		return -1;
	}
	
	private int subfileIndex(int leaf, int value) {
		for(int i=0; i<=9; i++) 
			if(subfile[leaf][i] == value)
				return i+1;
		return -1;
	}
	
	public void printNode() {
//		for(int i=0; i<=14; i++)
//			System.out.printf("%2d : " + node[i] + "\n",i);
		
		/* Tree 모양 print */
//		printTree();
		
		System.out.println("\n/* ===================== 정렬된 List =====================  */\n" + sortedList);
	}

	private void printTree() {
		System.out.println("							0:" + node[0]);
		
		System.out.print("			1:" + node[1]);
		System.out.println("							2:" + node[2]);
		
		System.out.print("	3:" + node[3]);
		System.out.print("			4:" + node[4]);
		System.out.print("			5:" + node[5]);
		System.out.println("			6:" + node[6]);
		
		System.out.print("7:" + node[7]);
		System.out.print("	8:" + node[8]);
		System.out.print("	9:" + node[9]);
		System.out.print("	10:" + node[10]);
		System.out.print("	11:" + node[11]);
		System.out.print("	12:" + node[12]);
		System.out.print("	13:" + node[13]);
		System.out.println("	14:" + node[14]);
	}
		
	private class Node {
		private int value;
		private Node prev;
		
		public Node(int aValue) {
			this.value = aValue;
			this.prev = null;
		}
		
		public void setNode(int aValue, Node aNode) {
			this.value = aValue;
			this.prev = aNode;
		}
		
		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("(" + this.value + "," + this.prev + ")");
			return buf+"";
		}
	}
}
