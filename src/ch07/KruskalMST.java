package ch07;

import java.util.Arrays;
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
	int vertexCnt;			// 정점들의 수
    int edgeCnt; 			// 간선들의 수
    Edge edgeArr[]; 			// 모든 간선들의 배열
	
	/**
	 * 생성자 <br>
	 * V 개의 정점들과 E 개의 간선들을 가진 그래프를 생성 
	 * @param v
	 * @param e
	 */
	public KruskalMST(int v, int e)
	{
		vertexCnt = v;
        edgeCnt = e;
        edgeArr = new Edge[edgeCnt];

        for (int i = 0; i < edgeCnt; ++i)
        {
        	edgeArr[i] = new Edge();
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
		Edge result[] = new Edge[vertexCnt];	// 찾은 최소 비용 신장 트리에 포함되는 간선들의 배열
		int e = 0;								// 최소 비용 신장 트리에 포함되는 간선들의 배열 인덱스	
				
		for (int i = 0; i < vertexCnt; ++i) 
		{
			result[i] = new Edge();
		} 
		
		// 단계 1: 모든 간선들을 가중치 순서로 오름차순으로 정렬한다
        Arrays.sort(edgeArr);
        
        // vertexCnt 개의 부분집합들을 위한 배열을 만든다
        Subset subsets[] = new Subset[vertexCnt];
        
        // 각 부분집합을 초기화한다
        for(int i = 0; i < vertexCnt; ++i)
        {
            subsets[i] = new Subset();
        }
        
        // 한 개의 요소를 갖는 V 개의 부분집합들을 생성한다
        for (int v = 0; v < vertexCnt; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
        
        int i = 0;		// 다음 간선을 선택하기 위해 사용되는 인덱스
        
        // 트리에 추가된 간선들의 수가 (vertexCnt - 1)이 될 때까지 반복한다
        while (e < vertexCnt - 1)
        {
        	
        }
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
        	graph.edgeArr[i].src = scan.nextInt();
        	graph.edgeArr[i].dest = scan.nextInt();
            graph.edgeArr[i].weight = scan.nextInt();
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
		int weight;		// 비중 
		int src;		// 시작노드 
		int dest;		// 종료 노드 
		
		/**
		 * 간선들을 가중치에 기초하여 정렬하기 위해 사용되는 비교 메소드
		 */
		@Override
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;	// 비중값을 계산 
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
