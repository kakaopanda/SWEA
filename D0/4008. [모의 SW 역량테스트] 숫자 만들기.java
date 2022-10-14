import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N; // 테스트케이스의 수 및 숫자의 개수
	static int op_count[]; // 각 연산자별 개수를 담는 배열
	static int number[]; // 피연산자 수를 담는 배열
	static int temp[]; // 피연산자 수의 백업본
	static int operator[]; // 배치된 연산자를 담는 배열
	static int min, max; // 수식으로 얻을 수 있는 최솟값 및 최댓값
	static int answer; // 최댓값과 최솟값의 차이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			number = new int[N];
			temp = new int[N];
			op_count = new int[4]; // +,-,*,/
			operator = new int[N-1];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int o=0; o<4; o++) {
				op_count[o] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				number[n] = Integer.parseInt(st.nextToken());
				temp[n] = number[n];
			}
			perm(0);
			answer = Math.abs(max-min);
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	// 연산자의 배치를 순열(nPr = n!/(n-r)!)로 해결할 경우, 시간 초과가 발생할 수 있다. (12! -> 4.8억)
	// 연산자의 배치를 중복 순열(n∏r = n^r)로 해결한다. -> 방문 처리가 필요없다.
	// 2 1 0 1 -> 0 0 1 3, 0 1 0 3, 1 0 0 3, ...
	static void perm(int cnt) {
		// 순열 구성이 완료된 경우
		if(cnt==N-1) {
			calc();
		}
		// 순열 구성이 완료되지 않은 경우
		else {
			for(int i=0; i<4; i++) {
				if(op_count[i] > 0) {
					operator[cnt] = i;
					op_count[i]--;
					perm(cnt+1);
					op_count[i]++;
				}
				else {
					continue;
				}
			}
		}
	}
	
	static void calc() {
		int result = 0;
		
		for(int i=0; i<N-1; i++) {
			switch(operator[i]) {
				case 0: // '+'
					number[i+1] = number[i] + number[i+1];
					break;
				case 1: // '-'
					number[i+1] = number[i] - number[i+1];
					break;
				case 2: // '*'
					number[i+1] = number[i] * number[i+1];
					break;
				case 3: // '/'
					number[i+1] = number[i] / number[i+1];
					break;
			}
		}
		result = number[N-1];
		
		if(min > result) {
			min = result;
		}
		if(max < result) {
			max = result;
		}
		copy(); // 원본 배열을 원래 상태로 복원한다.
	}
	
	static void copy() {
		for(int i=0; i<N; i++) {
			number[i] = temp[i];
		}
	}
}
