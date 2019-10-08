package ch.fhnw.algd1.search.seq;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SequenceSearchTest {
	@Test
	public void testSequenceSearchContains() {
		int[] numbers = { 5, 2, 44, 534, 22 };
		assertTrue(SequenceSearch.contains(numbers, 5));
		assertFalse(SequenceSearch.contains(numbers, 2000));
	}
	@Test
	public void testSequenceSearchBiggerTgab() {
		int[] numbers = { 5, 2, 44, 534, 22 };
		assertTrue(SequenceSearch.biggerThan(numbers, 0));
		assertFalse(SequenceSearch.biggerThan(numbers, 2000));
		assertFalse(SequenceSearch.biggerThan(numbers, 44));
	}

	@Test
	public void testFindFirstPowerOfTwoThatIsBiggerThan() {
		int val = 123456;
		var firstPowerBiggerThan = SequenceSearch.findFirstPowerOfTwoThatIsBiggerThan(val);
		assertTrue(Math.pow(2, firstPowerBiggerThan) > val); 
		assertTrue(Math.pow(2, firstPowerBiggerThan-1)< val); 
	}
}
