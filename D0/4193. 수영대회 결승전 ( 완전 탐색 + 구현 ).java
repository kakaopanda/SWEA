import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int array[][];
	static boolean visited[][];
	static int answer;
	static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static Coordinate start, end;
//  시간(t) 단위로 bfs를 수행하도록 통제할 수 없기때문에, bfs의 각 큐에 들어간 원소들의 t값으로 소용돌이를 지나갈 수 있는지를 판단한다.	
//	static List<Coordinate> swirl;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			// 좌표는 (0,0)~(N-1,N-1)로 구성된다.
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			array = new int[N][N];
			visited = new boolean[N][N];
//			swirl = new ArrayList<>();
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int m=0; m<N; m++) {
					array[n][m] = Integer.parseInt(st.nextToken());
//					if(array[n][m]==2) {
//						swirl.add(new Coordinate(n,m));
//					}
				}
			}
			
			st = new StringTokenizer(br.readLine()," ");
			start = new Coordinate(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),0);
			
			st = new StringTokenizer(br.readLine()," ");
			end = new Coordinate(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),0);

			bfs();
			if(answer==Integer.MAX_VALUE) {
				answer = -1;
			}
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Coordinate> queue = new ArrayDeque();
		queue.add(start);
		visited[start.x][start.y] = true;
		
		while(!queue.isEmpty()) {
			Coordinate cur = queue.poll();
			
			// 현재 선수의 위치가 도착점에 도달한 경우
			if(cur.x==end.x && cur.y==end.y) {
				answer = Math.min(answer, cur.t);
				continue;
			}
			
			else {
				for(int i=0; i<4; i++) {
					int tx = cur.x + delta[i][0];
					int ty = cur.y + delta[i][1];
					if(check(tx,ty)) {
						switch(array[tx][ty]) {
						case 0: // 나아갈 곳이 바다인 경우
							visited[tx][ty] = true;
							queue.add(new Coordinate(tx, ty, cur.t+1));
							break;
						case 1: // 나아갈 곳이 섬인 경우 -> 다음 경우의 수를 따져본다.
							continue;
						case 2: // 나아갈 곳이 소용돌이인 경우 -> 선수의 진행시간을 확인한다.
							if((cur.t%3)==2) { // 소용돌이가 사라진 시간인 경우
								visited[tx][ty] =  true;
								queue.add(new Coordinate(tx, ty, cur.t+1));
							}
							else { // 소용돌이가 존재하는 시간인 경우 -> 현재 위치에서 1초 더 위치한다.
								visited[cur.x][cur.y] =  true;
								queue.add(new Coordinate(cur.x, cur.y, cur.t+1));
							}
							break;
						}
					}
				}
			}
		}
	}
	
//	static void update() {
//		for(int n=0; n<swirl.size(); n++) {
//			if(array[swirl.get(n).x][swirl.get(n).y]==0) {
//				array[swirl.get(n).x][swirl.get(n).y] = 2;
//			}
//			else {
//				array[swirl.get(n).x][swirl.get(n).y] -= 1;
//			}
//		}
//	}
	
	static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) {
			return false;
		}
		else {
			if(!visited[x][y]) {
				return true;				
			}
			else {
				return false;
			}
		}
	}
}
class Coordinate{
	int x, y, t;

	public Coordinate(int x, int y, int t) {
		super();
		this.x = x;
		this.y = y;
		this.t = t;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + ", t=" + t + "]";
	}
}
