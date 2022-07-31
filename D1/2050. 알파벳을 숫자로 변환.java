import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char array[] = input.toCharArray();
		if(array.length<1 || array.length >200)
			return;
		char alpha[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int num[] = new int[26];
		String result = "";
		for(int i=0; i<26; i++) {
			num[i] = (i+1);
		}
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<26; j++) {
				if(array[i] == alpha[j])
					result += (j+1) +" ";
			}
		}
		System.out.println(result);
	}
}