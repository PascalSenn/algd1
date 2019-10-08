package ch.fhnw.algd1.search.seq;

public class SequenceSearch {
	public static boolean contains(int[] data, int value) {
		int index = 0;
		while(index < data.length && value != data[index]) {
			index++;
		}
		return index != data.length;
	}

	public static boolean biggerThan(int[] data, int value) {
		int index = 0;
		while(index < data.length && data[index] > value) {
			index++;
		}
		return index == data.length;
	}
	public static int findFirstPowerOfTwoThatIsBiggerThan(int value) {
		int index = 0;
		while(Math.pow(2, index) < value) {
			index++;
		}
		return index;
	}
	

}
