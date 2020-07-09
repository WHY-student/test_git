package lifeGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MapTest {

	public static Map map=new Map();
	@Before
	public void setUp() throws Exception {
		map.init();
	}

	@Test
	public void testInit() {
		for(int i=0;i<map.WIDTH;i++)
		{
			for(int j=0;j<map.HEIGHT;j++)
			{
				assertEquals(0,map.world[i][j]);
			}
		}
	}

	@Test
	public void testRandom() {
		map.random();
		int n=0;
		for(int i=0;i<map.WIDTH;i++)
		{
			for(int j=0;j<map.HEIGHT;j++)
			{
				if(map.world[i][j]==1)
					n++;
			}
		}
		assertEquals(map.BLOCKS,n);
		System.out.print(n);
	}

	@Test
	public void testAdd() {
		map.add(1, 1);
		assertEquals(1,map.world[1][1]);
	}

	@Test
	public void testCellState() {
		map.world[1][5]=1;
		assertEquals(1,map.cellState(1, 5));
		assertEquals(0,map.cellState(0, 0));
	}

	@Test
	public void testGetNeighbors0() {
			    //当前细胞[1][4]是死，周围没有活细胞
				
				//当前细胞[1][10]是死，周围有2个活细胞
				map.world[0][10]=1;
				map.world[2][10]=1;
				
				//当前细胞[1][13]是活，周围有3个活细胞
				map.world[1][13]=1;
				map.world[0][13]=1;
				map.world[2][13]=1;
				map.world[1][12]=1;
				
				
				//当前细胞[1][19]是活，周围有4个活细胞
				map.world[1][19]=1;
				map.world[0][19]=1;
				map.world[2][19]=1;
				map.world[1][18]=1;
				map.world[0][18]=1;
				assertEquals(0,map.getNeighbors(1, 4));
				assertEquals(2,map.getNeighbors(1, 10));
				assertEquals(3,map.getNeighbors(1, 13));
				assertEquals(4,map.getNeighbors(1, 19));
	}

}
