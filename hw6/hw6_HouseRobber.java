package leet_hw1;

/**
 * 198. House Robber 
 *  You are a professional robber planning to rob houses along
 * a street. Each house has a certain amount of money stashed, the only
 * constraint stopping you from robbing each of them is that adjacent houses
 * have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author liyugong
 *
 */
public class hw6_HouseRobber {
	public int rob(int[] num) {
		//represents the max loot if prev is not robbed
	    int prevNo = 0;
	    //if prev is robbed
	    int prevYes = 0;
	    
	    for (int n : num) {
	        int temp = prevNo;
	        //update if current n is not robbed
	        prevNo = Math.max(prevNo, prevYes);
	        //update if current n is robbed = n + prevNo
	        prevYes = n + temp;
	    }
	    return Math.max(prevNo, prevYes);
	}
	public static void main(String[] args){
		hw6_HouseRobber a = new hw6_HouseRobber();
		int n = 20;
		int[] test = new int[n];
		for(int i =0;i<n;i++){
			test[i] = 0;
		}
		System.out.println(a.rob(test));
	}
}
