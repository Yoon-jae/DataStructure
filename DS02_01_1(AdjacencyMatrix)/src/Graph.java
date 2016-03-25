import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private int size;
	private String[] vertices;
	private boolean[][] adj;
	private boolean[] visited;
	
	public Graph(String[] args) {
		this.size = args.length;
		this.vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		this.adj = new boolean[size][size];
	}
	
	public void bfs(String start) {
		Queue<String> queue = new LinkedList<String>();
		this.visited = new boolean[size];
		StringBuffer buf = new StringBuffer("\n넓이 우선 탐색의 결과 입니다.\n{");

		visited[index(start)] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			String front = queue.peek();
			queue.poll();
			buf.append(front + "->");
			for(int i=0; i<this.size; i++) {
				if(this.adj[index(front)][i] && !visited[i]) {
					visited[i] = true;
					queue.add(vertices[i]);
				}
			}
		}
		buf.delete(buf.length()-2, buf.length());
		buf.append("}");
		System.out.println(buf);
	}
	
	
	public void dfs(String start) {
		Stack<String> stack = new Stack<String>();
		this.visited = new boolean[size];
		StringBuffer buf = new StringBuffer("\n깊이 우선 탐색의 결과 입니다.\n{");
		
		visited[index(start)] = true;
		stack.push(start);
		
		while(!stack.isEmpty()) {
			String top = stack.peek();
			stack.pop();
			buf.append(top + "->");
			for(int i=0; i<this.size; i++) {
				if(this.adj[index(top)][i] && !visited[i]) {
					visited[i] = true;
					stack.push(vertices[i]);
				}
			}
		}
		buf.delete(buf.length()-2, buf.length());
		buf.append("}");
		System.out.println(buf);
	}
	
	public void add(String v, String w) {
		int i = index(v);
		int j = index(w);
		adj[i][j] = adj[j][i] = true;
	}
	
	public String toString() {
		if(this.size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("그래프 정점들의 정보입니다.\n{" + vertex(0));
		for(int i=1; i<this.size; i++)
			buf.append(", " + vertex(i));
		return buf + "}";
	}
	
	public void edgeInfo() {
		StringBuffer buf = new StringBuffer("\n그래프 간선들의 정보입니다.\n{");
		for(int i=0; i<size; i++) 
			for(int j=i; j<size; j++) 
				if(adj[i][j]) 
					buf.append(vertices[i] + "->" + vertices[j] + ", ");
		buf.delete(buf.length()-2,buf.length());
		buf.append("}");
		System.out.println(buf);
	}
	
	private int index(String v) {
		for(int i=0; i<this.size; i++)
			if(vertices[i].equals(v))
				return i;
		return adj.length; // If not found
	}
	
	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i]);
		for(int j=0; j<size; j++)
			if(adj[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}
	
}
