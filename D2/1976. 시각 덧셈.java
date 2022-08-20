import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt(); // 테스트케이스의 개수 T
		int result[][] = new int[testcase][2];
		int first[][] = new int[testcase][2];
		int second[][] = new int[testcase][2];
		for(int i=0; i<testcase; i++) {
			first[i][0] = s.nextInt(); // 3
			first[i][1] = s.nextInt(); // 17
			second[i][0] = s.nextInt(); // 1
			second[i][1] = s.nextInt(); // 39
			
			result[i][0] = first[i][0] + second[i][0];
			result[i][1] = first[i][1] + second[i][1];
			if(result[i][1] > 59) {
				result[i][1] -= 60;
				result[i][0] += 1;
			}
			if(result[i][0] > 12)
				result[i][0] -= 12;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i][0]+" "+result[i][1]);
		}
	}
}