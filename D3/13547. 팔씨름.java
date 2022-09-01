import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		String result[] = new String[testcase];
		for(int i=0; i<testcase; i++) {
			String str = s.next();
			char array[] = str.toCharArray();
			int count_o = 0;
			int count_x = 0;
			for(int j=0; j<array.length; j++) {
				if(array[j]=='o')
					count_o++;
				if(array[j]=='x')
					count_x++;
			}
			String answer = "";
			if(count_x <8)
				answer = "YES";
			else
				answer = "NO";
			result[i] = answer;
			}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
} 
