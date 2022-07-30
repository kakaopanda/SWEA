import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		if((testcase%2)==0)
			return;
		if(testcase < 9 || testcase > 199)
			return;
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			result[i] = s.nextInt();
		}
		Arrays.sort(result);
		int index = testcase/2;
		System.out.println(result[index]);
	}
}