// 반복문을 이용하여 순열(Permutation)을 구성하는 방법
// N개의 숫자를 대상으로 순열을 구성할 경우, N번 중첩된 for문의 형태를 갖게 된다.
public class Permutation {
	public static void main(String[] args) {
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				if(j!=i) {
					for(int k=1; k<=3; k++) {
						if(k!=i && k!=j) {
							System.out.println(i+","+j+","+k);
						}
					}
				}
			}
		}
	}
}
