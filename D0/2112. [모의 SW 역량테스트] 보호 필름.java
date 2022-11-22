import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int comb_numbers[]; // 약품을 투여할 행의 정보
	static int perm_numbers[]; // 투여할 약품의 순서 정보
	
	static int T; // 테스트케이스의 개수 T
	static int D; // 보호 필름의 두께 D
	static int W; // 보호 필름의 가로크기 W
	static int K; // 합격기준 K
	static int array[][]; // 보호 필름 단면의 정보
	static int copy_array[][]; // 보호 필름 원본의 정보를 저장할 복사본
	static int answer = 0; // 최소 약품 투입 횟수
	static int count = 1; // 약품 투입 횟수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			count = 1;
			answer = 0;
			
			array = new int[D][W];
			copy_array = new int[D][W];
			for(int d=0; d<D; d++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int w=0; w<W; w++) {
					array[d][w] = Integer.parseInt(st.nextToken());
					copy_array[d][w] = array[d][w];
				}
			}
			
			// 약품을 투여하지 않았을 때의 상태를 검사한다.
			if(inspect()) {
				answer = 0;
			}
			else {
				// K=1인 경우, 무조건 검사를 통과하므로 약품을 투여할 필요가 없다.
				// K!=1인 경우에 대해서 약품 투여를 고려한다.
				if(K!=1) {
					while(answer==0) {
						if(count<=D) {
							comb_numbers = new int[count];
							perm_numbers = new int[count];
							comb(0,0);
							count++;							
						}
						else {
							break;
						}
					}
				}
			}
			// System.out.println("inspect : "+inspect());
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	// [조합] 조합을 구성하여, 약품을 투여할 행을 결정한다.
	static void comb(int cnt, int index) {
		if(cnt==count) {
			// 약품을 투여할 행을 결정했으므로, 중복순열을 통해 어떤 약품 순서대로 투여할지 결정한다.
			perm(0);
			return;
		}
		else {
			for(int d=index; d<D; d++) {
				comb_numbers[cnt] = d;
				comb(cnt+1, d+1);
			}
		}
	}
	
	// [중복순열] 2개의 행에 약품을 투여한다면, (A,A),(A,B),(B,A),(B,B) 순서로 약품을 투여할 수 있다.
	static void perm(int cnt) {
		if(cnt==count) {
			// 투여할 약품의 종류 및 순서가 결정되었으므로, 성능검사를 수행한다.
			for(int c=0; c<count; c++) {
				inject(comb_numbers[c], perm_numbers[c]);
			}
			boolean check = inspect();
			
			// 성능 검사를 통과한 경우
			if(check) {
				answer = count;
				return;
			}
			else {
				// 검사를 끝낸 후, 원본 배열을 원래 정보로 복구한다.
				copy();
			}
			return;
		}
		else {
			for(int d=0; d<2; d++) {
				perm_numbers[cnt] = d;
				perm(cnt+1);
			}
		}
	}
	
	// 약품을 투여할 행과 투여할 약품의 종류(A=0, B=1)를 입력하여 실제 보호필름에 반영한다.
	static void inject(int row, int medicine) {
		for(int w=0; w<W; w++) {
			array[row][w] = medicine;
		}
	}
	
	// 성능검사를 수행하여 진리값을 반환한다.
	static boolean inspect() {
		boolean total_check = true;
		
		// 열을 기준으로 행단위로 검사한다.
		for(int w=0; w<W; w++) {
			boolean column_check = false;
			
			for(int d=0; d<=D-K; d++) {
				// 비교를 수행할 기준점을 설정한다.
				int value = array[d][w];
				boolean check = true; 
				
				// 기준점으로부터 K칸에 해당하는 검사를 수행한다.
				// 기준점부터 K칸까지 연속적인 검사에 통과해야 한 열이 통과한 것이다.
				int check_count = 0;
				for(int k=1; k<K; k++) {
					// System.out.println(d+","+w+":"+value);
					// System.out.println("compare : "+array[d+k][w]);
					if(array[d+k][w]==value) {
						check_count++;
						if(check_count==K-1) {
							column_check = true;
						}
						else {
							continue;							
						}
					}
					else {
						break;
					}
				}
			}
			// System.out.println(column_check);
			if(!column_check) {
				total_check = false;
				return total_check;
			}
		}
		return total_check;
	}
	
	// 복사본 배열로부터 원본 배열의 값을 재복사한다.
	static void copy() {
		for(int d=0; d<D; d++) {
			for(int w=0; w<W; w++) {
				array[d][w] = copy_array[d][w];
			}
		}
	}
}
