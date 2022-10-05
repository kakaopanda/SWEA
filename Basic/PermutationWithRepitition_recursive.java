// 재귀 함수를 이용하여 중복순열(Permutation With Repitition)을 구성하는 방법
// 재귀 함수의 경우, 탈출 조건과 탈출하지 않았을 때의 수행문으로 구분된다.
// 중복순열의 경우, 각 원소의 중복 여부를 검사하지 않아도 되므로, select[] 배열의 존재가 무의미해진다.
public class PermutationWithRepitition_recursive {
	static int numbers[]; // 순열을 담는 배열
	static int N = 3; // 순열의 원소 개수
	public static void main(String[] args) {
		// 숫자 1부터 3까지 담는다고 가정했을 때, 편의를 위해 배열의 크기를 1칸씩 추가로 더해준다.
		numbers = new int[N+1];
		
		// 순열을 구성하는 재귀함수는 아무것도 담겨있지 않는 상태에서 시작한다고 가정한다.
		perm(0);
	}
	
	static void perm(int cnt) {
		// Case1. [탈출문] 순열이 모두 구성된 경우
		if(cnt==N) {
			// 순열 구성시 처리할 내용을 작성한다.
			for(int i=0; i<N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
		}
		// Case2. [수행문] 순열이 모두 구성되지 않은 경우
		else {
			for(int i=1; i<=N; i++) {
				// Case2-1. 해당 원소를 배열에 넣는 경우, 해당 원소를 넣은 채 다음 원소를 넣으러 간다.
				// (1,1,1), (1,1,2) ... (1,2,1), (1,2,2) ... (1,3,3) ... (3,3,3)
				numbers[cnt] = i;
				perm(cnt+1);
			}
		}
	}
}

