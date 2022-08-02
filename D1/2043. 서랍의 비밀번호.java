import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		// P가 무조건 K보다 크다고 가정한다.
		Scanner s = new Scanner(System.in);
		int password = s.nextInt(); // 비밀번호 P
		int range = s.nextInt(); // 주어지는 번호 K
		int count = 0; //  K에서 P까지 찾아내는데 필요한 횟수
		System.out.println(password-range+1);
	}
}