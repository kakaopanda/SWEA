import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			if(n<3 || n>20)
				return;
			int m = s.nextInt();
			if(m<3 || m>20)
				return;
			int a[] = new int[n];
			int b[] = new int[m];
			for(int j=0; j<n; j++) {
				a[j] = s.nextInt();
			}
			for(int j=0; j<m; j++) {
				b[j] = s.nextInt();
			}
			if(n<=m) { // B가 더 긴 상황으로, A가 움직여야되는 상황
				int range = m-n;
				int max = 0;
				for(int j=0; j<=range; j++) {
					int sum = 0;
					for(int k=0; k<n; k++) {
						sum += a[k]*b[k+j];
					}
					if(sum > max)
						max = sum;
				}
				result[i] = max;
			}
			else if(n>m) { // A가 더 긴 상황으로, B가 움직여야되는 상황
				int range = n-m;
				int max = 0;
				for(int j=0; j<=range; j++) {
					int sum = 0;
					for(int k=0; k<m; k++) {
						sum += b[k]*a[k+j];
					}
					if(sum > max)
						max = sum;
				}
				result[i] = max;
			}
		}	
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}