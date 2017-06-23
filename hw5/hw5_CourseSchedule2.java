package leet_hw1;
import java.util.*;

/**
 * 210. Course Schedule II

Total Accepted: 60431
Total Submissions: 221839
Difficulty: Medium
Contributor: LeetCode
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

 * @author liyugong
 *
 */
public class hw5_CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, ArrayList<Integer>> prerequisite = new HashMap<>();
        
        for(int[] prereq : prerequisites){
        	indegree[prereq[0]] += 1;
        	if(prerequisite.containsKey(prereq[1])){
        		prerequisite.get(prereq[1]).add(prereq[0]);
        	}
        	else{
        		prerequisite.put(prereq[1], new ArrayList<>());
        		prerequisite.get(prereq[1]).add(prereq[0]);
        	}
        }
        
        Queue<Integer> out = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
        	if(indegree[i] == 0){
        		out.offer(i);
        	}
        }
        int[] res = new int[numCourses];
        int count = 0;
        while(!out.isEmpty()){
        	int peak = (int) out.poll();
        	res[count] = peak;
        	count += 1;
    		ArrayList<Integer> subseq = prerequisite.getOrDefault(peak, new ArrayList<>());
        	for(int j = 0; j < subseq.size(); j++){
        		int course = subseq.get(j);
        		indegree[course] -= 1;
        		if(indegree[course] == 0){
        			out.offer(course);
        		}
        	}
        }
        if(count != numCourses){
        	return new int[0];
        }
        else{
        	return res;
        }
    }
}
