// 반복문을 이용하여 중복순열(Permutation With Repitition)을 구성하는 방법
// N개의 숫자를 대상으로 순열을 구성할 경우, N번 중첩된 for문의 형태를 갖게 된다.
// 중복 순열의 경우, 서로 겹치는 경우를 조사하지 않아도 되므로 더 간단해진다.
public class PermutationWithRepitition_iteration {
	public static void main(String[] args) {
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				for(int k=1; k<=3; k++) {
					System.out.println(i+","+j+","+k);
				}
			}
		}
	}
}
