package lifeGame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LogicTest {

	public static Logic logic = new Logic();
	@Before
	public void setUp() throws Exception {
		
		Logic.map.init();
		
		//当前细胞[1][1]是生，周围没有活细胞
		Logic.map.world[1][1]=1;
		
		//当前细胞[1][4]是死，周围没有活细胞
		
		//当前细胞[1][7]是活，周围有2个活细胞
		Logic.map.world[1][7]=1;
		Logic.map.world[0][7]=1;
		Logic.map.world[2][7]=1;
		
		//当前细胞[1][10]是死，周围有2个活细胞
		Logic.map.world[0][10]=1;
		Logic.map.world[2][10]=1;
		
		//当前细胞[1][13]是活，周围有3个活细胞
		Logic.map.world[1][13]=1;
		Logic.map.world[0][13]=1;
		Logic.map.world[2][13]=1;
		Logic.map.world[1][12]=1;
		
		//当前细胞[1][16]是死，周围有3个活细胞
		Logic.map.world[0][16]=1;
		Logic.map.world[2][16]=1;
		Logic.map.world[1][15]=1;
		
		//当前细胞[1][19]是活，周围有4个活细胞
		Logic.map.world[1][19]=1;
		Logic.map.world[0][19]=1;
		Logic.map.world[2][19]=1;
		Logic.map.world[1][18]=1;
		Logic.map.world[0][18]=1;
		
		//当前细胞[1][22]是死，周围有4个活细胞
		Logic.map.world[0][22]=1;
		Logic.map.world[2][22]=1;
		Logic.map.world[0][21]=1;
		Logic.map.world[1][21]=1;
		
		Logic.nextWorld();
	}


	@Test
	public void test1$1() {
		assertEquals(0,Logic.map.world[1][1]);
	}
	@Test
	public void test1$4() {
		assertEquals(0,Logic.map.world[1][4]);
	}
	@Test
	public void test1$7() {
		assertEquals(1,Logic.map.world[1][7]);
	}@Test
	public void test1$10() {
		assertEquals(0,Logic.map.world[1][10]);
	}@Test
	public void test1$13() {
		assertEquals(1,Logic.map.world[1][13]);
	}
	@Test
	public void test1$16() {
		assertEquals(1,Logic.map.world[1][16]);
	}
	@Test
	public void test1$19() {
		assertEquals(0,Logic.map.world[1][19]);
	}
	@Test
	public void test1$22() {
		assertEquals(0,Logic.map.world[1][22]);
	}

}
