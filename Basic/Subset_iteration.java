// �ݺ����� �̿��Ͽ� �κ�����(Subset)�� �����ϴ� ���
// N���� ���ڸ� ������� �κ������� ������ ���, N+1�� ��ø�� for���� ���¸� ���� �ȴ�.
// ��� ���Ұ� ���õ� ���(��ü����)����, ��� ���Ұ� ���õ��� ���� ���(������)���� ��� ����Ѵ�.
public class Subset_iteration {
	public static void main(String[] args) {
		int select[] = new int[4];
		for(int i=1; i>=0; i--) {
			select[1] = i;
			for(int j=1; j>=0; j--) {
				select[2] = j;
				for(int k=1; k>=0; k--) {
					select[3] = k;
					for(int m=1; m<=3; m++) {
						if(select[m]==1) {
							System.out.print(m+" ");
						}
					}
					System.out.println();
				}
			}
		}
	}
}
