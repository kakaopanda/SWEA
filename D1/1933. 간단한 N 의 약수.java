import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if(n<1 || n>1000)
			return;
		for(int i=1; i<=n; i++) {
			if(n%i==0)
				System.out.print(i+" ");
		}
	}
}