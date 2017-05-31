package leet_hw1;

import java.util.Arrays;

/**
 * #475. Heaters 
 *  Total Accepted:14482
 *   Total Submissions: 49161 
 *   Difficulty: Easy 
 *   Contributors: neelamgehlot
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line, find
 * out minimum radius of heaters so that all houses could be covered by those
 * heaters.
 * 
 * So, your input will be the positions of houses and heaters seperately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note: Numbers of houses and heaters you are given are non-negative and will
 * not exceed 25000. Positions of houses and heaters you are given are
 * non-negative and will not exceed 10^9. As long as a house is in the heaters'
 * warm radius range, it can be warmed. All the heaters follow your radius
 * standard and the warm radius will the same.
 * 
 * @author liyugong
 *
 */
public class hw2_heaters {
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            // index of the search key, if it is contained in the array;
            // otherwise, (-(insertion point) - 1).
            // The insertion point is defined as the point at which the key would be inserted into the array:
            // the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key.
            // Note that this guarantees that the return value will be >= 0 if and only if the key is found.
            if (index < 0) {
                index = -(index + 1);
            }
            // System.out.print(index);
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
    
	public static void main(String[] args){
		int[] a = new int[]{1};
		int[] b = new int[]{2,5};
		hw2_heaters c = new hw2_heaters();
		System.out.print(c.findRadius(a, b));
	}
}
