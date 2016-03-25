import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		WeightedGraph g = new WeightedGraph();
//		System.out.println(g);
//		g.printArray();
		g.kruskal();
	}
}