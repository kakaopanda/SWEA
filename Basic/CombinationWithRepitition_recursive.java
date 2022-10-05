// ��� �Լ��� �̿��Ͽ� �ߺ�����(Combination With Repitition)�� �����ϴ� ���
// ��� �Լ��� ���, Ż�� ���ǰ� Ż������ �ʾ��� ���� ���๮���� ���еȴ�.
public class CombinationWithRepitition_recursive {
	static int numbers[]; // ������ ��� �迭
	static int input[] = {1,2,3,4}; // �Է� ���� ��� �迭
	static int N = 3; // ������ ���� ����
	public static void main(String[] args) {
		// ���� 1���� 4���� ��´ٰ� �������� ��, ���Ǹ� ���� �迭�� ũ�⸦ 1ĭ�� �߰��� �����ش�.
		numbers = new int[N+1];
		
		// ������ �����ϴ� ����Լ��� �ƹ��͵� ������� �ʴ� ���¿��� �����Ѵٰ� �����Ѵ�.
		comb(0,0);
	}
	
	static void comb(int cnt, int index) {
		// Case1. [Ż�⹮] ������ ��� ������ ���
		if(cnt==N) {
			// ���� ������ ó���� ������ �ۼ��Ѵ�.
			for(int i=0; i<N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
		}
		// Case2. [���๮] ������ ��� �������� ���� ���
		else {
			for(int i=index; i<input.length; i++) {
				numbers[cnt] = input[i];
				comb(cnt+1, i); // -> ���� ���Ҹ� ���� ��, �ε����� 1�� ������ �ʰ� ��� �����ϸ� �ȴ�.
			}
		}
	}
}
