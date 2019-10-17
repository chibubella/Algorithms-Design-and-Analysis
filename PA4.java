import java.util.*;

public class PA4
{

	class Edge implements Comparable<Edge>
	{
int src, dest, weight;

  
	public int compareTo(Edge compareEdge)
	{
		return this.weight-compareEdge.weight;
	}
	};

  
	class subset{
		int parent, rank;
	};

	int V, E;
	Edge edge[];
	PA4(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i=0; i<e; ++i)
			edge[i] = new Edge();
	}
	
	int find(subset subsets[], int i)
	{
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

  
	void Union(subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

  
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

  
		else
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

  
	void check()
	{
		Edge result[] = new Edge[V];
		int e = 0;
		int i = 0;
		for (i=0; i<V; ++i)
			result[i] = new Edge();

  
		Arrays.sort(edge);

  
		subset subsets[] = new subset[V];
		for(i=0; i<V; ++i)
			subsets[i]=new subset();

  
		for (int v = 0; v < V; ++v)
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

  
		while (e < V - 1)
		{
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			if (x != y)
			{
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
  
		}
		
		System.out.println("Following are the edges in the constructed MST");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].src+" -- "+result[i].dest+" == "+result[i].weight);
	}

  
	public static void main (String[] args)
	{
		int V = 9;
		int E = 16;
		PA4 g = new PA4(V, E);
		g.edge[0].src = 0;
		g.edge[0].dest = 1;
		g.edge[0].weight = 6;
		g.edge[1].src = 0;
		g.edge[1].dest = 2;
		g.edge[1].weight = 3;
		g.edge[2].src = 0;
		g.edge[2].dest = 4;
		g.edge[2].weight = 10;
		g.edge[3].src = 1;
		g.edge[3].dest = 2;
		g.edge[3].weight = 4;
		g.edge[4].src = 1;
		g.edge[4].dest = 8;
		g.edge[4].weight = 5;
		g.edge[5].src = 1;
		g.edge[5].dest = 7;
		g.edge[5].weight = 5;
		g.edge[6].src = 1;
		g.edge[6].dest = 3;
		g.edge[6].weight = 6;
		g.edge[7].src = 2;
		g.edge[7].dest = 3;
		g.edge[7].weight = 2;
		g.edge[8].src = 2;
		g.edge[8].dest = 4;
		g.edge[8].weight = 9;
		g.edge[9].src = 4;
		g.edge[9].dest = 5;
		g.edge[9].weight = 8;
		g.edge[10].src = 4;
		g.edge[10].dest = 6;
		g.edge[10].weight =18;
		g.edge[11].src = 3;
		g.edge[11].dest =5;
		g.edge[11].weight = 10;
		g.edge[12].src = 5;
		g.edge[12].dest =7;
		g.edge[12].weight = 9;
		g.edge[13].src = 5;
		g.edge[13].dest = 6;
		g.edge[13].weight =10;
		g.edge[14].src = 6;
		g.edge[14].dest = 7;
		g.edge[14].weight = 3;
		g.edge[15].src = 6;
		g.edge[15].dest = 8;
		g.edge[15].weight = 4;

		g.check();
	}
	/*
0 1 6
0 2 3
0 4 10
1 2 4
1 8 5
1 7 5
1 3 6
2 3 2
2 4 9
4 5 8
4 6 18
3 5 10
5 7 9
5 6 10
6 7 3
6 8 4
	 */
}