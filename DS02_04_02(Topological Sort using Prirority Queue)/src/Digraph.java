import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class Digraph {
	
	private int _size;
	private String[] _vertices;
	private Node[] _a;
	private int[] _indegree;
	private boolean[] _visited;
	
	public Digraph() throws IOException {
		FileInputStream stream = new FileInputStream("input_AOVNetwork");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		int i=0;
		
		while((token.nextToken() != StreamTokenizer.TT_EOF)){
			switch(token.ttype) {
			
				case StreamTokenizer.TT_NUMBER:
					if(token.lineno() == 1)	{ // ������ ù ��° ��. �����Ǽ� 
						this._size = (int)token.nval;
						this._vertices = new String[this._size];
						this._a = new Node[this._size];
					}
					break;
					
				case StreamTokenizer.TT_WORD:
					if(1 < token.lineno() && token.lineno() < this._size+2) { // �����߰�
						this._vertices[i] = token.sval;
						token.nextToken();
						this._a[i] = new Node(i,null,this._vertices[i++],(int)token.nval);
						
					} else { // �����߰�
						String v = token.sval;
						token.nextToken();
						String w = token.sval;
						add(v,w);
					}
					break;
			}
		}
		stream.close();
	}
	
	public void topologicalSort() {
		
		PriorityQueue<Node> vertexPriorityQueue = new PriorityQueue<Node>();
		StringBuffer sortedList = new StringBuffer();
		this._indegree = new int[this._size];
		this._visited = new boolean[this._size];
	
		exploreVertexAndInitIndegree(); // Vertex���� �˻��ϰ�, ������ indegree�� �ʱ�ȭ;
		pushValidVertexToPriorityQueue(vertexPriorityQueue); // indegree�� 0�̰�, �湮���� �ʾҴ� vertex�� PriorityQueue�� push;

		while(doesPriorityQueueHasElement(vertexPriorityQueue)) { // PriorityQueue�� ���Ұ� �����ִٸ�
			Node anElement = pollElementFromPriorityQueue(vertexPriorityQueue, sortedList); // PriorityQueue���� ���Ҹ� poll;
			removeImmediatePredecessor(anElement); // poll�� ���Ҹ� ���Ӽ����ڷ� ���� �͵��� indegree--;
			pushValidVertexToPriorityQueue(vertexPriorityQueue); // indegree�� 0�̰�, �湮���� �ʾҴ� vertex�� PriorityQueue�� push;
		}
		
		printSortedList(sortedList); // ��� ������ ���� ������ List���, �ƴϸ� Cycle�� ���� ��.
	}
	
	public void add(String v, String w) {
		this._a[index(v)].add(index(w),w);
	}
	
	public String toString() {
		if(this._size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{\n" + this._a[0]);
		for(int i = 1; i < this._size; i++)
			buf.append("/" + this._a[i]);
		return buf + "}";
	}
	
	private int index(String v) {
		for(int i = 0; i < this._size; i++)
			if(this._a[i]._vertex.equals(v))
				return i;
		return this._a.length;
	}	

	private void removeImmediatePredecessor(Node anElement) {
		for(Node p = anElement._edges; p != null; p = p._next)
			this._indegree[index(p._vertex)]--;
	}

	private Node pollElementFromPriorityQueue(PriorityQueue<Node> vertexPriorityQueue, StringBuffer sortedList) {
		Node anElement = vertexPriorityQueue.poll();
		sortedList.append(anElement + "->");
		return anElement;
	}

	private void printSortedList(StringBuffer sortedList) {
		boolean hasCycle = false;
		for(int i=0; i<this._size; i++)
			if(!this._visited[i])
				hasCycle = true;
		if(hasCycle)
			System.out.println("Network has a cycle.");
		else {
			int listSize = sortedList.length();
			sortedList.delete(listSize-2, listSize);
			System.out.println(sortedList);
		}
	}

	private boolean doesPriorityQueueHasElement(PriorityQueue<Node> vertexPriorityQueue) {
		return !vertexPriorityQueue.isEmpty();
	}

	private void pushValidVertexToPriorityQueue(PriorityQueue<Node> vertexPriorityQueue) {
		for(int i=0; i < this._size; i++) { // ���ǿ� �����ϴ� �͵��� ���ÿ� ����.
			if( !this._visited[i] && this._indegree[i] == 0) {
				vertexPriorityQueue.add(this._a[i]);
				this._visited[index(this._a[i]._vertex)] = true;
			}
		}
	}

	private void exploreVertexAndInitIndegree() {
		for(int i=0; i < this._size; i++) { // ó���� List�� �˻��ϸ鼭 ��ü���� indegree�� ���� �������ش�. O(n*e).
			for(Node p = this._a[i]._edges; p != null; p = p._next) {
				this._indegree[index(p._vertex)]++;
			}
		}
	}

	private void testIndegree() {
		for(int i=0; i < this._size; i++) { // this._indegree Ȯ��
			System.out.printf("this._indegree[%d] : " + this._indegree[i],i);
			System.out.println();
		}
		System.out.println();
	}
	
	private class Node implements Comparable<Node>
	{
		private int _to;
		private Node _next;
		private String _vertex;
		private Node _edges;
		private int _grade;
		
		public Node(int to, Node next, String v, int grade) {
			this._to = to;
			this._next = next;
			this._vertex = v;
			this._grade = grade;
		}

		public void add(int to, String v) { // ��带 �տ������� ����
			Node currentNode = this._edges;
			Node previousNode = null;
			while(currentNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.next();
			}
			if(previousNode == null)
				this._edges = new Node(to,null,v,0);
			else
				previousNode.setNext(new Node(to,null,v,0));
		}

		public String toString() {
			StringBuffer buf = new StringBuffer(this._vertex);
//			if(this._edges != null)
//				buf.append("->");
//			for(Node p = this._edges; p != null; p = p._next)
//				buf.append(Digraph.this._a[p._to]._vertex + "(" + Digraph.this._a[p._to]._grade + ")");
			return buf + "";
		}

		public Node next() {
			return this._next;
		}

		public void setNext(Node _next) {
			this._next = _next;
		}

		@Override
		public int compareTo(Node aNode) {
			// TODO Auto-generated method stub
			if(this._grade <= aNode._grade)
				return -1;
			else
				return 1;
		}		
		
	}
}
