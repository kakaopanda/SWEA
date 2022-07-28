import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			for(int j=0; j<10; j++) {
				int compare = s.nextInt();
				if(result[i] < compare)
					result[i] = compare;
			}
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+Integer.toString(i+1)+" "+result[i]);
		}
	}
}