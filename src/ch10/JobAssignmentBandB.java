package ch10;

import java.util.PriorityQueue;

public class JobAssignmentBandB
{

	private int N;						// 사람들의 수
	private int[][] costMatrix;			// 비용 행렬
	private PriorityQueue<Node2> queue;  // 상태 공간 트리를 대신하는 우선 순위 대기열
	
	/**
	 * 생성자 
	 * 객체 변수들의 값들을 주어진 값으로 초기화하면서 JobAssignmentBandB 객체를 생성한다
	 * @param num
	 * @param cost
	 */
	public JobAssignmentBandB(int num, int[][] cost)
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		// 일 배정 비용을 저장하는 배열
		// costMatrix[i][j]는 사람 i에 일 j를 배정하는 비용을 나타낸다
		int[][] costMatrix = 
			{
					{5, 3, 6, 7}, 
					{4, 6, 2, 5}, 
					{6, 3, 5, 4}, 
					{9, 6, 8, 5}
			};
		
		// 객체 변수들의 값들을 초기화하면서 JobAssignmentBandB 객체를 생성한다
		JobAssignmentBandB jabb = new JobAssignmentBandB(4, costMatrix);

		// 분기 한정을 이용하여 일들의 최소 배정 비용을 계산한 후 출력한다
		System.out.println("\n최소 배정 비용 = " + jabb.findMinCost());
	}

}
