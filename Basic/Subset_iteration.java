// 반복문을 이용하여 부분집합(Subset)을 구성하는 방법
// N개의 숫자를 대상으로 부분집합을 구성할 경우, N+1번 중첩된 for문의 형태를 갖게 된다.
// 모든 원소가 선택된 경우(전체집합)부터, 모든 원소가 선택되지 않은 경우(공집합)까지 모두 고려한다.
public class Subset_iteration {
	public static void main(String[] args) {
		int select[] = new int[4];
		for(int i=1; i>=0; i--) {
			select[1] = i;
			for(int j=1; j>=0; j--) {
				select[2] = j;
				for(int k=1; k>=0; k--) {
					select[3] = k;
					for(int m=1; m<=3; m++) {
						if(select[m]==1) {
							System.out.print(m+" ");
						}
					}
					System.out.println();
				}
			}
		}
	}
}
