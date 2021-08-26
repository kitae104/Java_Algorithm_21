package ch07;

import java.util.Scanner;

/**
 * 
 * <pre>
 * 주어진 연결된 무방향 가중 그래프의 최소 비용 신장 트리를 찾는 크루스칼(Kruskal) 알고리즘
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 27.
 * @Version	:
 */
public class KruskalMST
{
	int V;	// 정점들의 수
    int E; 	// 간선들의 수
    Edge edge[]; // 모든 간선들의 배열
	
	/**
	 * V 개의 정점들과 E 개의 간선들을 가진 그래프를 생성 
	 * 생성자
	 * @param v
	 * @param e
	 */
	public KruskalMST(int v, int e)
	{
		V = v;
        E = e;
        edge = new Edge[E];

        for (int i = 0; i < E; ++i)
        {
        	edge[i] = new Edge();
        }
	}

	/**
	 * <pre>
	 * 1. 개요 : 크루스칼 알고리즘을 이용하여 최소 비용 신장 트리를 찾는 메소드
	 * 2. 처리내용 : 
	 * </pre>
	 */
	public void kruskalMST()
	{
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		int V = 5;  // 그래프내의 정점들의 수
        int E = 7;  // 그래프내의 간선들의 수
        
        Scanner scan = new Scanner(System.in);
        
        // 주어진 연결된 가중치가 있는 무방향 그래프를 만든다
        KruskalMST graph = new KruskalMST(V, E);

        // 그래프내의 간선의 두 정점들과 가중치를 키보드릉 통해 입력받는다
        System.out.println("간선의 두 정점들과 가중치를 차례대로 입력하세요");
        for (int i = 0;  i < E; i++) 
        {
        	graph.edge[i].src = scan.nextInt();
        	graph.edge[i].dest = scan.nextInt();
            graph.edge[i].weight = scan.nextInt();
        }
        
        graph.kruskalMST();
	}
	
	/**
	 * <pre>
	 * 그래프의 한 간선을 나타내는 클래스
	 * </pre>
	 *	
	 * @author	: 김기태
	 * @Date  	: 2021. 8. 27.
	 * @Version	:
	 */
	private class Edge implements Comparable<Edge> {
		int weight;
		int src;
		int dest;
		
		@Override
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
		
	}
	
	/**
	 * <pre>
	 * union-find를 위한 서로소 부분집합(disjoint subset)을 나타내는 클래스
	 * </pre>
	 *	
	 * @author	: 김기태
	 * @Date  	: 2021. 8. 27.
	 * @Version	:
	 */
	private class Subset {
        int parent;			// 대표
        int rank;			// 순위
    };

}
