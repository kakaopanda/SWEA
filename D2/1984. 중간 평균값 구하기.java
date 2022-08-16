import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	static int max, m, n;
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int number[] = new int[10];
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int sum = 0;
			for(int j=0; j<10; j++) {
				number[j] = s.nextInt();
				if(j==9)
					Arrays.sort(number);
			}
			for(int j=1; j<9; j++) {
				sum += number[j];
			}
			result[i] = (int) Math.round((sum/8.0));
		}
		
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}