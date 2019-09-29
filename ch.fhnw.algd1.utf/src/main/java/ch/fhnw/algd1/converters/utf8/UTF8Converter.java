package ch.fhnw.algd1.converters.utf8;

import java.nio.ByteBuffer;
 

/*
 * Created on 05.09.2014
 */
/**
 * @author Wolfgang Weck
 */
public class UTF8Converter {
	public static byte[] codePointToUTF(int x) {
		byte[] b = null;
		// Number is bigger than 2^7
		if((0b1111_1111__1111_1111__1111_1111__1000_0000 & x )== 0) {
			b = new byte[1];
			b[0] =(byte) (0b0111_1111 & x);
		} 
		// Number is bigger than 2^15
		else if((0b1111_1111__1111_1111__0000_0000__0000_0000 & x )== 0) {
			b = new byte[2];
			b[1] =(byte) (0b0001_1111 & (x>>6) | 0b1100_0000);
			b[0] =(byte) (0b0011_1111 & (x) | 0b1000_0000);
		}
		// Number is bigger than 2^22
		else if((0b1111_1111__0000_0000__0000_0000__0000_0000 & x )== 0) {
			b = new byte[3];
			b[2] =(byte) (0b0000_1111 & (x>>12) | 0b1110_0000);
			b[1] =(byte) (0b0011_1111 & (x>>6) | 0b1000_0000);
			b[0] =(byte) (0b0011_1111 & (x) | 0b1000_0000);
		}

		// Number is bigger than 2^
		else {
			b = new byte[4];
			b[3] =(byte) (0b0000_0111 & (x>>18) | 0b1111_0000);
			b[2] =(byte) (0b0011_1111 & (x>>12) | 0b1000_0000);
			b[1] =(byte) (0b0011_1111 & (x>>6) | 0b1000_0000);
			b[0] =(byte) (0b0011_1111 & (x) | 0b1000_0000);
		}
		
		return b;
	}

	public static int UTFtoCodePoint(byte[] bytes) {
		if (isValidUTF8(bytes)) {
			if(bytes.length == 1) {
				return bytes[0] & 0b0111_1111;
			}
			if(bytes.length == 2) {
				return bytes[0] & 0b0001_1111 + getFollowUp(bytes[1]);
			}
			if(bytes.length == 3) {
				return bytes[0] & 0b0000_1111 + getFollowUp(bytes[1],bytes[2]);
			}
			if(bytes.length == 4) {
				return bytes[0] & 0b0000_0111 + getFollowUp(bytes[1],bytes[2], bytes[3]);
			}
			return 0;
		} else return 0;
	}

	private static boolean isValidUTF8(byte[] bytes) {
		if (bytes.length == 1) return (bytes[0] & 0b1000_0000) == 0;
		else if (bytes.length == 2) return ((bytes[0] & 0b1110_0000) == 0b1100_0000)
				&& isFollowup(bytes[1]);
		else if (bytes.length == 3) return ((bytes[0] & 0b1111_0000) == 0b1110_0000)
				&& isFollowup(bytes[1]) && isFollowup(bytes[2]);
		else if (bytes.length == 4) return ((bytes[0] & 0b1111_1000) == 0b1111_0000)
				&& isFollowup(bytes[1]) && isFollowup(bytes[2]) && isFollowup(bytes[3]);
		else return false;
	}

	private static boolean isFollowup(byte b) {
		return (b & 0b1100_0000) == 0b1000_0000;
	}
	private static int getFollowUp(byte b) {
		return b & 0b0011_1111;
	 }
	
	private static int getFollowUp(byte ...b) {
		int sum =0;
		for(int current : b ) {
			sum += getFollowUp(b) ;
		}
		return sum;
	 }
}
