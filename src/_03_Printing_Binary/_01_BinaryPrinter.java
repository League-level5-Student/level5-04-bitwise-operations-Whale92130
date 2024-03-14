package _03_Printing_Binary;

public class _01_BinaryPrinter {
    /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */


    public static void printByteBinary(byte b) {
        // We first want to print the bit in the one's place
    	System.out.println("Byte: " + b);
        // Shift b seven bits to the right
    	int bb = b;
        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1
    	//System.out.println("bb: " + bb);
        // Print the result using System.out.print (NOT System.out.println)
    	//System.out.println("bb&1 " + (bb&1));
        //Use this method to print the remaining 7 bits of b
    	String output ="";
    	for (int i = 1<<7; i > 0; i=i>>1) {
    		if ((bb&i) > 0) {
    			output+="1";
    		}
    		else {
    			output+="0";
    		}
    		//System.out.println("bb&" + i + " " + (bb&i));
    	}
    	System.out.println("Final Byte: " + output);
    }

    public static void printShortBinary(short s) {
        // Create 2 byte variables
        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte
        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
    	byte high = (byte) (s>>8);
    	byte low = (byte) (s&(255));
		printByteBinary(high);
    	printByteBinary(low);
    }

    public static void printIntBinary(int i) {
        // Create 2 short variables

        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short
    	short high = (short) (i>>16);
    	short low = (short) (i&(65535));
        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    	printShortBinary(high);
    	printShortBinary(low);
    	
    }

    public static void printLongBinary(long l) {
        // Use the same method as before to complete this method
    	int high = (int) (l>>16);
    	int low = (int) (l&(2147483646));
    	printIntBinary(high);
    	printIntBinary(low);
    }

    public static void main(String[] args) {
        // Test your methods here
    	byte b = 67;
    	//printByteBinary(b);
    	Short s = 513;
    	//printShortBinary(s);
    	int i = 2049;
    	//printIntBinary(i);
    	long l = 2147483646;
    	printLongBinary(l);
    }
}
