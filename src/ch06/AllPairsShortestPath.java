package ch06;

/**
 * <pre>
 * 모든 쌍 최단 경로 찾기 프로이드 알고리즘  
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 22.
 * @Version	:
 */
public class AllPairsShortestPath
{
	public final static int INF = 9999;			// 상수 선언 
	
	/**
	 * <pre>
	 * 1. 개요 : 모든 쌍 최단 경로를 찾는 메소드
	 * 2. 처리내용 : 
	 * </pre>
	 * @param graph
	 * @param n
	 */
	public void findAllPairShortestPath(int[][] graph, int n)
	{
		int dist[][] = new int[n][n];
		
		// 행렬 dist를 가중치 행렬 graph로 초기화 한다. 
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				dist[i][j] = graph[i][j];
			}
		}
		
		// 모든 정점들을 한 번에 하나씩 중간 정점들의 집합에 추가한다
		for (int k = 0; k < n; k++)
		{
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
			printSolution(dist, n, k);
		}
		
		
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 모든 쌍 최단 경로를 계산한 인접행렬을 출력하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param dist
	 * @param n
	 */
	public void printSolution(int[][] dist, int n, int k)
	{
		System.out.println("모든 두 정점들의 쌍사이의 최단 거리 행렬 : " + k);
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if(dist[i][j] == INF)
				{
					System.out.print("∞ ");
				}
				else
				{
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		// 가중치 인접 행렬 
		int graph[][] = { 
				{0, INF, 2, INF},
                {1, 0, INF, INF},
                {INF, 8, 0, 3},
                {6, 4, INF, 0}
              };

        int n = 4;

        AllPairsShortestPath apsp = new AllPairsShortestPath();

        // 최단 거리 행렬을 계산한 후 출력한다
        apsp.findAllPairShortestPath(graph, n);
	}

}
