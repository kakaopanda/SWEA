// 재귀 함수를 이용하여 중복조합(Combination With Repitition)을 구성하는 방법
// 재귀 함수의 경우, 탈출 조건과 탈출하지 않았을 때의 수행문으로 구분된다.
public class CombinationWithRepitition_recursive {
	static int numbers[]; // 조합을 담는 배열
	static int input[] = {1,2,3,4}; // 입력 값을 담는 배열
	static int N = 3; // 조합의 원소 개수
	public static void main(String[] args) {
		// 숫자 1부터 4까지 담는다고 가정했을 때, 편의를 위해 배열의 크기를 1칸씩 추가로 더해준다.
		numbers = new int[N+1];
		
		// 조합을 구성하는 재귀함수는 아무것도 담겨있지 않는 상태에서 시작한다고 가정한다.
		comb(0,0);
	}
	
	static void comb(int cnt, int index) {
		// Case1. [탈출문] 조합이 모두 구성된 경우
		if(cnt==N) {
			// 조합 구성시 처리할 내용을 작성한다.
			for(int i=0; i<N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
		}
		// Case2. [수행문] 조합이 모두 구성되지 않은 경우
		else {
			for(int i=index; i<input.length; i++) {
				numbers[cnt] = input[i];
				comb(cnt+1, i); // -> 다음 원소를 담을 때, 인덱스에 1을 더하지 않고 계속 진행하면 된다.
			}
		}
	}
}
