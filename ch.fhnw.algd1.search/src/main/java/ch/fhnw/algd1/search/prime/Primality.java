package ch.fhnw.algd1.search.prime;

public class Primality {
	public static boolean isPrime(int x) {
		var t = 2;   
		var root = (int)(Math.sqrt(x)+1);
		while( t < root  && x % t != 0 ) {
			t++;
		}
		return t ==  root;
	}
}
