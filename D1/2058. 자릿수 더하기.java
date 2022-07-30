import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if(n < 1 || n > 9999)
			return;
		int sum = 0;
		while(n > 0) {
			sum += n%10;
			n /= 10;
		}
		System.out.println(sum);
	}
}