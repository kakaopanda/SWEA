import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt(); // 테스트케이스의 수
			for(int t=0; t<T; t++) {
			int H = s.nextInt(); // 게임 맵의 높이
			int W = s.nextInt(); // 게임 맵의 너비
			
			char map[][] = new char[H][W];
			// 초기 맵의 정보를 배열에 기록한다.
			for(int i=0; i<H; i++) {
				String str = s.next();
				char array[] = str.toCharArray();
				for(int j=0; j<W; j++) {
					map[i][j] = array[j];
				}
			}
			
			// 초기 맵에서 탱크의 위치를 탐색한다. (탱크는 1대만 존재한다.)
			int tank_i = 0;
			int tank_j = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j]=='^' || map[i][j]=='v' || map[i][j]=='<' || map[i][j]=='>') {
						tank_i = i;
						tank_j = j;
						break;
					}
				}
			}

			int N = s.nextInt(); // 사용자가 넣을 입력의 개수
			String str = s.next();
			char input[] = str.toCharArray();
			for(int i=0; i<N; i++) {
				switch(input[i]) {
					case 'U':
						// 위쪽 방향은 현재 탱크의 위치에서 위쪽만 검사하면 된다.
						if(tank_i-1>=0 && tank_i-1<H) {
							if(map[tank_i-1][tank_j]=='.') {
								map[tank_i][tank_j] = '.';
								map[tank_i-1][tank_j] = '^';
								tank_i--;
							}
							else {
								map[tank_i][tank_j] = '^';
							}
						}
						// 이동하려는 방향의 위쪽이 맵을 벗어나면, 방향만 전환한다.
						else {
							map[tank_i][tank_j] = '^';
						}
						break;
						
					case 'D':
						// 아래쪽 방향은 현재 탱크의 위치에서 아래쪽만 검사하면 된다.
						if(tank_i+1>=0 && tank_i+1<H) {
							if(map[tank_i+1][tank_j]=='.') {
								map[tank_i][tank_j] = '.';
								map[tank_i+1][tank_j] = 'v';
								tank_i++;
							}
							else {
								map[tank_i][tank_j] = 'v';
							}
						}
						// 이동하려는 방향의 위쪽이 맵을 벗어나면, 방향만 전환한다.
						else {
							map[tank_i][tank_j] = 'v';
						}
						break;
						
					case 'L':
						// 왼쪽 방향은 현재 탱크의 위치에서 왼쪽만 검사하면 된다.
						if(tank_j-1>=0 && tank_j-1<W) {
							if(map[tank_i][tank_j-1]=='.') {
								map[tank_i][tank_j] = '.';
								map[tank_i][tank_j-1] = '<';
								tank_j--;
							}
							else {
								map[tank_i][tank_j] = '<';
							}
						}
						// 이동하려는 방향의 위쪽이 맵을 벗어나면, 방향만 전환한다.
						else {
							map[tank_i][tank_j] = '<';
						}
						break;
						
					case 'R':	
						// 오른쪽 방향은 현재 탱크의 위치에서 오른쪽만 검사하면 된다.
						if(tank_j+1>=0 && tank_j+1<W) {
							if(map[tank_i][tank_j+1]=='.') {
								map[tank_i][tank_j] = '.';
								map[tank_i][tank_j+1] = '>';
								tank_j++;
							}
							else {
								map[tank_i][tank_j] = '>';
							}
						}
						// 이동하려는 방향의 위쪽이 맵을 벗어나면, 방향만 전환한다.
						else {
							map[tank_i][tank_j] = '>';
						}
						break;
						
					case 'S':
						switch(map[tank_i][tank_j]) {
							case '^':
								for(int p=tank_i-1; p>=0; p--) {
									// 포탄이 벽을 만나면 소멸하고, 벽은 평지가 된다.
									if(map[p][tank_j]=='*') {
										map[p][tank_j] = '.';
										break;
									}
									else if(map[p][tank_j]=='#') {
										break;
									}
								}
								break;
							case 'v':
								for(int p=tank_i+1; p<H; p++) {
									// 포탄이 벽을 만나면 소멸하고, 벽은 평지가 된다.
									if(map[p][tank_j]=='*') {
										map[p][tank_j] = '.';
										break;
									}
									else if(map[p][tank_j]=='#') {
										break;
									}
								}
								break;
							case '<':
								for(int q=tank_j-1; q>=0; q--) {
									// 포탄이 벽을 만나면 소멸하고, 벽은 평지가 된다.
									if(map[tank_i][q]=='*') {
										map[tank_i][q] = '.';
										break;
									}
									else if(map[tank_i][q]=='#') {
										break;
									}
								}
								break;
							case '>':
								for(int q=tank_j+1; q<W; q++) {
									// 포탄이 벽을 만나면 소멸하고, 벽은 평지가 된다.
									if(map[tank_i][q]=='*') {
										map[tank_i][q] = '.';
										break;
									}
									else if(map[tank_i][q]=='#') {
										break;
									}
								}
								break;
						}
				}
			}
			
			// 변경된 맵의 정보를 테스트케이스별로 출력한다.
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
