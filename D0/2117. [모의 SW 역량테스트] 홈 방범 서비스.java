import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int array[][];
	static int answer; // 보안회사가 손해를 보지 않고 서비스 가능한 최대 집의 수 (profit-cost>=0)
	static int profit; // 보안회사가 얻을 수 있는 수익
	static int cost; // 보안회사가 서비스 운영시 필요한 비용
	static int service_home; // 보안회사가 서비스 운영시 서비스를 제공받는 집의 수
	static List<Coordinate> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			array = new int[N][N];
			list = new ArrayList<>();
			answer = Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
					// 집의 좌표는 리스트에 추가한다.
					if(array[i][j]==1) {
						list.add(new Coordinate(i,j));
					}
				}
			}
			
			// 홈방범 서비스가 모든 영역을 덮기 위해서는 2N-1까지 확장해야한다.
			for(int k=1; k<=(2*N-1); k++) {
				cost = cost(k);
				if(cost > M * list.size()) {
					break;
				}
				
				// 하나의 기준점을 대상으로, 방범 서비스 영역에 해당하는 집들을 계싼한다.
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						// 기준점 C
						Coordinate c = new Coordinate(i,j);
						service_home = 0;
						profit = 0;
						
						for(int l=0; l<list.size(); l++) {
							// 집의 위치 O
							Coordinate o = list.get(l);
							
							// 현재 기준점이 집의 위치인 경우
							if(o.x==c.x&&o.y==c.y) {
								service_home++;
								profit += M;
								continue;
							}
							
							else {
								if(distance(o,c)<=k-1) {
									service_home++;
									profit += M;
								}
							}

							// System.out.println(k+","+(profit-cost)+","+service_home);
							if(profit-cost>=0) {
								if(answer<service_home) {
									answer = service_home;
								}
							}
						}
					}
				}
				if(answer>=list.size()) {
					break;
				}
			}
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	
	
	// 기업의 서비스 운영 비용을 계산한다.
	static int cost(int k) {
		return ((k*k) + (k-1)*(k-1));
	}
	
	// 집과 집 사이의 거리를 계산한다.
	// 홈방범 서비스가 K일 때, 집과 집 사이의 거리가 K-1에 해당하면 서비스 범위에 포함된다.
	static int distance(Coordinate o, Coordinate c) {
		return Math.abs(o.x-c.x)+Math.abs(o.y-c.y);
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
