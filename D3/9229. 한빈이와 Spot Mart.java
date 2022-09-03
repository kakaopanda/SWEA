import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = s.nextInt();
		for(int t=0; t<TC; t++) {
			int N = s.nextInt();
			int M = s.nextInt();
			int snack[] = new int[N];
			for(int i=0; i<N; i++) {
				snack[i] = s.nextInt();
			}
			int max = -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(snack[i]+snack[j]>M) {
						continue;
					}
					else {
						if(snack[i]+snack[j] > max)
							max = snack[i]+snack[j];
					}
				}
			}
			sb.append("#"+(t+1)+" "+max+"\n");
		}
		System.out.println(sb);
	}
}
