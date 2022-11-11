import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, S, B;
	static int array[];
	static int answer;
	static boolean select[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			array = new int[N];
			select = new boolean[N];
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				array[n] = Integer.parseInt(st.nextToken());
			}
			subset(0);
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	public static void subset(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(select[i]) {
					sum += array[i];
				}
			}
			if(sum >= S) {
				int diff = (sum-S);
				answer = Math.min(diff, answer);
			}
		}
		else {
			select[cnt] = true;
			subset(cnt+1);
			select[cnt] = false;
			subset(cnt+1);
		}
	}
}
