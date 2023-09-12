package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class DivisorCalculatorTest {

	DivisorCalculator dc = new DivisorCalculator();
	ArrayList<Integer> list = new ArrayList<Integer>();
	@Test
	void testFindDivisors() {
		//fail("Not yet implemented");
		list.add(1);
		list.add(2);
		
		
		assertEquals(1, 2, DivisorCalculator.findDivisors(2));
	}
	private void assertEquals(int i, int j, List<Integer> findDivisors) {
		// TODO Auto-generated method stub
		
	}
	

}
