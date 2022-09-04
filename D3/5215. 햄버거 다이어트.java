import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L, answer;
	static int score[], calorie[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			answer = 0;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			calorie = new int[N];
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				score[n] = Integer.parseInt(st.nextToken());
				calorie[n] = Integer.parseInt(st.nextToken());
			}
			
			calc(0, 0, 0);
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	static void calc(int index, int sum_score, int sum_calorie) {
		// STEP1. 칼로리의 합이 제한 칼로리보다 높을 경우, 유효하지 않은 조합이므로 점수 계산 없이 종료한다.
		if(sum_calorie > L) {
			return;
		}
		
		// STEP2. 인덱스의 끝까지 조합을 완료했을 때, 점수의 합이 현재 답보다 큰 경우 해당 조합으로 교체한다.
		else if(index==N) {
			answer = Math.max(answer, sum_score);
			return;
		}
		
		// STEP3. 아직 조합이 완료되지 않은 경우, 다른 인덱스에 대한 조합을 계속해서 수행한다.
		else {
			// Case1. 현재 인덱스에 해당하는 요소를 추가하는 경우
			calc(index+1, sum_score + score[index], sum_calorie + calorie[index]);
			
			// Case2. 현재 인덱스에 해당하는 요소를 추가하지 않는 경우
			calc(index+1, sum_score, sum_calorie);
		}
	}
}
