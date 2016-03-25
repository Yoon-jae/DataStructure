import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

public class WeightedGraph {
	
	private int _size;
	private String[] _vertices;
	private int[][] _a; //adjacency matrix

	private PriorityQueue<Edge> _pQueue;
	private int[] _parent;
	
	public WeightedGraph() throws IOException
	{
//		FileInputStream stream = new FileInputStream("input_WeightedGraph");
		FileInputStream stream = new FileInputStream("input_CycleGraph");
//		FileInputStream stream = new FileInputStream("input_NoSpanningTree");

		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		this._pQueue = new PriorityQueue<Edge>();
		
		int verticesIndex=0;
		
		while((token.nextToken() != StreamTokenizer.TT_EOF))
		{
			switch(token.ttype) {
			
				case StreamTokenizer.TT_NUMBER:
					if(token.lineno() == 1)	{ // ������ ù ��° ��. �����Ǽ� 
						this._size = (int)token.nval;
						this._vertices = new String[this._size];
						this._a = new int[this._size][this._size];
						
						for(int j=0; j<this._size; j++) 
							for(int k=0; k<this._size; k++) 
								this._a[j][k] = Integer.MAX_VALUE;	// ��� dist���� Infinity�� �ʱ�ȭ
						
						this._parent = new int[this._size];
						for(int i=0; i<this._size; i++)
							this._parent[i] = -1;
					}
					break;
					
				case StreamTokenizer.TT_WORD:
					if(1 < token.lineno() && token.lineno() < this._size+2) // �����߰�
						this._vertices[verticesIndex++] = token.sval;
					else { // ����ġ�� ����ִ� ���� �߰�
						String v = token.sval;
						token.nextToken();
						String w = token.sval;
						token.nextToken();
						int inputWeight = (int)token.nval;
						add(v,w,inputWeight);
						Edge newEdge = new Edge(v, w, inputWeight);
						this._pQueue.add(newEdge);
					}
					break;
			}
		}
		stream.close();
	}
	
	public void add(String v, String w, int weight) // weight�� ��� �߰��Ұ��ΰ�?
	{
		int i = index(v);
		int j = index(w);
		this._a[i][j] = this._a[j][i] = weight;
	}
	
	public String toString()
	{
		if(this._size == 0) return "{}";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for(int i = 1; i < this._size; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}
	
	private int index(String v)
	{
		for(int i = 0; i < this._size; i++) 
			if(this._vertices[i].equals(v))
				return i;
		
		return this._a.length;
	}
	
	private String vertex(int i)
	{
		StringBuffer buf = new StringBuffer(this._vertices[i] + ":");
		for(int j = 0; j < this._size; j++) 
			if(this._a[i][j] != Integer.MAX_VALUE)  // �����Ѵٸ� 
				buf.append(this._vertices[j] + "(" + this._a[i][j] + ")");
		return buf + "";
	}
	
	public void weightedUnion(int i, int j)
	{
		int temp ;
		int root_1, root_2;
		// find�� �ϸ� collapsing rule�� ���� child�� root�� �ٰ� �ǹǷ� ������ ������.
		root_1 = collapsingFind(i);
		root_2 = collapsingFind(j);

		// union�� weighting rule�� ���� root�� #N
		temp =  this._parent[root_1] + this._parent[root_2];
		if(root_1 != root_2) {
			if (this._parent[root_1] > this._parent[root_2]) { // �����̹Ƿ� ������ ������ root_2�� �� ������ !
				this._parent[i] = root_2; // ���� �θ� ū �θ� ����.
				this._parent[root_2] = temp; // ū �θ��� ������ �÷���.
			} else {
				this._parent[j] = root_1;
				this._parent[root_1] = temp;
			}
		} else // root_1 == root_2
			System.out.println("Edge ("+i+","+j+")�� Cycle�� ���� ��ŵ�ϴ�.");
	}
	
	public int collapsingFind(int i) // ���� i�� root�� ã����. 
	{		
		int root, path, lead;
		for(root = i; this._parent[root]>=0; root = this._parent[root]); // root ã��, ������ root
		for(path = i; path != root && this._parent[path] != root; path = lead) { // collapsing Rule
			lead = this._parent[path]; // �θ� ������
			this._parent[path] = root; // root�Ʒ��� ����
		}
		
		return root;
	}
	
	public void kruskal()
	{
		Edge[] T = new Edge[this._size]; // T�� �ʱ�ȭ
		int numOfEdges = 0;
		int minimumCost = 0;
		
		while((numOfEdges < this._size -1) && !this._pQueue.isEmpty()) { // n-1���� ������ �����ų�, �켱����ť�� �� �� ���� �ݺ�.
			Edge anEdge = this._pQueue.poll(); // �켱����ť���� ������ ���� ���ο� Edge�� ����.
			int set1 = collapsingFind(index(anEdge._from)); // ������ Edge�� �� ������ Find����.
			int set2 = collapsingFind(index(anEdge._to));
			if(set1 != set2) {
				weightedUnion(set1, set2); // �� ������ �� �����̾ƴ϶�� Union����.
				T[numOfEdges++] = anEdge; // T�� Edge�� �߰�.
				minimumCost += anEdge._weight; // total��뿡 ������ ��� �߰�
			}
		}
		
		if(numOfEdges < this._size - 1) // ���� Edge�� ������ n-1������ ������ spanning tree�� �������� ����.
			System.out.println("No spanning Tree.\nnumOfEdges : " + numOfEdges + " => Edge�� ������ " + (this._size - 1 - numOfEdges) + "�� �����մϴ�.");
		else {
			StringBuffer buf = new StringBuffer("Kruskal �˰��� ���\n");
			buf.append("�ּ� ��� : " + minimumCost);
			buf.append("\n���� Edge : ");
			for(int i=0; i<numOfEdges; i++) {
				if(i != numOfEdges - 1)
					buf.append(T[i] + ", ");
				else
					buf.append(T[i]);
			}
			System.out.println(buf);
		}
	}
	
	public void printArray()
	{
		for(int i=0; i<this._size; i++) {
			for(int j=0; j<this._size; j++) 
				System.out.printf("%12d",this._a[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	private class Edge implements Comparable<Edge> {
		
		private String _from;
		private String _to;
		private int _weight;
		
		public Edge(String from, String to, int weight)
		{
			this._from = from;
			this._to = to;
			this._weight = weight;
		}

		@Override
		public int compareTo(Edge anEdge) {
			// TODO Auto-generated method stub
			if(this._weight < anEdge._weight)
				return -1;
			else if(this._weight > anEdge._weight)
				return 1;
			else
				return 0;
		}
		
		public String toString()
		{
			StringBuffer buf = new StringBuffer();
			buf.append(this._from + this._to + "(" + this._weight + ")");
			return buf + "";
		}
	}
}
