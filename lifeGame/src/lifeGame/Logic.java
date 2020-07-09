package lifeGame;

public class Logic {
	public static Map map = new Map();

	public static void init() {
		map.init();
		map.random();
	}

	public static void nextWorld() {
		int x, y;
		int[][] temp = new int[map.WIDTH][map.HEIGHT];
		for (x = 0; x < map.WIDTH; x++) {
			for (y = 0; y < map.HEIGHT; y++) {
				int neighbors = map.getNeighbors(x, y);
				switch (neighbors) {
				case 3:
					temp[x][y] = 1;
					break;// ���һ��ϸ����Χ��3��ϸ��Ϊ�������ϸ��Ϊ��
				case 2:
					temp[x][y] = map.world[x][y];
					break;// ���һ��ϸ����Χ��2��ϸ��Ϊ�������ϸ��������״̬���ֲ���
				default:
					temp[x][y] = 0;
					break;// ����������£���ϸ��Ϊ��
				}
//				 if (neighbors == 3) { // ���һ��ϸ����Χ��3��ϸ��Ϊ�������ϸ��Ϊ��
//				 temp[x][y] = 1;
//				 } else if (neighbors == 2) { // ���һ��ϸ����Χ��2��ϸ��Ϊ�������ϸ��������״̬���ֲ���
//				 temp[x][y] = map.world[x][y];
//				 } else { // ����������£���ϸ��Ϊ��
//				 temp[x][y] = 0;
//				 }
			}
		}
		map.world = temp;
		return;
	}

	// public static void print() {
	// map.print();
	// return;
	// }
}