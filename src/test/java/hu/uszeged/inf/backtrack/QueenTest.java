package hu.uszeged.inf.backtrack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueenTest{
	
	@Before
	public void clearMap() {
		Queen.map = new Queen[8][8];
	}
	@Test(timeout = 100)
	public void testRowAndColumnAndDiagonal() {
	
		new Queen(1, 6);
		new Queen(5, 2);
		new Queen(0, 3);
		new Queen(0, 1);		
		new Queen(3, 0);
		new Queen(6, 7);
		new Queen(4, 7);

		//Queen.print();
		
		Assert.assertEquals(6, Queen.checkPosition(1,2));
	}
	
	@Test(timeout = 100)
	public void testCorner() {
		new Queen(0,0);
		new Queen(0, 7);
		new Queen(7, 0);
		new Queen(7, 7);
		
		//Queen.print();
		
		Assert.assertEquals(4, Queen.checkPosition(0,0));

	}
	
	
	@Test(timeout = 100)
	public void testPositon() {
		new Queen(1,0);
		new Queen(1, 7);

		
		//Queen.print();
		System.out.println(Queen.checkPosition(1,7));
	//	Assert.assertEquals(4, Queen.checkPosition(00,0));

	}
	
	@Test(timeout = 100)
	public void testExistingQueen() {
		
		new Queen(4, 4);
		new Queen(0, 0);
		new Queen(7, 7);
		new Queen(0, 4);
		new Queen(4, 0);
		new Queen(7, 4);
		new Queen(4, 7);

		//Queen.print();
		
		Assert.assertEquals(7, Queen.checkPosition(4,4));

	}

	@Test(timeout = 100)
	public void testCorrectPlacement() {
			
		new Queen(3, 0);
		new Queen(6, 1);
		new Queen(2, 2);
		new Queen(7, 3);
		new Queen(1, 4);
		new Queen(4, 5);
		new Queen(0, 6);
		new Queen(5, 7);

		//Queen.print();
		
		Assert.assertTrue(Queen.correctPlacement());
		
	}
	
	@Test(timeout = 100)
	public void testInCorrectPlacement() {
			
		new Queen(3, 0);
		new Queen(6, 1);
		new Queen(2, 2);
		new Queen(7, 3);
		new Queen(1, 4);
		new Queen(4, 5);
		new Queen(0, 6);
		new Queen(5, 6);
		//Queen.print();
		
		Assert.assertFalse(Queen.correctPlacement());
		
	}
	
	@Test(timeout = 100)
	public void tesSimpleStep() {
		Queen q1 =  new Queen(1, 0);
		Queen q2 =  new Queen(7, 2);		

		//Queen.print();
		q1.step();
		q2.step();
		//Queen.print();
		
		Assert.assertEquals(2, q1.x);
		Assert.assertEquals(0, q2.x);
		Assert.assertEquals(null, Queen.map[7][2]);
		Assert.assertEquals(null, Queen.map[1][0]);

	}


}