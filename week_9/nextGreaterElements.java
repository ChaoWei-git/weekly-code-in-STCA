import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        for(int index=0;index< 2 * nums.length;index++){
            int num = nums[index%nums.length];
            while(!stack.isEmpty()&&nums[stack.peek()]<num) result[stack.pop()] = num;
            if(index<nums.length) stack.push(index);
        }
        
        return result;
    }
}