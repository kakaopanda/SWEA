import java.util.Scanner;

/*
 *  파스칼의 삼각형은 이항계수를 삼각형의 모양으로 나열한 것이다.
	조합(nCr, Combination)을 이용하여 간단하게 출력해낼 수 있다.
	nCr = n! / r!(n-r)!
	
	0C0
	1C0 1C1
	2C0 2C1 2C2
	3C0 3C1 3C2 3C3..
 * 
 */

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			if(n<1 || n>10)
				return;
			System.out.println("#"+(i+1));
			for(int j=0; j<n; j++) {
				for(int k=0; k<=j; k++) {
					System.out.print(combination(j,k)+" ");
				}
				System.out.println();
			}
		}
	}
	
	// 조합에 대한 결과를 출력하는 함수 comination
	static int combination(int n, int r) {
		return factorial(n) / (factorial(r)*factorial(n-r));
	}
	
	// 팩토리얼에 대한 결과를 출력하는 함수 factorial
	static int factorial(int num) {
		if(num==0)
			return 1;
		return num*factorial(num-1);
	}
}