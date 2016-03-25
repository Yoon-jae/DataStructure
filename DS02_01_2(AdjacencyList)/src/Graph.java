import java.util.Stack;

class Graph
{
	private int _size;
	private String[] _vertices;
	private Node[] _a;
	
	private Stack<String> _stack;
	private String[] _list;
	
	public Graph(String[] args)
	{
		this._size = args.length;
		this._vertices = new String[this._size];
		this._a = new Node[this._size];
		
		for(int i=0; i<this._size; i++) {
			this._vertices[i] = args[i];
			this._a[i] = new Node(i,null,this._vertices[i]);
		}
	}
	
	public void add(String v, String w)
	{
		this._a[index(v)].add(index(w),w);
		this._a[index(w)].add(index(v),v);
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

	public void dfs() 
	{
		this._stack = new Stack<String>();
		this._list = new String[this._vertices.length]; // S와 L의 초기화
		boolean[] isVisited = new boolean[this._vertices.length];
		
		int idx = 0;
		int i = 0;
		
		isVisited[idx] = true; // 첫번째 정점 마크
		this._stack.push(this._a[idx]._vertex); // 스택 삽입
		
		while(true)
		{
			this._list[i] = this._stack.pop();
			idx = index(this._list[i++]);
			
			for(Node p = this._a[idx]._edges; p != null; p = p._next) {
				if(!isVisited[index(p._vertex)]) {// 인접하고(Node _a[idx]의 원소이고) 방문하지 않앗다면
					isVisited[index(p._vertex)] = true;
					this._stack.push(p._vertex);
				}
			}			
			if(this._stack.isEmpty())
				break;
		}
		
		// 출력 
		System.out.println("깊이 우선 탐색의 결과입니다.");
		StringBuffer buf = new StringBuffer();
		if(this._list != null)
			buf.append("{");
		for(int k=0; k<this._list.length; k++) {
			if(k == this._list.length-1)
				buf.append(this._list[k] + "}");
			else
				buf.append(this._list[k] + "->");	
		}
		System.out.println(buf);
	}
	
	private class Node
	{
		private int _to;
		private Node _next;
		private String _vertex;
		private Node _edges;
		
		Node(int to, Node next, String v)
		{
			this._to = to;
			this._next = next;
			this._vertex = v;
		}

		public void add(int j,String v) // Node를 뒤에 삽입
		{
			Node currentNode = this._edges;
			Node previousNode = null;
			while(currentNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.next();
			}
			if(previousNode == null)
				this._edges = new Node(j,null,v);
			else
				previousNode.setNext(new Node(j,null,v));
		}
		
		public String toString()
		{
			StringBuffer buf = new StringBuffer(this._vertex);
			if(this._edges != null)
				buf.append(":");
			for(Node p = this._edges; p != null; p = p._next)
				buf.append(Graph.this._a[p._to]._vertex);
			return buf + "";
		}

		public Node next() {
			return this._next;
		}

		public void setNext(Node next) {
			this._next = next;
		}
		
	}

}

