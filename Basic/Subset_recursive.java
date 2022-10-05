// ����Լ��� �̿��Ͽ� �κ�����(Subset)�� �����ϴ� ���
// ��� �Լ��� ���, Ż�� ���ǰ� Ż������ �ʾ��� ���� ���๮���� ���еȴ�.
public class Subset_recursive {
	static int input[] = {1,2,3}; // �Է� ���� ��� �迭
	static boolean select[]; // �κ������� ������ �� �� ���Ұ� ����� �ִ����� ���� ���θ� Ȯ���ϴ� �迭
	static int N = 3; // ������ ���� ����
	public static void main(String[] args) {
		select = new boolean[N];
		
		// �κ������� �����ϴ� ����Լ��� �ƹ��͵� ������� �ʴ� ���¿��� �����Ѵٰ� �����Ѵ�.
		subset(0);
	}
	
	static void subset(int cnt) {
		if(cnt==N) {
			// �κ� ���� ������ ó���� ������ �ۼ��Ѵ�.
			for(int i=0; i<N; i++) {
				if(select[i]) {
					System.out.print(input[i]+" ");					
				}
			}
			System.out.println();
		}
		else {
			select[cnt] = true;
			subset(cnt+1);
			select[cnt] = false;
			subset(cnt+1);
		}
	}
}
