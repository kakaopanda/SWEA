import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int num[] = new int[2];
		char result[] = new char[testcase];
		for(int i=0; i<testcase; i++) {
			for(int j=0; j<2; j++) {
				num[j] = s.nextInt();
			}
			if(num[0] > num[1]) {
				result[i] = '>';
			}
			else if(num[0] < num[1]) {
				result[i] = '<';
			}
			else
				result[i] = '=';
		}
		
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+Integer.toString(i+1)+" "+result[i]);
		}
	}
}