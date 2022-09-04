import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 9! = 362,880
public class Solution {
	public static int kyu[], in[], check[];
	public static boolean visit[];
	public static int count, win;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			// 규영이가 게임에서 이기는 횟수
			int record[] = new int[19];
			kyu = new int[9];
			in = new int[9];
			visit = new boolean[9];
			check = new int[9];
			win = 0;
			count = 0;
			
			// 규영이가 가진 카드 정보를 배열에 기록한다.
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				record[kyu[i]] = 1;
			}
			
			// 인영이가 가진 카드 정보를 배열에 기록한다.
			int index = 0;
			for(int i=1; i<=18; i++) {
				if(record[i]==0) {
					in[index++] = i;
				}
			}
			
			permutation(count);
			// 아홉 라운드에 걸쳐 총점이 더 높은 사람을 판별한다.
			// 규영이가 내는 순서는 고정되어 있고, 인영이가 내는 순서를 N!의 형태로 회전시킨다.
			// 인영이가 내는 순서의 종류는 9!이다.
			sb.append("#"+(t+1)+" "+win+" "+(362880-win)+"\n");
		}
		System.out.println(sb);
	}
	
	public static void permutation(int count) {
		if(count==9) {
			int score_kyu = 0, score_in = 0;
			for(int i=0; i<9; i++) {
				if(in[check[i]] > kyu[i]) {
					score_in += in[check[i]] + kyu[i];
				}
				else {
					score_kyu += in[check[i]] + kyu[i];
				}
			}
			int result = (score_kyu>score_in) ? win++ : 0;
		}
		else {
			for(int i=0; i<9; i++) {
				if(!visit[i]) {
					visit[i] = true;
					check[count] = i;
					count++;
					permutation(count);
					visit[i] = false;
					count--;
				}
			}
		}
	}
}
