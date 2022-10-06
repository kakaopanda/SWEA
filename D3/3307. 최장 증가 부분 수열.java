import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb= new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			// DP로 풀이한 방식
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int array[] = new int[N];
			int dp[] = new int[N];
			int max = 0;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				array[n] = Integer.parseInt(st.nextToken()); 
				dp[n] = 1;
			}
			
			for(int i=1; i<N; i++) {
				for(int j=i-1; j>=0; j--) {
					if(array[i] > array[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				max = Math.max(max, dp[i]);
			}
			sb.append("#"+(t+1)+" "+max+"\n");
			
			// 단순 비교 연산으로 구현할 경우, 다음 숫자가 큰 숫자일 때 그 다음 숫자를 찾지 못하는 논리적 오류가 발생한다!
			// 1 6 2 3 4 -> 정답이 4(1,2,3,4)가 아닌 3(2,3,4)이 출력된다.
			// 해당 문제를 해결하기 위해 DP로 풀어야한다.
			/*
			int compare = 0, max = 0;
			for(int i=0; i<N; i++) {
				compare = 0;
				List<Integer> list = new ArrayList<>();
				for(int j=i; j<N; j++) {
					if(compare < array[j]) {
						compare = array[j];
						list.add(array[j]);
					}
				}
				System.out.println(t+","+list.size());
				max = Math.max(max, list.size());
			}
			*/
		}
		System.out.println(sb);
	}
}
