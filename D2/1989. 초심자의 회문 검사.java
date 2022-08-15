import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		String str;
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++){
			str = s.next();
			char array[] = str.toCharArray();
			int test = 0;
			for(int j=0; j<array.length; j++){
				if(array[j]==array[array.length-1-j]){
					test = 1;
					continue;
				}
				else{
					test = 0;
				}
			}
			result[i] = test;
		}
		for(int i=0; i<testcase; i++){
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}