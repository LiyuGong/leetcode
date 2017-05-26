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
}
