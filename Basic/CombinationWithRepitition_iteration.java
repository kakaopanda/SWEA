// 반복문을 이용하여 중복조합(Combination With Repitition)을 구성하는 방법
// N개의 숫자를 대상으로 중복조합을 구성할 경우, N번 중첩된 for문의 형태를 갖게 된다.
// 이때, 다음번 인덱스는 이전 인덱스의 영향을 받게 된다.
public class CombinationWithRepitition_iteration {
	public static void main(String[] args) {
		for(int i=1; i<=4; i++) {
			for(int j=i; j<=4; j++) {
				for(int k=j; k<=4; k++) {
					System.out.println(i+","+j+","+k);
				}
			}
		}
	}
}
