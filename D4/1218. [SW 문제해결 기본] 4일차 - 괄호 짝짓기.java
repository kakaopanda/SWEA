import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			int length = s.nextInt();
			int check = 1;
			String str = s.next();
			char array[] = str.toCharArray();
			
			// (, [, {, < 순서로 인덱스를 지정한다.
			int start_bracket[] = new int[4];
			
			// ), ], }, > 순서로 인덱스를 지정한다.
			int end_bracket[] = new int[4];
			
			END:
			for(int i=0; i<array.length; i++) {
				switch(array[i]) {
					case '(': 
						start_bracket[0]++;
						break;
					case '[':
						start_bracket[1]++;
						break;
					case '{':
						start_bracket[2]++;
						break;
					case '<':
						start_bracket[3]++;
						break;
					case ')':
						// 닫는 기호가 나왔는데 시작하는 기호가 없는 경우
						if(start_bracket[0]==0) {
							check = 0;
							break END;
						}
						else {
							start_bracket[0]--;
						}
						end_bracket[0]++;
						break;
					case ']':
						// 닫는 기호가 나왔는데 시작하는 기호가 없는 경우
						if(start_bracket[1]==0) {
							check = 0;
							break END;
						}
						else {
							start_bracket[1]--;
						}
						end_bracket[1]++;
						break;
					case '}':
						// 닫는 기호가 나왔는데 시작하는 기호가 없는 경우
						if(start_bracket[2]==0) {
							check = 0;
							break END;
						}
						else {
							start_bracket[2]--;
						}
						end_bracket[2]++;
						break;
					case '>':
						// 닫는 기호가 나왔는데 시작하는 기호가 없는 경우
						if(start_bracket[3]==0) {
							check = 0;
							break END;
						}
						else {
							start_bracket[3]--;
						}
						end_bracket[3]++;
						break;
				}
			}
			sb.append("#"+(t+1)+" "+check+"\n");
		}
		System.out.println(sb);
	}
}
