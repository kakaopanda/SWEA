import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt(); // 테스트케이스의 개수 T
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			int sum = 0;
			for(int j=1; j<=n; j++) {
				if(j%2!=0)
					sum += j;
				else
					sum -= j;
			}
			result[i] = sum;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}