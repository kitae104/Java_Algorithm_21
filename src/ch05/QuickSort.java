package ch05;

/**
 * <pre>
 * 퀵 정렬 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 19.
 * @Version	:
 */
public class QuickSort 
{
	/**
	 * <pre>
	 * 1. 개요 : 퀵 정렬을 수행하는 메소드
	 *           - 파티션 부분 
	 *           - 퀵 소트 부분 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 * @param low
	 * @param high
	 */
	public void quickSort(int[] intArray, int low, int high) 
	{
		
		if(low < high) 
		{
			int pivotPoint = partition(intArray, low, high);
			quickSort(intArray, low, pivotPoint -1);
			quickSort(intArray, pivotPoint + 1, high);
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 분할을 수행하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int[] intArray, int low, int high) 
	{
		int i, j, temp;
		
		i = low + 1;		// 기준 다음위치 
		j = high;			// 마지막 위치 
		
		// 배열을 intArray[low]를 기준으로 하여 기준보다 
		// 큰 요소는 오른쪽으로 옮기고 작은 원소는 왼쪽으로 옮긴다.
		while(i<=j) 
		{
			if(intArray[i] <= intArray[low]) 
			{
				i = i + 1;
			}
			else if (intArray[j] > intArray[low]) 
			{
				j = j - 1;
			}
			else
			{
				temp = intArray[i];
				intArray[i] = intArray[j];
				intArray[j] = temp;
				i = i + 1;
				j = j - 1;						
			}
		}
		
		// intArray[low]를 intArray[low]보다 작거나 같은 요소들의 구역의 마지막 요소와 교환
		temp = intArray[low];
		intArray[low] = intArray[j];
		intArray[j] = temp;
		return j;						// 파티션 기준을 옮긴 인덱스 반환  
	}

	/**
	 * <pre>
	 * 1. 개요 : 배열의 모든 요소를 한 줄로 출력하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param intArray
	 */
	public void printArray(int[] intArray) 
	{
		for (int i = 0; i < intArray.length; ++i) 
		{
            System.out.print(intArray[i] + " ");
		}
        System.out.println();
	}
	
	public static void main(String[] args) 
	{
		QuickSort qs = new QuickSort();
		
		int intArray[] = {15, 22, 13, 27, 12, 10, 20, 25, 32};

        System.out.println("주어진 배열");
        qs.printArray(intArray);


        qs.quickSort(intArray, 0, intArray.length - 1);

        System.out.println("\n정렬된 배열");
        qs.printArray(intArray);
	}
}
