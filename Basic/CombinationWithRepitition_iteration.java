// �ݺ����� �̿��Ͽ� �ߺ�����(Combination With Repitition)�� �����ϴ� ���
// N���� ���ڸ� ������� �ߺ������� ������ ���, N�� ��ø�� for���� ���¸� ���� �ȴ�.
// �̶�, ������ �ε����� ���� �ε����� ������ �ް� �ȴ�.
public class CombinationWithRepitition_iteration {
	public static void main(String[] args) {
		for(int i=1; i<=4; i++) {
			for(int j=i; j<=4; j++) {
				for(int k=j; k<=4; k++) {
					System.out.println(i+","+j+","+k);
				}
			}
		}
	}
}
