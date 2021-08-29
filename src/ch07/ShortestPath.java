package ch07;

/**
 * 
 * <pre>
 * Dijkstra의 알고리즘
 * 출발 정점으로부터 모든 다른 정점까지 가는 최단 경로를 찾는다
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 28.
 * @Version	:
 */
public class ShortestPath
{	
	public final static int INF = 9999; 		// 무한대
	
	/**
	 * <pre>
	 * 1. 개요 : 출발 정점으로부터 모든 다른 정점까지 가는 최단 경로를 찾기
	 * 2. 처리내용 : 
	 * </pre>
	 * @param W
	 * @param src
	 * @param n
	 */
	public void dijkstra(int[][] W, int src, int n)
	{
		int[] distance = new int[n];			// distance[i]는 출발 정점으로부터 정점 i까지 최단 거리를 저장
		boolean[] tree = new boolean[n];		// tree[i]는 정점 i가 최단 경로 트리에 포함된다면 true
		int[] parent = new int[n];				// parent[i]는 최단 경로 트리에서 정점 i의 부모 노드를 저장
		// 
		for (int i = 0; i < n; i++)
		{
			distance[i] = Integer.MAX_VALUE;	// 모든 정점의 출발 정점으로부터 최단 거리를  가장 큰 정수로 초기화
			tree[i] = false;					// 모든 정점이  최단 경로 트리에 포함되지 않음
			parent[i] = -1;						// 모든 정점의  최단 경로 트리에서 부모 노드를 -1로 초기화
		}
		
		distance[src] = 0;						// 출발 정점의 최단 거리를  0으로 설정
		
		// 모든 정점의 출발 정점으로부터 최단 경로를 찾는다
		for (int i = 0; i < n -1 ; i++)
		{
			// 최단 경로 트리에 아직 포함되지 않는 정점들의 집합에서  출발 정점으로부터 최소 거리에 있는 정점을
			// 선택한다. 첫 반복시 정점 u는 출발 정점이다.
			int u = findMinDistance(distance, tree, n);
			
			tree[u] = true;						// 선택된 정점을 최단 경로 트리에 포함
			
			// 선택된 정점의 인접 정점들의 출발 정점으로부터 최단 거리를 갱신
			for (int v = 0; v < n; v++)
			{
				// 정점 v가 최단 경로 트리에 포함되지 않고 정점 u와 정점 v사이에 간선이 있고
				// 출발 정점부터 u를 거쳐 v까지 가는 경로의 거리가 d[v]의 현재 값보다 작다면
				// d[v]를 갱신한다
				if(!tree[v] && W[u][v] != 0 && distance[u] != Integer.MAX_VALUE &&
						distance[u] + W[u][v] < distance[v])
				{
					distance[v] = distance[u] + W[u][v];
					parent[v] = u;
				}
			}
		}
		
		printShortestPath(distance, parent, n);
	}
	

	/**
	 * <pre>
	 * 1. 개요 : 최단 경로 트리에 아직 포함되지 않는 정점들의 집합에서 출발 정점으로부터 
	 *           최소 거리에 있는 정점을 찾는다
	 * 2. 처리내용 : 
	 * </pre>
	 * @param distance
	 * @param tree
	 * @param n
	 * @return 최소 값을 갖는 노드의 인덱스를 반환  
	 */
	public int findMinDistance(int[] distance, boolean[] tree, int n)
	{
		int min = Integer.MAX_VALUE;
		int min_index = -1; 
		
		for (int v = 0; v < n; v++)
		{
			if(tree[v] == false && distance[v] <= min)
			{
				min = distance[v];
				min_index = v;
			}
		}
		return min_index;
	}

	/**
	 * <pre>
	 * 1. 개요 : 모든 정점의 출발 정점으로부터 최단 경로를 길이와 함께 출력
	 * 2. 처리내용 : 
	 * </pre>
	 * @param distance
	 * @param parent
	 * @param n
	 */
	public void printShortestPath(int[] distance, int[] parent, int n)
	{
		System.out.println("정점\t거리\t최단 경로");
		
		// 각 정점의 출발 정점으로부터  최단 경로를 최단 경로 트리에서
		// 그 정점의 부모 노드를 거꾸로 따라가면서 찾아서 출력한다
		for (int i = 0; i < n; i++)
		{
			int v = i;
			String sp = v + "";
			
			while(parent[v] != -1)
			{
				sp = parent[v] + " - " + sp;
				v = parent[v];
			}
			System.out.println(i + "\t" + distance[i] + "\t" + sp);
		}
		
	}
	
	public static void main(String[] args)
	{
		ShortestPath sp = new ShortestPath();
				
		// W[][]: 주어진 그래프의 인접 행렬 표현
		int W[][] = new int[][] {
			{0, 2, INF, INF, 7},
			{2, 0, 5, INF, 1},
			{INF, 5, 0, 4, 3},
			{INF, INF, 4, 0, 6},
			{7, 1, 3, 6, 0},
		};
		
		sp.dijkstra(W, 0, 5);

	}

	

}
