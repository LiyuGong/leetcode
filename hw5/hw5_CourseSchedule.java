package leet_hw1;
import java.util.*;
/**
 *  
207. Course Schedule
Total Accepted: 80956
Total Submissions: 256071
Difficulty: Medium
Contributor: LeetCode
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 * @author liyugong
 *
 */
public class hw5_CourseSchedule {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
		 int[] indegree = new int[numCourses];
		 Map<Integer,ArrayList<Integer>> prerequisite = new HashMap<>();
		 
		 //calculate indegree for each vertices and initialize the prerequisite
		 for (int[] prereq: prerequisites){
			 int preCourse = prereq[1];
			 indegree[prereq[0]] += 1;
			 if (prerequisite.containsKey(preCourse)){
				 prerequisite.get(preCourse).add(prereq[0]);
			 }
			 else{
				 prerequisite.put(preCourse, new ArrayList<>());
				 prerequisite.get(preCourse).add(prereq[0]);
			 }
		 }

		 int outsize = 0;
		 //out is the queue of 0 indegree vertices
		 Queue<Integer> out = new LinkedList<>();
		 for (int i = 0; i < numCourses; i++){
			 if (indegree[i] == 0){
				 out.add(i);
			 	 indegree[i] = -1;
			 }
		 }	
		 
		 while(!out.isEmpty()){
			 int peak = (int) out.poll();
			 outsize +=1;
			 
			 //subtract one from the indegree of all the subsequent course
			 for(int j = 0; j < prerequisite.getOrDefault(peak, new ArrayList()).size(); j++){		 
				 int subseq = prerequisite.get(peak).get(j); 
				 indegree[subseq] -=1;
				 if(indegree[subseq]==0)
					 out.add(subseq);
			 }			 
		 }		 
		 return outsize == numCourses;
	 }
	 public static void main(String[] args){
		 int[][] prerequisites= {{1,0},{3,2},{2,1},{2,0},{3,0},{3,1}};
		 hw5_CourseSchedule a = new hw5_CourseSchedule();
		 System.out.print(a.canFinish(4, prerequisites));

	 }
}
