package ch07;

/**
 * 프림(Prim)의 최소 비용 신장 트리 알고리즘
 * @author 김기태
 *
 */
public class PrimeMST {
	
	public final static int INF = 9999;
	
	
	
	public static void main(String[] args) {
		
		PrimeMST mst = new PrimeMST();
		
		int graph[][] = new int[][] {
			{0, 2, INF, INF, 4},
            {2, 0, 8, INF, 4},
            {INF, 8, 0, 7, 6},
            {INF, INF, 7, 0, 3},
            {4, 4, 6, 3, 0},
           };

	}

}
