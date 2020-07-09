package lifeGame;

import java.util.Arrays;
import java.util.Random;

public class Map {
	public final int HEIGHT = 40; // 设定生命游戏的地图大小
	public final int WIDTH = 40;
	public final int BLOCKS = 400;
	public int[][] world = new int[WIDTH][HEIGHT];

	public void init() {
		// Arrays.fill(world, 0); // 1为生，0为死
		for (int i = 0; i < WIDTH; i++) {
//			for (int j = 0; j < HEIGHT; j++) {
//				world[i][j] = 0;
//			}
			Arrays.fill(world[i],0);
		}
		return;
	}

	public void random() {
		Random r = new Random(1);
		int x, y;
		for (int i = 0; i < BLOCKS; i++) {
			x = r.nextInt(WIDTH);
			y = r.nextInt(HEIGHT);
			if(world[x][y]==1)
			{
				i--;
				continue;
			}
			add(x, y);
		}
		return;
	}

	public void add(int x, int y) {
		world[x][y] = 1;
		return;
	}

	public void print() {
		for (int i = 0; i < 40; i++)
			System.out.print("*");
		System.out.println();
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				System.out.print(world[x][y]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public int cellState(int x, int y) { // 得到当前格子的细胞生死状态
		if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT)
			return 0;
		else
			return world[x][y];
	}

	public int getNeighbors(int x, int y) {
		int n = 0; // n为附近8个格子中活着的细胞状态
		n += cellState(x - 1, y - 1);
		n += cellState(x, y - 1);
		n += cellState(x + 1, y - 1);
		n += cellState(x - 1, y);
		n += cellState(x, y + 1);
		n += cellState(x + 1, y - 1);
		n += cellState(x + 1, y);
		n += cellState(x + 1, y + 1);
		return n;
	}

}