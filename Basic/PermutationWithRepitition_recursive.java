// ��� �Լ��� �̿��Ͽ� �ߺ�����(Permutation With Repitition)�� �����ϴ� ���
// ��� �Լ��� ���, Ż�� ���ǰ� Ż������ �ʾ��� ���� ���๮���� ���еȴ�.
// �ߺ������� ���, �� ������ �ߺ� ���θ� �˻����� �ʾƵ� �ǹǷ�, select[] �迭�� ���簡 ���ǹ�������.
public class PermutationWithRepitition_recursive {
	static int numbers[]; // ������ ��� �迭
	static int N = 3; // ������ ���� ����
	public static void main(String[] args) {
		// ���� 1���� 3���� ��´ٰ� �������� ��, ���Ǹ� ���� �迭�� ũ�⸦ 1ĭ�� �߰��� �����ش�.
		numbers = new int[N+1];
		
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
				// Case2-1. �ش� ���Ҹ� �迭�� �ִ� ���, �ش� ���Ҹ� ���� ä ���� ���Ҹ� ������ ����.
				// (1,1,1), (1,1,2) ... (1,2,1), (1,2,2) ... (1,3,3) ... (3,3,3)
				numbers[cnt] = i;
				perm(cnt+1);
			}
		}
	}
}

