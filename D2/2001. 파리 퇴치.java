import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt(); // 테스트케이스의 수
		int answer[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt(); // 배열의 크기
			if(n<5 || n>15) // 배열의 크기에 대한 조건 검사
				return;
			int m = s.nextInt(); // 파리채의 크기
			if(m<2 || m>n) // 파리채의 크기에 대한 조건 검사
				return;
			int array[][] = new int[n][n];
			for(int j=0; j<n; j++) { // 배열의 각 영역에 대한 파리 개수 정보 적용
				for(int k=0; k<n; k++) {
					array[j][k] = s.nextInt();
					if(array[j][k] > 30) // 각 영역의 파리 개수에 대한 조건 검사
						return;
				}
			}
			answer[i] = detect(array, n, m);
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
	}
	static int detect(int array[][], int n, int m) { // 파리채의 크기와 배열에 대한 정보를 넘겨받고, 파리채를 휘둘렀을 때 죽은 파리의 개수를 구하는 함수
		int move = n-m; // 배열의 크기에서 파리채의 크기를 빼준 만큼, 파리채가 이동할 수 있다.
		int max = 0; // 파리채를 휘둘렀을 때 죽은 파리의 최대 개수
		for(int i=0; i<=move; i++) { // 배열의 크기가 5고, 파리채의 크기가 2인 경우 move는 3이고 이동 가능 범위의 x축은 0,1,2,3
			for(int j=0; j<=move; j++) { // 배열의 크기가 5고, 파리채의 크기가 2인 경우 move는 3이고 이동 가능 범위의 y축은 0,1,2,3
				int temp = sum(array, m, i, j);
				if(temp > max)
					max = temp;
			}
		}
		return max;
	}
	static int sum(int array[][], int m, int y, int x) { // 파리채의 크기와 배열에 대한 정보를 넘겨받고, 파리채 영역에 해당하는 죽은 파리의 개수에 대한 총합을 구하는 함수
		int s = 0;
		for(int i=x; i<m+x; i++) {
			for(int j=y; j<m+y; j++) {
				s += array[i][j]; 
			}
		}
		return s;
	}
}
