package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		if (x < 0) {
			x += 256;
		}
		var result = "";
		while (x > 0) {
			if (x % 2 == 0) {
				result = "0" + result;
			} else {

				result = "1" + result;
			}
			x = x / 2;
		}
		var nullCount = 8 - result.length();
		for (var i = 0; i < nullCount; i++) {
			result = "0" + result;
		}
		return result;
	}

	public static int fromString(String text) {
		var result = 0;
		for (var index = text.length(); index > 0; index--) {
			var pow = text.length() - index ;
			var factor = Math.pow(2, pow);
			if (index == 1) {
				factor *= -1;
			}
			if (text.charAt(index-1) == '1') {
				result += factor;
			}
		}
		return result;
	}
}