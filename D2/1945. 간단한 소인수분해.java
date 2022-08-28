import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int factorization[][] = new int[testcase][5];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			if(n<2 || n>10000000)
				return;
			while(n!=1) {
				if(n%2==0) {
					factorization[i][0] += 1;
					n /= 2;
				}
				else if(n%3==0) {
					factorization[i][1] += 1;
					n /= 3;
				}
				else if(n%5==0) {
					factorization[i][2] += 1;
					n /= 5;
				}
				else if(n%7==0) {
					factorization[i][3] += 1;
					n /= 7;
				}
				else if(n%11==0) {
					factorization[i][4] += 1;
					n /= 11;
				}
			}
		}
		for(int i=0; i<testcase; i++) {
			System.out.print("#"+(i+1)+" ");
			for(int j=0; j<5; j++) {
				System.out.print(factorization[i][j]+" ");
			}
			System.out.println();
		}
	}
}