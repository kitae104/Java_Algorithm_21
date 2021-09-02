package ch10;

import java.util.PriorityQueue;

/**
 * 분기 한정을 이용하여 배낭 채우기 문제를 해결하는 알고리즘
 * @author 김기태
 *
 */
public class KnapsackBandB {

	private int maxValue;  	// 현재까지 찾은 최고 해의 값
	private int N;			// 물건들의 수
	private int C;			// 배낭의 용량
	private int[] Wt;		// 각 물건의 무게를 저장하는 배열
	private int[] Val;		// 각 물건의 가치를 저장하는 배열
	
	private PriorityQueue<Node> queue;  // 상태 공간 트리를 대신하는 우선 순위 대기열
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
