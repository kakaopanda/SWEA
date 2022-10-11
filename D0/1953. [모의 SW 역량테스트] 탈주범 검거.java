import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, R, C, L;
	static int map[][];
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int count;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			count = 0;
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int m=0; m<M; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(new Coordinate(R,C));
			count = possible();
			sb.append("#"+(t+1)+" "+count+"\n");			
		}
		System.out.println(sb);
	}
	
	static int possible() {
		int p = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) {
					p++;
				}
			}
		}
		return p;
	}
	
	static void bfs(Coordinate c) {
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(c);
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(++time > L) {
				return;
			}
			
			for(int i=0; i<size; i++) {
				Coordinate now = queue.poll();
				if(visited[now.x][now.y]) {
					continue;
				}
				else {
					visited[now.x][now.y] = true;
					
					int value = map[now.x][now.y];
					Coordinate up = new Coordinate(now.x+delta[0][0],now.y+delta[0][1]);
					Coordinate down = new Coordinate(now.x+delta[1][0],now.y+delta[1][1]);
					Coordinate left = new Coordinate(now.x+delta[2][0],now.y+delta[2][1]);
					Coordinate right = new Coordinate(now.x+delta[3][0],now.y+delta[3][1]);
					
					switch(value) {
					case 0: // 터널이 없는 장소
						break;
					// up이 가능한 경우는 1,2,5,6이다.
					// down이 가능한 경우는 1,2,4,7이다.
					// left가 가능한 경우는 1,3,4,5이다.
					// right가 가능한 경우는 1,3,6,7이다.
					case 1: // 상,하,좌,우
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									count++;
									queue.add(up);
							}
						}
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									count++;
									queue.add(down);
							}
						}
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									count++;
									queue.add(left);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									count++;
									queue.add(right);
							}
						}
						break;
					case 2: // 상,하
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									count++;
									queue.add(up);
							}
						}
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									count++;
									queue.add(down);
							}
						}
						break;
					case 3: // 좌,우
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									count++;
									queue.add(left);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									count++;
									queue.add(right);
							}
						}
						break;
					case 4: // 상,우
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									count++;
									queue.add(up);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									count++;
									queue.add(right);
							}
						}
						break;
					case 5: // 하,우
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									count++;
									queue.add(down);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									count++;
									queue.add(right);
							}
						}
						break;
					case 6: // 하,좌
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									count++;
									queue.add(down);
							}
						}
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									count++;
									queue.add(left);
							}
						}
						break;
					case 7: // 상,좌
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									count++;
									queue.add(up);
							}
						}
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									count++;
									queue.add(left);
							}
						}
						break;
				}
			}
			}
		}
	}
	
	// dfs는 깊이 우선 탐색으로, 해당 문제의 풀이방식으로는 적절하지 않다.
	// dfs를 bfs와 같이 운용하기 위해서 추가적인 처리가 필요하다. (visited[])
	/*
	static void dfs(Coordinate c, int cnt) {
		// 제공된 시간이 모두 경과된 경우
		if(cnt==L) {
			return;
		}
		else {
			if(!visited[c.x][c.y]) {
				// dfs에 전달된 좌표(Coordinate)는 배열 범위 내에 존재한다고 가정한다.
				visited[c.x][c.y] = true;
				
				int value = map[c.x][c.y];
				Coordinate up = new Coordinate(c.x+delta[0][0],c.y+delta[0][1]);
				Coordinate down = new Coordinate(c.x+delta[1][0],c.y+delta[1][1]);
				Coordinate left = new Coordinate(c.x+delta[2][0],c.y+delta[2][1]);
				Coordinate right = new Coordinate(c.x+delta[3][0],c.y+delta[3][1]);
				
				switch(value) {
					case 0: // 터널이 없는 장소
						break;
					// up이 가능한 경우는 1,2,5,6이다.
					// down이 가능한 경우는 1,2,4,7이다.
					// left가 가능한 경우는 1,3,4,5이다.
					// right가 가능한 경우는 1,3,6,7이다.
					case 1: // 상,하,좌,우
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									dfs(up,cnt+1);
							}
						}
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									dfs(down,cnt+1);
							}
						}
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									dfs(left,cnt+1);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									dfs(right,cnt+1);
							}
						}
						break;
					case 2: // 상,하
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									dfs(up,cnt+1);
							}
						}
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									dfs(down,cnt+1);
							}
						}
						break;
					case 3: // 좌,우
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									dfs(left,cnt+1);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									dfs(right,cnt+1);
							}
						}
						break;
					case 4: // 상,우
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									dfs(up,cnt+1);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									dfs(right,cnt+1);
							}
						}
						break;
					case 5: // 하,우
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									dfs(down,cnt+1);
							}
						}
						if(check(right)) {
							switch(map[right.x][right.y]) {
								case 1:
								case 3:
								case 6:
								case 7:
									dfs(right,cnt+1);
							}
						}
						break;
					case 6: // 하,좌
						if(check(down)) {
							switch(map[down.x][down.y]) {
								case 1:
								case 2:
								case 4:
								case 7:
									dfs(down,cnt+1);
							}
						}
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									dfs(left,cnt+1);
							}
						}
						break;
					case 7: // 상,좌
						if(check(up)) {
							switch(map[up.x][up.y]) {
								case 1:
								case 2:
								case 5:
								case 6:
									dfs(up,cnt+1);
							}
						}
						if(check(left)) {
							switch(map[left.x][left.y]) {
								case 1:
								case 3:
								case 4:
								case 5:
									dfs(left,cnt+1);
							}
						}
						break;
				}
			}
		}
	}
	*/

	static boolean check(Coordinate next) {
		boolean check = true;
		if(next.x>=0 && next.x<N && next.y>=0 && next.y<M) {
			return check;
		}
		else {
			check = false;
		}
		return check;
	}
}

class Coordinate{
	int x, y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
