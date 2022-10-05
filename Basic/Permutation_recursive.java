// ��� �Լ��� �̿��Ͽ� ����(Permutation)�� �����ϴ� ���
// ��� �Լ��� ���, Ż�� ���ǰ� Ż������ �ʾ��� ���� ���๮���� ���еȴ�.
public class Permutation_recursive {
	static int numbers[]; // ������ ��� �迭
	static boolean select[]; // ������ ���� �� �� ���Ұ� ����� �ִ����� ���� ���θ� Ȯ���ϴ� �迭
	static int N = 3; // ������ ���� ����
	public static void main(String[] args) {
		// ���� 1���� 3���� ��´ٰ� �������� ��, ���Ǹ� ���� �迭�� ũ�⸦ 1ĭ�� �߰��� �����ش�.
		numbers = new int[N+1];
		select = new boolean[N+1];
		
		// ������ �����ϴ� ����Լ��� �ƹ��͵� ������� �ʴ� ���¿��� �����Ѵٰ� �����Ѵ�.
		perm(0);
	}
	
	static void perm(int cnt) {
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
			for(int i=1; i<=N; i++) {
				// �ش� ���Ҹ� ���� �迭�� ���� ���� ���
				if(!select[i]) {
					// Case2-1. �ش� ���Ҹ� �迭�� �ִ� ���, �ش� ���Ҹ� ���� ä ���� ���Ҹ� ������ ����.
					select[i] = true;
					numbers[cnt] = i;
					perm(cnt+1);
					// Case2-2. �ش� ���Ҹ� �迭�� ���� ���� ���, �ٸ� ���Ҹ� ������ ����.
					select[i] = false;
				}
			}
		}
	}
}
