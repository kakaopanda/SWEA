import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt(); // 테스트케이스의 수
		int answer[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt(); // 행렬의 크기
			if(n<3 || n>7) // 행렬의 크기에 대한 조건 검사
				return;
			int array[][] = new int[n][n];
			for(int j=0; j<n; j++) { // 행렬에 대한 입력 정보 적용
				for(int k=0; k<n; k++) {
					array[j][k] = s.nextInt();
				}
			}
			String rotation[][] = new String[n][3];
			for(int j=0; j<3; j++) { // 행렬에 대한 회전 결과 반영, j는 열, k는 행
				for(int k=0; k<n; k++) { // 741, 852, 963에 해당하는 1열(rotate_90)을 채운뒤, 2열(rotate_180), 3열(rotate_270)을 채운다.
					String str;
					if(j==0) 
						rotation[k][j] = rotate_90(array, n, k);
					else if(j==1)
						rotation[k][j] = rotate_180(array, n, k);
					else if(j==2)
						rotation[k][j] = rotate_270(array, n, k);
				}
			}
			System.out.println("#"+(i+1));
			for(int k=0; k<n; k++) {
				for(int j=0; j<3; j++) {
					System.out.print(rotation[k][j]+" ");
				}
				System.out.println();
			}
		}
	}
	static String rotate_90(int array[][], int n, int x) { 
		// 741 : [2][0] + [1][0] + [0][0] 
		// -> 852 : [2][1] + [1][1] + [0][1] 
		// -> 963 : [2][2] + [1][2] + [0][2]
		String str = "";
		for(int i=n-1; i>=0; i--) {
			str += Integer.toString(array[i][x]);
		}
		return str;
	}
	static String rotate_180(int array[][], int n, int y) {
		// 987 : [2][2] + [2][1] + [2][0]
		// -> 654 : [1][2] + [1][1] + [1][0] 
		// -> 321 : [0][2] + [0][1] + [0][0]
		String str = "";
		for(int i=n-1; i>=0; i--) {
			str += Integer.toString(array[n-1-y][i]);
		}
		return str;
	}
	static String rotate_270(int array[][], int n, int y) { 
		// 369 : [0][2] + [1][2] + [2][2] 
		// -> 258 : [0][1] + [1][1] + [2][1]
		// -> 147 : [0][0] + [1][0] + [2][0]
		String str = "";
		for(int i=0; i<=n-1; i++) {
			str += Integer.toString(array[i][n-1-y]);
		}
		return str;
	}
}
