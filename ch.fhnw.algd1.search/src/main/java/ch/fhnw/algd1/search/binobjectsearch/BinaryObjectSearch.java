package ch.fhnw.algd1.search.binobjectsearch;

public class BinaryObjectSearch {
	public static final int NOT_FOUND = -1;

	public static <T extends Comparable<? super T>> int binSearch(T[] data, T value) {
		var l = -1;
		var h = data.length;
		while(l + 1 < h) {
			var m = (l+h) /2; 
			var compareResult = data[m].compareTo(value);
			if( compareResult< 0) {
				l = m;
			} else if(compareResult > 0) {
				h = m;
			} else {
				return m;
			}
		} 
		return NOT_FOUND;
	}
}
