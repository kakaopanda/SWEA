import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = 10;
		for(int t=0; t<T; t++) {
			s.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			// 큐에 입력받은 숫자를 기록한다.
			for(int i=0; i<8; i++) {
				queue.add(s.nextInt());
			}
			int index = 1;
			
			while(true) {
				int top = queue.peek();
				queue.poll();
				if(index>5) {
					index -= 5;
				}
				top -= index++;
				if(top<=0) {
					queue.offer(0);
					break;
				}
				queue.offer(top);
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<8; i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}
}
