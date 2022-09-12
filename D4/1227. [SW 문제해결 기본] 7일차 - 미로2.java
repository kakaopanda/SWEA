import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int maze[][] = new int[100][100];
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean visit[][];
	static int answer;
	static Coordinate start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<10; t++) {
			st = new StringTokenizer(br.readLine(), "");
			int T = Integer.parseInt(st.nextToken());
			// STEP1. 미로의 정보를 배열에 기록하면서, 출발점과 도착점을 저장한다.
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine(), "");
				String str = st.nextToken();
				for(int j=0; j<100; j++) {
					maze[i][j] = str.charAt(j)-'0';
					// Case1. 입력 값이 출발점인 경우
					if(maze[i][j]==2) {
						start = new Coordinate(i,j);
					}
					// Case2. 입력 값이 도착점인 경우
					else if(maze[i][j]==3) {
						end = new Coordinate(i,j);
					}
				}
			}
			
			// STEP2. 도착점에서 출발하여, 시작점까지 도달할 수 있는지 탐색한다.
			answer = 0;
			bfs(end.x, end.y);
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<Coordinate> queue = new ArrayDeque<>();
		visit = new boolean[100][100];
		
		// STEP3. 검사를 수행하는 좌표에 대해 검사 수행 여부를 표시하고 큐에 넣는다.
		visit[x][y] = true;
		queue.offer(new Coordinate(x,y));
		
		// STEP4. 큐에서 꺼낼 원소가 없을때까지 탐색을 수행한다.
		while(!queue.isEmpty()) {
			Coordinate c = queue.poll();
			
			for(int i=0; i<4; i++) {
				int cx = c.x + delta[i][0];
				int cy = c.y + delta[i][1];
				
				// STEP5. 새로운 탐색 범위가 미로를 벗어나지 않는지 확인한다.
				if(cx>=0 && cx<100 && cy>=0 && cy<100) {
					// STEP6. 새로운 탐색 범위를 처음 방문하는 경우
					if(!visit[cx][cy] && maze[cx][cy]!=1) {
						visit[cx][cy] = true;
						
						// STEP7. 새로운 탐색 범위가 출발점인 경우, 탐색을 종료한다.
						if(maze[cx][cy]==2) {
							answer = 1;
							return;
						}
						else {
							queue.offer(new Coordinate(cx,cy));
						}
					}
				}
			}
		}
	}
}
class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}