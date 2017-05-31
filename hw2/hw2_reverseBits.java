package leet_hw1;

/**
 * #190. Reverse Bits Add to List DescriptionHintsSubmissionsSolutions Total
 * Accepted: 100943 Total Submissions: 342639 Difficulty: Easy Contributor:
 * LeetCode Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * @author liyugong
 *
 */
public class hw2_reverseBits {
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        int out = 0;
        for(int i = 0;i<32;i++){
            out += ((n >> i) & 1) << (31-i);
        }
        return out;
    }
    public int reverseBits2(int n) {
        // swap first 16 bits and last 16 bits
        int r = 0xFFFF, l = 0xFFFF0000;
        n = (( n & l ) >>> 16) | ((n & r) << 16);
        // swap 8 bits
        l = 0xFF00FF00;
        r = 0x00FF00FF;
        n = ((n & l) >>> 8) | ((n & r) << 8);
        
        // swap 4 bits
        l = 0xF0F0F0F0;
        r = 0x0F0F0F0F;
        n = ((n & l) >>> 4) | ((n & r) << 4);
        
        // swap 2 bits
        l = 0xCCCCCCCC;
        r = 0x33333333;
        n = ((n & l) >>> 2) | ((n & r) << 2);
        
        // swap 1 bit
        l = 0xAAAAAAAA;
        r = 0x55555555;
        n = ((n & l) >>> 1) | ((n & r) << 1);
        
        return n;
    }
}
