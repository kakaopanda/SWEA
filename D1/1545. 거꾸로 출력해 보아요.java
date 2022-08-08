import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=n; i>=0; i--) {
			System.out.print(i+" ");
		}
	}
}