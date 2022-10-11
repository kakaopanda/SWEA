import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int count = 0;
	static int T, N, C;
	static int min = Integer.MAX_VALUE;
	static int max_core = 0;
	static int array[][], copy[][];
	static int numbers[];
	static boolean visited[];
	static List<Coordinate> core;
	public static void main(String[] args) throws IOException {
		// 순열로 풀어도 풀어지긴 하지만, 경우의 수가 너무 많아져서 시간 초과가 발생하게 된다. -> 부분집합으로 풀이한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			
			array = new int[N][N];
			copy = new int[N][N];
			core = new ArrayList<>();
			for(int i=0; i<N; i++) {
				// 코어를 넣을 때, 가장자리에 위치한 코어는 코어리스트(core)에 추가하지 않는다.
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = array[i][j];
					if(array[i][j]==1) {
						// 가장자리에 위치한 코어인 경우, 다음 탐색으로 넘어간다.
						if(i==0 || j==0 || i==N-1 || j==N-1) {
							continue;
						}
						// 가장자리에 포함되지 않은 코어인 경우, 코어리스트에 추가한다.
						else {
							core.add(new Coordinate(i,j));								
						}
					}
				}
			}
			C = core.size();
			max_core = 0;
			numbers = new int[C];
			visited = new boolean[C];
			subset(0,0);
			sb.append("#"+(t+1)+" "+min+"\n");
		}
		System.out.println(sb);
	}
	
	static void subset(int cnt, int index) {
		if(cnt==C) {
			// Case1. 뒤쪽 코어부터 앞쪽 코어로 전선을 연결하는 경우
			int temp_core = 0;
			for(int i=C-1; i>=0; i--) {
				Coordinate co = core.get(numbers[i]);
				int up = check_up(co.x,co.y);
				int down = check_down(co.x,co.y);
				int left = check_left(co.x,co.y);
				int right = check_right(co.x,co.y);
	
				int compare = Integer.MAX_VALUE;
				if(up!=0 && up < compare) {
					compare = up;
				}
				if(down !=0 && down < compare) {
					compare = down;
				}
				if(left !=0 && left < compare) {
					compare = left;
				}
				if(right !=0 && right < compare) {
					compare = right;
				}

				// 코어를 연결할 수 있는 경우가 없는 경우
				if(compare==Integer.MAX_VALUE) {
					continue;
				}
				// 코어를 연결할 수 있는 경우
				else {
					temp_core++;
					if(compare==up) {
						mark_up(co.x,co.y);
					} else if(compare==down) {
						mark_down(co.x,co.y);
					} else if(compare==left) {
						mark_left(co.x,co.y);
					} else if(compare==right) {
						mark_right(co.x,co.y);
					}
				}
			}
			if(temp_core == max_core) {
				int wire_count = check();
				if(wire_count < min) {
					min = wire_count;
				}
			}
			else if(temp_core >= max_core) {
				min = Integer.MAX_VALUE;
				int wire_count = check();
				max_core = temp_core;
				if(wire_count < min) {
					min = wire_count;
				}
			}
			copy();
			
			// Case2. 앞쪽 코어부터 뒤쪽 코어로 전선을 연결하는 경우
			temp_core = 0;
			for(int i=0; i<C; i++) {
				Coordinate co = core.get(numbers[i]);
				int up = check_up(co.x,co.y);
				int down = check_down(co.x,co.y);
				int left = check_left(co.x,co.y);
				int right = check_right(co.x,co.y);
	
				int compare = Integer.MAX_VALUE;
				if(up!=0 && up < compare) {
					compare = up;
				}
				if(down !=0 && down < compare) {
					compare = down;
				}
				if(left !=0 && left < compare) {
					compare = left;
				}
				if(right !=0 && right < compare) {
					compare = right;
				}

				// 코어를 연결할 수 있는 경우가 없는 경우
				if(compare==Integer.MAX_VALUE) {
					continue;
				}
				// 코어를 연결할 수 있는 경우
				else {
					temp_core++;
					if(compare==up) {
						mark_up(co.x,co.y);
					} else if(compare==down) {
						mark_down(co.x,co.y);
					} else if(compare==left) {
						mark_left(co.x,co.y);
					} else if(compare==right) {
						mark_right(co.x,co.y);
					}
				}
			}
			if(temp_core == max_core) {
				int wire_count = check();
				if(wire_count < min) {
					min = wire_count;
				}
			}
			else if(temp_core >= max_core) {
				min = Integer.MAX_VALUE;
				int wire_count = check();
				max_core = temp_core;
				if(wire_count < min) {
					min = wire_count;
				}
			}
			copy();
		}
		else {
			for(int i=index; i<C; i++) {
				if(!visited[i]) {
					numbers[cnt] = i;
					visited[i] = true;
					subset(cnt+1, i+1);
					visited[i] = false;
				}
			}
		}
	}
	
	static void copy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				array[i][j] = copy[i][j];
			}
		}
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int check() {
		int wire = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(array[i][j]==2) {
					wire++;
				}
			}
		}
		return wire;
	}
	
	static void mark_up(int x, int y) {
		for(int i=(x-1); i>=0; i--) {
			if(array[i][y]==0) {
				array[i][y] = 2;
			}
			else {
				continue;
			}
		}
		return;
	}
	
	static void mark_down(int x, int y) {
		for(int i=(x+1); i<N; i++) {
			if(array[i][y]==0) {
				array[i][y] = 2;
			}
			else {
				continue;
			}
		}
		return;
	}
	
	static void mark_left(int x, int y) {
		for(int j=(y-1); j>=0; j--) {
			if(array[x][j]==0) {
				array[x][j]=2;
			}
			else {
				continue;
			}
		}
		return;
	}
	
	static void mark_right(int x, int y) {
		for(int j=(y+1); j<N; j++) {
			if(array[x][j]==0) {
				array[x][j]=2;
			}
			else {
				continue;
			}
		}
		return;
	}
	
	static int check_up(int x, int y) {
		// 위쪽에 전선을 설치할 때, 몇개의 칸을 이용할지 카운트한다.
		// check = 0인 경우, 전선이나 코어가 교차하는 경우에 해당한다.
		int check = 0;
		
		// 위쪽 방향만 검사하므로, x좌표만 변동시키면 된다.
		for(int i=(x-1); i>=0; i--) {
			if(array[i][y]==0) {
				check++;
			}
			else {
				check = 0;
				return check;
			}
		}
		return check;
	}
	
	static int check_down(int x, int y) {
		int check = 0;
		
		// 아래쪽 방향만 검사하므로, x좌표만 변동시키면 된다.
		for(int i=(x+1); i<N; i++) {
			if(array[i][y]==0) {
				check++;
			}
			else {
				check = 0;
				return check;
			}
		}
		return check;
	}
	
	static int check_left(int x, int y) {
		int check = 0;
		
		// 왼쪽 방향만 검사하므로, y좌표만 변동시키면 된다.
		for(int j=(y-1); j>=0; j--) {
			if(array[x][j]==0) {
				check++;
			}
			else {
				check = 0;
				return check;
			}
		}
		return check;
	}
	
	static int check_right(int x, int y) {
		int check = 0;
		
		// 오른쪽 방향만 검사하므로, y좌표만 변동시키면 된다.
		for(int j=(y+1); j<N; j++) {
			if(array[x][j]==0) {
				check++;
			}
			else {
				check = 0;
				return check;
			}
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