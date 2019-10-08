package ch.fhnw.algd1.search.sentinelsearch;

public class SentinelSearch {
	public static boolean exists(int[] data, int value) {
		var index = 0;
		var temp = data[data.length-1]; 
		if(temp != value) { 
			data[data.length-1] = value; 
		
			while(data[index] != value) {
				index++;
			} 
			data[data.length-1] = temp; 
			return index != data.length-1;
		}
		else {
			return true;
		}
	}

	public static int firstIndex(int[] data, int value) {
		var index = 0;
		var temp = data[data.length-1];  
		data[data.length-1] = value; 
	
		while(data[index] != value) {
			index++;
		} 
		data[data.length-1] = temp;  
		if(index == data.length-1 && temp != value ) {
			return -1; 
		} else {
			return index;
		}
	}
}