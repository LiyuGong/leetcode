package leet_hw1;

/**
 * 303. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 * @author liyugong
 *
 */
public class hw6_RangeSumQuery_Immutable {
	int[] subtotal;	
	
	public hw6_RangeSumQuery_Immutable(int[] nums) {
		subtotal = new int[nums.length+1];
		subtotal[0] = 0;
		
		for(int i = 0; i<nums.length; i++){
			subtotal[i+1] = subtotal[i] + nums[i];
		}
    }
    
    public int sumRange(int i, int j) {
        return subtotal[j+1] - subtotal[i];
    }
    public static void main(String[] args){
    	hw6_RangeSumQuery_Immutable a = new hw6_RangeSumQuery_Immutable(new int[]{1,3,5,7,9});
    	System.out.print(a.sumRange(0, 4));
    }
}
