package leetcode;

import java.util.Stack;

public class M132Pattern {
	
	class Pair{
        int min, max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
	
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for(int n: nums){
            if(stack.isEmpty() || n <stack.peek().min ) stack.push(new Pair(n,n));
            else if(n > stack.peek().min){ 
                Pair last = stack.pop();
                if(n < last.max) return true;
                else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
                
            }
        }
        return false;
    }
	
	public static void main(String[] args){
		M132Pattern m = new M132Pattern();
		int[] input = {-1, 3, 2, 0};
		System.out.println(m.find132pattern(input));
	}

}
