import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;
import java.util.Scanner;


class WeightedGraph
{
	private int _size;
	private String[] _vertices;
	private Node[] _a;
	
	boolean _isVisited[];
	String _prev[];
	int _dist[];
	int _firstIndex;
	
	public WeightedGraph() throws IOException
	{
		FileInputStream stream = new FileInputStream("input_WeightedGraph");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		int i=0;
		
		while((token.nextToken() != StreamTokenizer.TT_EOF))
		{
			switch(token.ttype) {
			
				case StreamTokenizer.TT_NUMBER:
					if(token.lineno() == 1)	{ // 파일의 첫 번째 줄. 정점의수 
						this._size = (int)token.nval;
						this._vertices = new String[this._size];
						this._a = new Node[this._size];
					}
					break;
					
				case StreamTokenizer.TT_WORD:
					if(1 < token.lineno() && token.lineno() < this._size+2) { // 정점추가
						this._vertices[i] = token.sval;
						this._a[i] = new Node(i,null,this._vertices[i++],0);

					} else { // 가중치가 들어있는 간선 추가
						String v = token.sval;
						token.nextToken();
						String w = token.sval;
						token.nextToken();
						int inputWeight = (int)token.nval;
						add(v,w,inputWeight);
					}
					break;
			}
		}
		stream.close();
	}
	
	public void add(String v, String w, int weight)
	{
		this._a[index(v)].add(index(w),w,weight);
		this._a[index(w)].add(index(v),v,weight);
	}
	
	public String toString()
	{
		if(this._size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + this._a[0]);
		for(int i = 1; i < this._size; i++)
			buf.append("," + this._a[i]);
		return buf + "}";
	}
	
	private int index(String v)
	{
		for(int i = 0; i < this._size; i++)
			if(this._a[i]._vertex.equals(v))
				return i;
		return this._a.length;
	}
	
	private int distIndex(int d)
	{
		for(int i=0; i<this._size; i++) 
			if(this._dist[i] == d && !this._isVisited[i])
				return i;
		return this._size;			
	}
	
	public void dijkstra(String startVertex)
	{
		this._isVisited = new boolean[this._size];
		this._prev = new String[this._size];
		this._dist = new int[this._size];
		
		int x = this._firstIndex = index(startVertex);
		
		for(int i=0; i<this._size; i++)  // this._dist를 최초정점은 0으로하고 나머지는 Infinity로 초기화
			if(i != x)
				this._dist[i] = Integer.MAX_VALUE;				
		
		this._isVisited[x] = true;
	
		int cnt = 1;
		while(cnt != this._size) {
			for(Node p = this._a[x]._edges; p != null; p = p._next) { // 인접하는것들에 대하여
				if(!this._isVisited[(index(p._vertex))] && this._dist[(index(p._vertex))] >= this._dist[x] + p._weight)
				// 방문되지않고, this._dist값을 더 줄일수 있다면
				{
					this._dist[(index(p._vertex))] = this._dist[x] + p._weight;
					this._prev[index(p._vertex)] = this._a[x]._vertex;
				}
			}
			
			PriorityQueue<Integer> _pQueue = new PriorityQueue<>();
			for(int i=0; i<this._size; i++)
				if(i != this._firstIndex && !this._isVisited[i]) 
					_pQueue.add(this._dist[i]);
	
			x = distIndex(_pQueue.poll()); // 우선순위큐에서 뺀 값(this._dist값중 가장 작은값)의 index를 x로 놓음.
			this._isVisited[x] = true;
			
			cnt++;	
		}		
	}
	
	private String printRecursively(String v)
	{
		if(v == this._prev[this._firstIndex])
			return "";
		else {
			return "<-" + v + printRecursively(this._prev[index(v)]);
		}
	}
	
	public void printPath()
	{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		StringBuffer buf = new StringBuffer();
		
		for(int i=0; i<this._size; i++)
		{
			if(i == this._size-1)
				buf.append(this._vertices[i]);
			else
				buf.append(this._vertices[i] + ",");
		}
		buf.append(" 총 " + this._size + "개의 정점(Vertex)가 잇습니다.");
		buf.append("출발점을 입력하세요");
		System.out.println(buf);
		
		String firstVertex = keyboard.nextLine();
		dijkstra(firstVertex);	
		
		for(int i=0; i<this._size; i++) {
			System.out.print(this._a[i]._vertex + " : 거리 " + this._dist[i] + " /" );
			if(this._dist[i]==0)
				System.out.println(" 출발점");
			else {
				System.out.print(" " + this._a[i]._vertex);
				System.out.println(printRecursively(this._prev[i]));		
			}	
		}
	}
	
	private class Node
	{
		private int _to;
		private Node _next;
		private String _vertex;
		private int _weight;
		private Node _edges;
		
		
		public Node(int to, Node next, String v, int weight)
		{
			this._to = to;
			this._next = next;
			this._vertex = v;
			this._weight = weight;
		}

		public void add(int j, String v, int weight) // 노드를 앞에서부터 삽입
		{
			this._edges = new Node(j,this._edges,v,weight);
		}

		public String toString()
		{
			StringBuffer buf = new StringBuffer(this._vertex);
			if(this._edges != null)
				buf.append(":");
			for(Node p = this._edges; p != null; p = p._next)
				buf.append(WeightedGraph.this._a[p._to]._vertex + "(" + p._weight + ")");
			return buf + "";
		}
	}

}

