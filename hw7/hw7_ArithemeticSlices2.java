package leet_hw1;

import java.util.HashMap;
import java.util.Map;

/**
 * 446. Arithmetic Slices II - Subsequence (hard)

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. 
A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic.
In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A.

The input contains N integers. Every integer is in the range of -2^31 and 2^31-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 2^31-1.


Example:

Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
 * @author liyugong
 *
 */
public class hw7_ArithemeticSlices2 {
	
	public int numberOfArithmeticSlices(int[] A) {
	    int res = 0;
	    //an array of map
	  	//each element in A has a map
	  	//key = difference between elements and its predecessor
	  	//value = # arithmetic sequence ended at current index including those of length 2
	    Map<Integer, Integer>[] map = new Map[A.length];
			
	    for (int i = 0; i < A.length; i++) {
	        map[i] = new HashMap<>(i);
	        	
	        for (int j = 0; j < i; j++) {
	            long diff = (long)A[i] - A[j];
	            if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
	        		
	            int d = (int)diff;
	            //c1 = current # arithmetic sequence of diff d without using jth element
	            int c1 = map[i].getOrDefault(d, 0);
	            //c2 = # arithmetic sequence of diff d at jth element including those of length 2
	            int c2 = map[j].getOrDefault(d, 0);
	            //if c2 > 0 then means all the arithmetic sequence at index j are valid after adding current ith element 
	            res += c2;
	            //the # of arithmetic sequence at current = 
	            //# of previous sequence ended at j plus current element so no need to plus 1
	            //# sequence ended at i (without j element)  so no need to plus 1
	            //previous element plus current element which is 1
	            map[i].put(d, c1 + c2 + 1);
	        }
	    }
			
	    return res;
	}
	public static void main(String[] args){
		hw7_ArithemeticSlices2 a = new hw7_ArithemeticSlices2();
		System.out.print(a.numberOfArithmeticSlices(new int[]{1,1,1,1,1}));
	}
}
