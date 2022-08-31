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
		int frequency[] = new int[101];
		for(int i=0; i<testcase; i++) {
			int number = s.nextInt();
			for(int j=0; j<100; j++) {
				frequency[j] = 0;
			}
			for(int j=0; j<1000; j++) {
				int score = s.nextInt();
				if(score<0 || score>100)
					return;
				else {
					frequency[score] += 1;
				}
			}
			int max_frequency = 0;
			for(int j=0; j<100; j++) {
				if(max_frequency<frequency[j])
					max_frequency = frequency[j];
			}
			int max_score = 0;
			for(int j=0; j<100; j++) {
				if(max_frequency==frequency[j])
					max_score = j;
			}
			result[i] = max_score;
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}