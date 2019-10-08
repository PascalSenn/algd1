package ch.fhnw.algd1.search.binsearchfirst;

public class BinSearchFirstElement {
	public static int binSearch(int[] data, int value) {
		var l = -1; 
		var h = data.length;
		var m = (l+h) /2;
		while(l + 1 < h) {   
			m = (l+h) /2;
			if( data[m] < value) {
				l = m;
			} else {
				h = m;
			}
		} 
		return m; 
	}
}