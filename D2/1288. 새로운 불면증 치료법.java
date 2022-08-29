import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		int result[] = new int[testcase];
		for(int i=0; i<testcase; i++) {
			boolean check;
			int n = s.nextInt();
			if(n<1 || n>1000000)
				return;
			// 0에서부터 9까지의 숫자를 저장할 정수 배열
			int number[] = new int[10];
			int input = n;
			int count = 0;
			do {
				check = true;
				String str = Integer.toString(n);
				n += input;
				char array[] = str.toCharArray();
				for(int j=0; j<array.length; j++) {
					number[array[j]-'0']++;
				}
				
				// 0~9까지의 숫자 중 하나라도 한번이상 나오지 않았다면 반복을 수행한다.
				for(int j=0; j<10; j++) {
					if(number[j]==0)
						check = false;
				}
				count++;
				if(check)
					result[i] = count*input;
			}while(!check);
		}
		for(int i=0; i<testcase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}
