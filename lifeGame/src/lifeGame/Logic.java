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
					break;// 如果一个细胞周围有3个细胞为生，则该细胞为生
				case 2:
					temp[x][y] = map.world[x][y];
					break;// 如果一个细胞周围有2个细胞为生，则该细胞的生死状态保持不变
				default:
					temp[x][y] = 0;
					break;// 在其它情况下，该细胞为死
				}
//				 if (neighbors == 3) { // 如果一个细胞周围有3个细胞为生，则该细胞为生
//				 temp[x][y] = 1;
//				 } else if (neighbors == 2) { // 如果一个细胞周围有2个细胞为生，则该细胞的生死状态保持不变
//				 temp[x][y] = map.world[x][y];
//				 } else { // 在其它情况下，该细胞为死
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