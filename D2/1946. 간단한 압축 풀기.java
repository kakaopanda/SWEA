import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt();
			if(n<1 || n>10)
				return;
			int count[] = new int[n];
			char zip[] = new char[n];
			
			for(int j=0; j<n; j++) {
				zip[j] = s.next().charAt(0);
				count[j] = s.nextInt();
			}
			System.out.println("#"+(i+1));
			int line = 0;
			for(int j=0; j<n; j++) {
				for(int k=0; k<count[j]; k++, line++) {
					if(line >= 10) {
						System.out.println();
						line -= 10;
					}
					System.out.print((char)zip[j]);
				}
			}
			System.out.println();
		}
	}
}
