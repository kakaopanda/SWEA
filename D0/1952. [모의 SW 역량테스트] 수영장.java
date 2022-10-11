import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int ticket[] = new int[4];
	static int plan[] = new int[12];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			ticket = new int[4];
			plan = new int[12];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<4; i++) {
				ticket[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			dp(0,0);
			if(min > ticket[3]) {
				min = ticket[3];
			}
			sb.append("#"+(t+1)+" "+min+"\n");
		}
		System.out.println(sb);
	}
	
	static void dp(int cnt, int price) {
		// 모든 달에 대해서 최소비용에 대한 계산을 마친 경우
		if(cnt==12) {
			if(min > price) {
				min = price;
			}
		}
		else {
			// Case1. 1일 이용권의 요금을 지불했을 때와 1달 이용권의 요금을 지불했을 때를 비교하는 경우
			dp(cnt+1, price+(Math.min(plan[cnt]*ticket[0], ticket[1])));
			
			// Case2. ('0' 1 2) 3개의 달 단위로, 1달 이용권의 요금을 지불했을 때와 3달 이용권의 요금을 지불했을 때를 비교하는 경우
			if(cnt<=9) {
				dp(cnt+3, price+(Math.min(plan[cnt+2]*ticket[0]+plan[cnt+1]*ticket[0]+plan[cnt]*ticket[0], 
						ticket[2])));					
			}
			// Case3. (0 '1' 2) 3개의 달 단위로, 1달 이용권의 요금을 지불했을 때와 3달 이용권의 요금을 지불했을 때를 비교하는 경우
			if(cnt>=1 && cnt<10) {
				dp(cnt+2, price+(Math.min(plan[cnt+1]*ticket[0]+plan[cnt]*ticket[0]+plan[cnt-1]*ticket[0], 
						ticket[2])));				
			}
			// Case4. (0 1 '2') 3개의 달 단위로, 1달 이용권의 요금을 지불했을 때와 3달 이용권의 요금을 지불했을 때를 비교하는 경우
			if(cnt>=2) {
				dp(cnt+1, price+(Math.min(plan[cnt-2]*ticket[0]+plan[cnt-1]*ticket[0]+plan[cnt]*ticket[0], 
						ticket[2])));
			}
		}
	}
}
