import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int sum;
		double result[] = new double[testcase];
		for(int i=0; i<testcase; i++) {
			sum = 0;
			for(int j=0; j<10; j++) {
				sum += s.nextInt();
			}
			result[i] = (double)sum/10;
		}
		
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+Integer.toString(i+1)+" "+Integer.toString((int)(Math.round((result[i]*10/10.0)))));
		}
	}
}