import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int share[] = new int[testcase];
		int remainder[] = new int[testcase];
		for(int i=0;  i<testcase; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			share[i] = a/b;
			remainder[i] = a%b;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+share[i]+" "+remainder[i]);
		}
	}
}