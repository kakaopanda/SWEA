import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt(); // 테스트케이스의 수
		int answer[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int record[] = new int[225]; // 연속된 칸의 길이를 기록하는 배열
			for(int j=0; j<225; j++)
				record[j] = 0;
			int n = s.nextInt(); // 단어 퍼즐의 가로 길이
			if(n<5 || n>15) // 단어 퍼즐의 가로, 세로 길이 조건 검사
				return;
			int puzzle[][] = new int[n][n];
			int k = s.nextInt(); // 단어의 길이
			if(k<2 || k>n) // 단어의 길이 조건 검사
				return;
			for(int j=0; j<n; j++) { // 퍼즐에 대한 정보 초기화
				for(int l=0; l<n; l++) {
					puzzle[j][l] = 0;
				}
			}
			for(int j=0; j<n; j++) { // 퍼즐 환경 구성
				for(int l=0; l<n; l++) {
					puzzle[j][l] = s.nextInt();
				}
			}
			int result = 0; // 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수
			for(int j=0; j<n; j++) { // 가로 길이에 대한 연속적인 문자열 형태 검사
				int count = 0;
				for(int l=0; l<n; l++) {
					if(puzzle[j][l]==1) {
						count++;
						if(l==n-1) {
							record[count]++;
						}
					}
					else {
						record[count]++;
						count = 0;
						continue;	
					}
				}
			}
			for(int j=0; j<n; j++) { // 세로 길이에 대한 연속적인 문자열 형태 검사
				int count = 0;
				for(int l=0; l<n; l++) {
					if(puzzle[l][j]==1) {
						count++;
						if(l==n-1) {
							record[count]++;
						}
					}
					else {
						record[count]++;
						count = 0;
						continue;	
					}
				}
			}
			answer[i] = record[k];
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
	}
}
