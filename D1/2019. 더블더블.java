import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int exp = s.nextInt();
		int result = 1;
		if(exp >30)
			return;
		for(int i=0; i<exp+1; i++) {
			System.out.print(result+" ");
			result *= 2;
		}
	}
}