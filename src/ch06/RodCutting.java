package ch06;

/**
 * <pre>
 * 막대 자르기 알고리즘 
 * 분할정복과 동적 계획 적용   
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 21.
 * @Version	:
 */
public class RodCutting
{
	private static int cnt = 0;
	/**
	 * <pre>
	 * 1. 개요 : 분할 정복을 이용하여 길이 i의 막대를 잘라 얻을 수 있는 최대 판매 가격을 구하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param priceArray
	 * @param i 막대의 길이 
	 * @return
	 */
	public int cutRod_DC(int[] priceArray, int i)
	{	
		//System.out.println(++cnt);
		if(i == 0) 
		{
			return 0;
		}
		
		int maxSell = 0;
		
		for(int j = 1; j <= i; j++)
		{
			maxSell = Math.max(maxSell, priceArray[j-1] + cutRod_DC(priceArray, i - j));
		}
		
		return maxSell;
	}

	/**
	 * <pre>
	 * 1. 개요 : 동적 계획을 이용하여 길이 i의 막대를 잘라 얻을 수 있는 최대 판매 가격을 구하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param priceArray
	 * @param i
	 * @return
	 */
	public int cutRod_DP(int[] priceArray, int i)
	{
		//System.out.println(++cnt);
		int maxSell[] = new int[i + 1];
		
		maxSell[0] = 0;
		
		for (int j = 1; j <= i; j++)
		{
			int max_val = 0; 
			
			for (int k = 1; k <= j; k++)
			{
				max_val = Math.max(max_val, priceArray[k - 1] + maxSell[j - k]);
			}
			maxSell[j] = max_val;
		}
		return maxSell[i];
	}
	
	public static void main(String[] args)
	{
		RodCutting rc = new RodCutting();
		
		int[] priceArray = new int[] {2, 5, 9, 10};
		int size = priceArray.length;

		long beforeTime = System.currentTimeMillis(); 		//코드 실행 전에 시간 받아오기		
		System.out.println("분할 정복을 이용하여 구한 최대 판매 금액: " + rc.cutRod_DC(priceArray, size));
		long afterTime = System.currentTimeMillis(); 		// 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); 		//두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		System.out.println();
		
		beforeTime = System.currentTimeMillis(); 			//코드 실행 전에 시간 받아오기
		System.out.println("동적 계획을 이용하여 구한 최대 판매 금액: " + rc.cutRod_DP(priceArray, size));
		afterTime = System.currentTimeMillis(); 			// 코드 실행 후에 시간 받아오기
		secDiffTime = (afterTime - beforeTime);		 		//두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}

}
