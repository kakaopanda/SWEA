import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		long result[] = new long[testcase];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			if(n<2 || n>1000000)
				return;
			int price[] = new int[n];
			for(int j=0; j<n; j++) {
				price[j] = s.nextInt();
				if(price[j]>10000)
					return;
			}
			long benefit = calc(price); // 테스트케이스에서 획득할 수 있는 최대 이익
			result[i] = benefit;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+(long)result[i]);
		}
	}
	static long calc(int[] array) {
		long benefit = 0;
		int index = 0;
		// STEP1. 배열의 최댓값에 해당하는 요소의 인덱스를 계산하는 반복문
		for(int i=0; i<array.length; i++) {
			if(array[index] < array[i])
				index = i;
		}
		
		// STEP2. 배열의 최댓값이 존재하는 이전 날들로부터 획득할 수 있는 이익 합산
		for(int i=0; i<index; i++) {
			benefit += array[index] - array[i];
		}
		
		int[] array_update = new int[array.length-index];
		System.arraycopy(array, index+1, array_update, 0, array.length-index-1);
		if(index!=0) {
			return benefit+calc(array_update);
		}
		else {
			// STEP3. 이익 합산 이후, 새로 생성한 배열에서 첫 번째 요소가 최대값에 해당하는 경우
			if(array.length > 1) {
				int[] array_except = new int[array.length-1];
				System.arraycopy(array, index+1, array_except, 0, array.length-index-1);
				return benefit+calc(array_except);
			}
			return benefit;
		}
	}
}
