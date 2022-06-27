package blind75;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
	Return true if you can finish all courses. Otherwise, return false.
	
	Example 1:
	Input: numCourses = 2, prerequisites = [[1,0]]
	Output: true
	Explanation: There are a total of 2 courses to take. 
	To take course 1 you should have finished course 0. So it is possible.
	
	Example 2:
	Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take.
	To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class CourseSchedule {
	static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		p(courseSchedule(2, new int[][] {{1, 0}}));
		p(courseSchedule(2, new int[][] {{1, 0}, {0, 1}}));
	}
	static boolean courseSchedule(int numOfCourses, int[][] prereqs) {
		if(prereqs.length == 0 || prereqs == null || numOfCourses <= 0) return false;
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		
		// build an adjacency list via HashMap
		for(int[] directedEdge : prereqs) {
			int from = directedEdge[0];
			int to = directedEdge[1];
			if(!adjList.containsKey(from))
				adjList.put(from, new ArrayList<>());
			adjList.get(from).add(to);
		}
//		p(adjList);
		Set<Integer> visited = new HashSet<>();
		for(int vertex : adjList.keySet()) {
//			p("vertex : " + vertex);
			if(dfs(adjList, vertex, visited)) {
				p("worked");
				return true;
			}
		}
		return false;
	}
	static boolean dfs(Map<Integer, List<Integer>> adjList, int vertex, Set<Integer> visited) {
		if(visited.contains(vertex)) return false;
		if(adjList.get(vertex) == null) return true;
		
		visited.add(vertex);
		for(int neighbor : adjList.get(vertex))
			if(!visited.contains(neighbor))// && vertex != neighbor) // loop
				if(!dfs(adjList, neighbor, visited)) return false;
		visited.remove(vertex);
		adjList.get(vertex).clear();
		return true;
	}
}


