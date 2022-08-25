import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0; i<T; i++) {
			int N = s.nextInt();
			System.out.println("#"+(i+1));
			calc(N);
		}
	}
	
	static void calc(int n) {
		int array[][] = new int[n][n];
		
		// 배열의 크기에 따라, 진행 방향이 바뀌는 경우가 한정되어있다.
		// (2n-1)번
		// n = 3 -> 5번
		// n = 4 -> 7번
		int index = (2*n-1);
		int number = 1;
		
		int left_row = 0;
		int down_row = 1;
		int down_column = n-1;
		int right_row = n-1;
		int right_column = 0;
		int up_row = n-1;
		int up_column = 0;
		
		while(true) {
			if(index==0)
				break;
			// Case1. Right
			// (0,0) -> (1,1)
			for(int i=left_row; i<n-left_row; i++) {
				array[left_row][i] = number++;
			}
			index--;
			left_row++;
			
			if(index==0)
				break;
			
			// Case2. Down 
			// (1,3) -> (2,2)
			for(int i=down_row; i<n-down_row+1; i++) {
				array[i][down_column] = number++;
			}
			index--;
			down_column--;
			down_row++;

			if(index==0)
				break;
			
			// Case3. Left
			// (3,2) -> (2,1)
			for(int i=down_column; i>=right_column; i--) {
				array[right_row][i] = number++;
			}
			index--;
			right_column++;
			right_row--;
			
			if(index==0)
				break;
			
			// Case4. Up
			// (2,0) -> (1,1)
			for(int i=up_row-1; i>=n-up_row; i--) {
				array[i][up_column] = number++;
			}
			index--;
			up_row--;
			up_column++;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
