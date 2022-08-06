import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		// 비기는 경우는 존재하지 않으므로, 총 6가지 경우의수가 발생한다.
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		if(a==1) {
			if(b==2) // 가위 VS 바위
				System.out.println("B");
			else if(b==3) // 가위 VS 보
				System.out.println("A");
		}
		else if(a==2) {
			if(b==1) // 바위 VS 가위
				System.out.println("A");
			else if(b==3) // 바위 VS 보
				System.out.println("B");
		}
		else if(a==3) {
			if(b==1) // 보 VS 가위
				System.out.println("B");
			else if(b==2) // 보 VS 바위
				System.out.println("A");
		}
	}
}