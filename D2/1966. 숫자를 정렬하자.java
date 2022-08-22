import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int total[][] = new int[testcase][50];
		int memory_m[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			memory_m[i] = n;
			if(n<5 || n>50)
				return;
			int array[] = new int[n];
			for(int j=0; j<n; j++) {
				array[j] = s.nextInt();
			}
			Arrays.sort(array);
			for(int j=0; j<n; j++) {
				total[i][j] = array[j];
			}
		}
		for(int i=0; i<testcase; i++) {
			System.out.print("#"+(i+1)+" ");
			for(int j=0; j<memory_m[i]; j++) {
				System.out.print(total[i][j]+" ");
			}
			System.out.println();
		}
	}
}