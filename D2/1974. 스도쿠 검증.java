import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt(); // 테스트케이스의 수
		int answer[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int sdoku[][] = new int[9][9];
			for(int j=0; j<9; j++) { // 스도쿠 입력정보 적용
				for(int k=0; k<9; k++) {
					sdoku[j][k] = s.nextInt();
					if(sdoku[j][k]<1 || sdoku[j][k]>9)
						return;
				}
			}
			int result = 1; // 스도쿠에 대해 겹치는 숫자가 존재하는지에 대한 여부.(겹치지 않는 경우 1, 겹치는 경우 0)
			int record[] = new int[10];
			for(int j=0; j<9; j++) { // 행(row)에 대한 검증
				for(int k=0; k<9; k++) {
					record[sdoku[j][k]]++;
				}
				for(int k=1; k<10; k++) {
					if(record[k]==1)
						continue;
					else
						result = 0;
				}
				for(int k=1; k<10; k++) {
					record[k] = 0;
				}
			}
			for(int j=0; j<9; j++) { // 열(column)에 대한 검증
				for(int k=0; k<9; k++) {
					record[sdoku[k][j]]++;
				}
				for(int k=1; k<10; k++) {
					if(record[k]==1)
						continue;
					else
						result = 0;
				}
				for(int k=1; k<10; k++) {
					record[k] = 0;
				}
			}
			for(int j=0; j<9; j+=3) { 
				// 3*3 크기의 작은 격자에 대한 검증. 열 j=0,3,6
				for(int k=0; k<9; k+=3) { // 행 k=0,3,6
					record[sdoku[j][k]]++;
					record[sdoku[j+1][k]]++;
					record[sdoku[j+2][k]]++;
					record[sdoku[j][k+1]]++;
					record[sdoku[j][k+2]]++;
					record[sdoku[j+1][k+1]]++;
					record[sdoku[j+2][k+1]]++;
					record[sdoku[j+1][k+2]]++;
					record[sdoku[j+2][k+2]]++;
					
					for(int l=1; l<10; l++) {
						if(record[l]==1)
							continue;
						else {
							result = 0;
						}	
					}
					for(int l=1; l<10; l++) {
						record[l] = 0;
					}
				}
			}
			answer[i] = result;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
	}
}
