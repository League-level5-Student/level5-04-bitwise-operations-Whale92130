package _02_AND_OR_and_XOR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*
 * Goal: Implement left and right rotate methods.
 * 
 * Inherently Java doesn't have an instruction to perform left or right
 * rotates (though there are rotate functions in the Integer class).
 * 
 * A rotate is when a bit is shifted outside the width of the variable and is
 * placed on the other side. Here is an example of a right rotate on int 7
 * by 1:
 *      00000000 00000000 00000000 00000111   // original value of 7
 *      10000000 00000000 00000000 00000011   // rotate right by 1
 * 
 * Normally when the number 7 is right shifted by 1, the rightmost '1' is
 * discarded and the result looks like this:
 *      00000000 00000000 00000000 00000011   // 7 >> 1 (last '1' is discarded)
 * For a right rotate the number is not discarded and it's placed on the left,
 * the most significant bit (bit 31).
 * 
 * The same goes for a left rotate:
 *      11111111 11111111 11111111 11111000   // original value of -8
 *      11111111 11111111 11111111 11110001   // rotate left by 1
 */
public class _02_Rotate {

	int rotateLeft(int value, int rotateAmount) {
		String binary = convertDecimalToBinary(value);
		char[] bits = binary.toCharArray();
		for (int o = 0; o < rotateAmount; o++) {
			char first = bits[0];
			for (int i = 0; i < bits.length - 1; i++) {
				if (i == bits.length - 2) {
					bits[bits.length - 2] = first;
				}
				char temp = bits[i];
				bits[i] = bits[i + 1];
				bits[i + 1] = temp;

			}
		}

		String output = "";
		for (int i = 0; i < bits.length; i++) {
			output += bits[i];
		}
		System.out.println("Output left: " + output);
		return convertBinaryStringToDecimalInt(output);
	}

	int rotateRight(int value, int rotateAmount) {
		System.out.println("value: " + value);
		String binary = "00000000000000000000000000000" + convertDecimalToBinary(value);
		System.out.println("Binary String: " + binary);

		char[] bits = binary.toCharArray();
		for (int o = 0; o < rotateAmount; o++) {
			for (int p = 0; p < bits.length-1; p++) {
				char first = bits[0];
				for (int i = 0; i < bits.length - 1; i++) {
					if (i == bits.length - 2) {
						bits[bits.length - 2] = first;
					}
					char temp = bits[i];
					bits[i] = bits[i + 1];
					bits[i + 1] = temp;
				}
			}
		}

		String output = "";
		for (int i = 0; i < bits.length; i++) {
			output += bits[i];
		}
		System.out.println("Output left: " + output);
		return convertBinaryStringToDecimalInt(output);
	}

	public static String convertDecimalToBinary(int decimalNum) {
		String binaryStr = "";

		do {
			// 1. Logical right shift by 1
			int quotient = decimalNum >>> 1;

			// 2. Check remainder and add '1' or '0'
			if (decimalNum % 2 != 0) {
				binaryStr = '1' + binaryStr;
			} else {
				binaryStr = '0' + binaryStr;
			}

			decimalNum = quotient;

			// 3. Repeat until number is 0
		} while (decimalNum != 0);

		return binaryStr;
	}

	int convertBinaryStringToDecimalInt(String binStr) {
		StringBuilder sb = new StringBuilder(binStr);
		sb.reverse();
		String binStr2 = sb.toString();
		System.out.println(binStr2);
		String[] bits = binStr2.split("");
		int num = 0;
		int power = 1;
		for (int i = 0; i < bits.length; i++) {
			if (bits[i].equals("1")) {
				num += power;
			} else if (bits[i].equals("0")) {
				num += 0;
			}
			power = power * 2;
		}
		return num;
	}

	@Test
	void testRotateLeft() {
		int i = -8;

		int result = rotateLeft(i, 1);
		System.out.println("Left rotate tests");
		System.out.println("Expected: " + Integer.toBinaryString(-15));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(-15, result);

		result = rotateLeft(i, 3);
		System.out.println();
		System.out.println("Expected: " + Integer.toBinaryString(-57));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(-57, result);
	}

	@Test
	void testRotateRight() {
		int i = 7;

		int result = rotateRight(i, 1);
		System.out.println("\nRight rotate tests");
		System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(-2147483645, result);

		result = rotateRight(i, 16);
		System.out.println();
		System.out.println("Expected: " + Integer.toBinaryString(458752));
		System.out.println("Actual  : " + Integer.toBinaryString(result));
		assertEquals(458752, result);
	}
}
