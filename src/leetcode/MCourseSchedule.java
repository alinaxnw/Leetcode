package leetcode;

import java.util.*;

public class MCourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){

        	Stack<Integer> stack = new Stack<>();
        	stack.push(prerequisites[i][1]);
        	Set<Integer> visited = new HashSet<>();
        	System.out.println(i);
        	System.out.println("map size: "+map.size());
        	while(!stack.isEmpty()){
        		int pre = stack.pop();
        		System.out.println("****"+pre);
        		if(pre == prerequisites[i][0]) return false;
        		if(!visited.contains(pre)){
        			if(map.containsKey(pre)){
            			List<Integer> list = map.get(pre);
                		for(int j = 0; j < list.size(); j++){
                			if(!visited.contains(list.get(j)))
                				stack.push(list.get(j));
                		}
        			}
        			visited.add(pre);

        		}
        	}
        	if(map.containsKey(prerequisites[i][0])){
        		List<Integer> l = map.get(prerequisites[i][0]);
        		l.add(prerequisites[i][1]);
        		map.put(prerequisites[i][0], l);
        	}else{
        		List<Integer> l = new ArrayList<>();
        		l.add(prerequisites[i][1]);
        		map.put(prerequisites[i][0], l);
        	}
        }
        return true;
    }
    
    public static void main(String[] args){
    	MCourseSchedule m = new MCourseSchedule();
    	int[][] pre = {{1, 0}, {1, 2}, {0, 2}, {0, 1}};
    	System.out.println(m.canFinish(2, pre));
    }
}
