import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			String str = s.next();
			char[] array = new char[31];
			array = str.toCharArray();

			char first = array[0];
			char second = array[1];
			
			// 첫 번째 글자와 두 번째 글자의 일치 여부를 검사한다.
			if(first == second){
				result[i] = 1;
				continue;
			}
			// 세 번째 글자부터 마디의 여부를 검사한다.
			else {
				int index = 0;
				for(int j=2; j<(30-1); j++) {
					if(array[j]==first) {
						if(array[j+1]==second) {
							// 마디의 길이이므로 처음 반복이 다시 시작되는 첫 번째 인덱스와 동일하다.
							index = j;
							break;
						}
					}
				}
				result[i] = index;
			}
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}
