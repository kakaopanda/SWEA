// �ݺ����� �̿��Ͽ� ����(Combination)�� �����ϴ� ���
// N���� ���ڸ� ������� ������ ������ ���, N�� ��ø�� for���� ���¸� ���� �ȴ�.
// �̶�, ������ �ε����� ���� �ε����� ������ �ް� �ȴ�.
public class Combination_iteration {
	public static void main(String[] args) {
		for(int i=1; i<=4; i++) {
			for(int j=i+1; j<=4; j++) {
				for(int k=j+1; k<=4; k++) {
					System.out.println(i+","+j+","+k);
				}
			}
		}
	}
}
