import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static int type[] = new int[8]; // 50000, 10000, 5000, 1000, 500, 100, 50, 10 (8종류)
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int result[][] = new int[testcase][8];
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			for(int j=0; j<8; j++) {
				type[j] = 0;
			}
			if(n<10 || n>1000000)
				return;
			else
				calc(i,n);
			for(int j=0; j<8; j++) {
				result[i][j] = type[j];
			}
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1));
			for(int j=0; j<8; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void calc(int i, int n) {
		int money = n;
		while(money >= 50000) {
			type[0] += 1;
			money -= 50000;
		}
		while(money >= 10000) {
			type[1] += 1;
			money -= 10000;
		}
		while(money >= 5000) {
			type[2] += 1;
			money -= 5000;
		}
		while(money >= 1000) {
			type[3] += 1;
			money -= 1000;
		}
		while(money >= 500) {
			type[4] += 1;
			money -= 500;
		}
		while(money >= 100) {
			type[5] += 1;
			money -= 100;
		}
		while(money >= 50) {
			type[6] += 1;
			money -= 50;
		}
		while(money >= 10) {
			type[7] += 1;
			money -= 10;
		}
		return;
	}
}