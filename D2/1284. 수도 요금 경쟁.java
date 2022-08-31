import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		int testcase = scanner.nextInt();
		int p,q,r,s,w;
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			int a = 0, b = 0;
			p = scanner.nextInt();
			q = scanner.nextInt();
			r = scanner.nextInt();
			s = scanner.nextInt();
			w = scanner.nextInt();
			
			a = w * p;
			if(w <= r) {
				b = q;
			}
			else {
				w -= r;
				b = q + w*s;
			}
			result[i] = (a<b) ? a : b;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}