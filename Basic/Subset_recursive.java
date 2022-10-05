// 재귀함수를 이용하여 부분집합(Subset)을 구성하는 방법
// 재귀 함수의 경우, 탈출 조건과 탈출하지 않았을 때의 수행문으로 구분된다.
public class Subset_recursive {
	static int input[] = {1,2,3}; // 입력 값을 담는 배열
	static boolean select[]; // 부분집합을 구성할 때 각 원소가 담겨져 있는지에 대한 여부를 확인하는 배열
	static int N = 3; // 집합의 원소 개수
	public static void main(String[] args) {
		select = new boolean[N];
		
		// 부분집합을 구성하는 재귀함수는 아무것도 담겨있지 않는 상태에서 시작한다고 가정한다.
		subset(0);
	}
	
	static void subset(int cnt) {
		if(cnt==N) {
			// 부분 집합 구성시 처리할 내용을 작성한다.
			for(int i=0; i<N; i++) {
				if(select[i]) {
					System.out.print(input[i]+" ");					
				}
			}
			System.out.println();
		}
		else {
			select[cnt] = true;
			subset(cnt+1);
			select[cnt] = false;
			subset(cnt+1);
		}
	}
}
