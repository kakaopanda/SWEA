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
		int month[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int day[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=0; i<testcase; i++) {
			int first_month = s.nextInt();
			/*
			if(first_month<1 || first_month>12)
				return;
				*/
			int first_day = s.nextInt();
			/*
			if(first_day<1 || first_day>31)
				return;
				*/
			int second_month = s.nextInt();
			/*
			if(second_month<1 || second_month>12)
				return;
			else if(second_month < first_month)
				return;
				*/
			int second_day = s.nextInt();
			/*
			if(second_day<1 || second_day>31)
				return;
			else if(second_day < first_day)
				return;
			*/
			int answer = 0;
			if(first_month == second_month) {
				answer = second_day - first_day +1;
				result[i] = answer;
			}
			else if(first_month < second_month) {
				answer = second_day - first_day +1;
				for(int j=1; j<=second_month-first_month; j++) {
					answer += day[second_month-j-1];
				}
				result[i] = answer;
			}
		}	
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}