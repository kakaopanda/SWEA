import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int max, max_depth;
	static int matrix[][];
	static boolean visit[];
	static ArrayList<Node> arrayList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			arrayList = new ArrayList<>();
			matrix = new int[100+1][100+1];
			visit = new boolean[100+1];
			max = 0;
			max_depth = 1;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = 1;
			}
			bfs(S,1);
			sb.append("#"+(t+1)+" "+max+"\n");
		}
		System.out.println(sb);
	}
	
	// Depth 1 : 2
	// Depth 2 : 7 15
	// Depth 3 : 1 4
	// Depth 4 : 10 8 17 -> 17이 정답!
	static void bfs(int index, int depth) {
		Queue<Node> queue = new ArrayDeque<>();
		visit[index] = true;
		
		// 처음 시작하는 노드에 대한 정보를 큐에 넣어준다.
		queue.offer(new Node(depth,index));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			depth = cur.depth;
			
			for(int i=1; i<=100; i++) {
				if(!visit[i] && matrix[cur.vertex][i] != 0) {
					visit[i] = true;
					arrayList.add(new Node(depth+1,i));
					queue.offer(new Node(depth+1,i));
				}
			}
			max_depth = Math.max(max_depth, depth);
		}
		
		for(int i=0; i<arrayList.size(); i++) {
			if(arrayList.get(i).depth==max_depth) {
				max = Math.max(max, arrayList.get(i).vertex);
			}
		}
	}
}

class Node{
	int depth;
	int vertex;
	public Node(int d, int v) {
		depth = d;
		vertex = v;
	}
}
