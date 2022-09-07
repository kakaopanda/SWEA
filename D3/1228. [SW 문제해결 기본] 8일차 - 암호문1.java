import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringTokenizer st;
		int T = 10;
		for(int t=0; t<T; t++) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			
			// Step1. 원본 암호문의 길이를 입력받는다.
			int N = s.nextInt();
			
			// Step2. 원본 암호물을 입력받는다.
			for(int i=0; i<N; i++) {
				arrayList.add(s.nextInt());
			}
			
			// Step3. 명령어의 개수를 입력받는다.
			N = s.nextInt();
			
			// Step4. 명령어를 입력받는다.
			for(int i=0; i<N; i++) {
				// 'I' 입력 받기
				String str = s.next();
				int x = s.nextInt();
				int y = s.nextInt();
				int edit[] = new int[y];
				for(int j=0; j<y; j++) {
					edit[j] = s.nextInt();
				}
				for(int j=x; j<x+y; j++) {
					arrayList.add(j,edit[j-x]);
				}
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<10; i++) {
				System.out.print(arrayList.get(i)+" ");
			}
			System.out.println();
		}
	}
}
