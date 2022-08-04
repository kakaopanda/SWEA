import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int range = s.nextInt();
		int sum = 0;
		for(int i=1; i<=range; i++)
			sum += i;
		System.out.println(sum);
	}
}