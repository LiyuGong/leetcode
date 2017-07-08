package leet_hw1;
import java.util.*;
/**
 * 523. Continuous Subarray Sum (medium)
 * 
Given a list of non-negative numbers and a target integer k, 
write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, 
that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 * @author liyugong
 *
 */
public class hw7_ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length <= 1) return false;
        //key = remainder of subarray[0,i]
		//value = index i
		//if r_i == r_j which means sum[0,j] - sum[0,i] = n*k then sum of subarray[ni+1,nj] is a multiplt of k
		Map<Integer, Integer> map = new HashMap<>();
		//corner case where the first element is a multiple of k
		map.put(0, -1);
		int subtotal = 0;
        for(int i = 0; i < nums.length; i++){
        	//if k == 0  using this updating method, map is recording subtotal instead of remainder
        	subtotal += nums[i];
        	if ( k != 0){
        		//we can delete some part of the subtotal
        		subtotal = subtotal % k;
        	}
        	Integer prev = map.get(subtotal);
        	if(prev != null){
        		if(i - prev > 1) return true;
        	}
        	else
        		
        		map.put(subtotal, i);
        	}
        
        return false;
        
    }

	public static void main(String[] args){
		hw7_ContinuousSubarraySum a = new hw7_ContinuousSubarraySum();
		System.out.print(a.checkSubarraySum(new int[]{1,0,0},0));
	}
}
