import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, answer;
	static int array[][];
	static boolean visit[];
	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = 0;
			visit = new boolean[N+1];
			array = new int[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				array[from][to] = 1;
				array[to][from] = 1;
			}

			for(int i=1; i<=N; i++) {
				if(!visit[i]) {
					bfs(i);
					answer++;
				}
			}
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}

	static void bfs(int index) {
		queue.add(index);
		visit[index] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();

			for(int i=1; i<=N; i++) {
				if(!visit[i] && array[cur][i]==1) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
