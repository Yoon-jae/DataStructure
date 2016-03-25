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
					if(token.lineno() == 1)	{ // 파일의 첫 번째 줄. 정점의수 
						this._size = (int)token.nval;
						this._vertices = new String[this._size];
						this._a = new int[this._size][this._size];
						
						for(int j=0; j<this._size; j++) 
							for(int k=0; k<this._size; k++) 
								this._a[j][k] = Integer.MAX_VALUE;	// 모든 dist값을 Infinity로 초기화
						
						this._parent = new int[this._size];
						for(int i=0; i<this._size; i++)
							this._parent[i] = -1;
					}
					break;
					
				case StreamTokenizer.TT_WORD:
					if(1 < token.lineno() && token.lineno() < this._size+2) // 정점추가
						this._vertices[verticesIndex++] = token.sval;
					else { // 가중치가 들어있는 간선 추가
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
	
	public void add(String v, String w, int weight) // weight를 어떻게 추가할것인가?
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
			if(this._a[i][j] != Integer.MAX_VALUE)  // 인접한다면 
				buf.append(this._vertices[j] + "(" + this._a[i][j] + ")");
		return buf + "";
	}
	
	public void weightedUnion(int i, int j)
	{
		int temp ;
		int root_1, root_2;
		// find를 하면 collapsing rule에 따라 child가 root에 붙게 되므로 변수에 저장함.
		root_1 = collapsingFind(i);
		root_2 = collapsingFind(j);

		// union은 weighting rule에 의해 root엔 #N
		temp =  this._parent[root_1] + this._parent[root_2];
		if(root_1 != root_2) {
			if (this._parent[root_1] > this._parent[root_2]) { // 음수이므로 원소의 개수는 root_2가 더 많은것 !
				this._parent[i] = root_2; // 작은 부모를 큰 부모에 붙임.
				this._parent[root_2] = temp; // 큰 부모의 개수를 늘려줌.
			} else {
				this._parent[j] = root_1;
				this._parent[root_1] = temp;
			}
		} else // root_1 == root_2
			System.out.println("Edge ("+i+","+j+")는 Cycle을 생성 시킵니다.");
	}
	
	public int collapsingFind(int i) // 들어온 i의 root를 찾아줌. 
	{		
		int root, path, lead;
		for(root = i; this._parent[root]>=0; root = this._parent[root]); // root 찾기, 음수는 root
		for(path = i; path != root && this._parent[path] != root; path = lead) { // collapsing Rule
			lead = this._parent[path]; // 부모를 저장함
			this._parent[path] = root; // root아래로 지정
		}
		
		return root;
	}
	
	public void kruskal()
	{
		Edge[] T = new Edge[this._size]; // T의 초기화
		int numOfEdges = 0;
		int minimumCost = 0;
		
		while((numOfEdges < this._size -1) && !this._pQueue.isEmpty()) { // n-1개의 간선을 가지거나, 우선순위큐가 빌 때 까지 반복.
			Edge anEdge = this._pQueue.poll(); // 우선순위큐에서 가져온 값을 새로운 Edge로 지정.
			int set1 = collapsingFind(index(anEdge._from)); // 가져온 Edge의 두 정점을 Find해줌.
			int set2 = collapsingFind(index(anEdge._to));
			if(set1 != set2) {
				weightedUnion(set1, set2); // 두 정점이 한 집합이아니라면 Union해줌.
				T[numOfEdges++] = anEdge; // T에 Edge를 추가.
				minimumCost += anEdge._weight; // total비용에 간선의 비용 추가
			}
		}
		
		if(numOfEdges < this._size - 1) // 최종 Edge의 개수가 n-1개보다 작으면 spanning tree가 형성되지 않음.
			System.out.println("No spanning Tree.\nnumOfEdges : " + numOfEdges + " => Edge의 개수가 " + (this._size - 1 - numOfEdges) + "개 부족합니다.");
		else {
			StringBuffer buf = new StringBuffer("Kruskal 알고리즘 결과\n");
			buf.append("최소 비용 : " + minimumCost);
			buf.append("\n사용된 Edge : ");
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
