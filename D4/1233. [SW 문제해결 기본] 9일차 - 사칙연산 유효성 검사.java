import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=10; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			
			// STEP1. 리프 노드를 찾는다.
			int leaf = (N/2)+1;
			
			// 트리의 인덱스는 1번부터 시작한다. (0번 인덱스는 비워둔다.)
			String tree[] = new String[N+1];
			
			// STEP2. N줄에 걸쳐 정점의 정보를 입력받는다.
			// 정점의 인덱스, 정점의 알파벳, 정점의 왼쪽 자식번호, 정점의 오른쪽 자식번호 순서대로 입력받는다.
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				// 자식노드가 없는 경우(리프노드)
				if(st.countTokens()==2) {
					st.nextToken(); // 정점의 인덱스 정보는 저장할 필요가 없다.
					tree[i] = st.nextToken(); // 정점의 알파벳 정보를 입력한다.	
				}
				
				// 자식노드가 1개 있는 경우
				else if(st.countTokens()==3) {
					st.nextToken(); // 정점의 인덱스 정보는 저장할 필요가 없다.
					tree[i] = st.nextToken(); // 정점의 알파벳 정보를 입력한다.
					st.nextToken(); // 정점의 왼쪽 자식번호는 저장할 필요가 없다. (완전이진트리)
				}
				
				// 자식노드가 2개 있는 경우
				else if(st.countTokens()==4) {
					st.nextToken(); // 정점의 인덱스 정보는 저장할 필요가 없다.
					tree[i] = st.nextToken(); // 정점의 알파벳 정보를 입력한다.	
					st.nextToken(); // 정점의 왼쪽 자식번호는 저장할 필요가 없다. (완전이진트리)
					st.nextToken(); // 정점의 오른쪽 자식번호는 저장할 필요가 없다. (완전이진트리)
				}
			}
			boolean check = true;
			
			// STEP3. 리프 노드들이 모두 숫자로 구성되어 있는지 확인한다.
			CHECK_FIRST:
			for(int i=leaf; i<=N; i++) {
				for(int j=0; j<tree[i].length(); j++) {
					if(!Character.isDigit(tree[i].charAt(j))) {
						check = false;
						break CHECK_FIRST;
					}
				}
			}
			
			// STEP4. 자식 노드가 없는 노드들이 모두 기호로 구성되어 있는지 확인한다.
			CHECK_SECOND:
				for(int i=1; i<=leaf-1; i++) {
					for(int j=0; j<tree[i].length(); j++) {
						if(tree[i].length()==2 && isOperator(tree[i].charAt(j))) {
							check = false;
							break CHECK_SECOND;
					}
				}
			}
			
			if(check) {
				sb.append("#"+(t)+" "+1+"\n");
			}
			else {
				sb.append("#"+(t)+" "+0+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean isOperator(char op) {
		if(op=='+'||op=='-'||op=='*'||op=='/')
			return true;
		else
			return false;
	}
}
