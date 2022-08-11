import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner s = new Scanner(System.in);
		boolean check;
		int n = s.nextInt();
		if(n<10 || n>1000)
			return;
		for(int i=1; i<=n; i++) {
			String str = Integer.toString(i);
			char array[] = str.toCharArray();
			check = true;
			for(int j=0; j<array.length; j++) {
				if(array[j]=='3' || array[j]=='6' || array[j]=='9') {
					System.out.print('-');
					check = false;
				}
				else if(check && j==array.length-1)
					System.out.print(i);
			}
			System.out.print(" ");
		}
	}
}