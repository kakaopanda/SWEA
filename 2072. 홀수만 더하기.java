import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = Integer.parseInt(s.nextLine());
		int printing[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			for(int j=0; j<10; j++) {
				int test = s.nextInt();
				if((test%2)!=0)
					printing[i] += test;
			}
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+Integer.toString(i+1)+" "+Integer.toString(printing[i]));
		}
	}
}