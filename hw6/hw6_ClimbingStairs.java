package leet_hw1;

/**
 * 70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
 * @author liyugong
 *
 */
public class hw6_ClimbingStairs {

	public int climbStairs(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		int[] comb= new int[n+1];
		comb[0] = 1;
		comb[1] = 1;

		for(int i = 2; i < comb.length; i++){
			comb[i] = comb[i-2] + comb[i-1];
		}
        return comb[n];
    }
	
	public static void main(String[] args){
		hw6_ClimbingStairs a = new hw6_ClimbingStairs();
		System.out.println(a.climbStairs(60));

	}
}
