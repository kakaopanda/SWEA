import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, K, N, M;
	static int array[][];
	// 상(1), 하(2), 좌(3), 우(4)의 인덱스를 맞추기 위해, {0,0}을 맨 앞에 추가한다.
	static int delta[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}}; 
	static List<Cluster> list;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		T = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			array = new int[N][N];
			list = new ArrayList<>();
			answer = 0;
			
			for(int k=0; k<K; k++) {
				int column, row, count, direction;
				st = new StringTokenizer(br.readLine()," ");
				column = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				count = Integer.parseInt(st.nextToken());
				direction = Integer.parseInt(st.nextToken());
				list.add(new Cluster(column,row,count,direction));
				array[column][row] += 1;
			}
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(array[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			// 최초에 약품이 칠해진 가장자리 부분에 군집이 배치되지 않고, 둘 이상의 군집이 동일한 셀에 배치되지 않는다.
			for(int m=0; m<M; m++) {
				// STEP1. 군집 이동
				for(int i=0; i<list.size(); i++) {
					Cluster c = list.get(i);
					int tx = c.column + delta[c.direction][0];
					int ty = c.row + delta[c.direction][1];
					
					// 군집의 진로가 배열의 범위에서 벗어나지 않는 경우
					if(check(tx,ty)) {
						array[c.column][c.row] -= 1;
						c.column = tx;
						c.row = ty;
						array[tx][ty] += 1;
					}
				}
				
//				for(int i=0; i<N; i++) {
//					for(int j=0; j<N; j++) {
//						System.out.print(array[i][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				// 미생물의 수를 기준으로 내림차순 정렬한다.
				Collections.sort(list);
				
				// STEP2. 동일한 셀에 배치된 군집 합병(미생물 수, 이동 방향은 미생물 수가 가장 큰 군집을 기준으로 결정된다.)
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						// 한 위치에 둘 이상의 군집이 위치한 경우
						if(array[i][j]>1) {
							int tc = 0, td = 0;
							List<Integer> removeList = new ArrayList<>();
							for(int k=0; k<list.size(); k++) {
								Cluster c = list.get(k);
								if(c.column==i && c.row==j) {
									tc += c.count;
									if(td==0) {
										td = c.direction;
									}
									removeList.add(k);
								}
							}
							for(int k=0; k<removeList.size(); k++) {
								// (주의!) 리스트의 앞 요소를 제거할 경우, 뒷 요소의 인덱스가 앞으로 한칸 당겨짐을 명심하자!
								list.remove(removeList.get(k)-k);
								array[i][j] -= 1;
							}
							list.add(new Cluster(i,j,tc,td));
							array[i][j] += 1;
						}
					}
				}
				
				// STEP3. 약품이 칠해진 가장자리에 위치한 군집에 대한 미생물의 수 반감, 이동방향 역전 처리
				for(int i=0; i<list.size(); i++) {
					Cluster c = list.get(i);
					if(c.column==0 || c.column==N-1 || c.row==0 || c.row==N-1) {
						c.count /= 2;
						switch(c.direction) {
							case 1:
								c.direction += 1;
								break;
							case 2:
								c.direction -= 1;
								break;
							case 3:
								c.direction += 1;
								break;
							case 4:
								c.direction -= 1;
								break;
						}
					}
					else {
						continue;
					}
				}
				
				// STEP4. M시간 후 남아있는 군집들에 대해, 미생물 수의 총합 집계
				if(m==M-1) {
					for(int i=0; i<list.size(); i++) {
						answer += list.get(i).count;
					}
				}
			}
			
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) {
			return false;
		}
		else {
			return true;
		}
	}
}

class Cluster implements Comparable<Cluster>{
	int column, row, count, direction;

	public Cluster(int column, int row, int count, int direction) {
		super();
		this.column = column;
		this.row = row;
		this.count = count;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Cluster [column=" + column + ", row=" + row + ", count=" + count + ", direction=" + direction + "]";
	}

	@Override
	public int compareTo(Cluster o) {
		// TODO Auto-generated method stub
		return o.count - this.count;
	}
}
